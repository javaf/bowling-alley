package main;

public class drive {
  public static void main2(String[] args) {
    int numLanes = 3;
    int maxPatronsPerParty = 5;
    ControlDesk controlDesk = new ControlDesk(numLanes);
    ControlDeskView cdv = new ControlDeskView(controlDesk, maxPatronsPerParty);
    controlDesk.subscribe(cdv);
  }
  
  public static void main(String[] args) {
    Game game = new Game();
    Frame frame = new Frame();
    Pinsetter pinsetter = new Pinsetter();
    Roll roll = pinsetter.roll();
    frame.add(roll);
    game.add(frame);
    System.out.println(game);
  }
}
