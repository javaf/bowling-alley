package main;
import iiit.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.util.*;


public class PartyDeskAdapter implements ActionListener, ListSelectionListener {
  private final JFrame frame;
  private final JList partyList, fileList;
  private final JButtonPanel addBowler, newBowler, removeBowler, finished;
  private String fileSelect, partySelect;
  private Party party;
  private BowlerMap bowlers;
  private int capacity;
  private ControlDeskView controlDesk;
  private static final BowlerMap BOWLER_FILE = new BowlerMap("BOWLERS.DAT");
  

  public PartyDeskAdapter(ControlDeskView controlDesk, int capacity) {
    this.controlDesk = controlDesk;
    this.capacity = capacity;

    frame = new JFrame("Party Desk");
    frame.getContentPane().setLayout(new BorderLayout());
    ((JPanel) frame.getContentPane()).setOpaque(false);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(1, 3));

    JPanel partyPanel = new JPanel();
    partyPanel.setLayout(new FlowLayout());
    partyPanel.setBorder(new TitledBorder("Your Party"));

    party = new Party();
    Vector empty = new Vector();
    empty.add("(Empty)");

    partyList = new JList(empty);
    partyList.setFixedCellWidth(120);
    partyList.setVisibleRowCount(5);
    partyList.addListSelectionListener(this);
    JScrollPane partyPane = new JScrollPane(partyList);
    partyPanel.add(partyPane);

    JPanel filePanel = new JPanel();
    filePanel.setLayout(new FlowLayout());
    filePanel.setBorder(new TitledBorder("Bowler File"));

    bowlers = new BowlerMap(BOWLER_FILE.file());
    try {
      bowlers.load();
    } catch (IOException e) {
      System.err.println("File Error");
      System.err.println(e);
    }
    fileList = new JList(bowlerIds());
    fileList.setVisibleRowCount(8);
    fileList.setFixedCellWidth(120);
    JScrollPane bowlerPane = new JScrollPane(fileList);
    bowlerPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    fileList.addListSelectionListener(this);
    filePanel.add(bowlerPane);

    JPanel buttons = new JPanel();
    buttons.setLayout(new GridLayout(4, 1));
    buttons.add(addBowler = new JButtonPanel("Add to Party", this));
    buttons.add(removeBowler = new JButtonPanel("Remove from Party", this));
    buttons.add(newBowler = new JButtonPanel("New Patron", this));
    buttons.add(finished = new JButtonPanel("Finished", this));

    // Clean up main panel
    panel.add(partyPanel);
    panel.add(filePanel);
    panel.add(buttons);

    frame.getContentPane().add("Center", panel);
    frame.pack();
    JFrames.screenCenter(frame);
    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (source.equals(addBowler.button)) {
      if (fileSelect!=null && party.size()<capacity) {
        Bowler bowler = bowlers.get(fileSelect);
        if (party.contains(bowler)) {
          System.err.println("Member already in Party");
        } else {
          party.add(bowler);
          partyList.setListData(partyIds());
        }
      }
    }
    if (source.equals(removeBowler.button)) {
      if (partySelect!=null) {
        Bowler bowler = bowlers.get(partySelect);
        party.remove(bowler);
        partyList.setListData(partyIds());
      }
    }
    if (source.equals(newBowler.button)) {
      RegistrationDesk newPatron = new RegistrationDesk();
      newPatron.events.on("register", (String event, Object value) -> {
        updateNewPatron((Bowler)value);
      });
    }
    if (source.equals(finished.button)) {
      if (party!=null && party.size()>0)
        controlDesk.updateAddParty(this);
      // emit("end", party)
      frame.setVisible(false);
    }

  }

  @Override
  public void valueChanged(ListSelectionEvent e) {
    Object source = e.getSource();
    if (source.equals(fileList))
      fileSelect = (String) ((JList)source).getSelectedValue();
    if (source.equals(partyList))
      partySelect = (String) ((JList)source).getSelectedValue();
  }

  public Vector partyIds() {
    return new Vector(Arrays.asList(party.ids()));
  }
  
  public Vector bowlerIds() {
    return new Vector(Arrays.asList(bowlers.ids()));
  }

  private void updateNewPatron(Bowler bowler) {
    try {
      if (bowlers.containsKey(bowler))
        System.err.println("A bowler with that id already exists.");
      bowlers.add(bowler);
      fileList.setListData(bowlerIds());
      party.add(bowler);
      partyList.setListData(partyIds());
    } catch (IOException e) {
      System.err.println("File I/O Error");
    }
  }
}
