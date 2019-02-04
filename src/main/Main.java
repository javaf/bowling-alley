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
    controlDesk.events.on("addParty", (event, value) -> {
      Party party = (Party) value;
      partyQueue.add(party);
      Lane lane = completeLane();
      if (lane!=null) {
        lane.clear();
        lane.addBowlers(partyQueue.removeFirst());
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
      lane.addBowlers(partyQueue.removeFirst());
    });
    lanes.get(0).add(new Game(null));
    new Main().start();
  }
  
  @Override
  public void run() {
    System.out.println(lanes.size());
    for (;;) {
      boolean played = false;
      for (Lane lane : lanes) {
        if (lane.isEmpty()) continue;
        if (lane.complete()) continue;
        System.out.println(lane.hashCode()+": "+lane.frame());
        Game game = lane.game();
        Bowler bowler = game.bowler();
        Pinsetter pinsetter = lane.pinsetter();
        Roll roll = pinsetter.roll(bowler!=null? bowler.skill() : Math.random());
        game.addRoll(roll);
        if(roll.full() || game.last().complete(game.size()==10)) pinsetter.reset();
        played = true;
        controlDesk.update(partyQueue, lanes);
        try { Thread.sleep(2000); }
        catch (InterruptedException e) { System.err.println(e); }
      }
      if (!played) break;
    }
    for (Lane lane : lanes) {
      for (Game game : lane)
        System.out.println(game);
    }
  }
  
  private static void onAddParty(String event, Object value) {
    Party party = (Party) value;
    partyQueue.add(party);
    Lane lane = completeLane();
    if (lane==null) return;
    lane.clear();
    for (Bowler bowler : party)
      lane.add(new Game(bowler));
  }
  
  private static Lane completeLane() {
    for (Lane lane : lanes)
      if (lane.complete()) return lane;
    return null;
  }
}
