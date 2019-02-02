package main;
import java.util.*;


public class Throw {
  private static final Random RANDOM = new Random();
  public final boolean[] pins; // true => pins dropped
  public final boolean foul;
  
  public Throw(boolean[] pins, boolean foul) {
    this.pins = pins;
    this.foul = foul;
  }
  
  public Throw(double skill) {
    pins = new boolean[10];
    foul = luck(skill)<0.05;
    for (int i=0; i<pins.length; i++)
      pins[i] = Math.pow(RANDOM.nextDouble(), 1-skill)>=0.5;
  }
  
  public Throw() {
    this(RANDOM.nextDouble());
  }
  
  private double luck(double skill) {
    return Math.pow(RANDOM.nextDouble(), 1-skill);
  }
}
