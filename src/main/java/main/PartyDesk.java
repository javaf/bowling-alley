package main;
import iiit.swing.*;
import iiit.util.*;
import javax.swing.*;


public class PartyDesk extends JFrame implements Publisher {
  public final Party party;
  private final BowlerData bowlers;
  private final EventMap events;

  
  public PartyDesk() {
    this(new BowlerData());
  }
  
  public PartyDesk(BowlerData bowlers) {
    initComponents();
    events = new EventMap();
    party = new Party();
    this.bowlers = bowlers;
    partyList.setListData(party.ids());
    bowlerList.setListData(bowlers.ids());
  }

  
  @Override
  public EventMap events() {
    return events;
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
    message = new javax.swing.JLabel();

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
        .addComponent(jScrollPane1)
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
        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
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

    message.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    message.setText(" ");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(partyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bowlersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(addParty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(removeParty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(addBowler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(finished, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(message)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(partyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(addParty)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(removeParty)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(addBowler)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(finished))
          .addComponent(bowlersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void addPartyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPartyActionPerformed
    Bowler bowler = bowlers.get(bowlerList.getSelectedValue());
    if (party.full()) { message.setText("Party is full!"); return; }
    if (bowler==null) { message.setText("Bowler not found!"); return; }
    if (party.contains(bowler)) { message.setText("Bowler already added!"); return; }
    party.add(bowler);
    partyList.setListData(party.ids());
  }//GEN-LAST:event_addPartyActionPerformed

  private void removePartyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePartyActionPerformed
    Bowler bowler = bowlers.get(partyList.getSelectedValue());
    if (party.isEmpty()) { message.setText("Party is empty!"); return; }
    if (bowler==null) { message.setText("Bowler not found!"); return; }
    party.remove(bowler);
    partyList.setListData(party.ids());
  }//GEN-LAST:event_removePartyActionPerformed

  private void addBowlerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBowlerActionPerformed
    RegistrationDesk registrationDesk = new RegistrationDesk(bowlers);
    JFrames.showCenter(registrationDesk);
    registrationDesk.events().on("bowlerRegister", (e, data) -> {
      Bowler bowler = (Bowler)data;
      party.add(bowler);
      bowlerList.setListData(bowlers.ids());
      partyList.setListData(party.ids());
    });
  }//GEN-LAST:event_addBowlerActionPerformed

  private void finishedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishedActionPerformed
    events.emit("partyAdd", party);
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
  private javax.swing.JLabel message;
  private javax.swing.JList<String> partyList;
  private javax.swing.JPanel partyPanel;
  private javax.swing.JButton removeParty;
  // End of variables declaration//GEN-END:variables
}
