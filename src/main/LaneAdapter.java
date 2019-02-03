package main;
import java.util.*;


public class LaneAdapter extends Thread implements PinsetterObserver {
  private PartyAdapter party;
  private PinsetterAdapter setter;
  private HashMap scores;
  private Vector subscribers;

  private boolean gameIsHalted;

  private boolean partyAssigned;
  private boolean gameFinished;
  private Iterator bowlerIterator;
  private int ball;
  private int bowlIndex;
  private int frameNumber;
  private boolean tenthFrameStrike;

  private int[] curScores;
  private int[][] cumulScores;
  private boolean canThrowAgain;

  private int[][] finalScores;
  private int gameNumber;

  private Bowler currentThrower;			// = the thrower who just took a throw

  public LaneAdapter() {
    setter = new PinsetterAdapter();
    scores = new HashMap();
    subscribers = new Vector();
    gameIsHalted = false;
    partyAssigned = false;
    gameNumber = 0;
    setter.subscribe(this);
    this.start();
  }

  public void run() {
    while (true) {
      if (partyAssigned && !gameFinished) {	// we have a party on this lane, 
        // so next bower can take a throw
        while (gameIsHalted) {
          try {
            sleep(10);
          } catch (Exception e) {
          }
        }
        if (bowlerIterator.hasNext()) {
          currentThrower = (Bowler) bowlerIterator.next();
          canThrowAgain = true;
          tenthFrameStrike = false;
          ball = 0;
          while (canThrowAgain) {
            setter.ballThrown();		// simulate the thrower's ball hiting
            ball++;
          }
          if (frameNumber == 9) {
            finalScores[bowlIndex][gameNumber] = cumulScores[bowlIndex][9];
            try {
              Date date = new Date();
              String dateString = "" + date.getHours() + ":" + date.getMinutes() + " " + date.getMonth() + "/" + date.getDay() + "/" + (date.getYear() + 1900);
              ScoreHistoryFileAdapter.addScore(currentThrower.id, dateString, new Integer(cumulScores[bowlIndex][9]).toString());
            } catch (Exception e) {
              System.err.println("Exception in addScore. " + e);
            }
          }
          setter.reset();
          bowlIndex++;
        } else {
          frameNumber++;
          resetBowlerIterator();
          bowlIndex = 0;
          if (frameNumber > 9) {
            gameFinished = true;
            gameNumber++;
          }
        }
      } else if (partyAssigned && gameFinished) {
        EndGamePrompt egp = new EndGamePrompt(((Bowler) party.getMembers().get(0)).id + "'s Party");
        String result = egp.getResult();
        egp.destroy();
        egp = null;

        System.out.println("result was: " + result);

        // TODO: send record of scores to control desk
        if (result.equals("yes")) {					// yes, want to play again
          resetScores();
          resetBowlerIterator();

        } else if (result.equals("no")) {// no, dont want to play another game
          Vector printVector;
          EndGameReport egr = new EndGameReport(((Bowler) party.getMembers().get(0)).id + "'s Party", party);
          printVector = egr.getResult();
          partyAssigned = false;
          Iterator scoreIt = party.getMembers().iterator();
          party = null;
          partyAssigned = false;

          publish(lanePublish());

          int myIndex = 0;
          while (scoreIt.hasNext()) {
            Bowler thisBowler = (Bowler) scoreIt.next();
            ScoreReport sr = new ScoreReport(thisBowler, finalScores[myIndex++], gameNumber);
            sr.sendEmail(thisBowler.email);
            Iterator printIt = printVector.iterator();
            while (printIt.hasNext()) {
              if (thisBowler.id == (String) printIt.next()) {
                System.out.println("Printing " + thisBowler.id);
                sr.sendPrintout();
              }
            }

          }
        }
      }

      try {
        sleep(10);
      } catch (Exception e) {
      }
    }
  }

  public void receivePinsetterEvent(PinsetterEvent pe) {

    if (pe.pinsDownOnThisThrow() >= 0) {			// this is a real throw
      markScore(currentThrower, frameNumber + 1, pe.getThrowNumber(), pe.pinsDownOnThisThrow());

      // next logic handles the ?: what conditions dont allow them another throw?
      // handle the case of 10th frame first
      if (frameNumber == 9) {
        if (pe.totalPinsDown() == 10) {
          setter.resetPins();
          if (pe.getThrowNumber() == 1) {
            tenthFrameStrike = true;
          }
        }

        if ((pe.totalPinsDown() != 10) && (pe.getThrowNumber() == 2 && tenthFrameStrike == false)) {
          canThrowAgain = false;
          //publish( lanePublish() );
        }

        if (pe.getThrowNumber() == 3) {
          canThrowAgain = false;
          //publish( lanePublish() );
        }
      } else { // its not the 10th frame

        if (pe.pinsDownOnThisThrow() == 10) {		// threw a strike
          canThrowAgain = false;
          //publish( lanePublish() );
        } else if (pe.getThrowNumber() == 2) {
          canThrowAgain = false;
          //publish( lanePublish() );
        } else if (pe.getThrowNumber() == 3) {
          System.out.println("I'm here...");
        }
      }
    } else {								//  this is not a real throw, probably a reset
    }
  }

  private void resetBowlerIterator() {
    bowlerIterator = (party.getMembers()).iterator();
  }

  private void resetScores() {
    Iterator bowlIt = (party.getMembers()).iterator();
    while (bowlIt.hasNext()) {
      int[] toPut = new int[25];
      for (int i = 0; i != 25; i++) {
        toPut[i] = -1;
      }
      scores.put(bowlIt.next(), toPut);
    }
    gameFinished = false;
    frameNumber = 0;
  }

  public void assignParty(PartyAdapter theParty) {
    party = theParty;
    resetBowlerIterator();
    partyAssigned = true;
    curScores = new int[party.getMembers().size()];
    cumulScores = new int[party.getMembers().size()][10];
    finalScores = new int[party.getMembers().size()][128]; //Hardcoding a max of 128 games, bite me.
    gameNumber = 0;
    resetScores();
  }

  private void markScore(Bowler Cur, int frame, int ball, int score) {
    int[] curScore;
    int index = ((frame - 1) * 2 + ball);
    curScore = (int[]) scores.get(Cur);
    curScore[index - 1] = score;
    scores.put(Cur, curScore);
    getScoreAdapter(Cur, frame);
    publish(lanePublish());
  }

  private LaneEvent lanePublish() {
    LaneEvent laneEvent = new LaneEvent(party, bowlIndex, currentThrower, cumulScores, scores, frameNumber + 1, curScores, ball, gameIsHalted);
    return laneEvent;
  }
  
  private int getScore(int[] now, int[] sum, int frame, int ball) {
    int strikeballs = 0;
    int totalScore = 0;
    for (int i = 0; i != 10; i++) {
      sum[i] = 0;
    }
    int current = 2 * (frame - 1) + ball - 1;
    //Iterate through each ball until the current one.
    for (int i = 0; i != current + 2; i++) {
      //Spare:
      if (i % 2 == 1 && now[i - 1] + now[i] == 10 && i < current - 1 && i < 19) {
        //This ball was a the second of a spare.  
        //Also, we're not on the current ball.
        //Add the next ball to the ith one in cumul.
        sum[(i / 2)] += now[i + 1] + now[i];
        if (i > 1) {
          //cumulScores[i/2] += cumulScores[i/2 -1];
        }
      } else if (i < current && i % 2 == 0 && now[i] == 10 && i < 18) {
        strikeballs = 0;
        //This ball is the first ball, and was a strike.
        //If we can get 2 balls after it, good add them to cumul.
        if (now[i + 2] != -1) {
          strikeballs = 1;
          if (now[i + 3] != -1) {
            //Still got em.
            strikeballs = 2;
          } else if (now[i + 4] != -1) {
            //Ok, got it.
            strikeballs = 2;
          }
        }
        if (strikeballs == 2) {
          //Add up the strike.
          //Add the next two balls to the current cumulscore.
          sum[i / 2] += 10;
          if (now[i + 1] != -1) {
            sum[i / 2] += now[i + 1] + sum[(i / 2) - 1];
            if (now[i + 2] != -1) {
              if (now[i + 2] != -2) {
                sum[(i / 2)] += now[i + 2];
              }
            } else {
              if (now[i + 3] != -2) {
                sum[(i / 2)] += now[i + 3];
              }
            }
          } else {
            if (i / 2 > 0) {
              sum[i / 2] += now[i + 2] + sum[(i / 2) - 1];
            } else {
              sum[i / 2] += now[i + 2];
            }
            if (now[i + 3] != -1) {
              if (now[i + 3] != -2) {
                sum[(i / 2)] += now[i + 3];
              }
            } else {
              sum[(i / 2)] += now[i + 4];
            }
          }
        } else {
          break;
        }
      } else {
        //We're dealing with a normal throw, add it and be on our way.
        if (i % 2 == 0 && i < 18) {
          if (i / 2 == 0) {
            //First frame, first ball.  Set his cumul score to the first ball
            if (now[i] != -2) {
              sum[i / 2] += now[i];
            }
          } else if (i / 2 != 9) {
            //add his last frame's cumul to this ball, make it this frame's cumul.
            if (now[i] != -2) {
              sum[i / 2] += sum[i / 2 - 1] + now[i];
            } else {
              sum[i / 2] += sum[i / 2 - 1];
            }
          }
        } else if (i < 18) {
          if (now[i] != -1 && i > 2) {
            if (now[i] != -2) {
              sum[i / 2] += now[i];
            }
          }
        }
        if (i / 2 == 9) {
          if (i == 18) {
            sum[9] += sum[8];
          }
          if (now[i] != -2) {
            sum[9] += now[i];
          }
        } else if (i / 2 == 10) {
          if (now[i] != -2) {
            sum[9] += now[i];
          }
        }
      }
    }
    return totalScore;
  }
  
  private int getScoreAdapter(Bowler Cur, int frame) {
    return getScore((int[]) scores.get(Cur), cumulScores[bowlIndex], frame, ball);
  }

  public boolean isPartyAssigned() {
    return partyAssigned;
  }

  public boolean isGameFinished() {
    return gameFinished;
  }

  public void subscribe(LaneObserver adding) {
    subscribers.add(adding);
  }

  public void unsubscribe(LaneObserver removing) {
    subscribers.remove(removing);
  }

  public void publish(LaneEvent event) {
    if (subscribers.size() > 0) {
      Iterator eventIterator = subscribers.iterator();

      while (eventIterator.hasNext()) {
        ((LaneObserver) eventIterator.next()).receiveLaneEvent(event);
      }
    }
  }

  public PinsetterAdapter getPinsetter() {
    return setter;
  }

  public void pauseGame() {
    gameIsHalted = true;
    publish(lanePublish());
  }

  public void unPauseGame() {
    gameIsHalted = false;
    publish(lanePublish());
  }
}
