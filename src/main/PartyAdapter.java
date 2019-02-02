package main;

import java.util.*;


public class PartyAdapter {
  private Vector myBowlers;


  public PartyAdapter(Vector bowlers) {
    myBowlers = new Vector(bowlers);
  }

  public Vector getMembers() {
    return myBowlers;
  }
}
