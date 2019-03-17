package main;


public class Lane2 extends Lane {
  private int state;
  
  @Override
  public boolean complete() {
    return state>2;
  }
  
  @Override
  public boolean addRoll(Roll roll) {
    if (!super.complete()) return super.addRoll(roll);
    sort(null);
    if (size()<2) return noRank2();
    if (state==0) rank2Chance();
    else if (state==1) rank1VsRank2();
    return super.addRoll(roll);
  }
  
  private boolean noRank2() {
    state = 3;
    return false;
  }
  
  private void rank2Chance() {
    state = 1;
    get(1).capacity += 1;
  }
  
  private void rank1VsRank2() {
    state = 2;
    get(0).capacity += 3;
    get(1).capacity += 3;
  }
}
