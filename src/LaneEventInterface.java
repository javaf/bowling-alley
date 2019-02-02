import java.util.*;
import java.rmi.*;


public interface LaneEventInterface extends Remote {
  public int getFrameNum() throws RemoteException;
  public HashMap getScore() throws RemoteException;
  public int[] getCurScores() throws RemoteException;
  public int getIndex() throws RemoteException;
  public int getFrame() throws RemoteException;
  public int getBall() throws RemoteException;
  public int[][] getCumulScore() throws RemoteException;
  public Party getParty() throws RemoteException;
  public Bowler getBowler() throws RemoteException;
}
