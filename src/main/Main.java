package main;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
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
      controlDesk.update(partyQueue, lanes);
    });
    controlDesk.events.on("finished", (event, value) -> {
      System.exit(0);
    });
    controlDesk.events.on("laneComplete", (event, value) -> {
      Lane lane = lanes.get((int) value);
      lane.clear();
      if (partyQueue.isEmpty()) return;
      lane.assign(partyQueue.removeFirst());
      controlDesk.update(partyQueue, lanes);
    });
    new Main().start();
    sendPrintout("Hello");
  }
  
  @Override
  public void run() {
    for (;;) {
      for (Lane lane : lanes) {
        if (lane.complete()) {
          controlDesk.events.emit("laneComplete", lanes.indexOf(lane));
          continue;
        }
        Game game = lane.game();
        Bowler bowler = game.bowler();
        Pinsetter pinsetter = lane.pinsetter();
        double skill = bowler!=null? bowler.skill() : Math.random();
        Roll roll = new Roll(pinsetter, skill);
        lane.addRoll(roll);
        controlDesk.update(partyQueue, lanes);
        System.out.println(pinsetter);
        lane.update();
        // if (pinsetter.standing()==0 || game.last().complete(game.size()==10)) pinsetter.clear();
        try { Thread.sleep(10000); }
        catch (InterruptedException e) {}
      }
    }
  }
  
    private static void sendPrintout(String content) {
    PrinterJob job = PrinterJob.getPrinterJob();
    PrintableText printobj = new PrintableText(content);
    job.setPrintable(printobj);
    if (job.printDialog()) {
      try {
        job.print();
      } catch (PrinterException e) {
        System.err.println(e);
      }
    }
  }
}
