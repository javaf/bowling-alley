package main;
import java.util.*;


public class Lane2 extends Lane {
  private int state;
  
  @Override
  public boolean complete() {
    if (isEmpty()) return true;
    if (state==0 && size()<2) return super.complete();
    if (state==1 && super.complete()) return get(1).score()<get(0).score();
    return state>=2 && super.complete();
  }
  
  @Override
  public boolean addRoll(Roll roll) {
    for (int i=0; i<size(); i++)
      System.out.print(i+":"+get(i).size()+"/"+get(i).capacity()+"."+get(i).complete()+"  ");
    System.out.println();
    if (!super.complete()) return super.addRoll(roll);
    Collections.sort(this, Comparator.reverseOrder());
    if (size()<2) return noRank2();
    if (state==0) rank2Chance();
    else if (state==1 && get(1).score()>=get(0).score()) rank1VsRank2();
    return super.addRoll(roll);
  }
  
  private boolean noRank2() {
    state = 2;
    return false;
  }
  
  private void rank2Chance() {
    state = 1;
    get(0).capacity += 1;
    get(1).capacity += 1;
    get(0).add(Frame.EMPTY);
  }
  
  private void rank1VsRank2() {
    state = 2;
    get(0).capacity += 3;
    get(1).capacity += 3;
  }
  
  @Override
  public void clear() {
    super.clear();
    state = 0;
  }
}
