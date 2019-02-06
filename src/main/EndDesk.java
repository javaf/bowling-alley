package main;
import iiit.swing.JFrames;
import iiit.util.EventEmitter;
import javax.swing.*;

public class EndDesk extends JFrame {
  public final EventEmitter events;
  private final Party party;

  
  public EndDesk() {
    this(null);
  }
  
  public EndDesk(Party party) {
    initComponents();
    this.party = party;
    events = new EventEmitter();
    partyList.setListData(party.ids());
    JFrames.screenCenter(this);
    setVisible(true);
  }
  
  
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    ask = new javax.swing.JLabel();
    playAnother = new javax.swing.JButton();
    printReport = new javax.swing.JButton();
    partyListPane = new javax.swing.JScrollPane();
    partyList = new javax.swing.JList<>();
    emailReport = new javax.swing.JButton();
    message = new javax.swing.JLabel();

    setTitle("End Desk");

    ask.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    ask.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    ask.setText("Anonymous Party game complete!");

    playAnother.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    playAnother.setText("Play Another");
    playAnother.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        playAnotherActionPerformed(evt);
      }
    });

    printReport.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    printReport.setText("Print Report");
    printReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        printReportActionPerformed(evt);
      }
    });

    partyList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    partyList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    partyListPane.setViewportView(partyList);

    emailReport.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    emailReport.setText("Email Report");
    emailReport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        emailReportActionPerformed(evt);
      }
    });

    message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    message.setText(" ");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(ask, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(partyListPane)
          .addGroup(layout.createSequentialGroup()
            .addComponent(playAnother, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(printReport, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(emailReport, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
          .addComponent(message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(ask)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(partyListPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(playAnother)
          .addComponent(printReport)
          .addComponent(emailReport))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void playAnotherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playAnotherActionPerformed
    events.emit("partyQueue", party);
    setVisible(false);
  }//GEN-LAST:event_playAnotherActionPerformed

  private void printReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printReportActionPerformed
    Bowler bowler = partyListBowler();
    if (bowler!=null) events.emit("bowlerPrint", bowler);
  }//GEN-LAST:event_printReportActionPerformed

  private void emailReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailReportActionPerformed
    Bowler bowler = partyListBowler();
    if (bowler!=null) events.emit("partyEmail", party);
  }//GEN-LAST:event_emailReportActionPerformed


  private Bowler partyListBowler() {
    int i = partyList.getSelectedIndex();
    if (i>=0) return party.get(i);
    message.setText("Please select bowler!");
    return null;
  }
  

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel ask;
  private javax.swing.JButton emailReport;
  private javax.swing.JLabel message;
  private javax.swing.JList<String> partyList;
  private javax.swing.JScrollPane partyListPane;
  private javax.swing.JButton playAnother;
  private javax.swing.JButton printReport;
  // End of variables declaration//GEN-END:variables
}
