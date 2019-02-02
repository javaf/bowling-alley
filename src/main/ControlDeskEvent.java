package main;

import java.util.*;


public class ControlDeskEvent {
  private Vector partyQueue;


  public ControlDeskEvent(Vector partyQueue) {
    this.partyQueue = partyQueue;
  }
  public Vector getPartyQueue() {
    return partyQueue;
  }
}
