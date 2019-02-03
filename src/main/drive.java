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
    Pinsetter pinsetter = new Pinsetter();
    for (;;) {
      Roll roll = pinsetter.roll();
      game.addRoll(roll);
      if(game.last().complete(game.size()==10)) pinsetter.reset();
      if(game.complete()) break;
    }
    System.out.println(game);
  }
}
