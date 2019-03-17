package main;


public class Lane2 extends Lane {
  private int state;
  
  @Override
  public boolean complete() {
    return isEmpty() || (state>=2 && super.complete());
  }
  
  @Override
  public boolean addRoll(Roll roll) {
    for (int i=0; i<size(); i++)
      System.out.println(i+".complete: "+get(i).complete());
    if (!super.complete()) return super.addRoll(roll);
    System.out.println("super.complete");
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
    get(0).capacity += 1;
    get(1).capacity += 1;
    get(0).add(Frame.EMPTY);
  }
  
  private void rank1VsRank2() {
    state = 2;
    get(0).capacity += 3;
    get(1).capacity += 3;
  }
}
