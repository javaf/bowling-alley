package main;

import iiit.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;


public class ControlDeskView implements ActionListener, ControlDeskObserver {
  private JFrame frame;
  private JButton addParty, finished, assign;
  private JList partyList;
  private int maxMembers;
  private ControlDeskAdapter controlDesk;

  public ControlDeskView(ControlDeskAdapter controlDesk, int maxMembers) {
    this.controlDesk = controlDesk;
    this.maxMembers = maxMembers;
    int numLanes = controlDesk.getNumLanes();

    frame = new JFrame("Control Desk");
    frame.getContentPane().setLayout(new BorderLayout());
    ((JPanel) frame.getContentPane()).setOpaque(false);

    JPanel columns = new JPanel();
    columns.setLayout(new BorderLayout());

    JPanel controls = new JPanel();
    controls.setLayout(new GridLayout(3, 1));
    controls.setBorder(new TitledBorder("Controls"));

    addParty = new JButton("Add Party");
    JPanel addPartyPanel = new JPanel();
    addPartyPanel.setLayout(new FlowLayout());
    addParty.addActionListener(this);
    addPartyPanel.add(addParty);
    controls.add(addPartyPanel);

    assign = new JButton("Assign Lanes");
    JPanel assignPanel = new JPanel();
    assignPanel.setLayout(new FlowLayout());
    assign.addActionListener(this);
    assignPanel.add(assign);
    // controlsPanel.add(assignPanel);

    finished = new JButton("Finished");
    JPanel finishedPanel = new JPanel();
    finishedPanel.setLayout(new FlowLayout());
    finished.addActionListener(this);
    finishedPanel.add(finished);
    controls.add(finishedPanel);

    // Lane Status Panel
    JPanel laneStatus = new JPanel();
    laneStatus.setLayout(new GridLayout(numLanes, 1));
    laneStatus.setBorder(new TitledBorder("Lane Status"));

    int laneCount = 0;
    for (LaneAdapter curLane : controlDesk.getLanes()) {
      LaneStatusView laneStat = new LaneStatusView(curLane, (laneCount + 1));
      curLane.subscribe(laneStat);
      ((PinsetterAdapter) curLane.getPinsetter()).subscribe(laneStat);
      JPanel lanePanel = laneStat.showLane();
      lanePanel.setBorder(new TitledBorder("Lane" + ++laneCount));
      laneStatus.add(lanePanel);
    }

    // Party Queue Panel
    JPanel partyQueue = new JPanel();
    partyQueue.setLayout(new FlowLayout());
    partyQueue.setBorder(new TitledBorder("Party Queue"));

    Vector empty = new Vector();
    empty.add("(Empty)");

    partyList = new JList(empty);
    partyList.setFixedCellWidth(120);
    partyList.setVisibleRowCount(10);
    JScrollPane partyPane = new JScrollPane(partyList);
    partyPane.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    partyQueue.add(partyPane);
    //		partyPanel.add(partyList);

    // Clean up main panel
    columns.add(controls, "East");
    columns.add(laneStatus, "Center");
    columns.add(partyQueue, "West");

    frame.getContentPane().add("Center", columns);
    frame.pack();

    /* Close program when this window closes */
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    JFrames.screenCenter(frame);
    frame.setVisible(true);
  }

  /**
   * Handler for actionEvents
   *
   * @param e	the ActionEvent that triggered the handler
   *
   */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(addParty)) {
      PartyDeskAdapter addPartyWin = new PartyDeskAdapter(this, maxMembers);
    }
    if (e.getSource().equals(assign)) {
      controlDesk.assignLane();
    }
    if (e.getSource().equals(finished)) {
      frame.setVisible(false);
      System.exit(0);
    }
  }

  /**
   * Receive a new party from andPartyView.
   *
   * @param addPartyView	the AddPartyView that is providing a new party
   *
   */
  public void updateAddParty(PartyDeskAdapter addPartyView) {
    controlDesk.addPartyQueue(addPartyView.partyIds());
  }

  /**
   * Receive a broadcast from a ControlDesk
   *
   * @param ce	the ControlDeskEvent that triggered the handler
   *
   */
  public void receiveControlDeskEvent(ControlDeskEvent ce) {
    partyList.setListData(((Vector) ce.getPartyQueue()));
  }
}
