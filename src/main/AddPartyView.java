package main;

import iiit.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.util.*;


public class AddPartyView implements ActionListener, ListSelectionListener {
  private int maxSize;
  private JFrame frame;
  private JButton addPatron, newPatron, remPatron, finished;
  private JList partyList, allBowlers;
  private Vector party, bowlerdb;
  private Integer lock;

  private ControlDeskView controlDesk;

  private String selectedNick, selectedMember;
  private static final BowlerFile BOWLER_FILE = new BowlerFile("BOWLERS.DAT");
  
  private static ArrayList bowlerNicknames(Collection<Bowler> bowlers) {
    ArrayList<String> nicknames = new ArrayList<>();
    for(Bowler bowler : bowlers)
      nicknames.add(bowler.id);
    return nicknames;
  }
  
  public AddPartyView(ControlDeskView controlDesk, int max) {

    this.controlDesk = controlDesk;
    maxSize = max;

    frame = new JFrame("Add Party");
    frame.getContentPane().setLayout(new BorderLayout());
    ((JPanel) frame.getContentPane()).setOpaque(false);

    JPanel colPanel = new JPanel();
    colPanel.setLayout(new GridLayout(1, 3));

    // Party Panel
    JPanel partyPanel = new JPanel();
    partyPanel.setLayout(new FlowLayout());
    partyPanel.setBorder(new TitledBorder("Your Party"));

    party = new Vector();
    Vector empty = new Vector();
    empty.add("(Empty)");

    partyList = new JList(empty);
    partyList.setFixedCellWidth(120);
    partyList.setVisibleRowCount(5);
    partyList.addListSelectionListener(this);
    JScrollPane partyPane = new JScrollPane(partyList);
    //        partyPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    partyPanel.add(partyPane);

    // Bowler Database
    JPanel bowlerPanel = new JPanel();
    bowlerPanel.setLayout(new FlowLayout());
    bowlerPanel.setBorder(new TitledBorder("Bowler Database"));

    try {
      bowlerdb = new Vector(bowlerNicknames(BOWLER_FILE.getAll().values()));
    } catch (Exception e) {
      System.err.println("File Error");
      System.err.println(e);
      bowlerdb = new Vector();
    }
    allBowlers = new JList(bowlerdb);
    allBowlers.setVisibleRowCount(8);
    allBowlers.setFixedCellWidth(120);
    JScrollPane bowlerPane = new JScrollPane(allBowlers);
    bowlerPane.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    allBowlers.addListSelectionListener(this);
    bowlerPanel.add(bowlerPane);

    // Button Panel
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(4, 1));

    Insets buttonMargin = new Insets(4, 4, 4, 4);

    addPatron = new JButton("Add to Party");
    JPanel addPatronPanel = new JPanel();
    addPatronPanel.setLayout(new FlowLayout());
    addPatron.addActionListener(this);
    addPatronPanel.add(addPatron);

    remPatron = new JButton("Remove Member");
    JPanel remPatronPanel = new JPanel();
    remPatronPanel.setLayout(new FlowLayout());
    remPatron.addActionListener(this);
    remPatronPanel.add(remPatron);

    newPatron = new JButton("New Patron");
    JPanel newPatronPanel = new JPanel();
    newPatronPanel.setLayout(new FlowLayout());
    newPatron.addActionListener(this);
    newPatronPanel.add(newPatron);

    finished = new JButton("Finished");
    JPanel finishedPanel = new JPanel();
    finishedPanel.setLayout(new FlowLayout());
    finished.addActionListener(this);
    finishedPanel.add(finished);

    buttonPanel.add(addPatronPanel);
    buttonPanel.add(remPatronPanel);
    buttonPanel.add(newPatronPanel);
    buttonPanel.add(finishedPanel);

    // Clean up main panel
    colPanel.add(partyPanel);
    colPanel.add(bowlerPanel);
    colPanel.add(buttonPanel);

    frame.getContentPane().add("Center", colPanel);
    frame.pack();
    JFrames.screenCenter(frame);
    frame.show();

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(addPatron)) {
      if (selectedNick != null && party.size() < maxSize) {
        if (party.contains(selectedNick)) {
          System.err.println("Member already in Party");
        } else {
          party.add(selectedNick);
          partyList.setListData(party);
        }
      }
    }
    if (e.getSource().equals(remPatron)) {
      if (selectedMember != null) {
        party.removeElement(selectedMember);
        partyList.setListData(party);
      }
    }
    if (e.getSource().equals(newPatron)) {
      BowlerRegisterView newPatron = new BowlerRegisterView();
      newPatron.on("end", (String event, Object value) -> {
        updateNewPatron((Bowler)value);
      });
    }
    if (e.getSource().equals(finished)) {
      if (party != null && party.size() > 0) {
        controlDesk.updateAddParty(this);
      }
      frame.hide();
    }

  }

  @Override
  public void valueChanged(ListSelectionEvent e) {
    if (e.getSource().equals(allBowlers)) {
      selectedNick
              = ((String) ((JList) e.getSource()).getSelectedValue());
    }
    if (e.getSource().equals(partyList)) {
      selectedMember
              = ((String) ((JList) e.getSource()).getSelectedValue());
    }
  }

  public Vector getNames() {
    return party;
  }

  public void updateNewPatron(Bowler newPatron) {
    try {
      Bowler checkBowler = BOWLER_FILE.get(newPatron.id);
      if (checkBowler == null) {
        BOWLER_FILE.add(newPatron);
        bowlerdb = new Vector(bowlerNicknames(BOWLER_FILE.getAll().values()));
        allBowlers.setListData(bowlerdb);
        party.add(newPatron.id);
        partyList.setListData(party);
      } else {
        System.err.println("A Bowler with that name already exists.");
      }
    } catch (Exception e) {
      System.err.println("File I/O Error");
    }
  }

  public Vector getParty() {
    return party;
  }

}
