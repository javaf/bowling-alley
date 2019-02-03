package main;

public class drive {
  public static void main2(String[] args) {
    int numLanes = 3;
    int maxPatronsPerParty = 5;
    // ControlDeskAdapter controlDesk = new ControlDeskAdapter(numLanes);
    // ControlDeskView cdv = new ControlDeskView(controlDesk, maxPatronsPerParty);
    // controlDesk.subscribe(cdv);
  }
  
  public static void main(String[] args) {
    main2(args);
    ControlDesk x = new ControlDesk();
    x.setVisible(true);
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
}
