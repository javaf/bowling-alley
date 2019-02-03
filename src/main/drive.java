package main;
import java.util.*;


public class drive {
  private static ArrayList<Party> partyQueue;
  private static ArrayList<Lane> lanes;
  private static ControlDesk controlDesk;
  
  
  public static void main(String[] args) {
    int numLanes = 3;
    partyQueue = new ArrayList<>();
    lanes = new ArrayList<>();
    for (int i=0; i<numLanes; i++)
      lanes.add(new Lane());
    controlDesk = new ControlDesk();
    controlDesk.events.on("addParty", (event, value) -> {
      Party party = (Party) value;
      partyQueue.add(party);
      Lane lane = completeLane();
      if (lane==null) return;
      lane.clear();
      lane.addBowlers(partyQueue.remove(0));
    });
    controlDesk.events.on("finished", (event, value) -> {
      System.exit(0);
    });
    controlDesk.events.on("laneComplete", (event, value) -> {
      Lane lane = (Lane) value;
      if (partyQueue.isEmpty()) return;
      lane.clear();
      lane.addBowlers(partyQueue.remove(0));
    });
    Game game = new Game(null);
    Pinsetter pinsetter = new Pinsetter();
    for (;;) {
      Roll roll = pinsetter.roll();
      game.addRoll(roll);
      if(roll.full() || game.last().complete(game.size()==10)) pinsetter.reset();
      if(game.complete()) break;
    }
    System.out.println(game);
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
