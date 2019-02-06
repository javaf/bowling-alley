package main;
import java.util.*;


public class Main extends Thread {
  private static PartyQueue partyQueue;
  private static ArrayList<Lane> lanes;
  private static ControlDesk controlDesk;
  
  
  public static void main(String[] args) {
    int numLanes = 3;
    partyQueue = new PartyQueue();
    lanes = new ArrayList<>();
    for (int i=0; i<numLanes; i++)
      lanes.add(new Lane());
    controlDesk = new ControlDesk();
    controlDesk.update(partyQueue, lanes);
    controlDesk.events.on("addParty", (event, value) -> {
      partyQueue.add((Party) value);
      Lane lane = completeLane();
      if (lane!=null) {
        lane.clear();
        lane.assign(partyQueue.removeFirst());
      }
      controlDesk.update(partyQueue, lanes);
    });
    controlDesk.events.on("finished", (event, value) -> {
      System.exit(0);
    });
    controlDesk.events.on("laneComplete", (event, value) -> {
      Lane lane = (Lane) value;
      if (partyQueue.isEmpty()) return;
      lane.clear();
      lane.assign(partyQueue.removeFirst());
    });
    new Main().start();
  }
  
  @Override
  public void run() {
    for (;;) {
      for (Lane lane : lanes) {
        if (lane.isEmpty()) continue;
        if (lane.complete()) continue;
        Game game = lane.game();
        Bowler bowler = game.bowler();
        Pinsetter pinsetter = lane.pinsetter();
        double skill = bowler!=null? bowler.skill() : Math.random();
        Roll roll = new Roll(pinsetter, skill);
        lane.addRoll(roll);
        controlDesk.update(partyQueue, lanes);
        System.out.println(pinsetter);
        if (pinsetter.standing()==0 || game.last().complete(game.size()==10)) pinsetter.clear();
        try { Thread.sleep(1000); }
        catch (InterruptedException e) {}
      }
    }
  }
  
  private static Lane completeLane() {
    for (Lane lane : lanes)
      if (lane.complete()) return lane;
    return null;
  }
}
