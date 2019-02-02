package main;

import iiit.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class LaneStatusView implements ActionListener, LaneObserver, PinsetterObserver {
  private JPanel jp;
  private JLabel curBowler, foul, pinsDown;
  private JButton viewLane;
  private JButton viewPinSetter, maintenance;
  private PinsetterView psv;
  private LaneView lv;
  private LaneAdapter lane;
  int laneNum;
  boolean laneShowing;
  boolean psShowing;

  
  public LaneStatusView(LaneAdapter lane, int laneNum) {
    this.lane = lane;
    this.laneNum = laneNum;
    laneShowing = false;
    psShowing = false;

    psv = new PinsetterView(laneNum);
    PinsetterAdapter ps = lane.getPinsetter();
    ps.subscribe(psv);

    lv = new LaneView(lane, laneNum);
    lane.subscribe(lv);

    jp = new JPanel();
    jp.setLayout(new FlowLayout());
    JLabel cLabel = new JLabel("Now Bowling: ");
    curBowler = new JLabel("(no one)");
    JLabel fLabel = new JLabel("Foul: ");
    foul = new JLabel(" ");
    JLabel pdLabel = new JLabel("Pins Down: ");
    pinsDown = new JLabel("0");

    JPanel buttons = new JPanel();
    buttons.setLayout(new FlowLayout());
    buttons.add(new JButtonPanel(viewLane = new JButton("View Lane"), this));
    buttons.add(new JButtonPanel(viewPinSetter = new JButton("Pinsetter"), this));
    buttons.add(new JButtonPanel(maintenance = new JButton("     "), this));
    viewLane.setEnabled(false);
    viewPinSetter.setEnabled(false);
    maintenance.setBackground(Color.GREEN);

    jp.add(cLabel);
    jp.add(curBowler);
    // jp.add( fLabel );
    // jp.add( foul );
    jp.add(pdLabel);
    jp.add(pinsDown);
    jp.add(buttons);
  }

  public JPanel showLane() {
    return jp;
  }

  public void actionPerformed(ActionEvent event) {
    Object source = event.getSource();
    if (lane.isPartyAssigned()) {
      if (source.equals(viewPinSetter)) {
        if (psShowing == false) {
          psv.show();
          psShowing = true;
        } else if (psShowing == true) {
          psv.hide();
          psShowing = false;
        }
      }
    }
    if (source.equals(viewLane)) {
      if (lane.isPartyAssigned()) {
        if (laneShowing == false) {
          lv.show();
          laneShowing = true;
        } else if (laneShowing == true) {
          lv.hide();
          laneShowing = false;
        }
      }
    }
    if (source.equals(maintenance)) {
      if (lane.isPartyAssigned()) {
        lane.unPauseGame();
        maintenance.setBackground(Color.GREEN);
      }
    }
  }

  public void receiveLaneEvent(LaneEvent le) {
    curBowler.setText(((Bowler) le.getBowler()).nickname);
    if (le.isMechanicalProblem()) {
      maintenance.setBackground(Color.RED);
    }
    if (lane.isPartyAssigned() == false) {
      viewLane.setEnabled(false);
      viewPinSetter.setEnabled(false);
    } else {
      viewLane.setEnabled(true);
      viewPinSetter.setEnabled(true);
    }
  }

  public void receivePinsetterEvent(PinsetterEvent pe) {
    pinsDown.setText((new Integer(pe.totalPinsDown())).toString());
    // foul.setText( ( new Boolean(pe.isFoulCommited()) ).toString() );
  }
}
