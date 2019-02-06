package main;
import iiit.swing.*;
import iiit.util.*;
import java.io.*;
import javax.swing.*;


public class PartyDesk extends JFrame {
  public final EventEmitter events;
  public final BowlerMap bowlerMap;
  public final Party party;
  private static final String BOWLERS_FILE = "BOWLERS.DAT";

  
  public PartyDesk() {
    initComponents();
    events = new EventEmitter();
    bowlerMap = new BowlerMap(BOWLERS_FILE);
    party = new Party();
    try { bowlerMap.load(); }
    catch (IOException e) { System.err.println(e); }
    partyList.setListData(party.ids());
    bowlerList.setListData(bowlerMap.ids());
    JFrames.screenCenter(this);
    setVisible(true);;
  }

  
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    partyPanel = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    partyList = new javax.swing.JList<>();
    bowlersPanel = new javax.swing.JPanel();
    jScrollPane2 = new javax.swing.JScrollPane();
    bowlerList = new javax.swing.JList<>();
    addParty = new javax.swing.JButton();
    removeParty = new javax.swing.JButton();
    addBowler = new javax.swing.JButton();
    finished = new javax.swing.JButton();

    setTitle("Party Desk");

    partyPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Your Party", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

    partyList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    partyList.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    partyList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jScrollPane1.setViewportView(partyList);

    javax.swing.GroupLayout partyPanelLayout = new javax.swing.GroupLayout(partyPanel);
    partyPanel.setLayout(partyPanelLayout);
    partyPanelLayout.setHorizontalGroup(
      partyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(partyPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
        .addContainerGap())
    );
    partyPanelLayout.setVerticalGroup(
      partyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(partyPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
        .addContainerGap())
    );

    bowlersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bowlers", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

    bowlerList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    bowlerList.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    bowlerList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jScrollPane2.setViewportView(bowlerList);

    javax.swing.GroupLayout bowlersPanelLayout = new javax.swing.GroupLayout(bowlersPanel);
    bowlersPanel.setLayout(bowlersPanelLayout);
    bowlersPanelLayout.setHorizontalGroup(
      bowlersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(bowlersPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
        .addContainerGap())
    );
    bowlersPanelLayout.setVerticalGroup(
      bowlersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(bowlersPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane2)
        .addContainerGap())
    );

    addParty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    addParty.setText("Add Bowler");
    addParty.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addPartyActionPerformed(evt);
      }
    });

    removeParty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    removeParty.setText("Remove Bowler");
    removeParty.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        removePartyActionPerformed(evt);
      }
    });

    addBowler.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    addBowler.setText("New Patron");
    addBowler.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addBowlerActionPerformed(evt);
      }
    });

    finished.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    finished.setText("Finished");
    finished.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        finishedActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(partyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(bowlersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(addParty, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(removeParty, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(addBowler, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(finished, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(addParty)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(removeParty)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(addBowler)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(finished)
            .addGap(0, 0, Short.MAX_VALUE))
          .addComponent(partyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(bowlersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void addPartyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPartyActionPerformed
    Bowler bowler = bowlerMap.get(bowlerList.getSelectedValue());
    System.out.println("addPartyActionPerformed: "+bowler);
    if (bowler==null || party.size()>=5) System.err.println("Party already full!");
    else {
      if (party.contains(bowler)) System.err.println("Bowler already added!");
      party.add(bowler);
      partyList.setListData(party.ids());
    }
  }//GEN-LAST:event_addPartyActionPerformed

  private void removePartyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePartyActionPerformed
    Bowler bowler = bowlerMap.get(partyList.getSelectedValue());
    if (bowler==null || party.isEmpty()) System.err.println("Bowler not found!");
    else {
      party.remove(bowler);
      partyList.setListData(party.ids());
    }
  }//GEN-LAST:event_removePartyActionPerformed

  private void addBowlerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBowlerActionPerformed
    RegistrationDesk registrationDesk = new RegistrationDesk();
    registrationDesk.events.on("register", (event, value) -> {
      Bowler bowler = (Bowler) value;
      if (bowler==null || bowler.id().length()==0) System.err.println("Bad Patron name!");
      else if (bowlerMap.containsKey(bowler.id())) System.err.println("Patron already exists!");
      else {
        try { bowlerMap.add(bowler); }
        catch (IOException e) { System.err.println(e); }
        party.add(bowler);
        bowlerList.setListData(bowlerMap.ids());
        partyList.setListData(party.ids());
      }      
    });
  }//GEN-LAST:event_addBowlerActionPerformed

  private void finishedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishedActionPerformed
    events.emit("finished", party);
    setVisible(false);
  }//GEN-LAST:event_finishedActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton addBowler;
  private javax.swing.JButton addParty;
  private javax.swing.JList<String> bowlerList;
  private javax.swing.JPanel bowlersPanel;
  private javax.swing.JButton finished;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JList<String> partyList;
  private javax.swing.JPanel partyPanel;
  private javax.swing.JButton removeParty;
  // End of variables declaration//GEN-END:variables
}
