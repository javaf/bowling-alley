package main;


/* PINS:
   true => pins dropped
    6   7   8   9
      3   4   5
        2   1
          0
 */
public class Pinsetter {
  public boolean[] pins;

  public Pinsetter() {
    pins = new boolean[10];
  }
  
  public int standing() {
    int count = 0;
    for(var i=0; i<pins.length; i++)
      count += pins[i]? 1 : 0;
    return count;
  }
  
  public int drop(Throw turn) {
    int count = 0;
    if(turn.foul) return 0;
    for(int i=0; i<pins.length; i++) {
      count += !pins[i] && turn.pins[i]? 1 : 0;
      pins[i] |= turn.pins[i];
    }
    return count;
  }
  
  public void resetPins() {
    for (int i=0; i<pins.length; i++)
      pins[i] = false;
  }
};
