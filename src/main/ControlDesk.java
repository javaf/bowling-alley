package main;
import iiit.swing.*;
import iiit.util.*;
import java.util.*;
import javax.swing.*;


public class ControlDesk extends JFrame {
  private final LanePanel[] lanes;
  public final EventEmitter events;

  public ControlDesk() {
    initComponents();
    lanes = new LanePanel[] {lane0, lane1, lane2};
    events = new EventEmitter();
    JFrames.screenCenter(this);
    setVisible(true);
  }
  
  public void update(ArrayList<Party> partyQueue, ArrayList<Lane> lanes) {
    this.partyQueue.setListData(null);
  }


  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    partyQueueLabel = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    partyQueue = new javax.swing.JList<>();
    lanesLabel = new javax.swing.JLabel();
    lane0 = new main.LanePanel();
    lane1 = new main.LanePanel();
    lane2 = new main.LanePanel();
    addParty = new javax.swing.JButton();
    finished = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Control Desk");

    partyQueueLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    partyQueueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    partyQueueLabel.setText("Party Queue");

    partyQueue.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jScrollPane1.setViewportView(partyQueue);

    lanesLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lanesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lanesLabel.setText("Lanes");

    lane0.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lane 1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

    lane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lane 2", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

    lane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lane 3", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

    addParty.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    addParty.setText("Add Party");
    addParty.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addPartyActionPerformed(evt);
      }
    });

    finished.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(partyQueueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jScrollPane1)
          .addComponent(addParty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(finished, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(lane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(lane0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(lanesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(lane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(partyQueueLabel)
          .addComponent(lanesLabel))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(lane0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(addParty)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(finished)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void addPartyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPartyActionPerformed
    PartyDesk partyDesk = new PartyDesk();
    partyDesk.events.on("finished", (event, value) -> {
      events.emit("addParty", value);
    });
  }//GEN-LAST:event_addPartyActionPerformed

  private void finishedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishedActionPerformed
    events.emit("finished", null);
  }//GEN-LAST:event_finishedActionPerformed

  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton addParty;
  private javax.swing.JButton finished;
  private javax.swing.JScrollPane jScrollPane1;
  private main.LanePanel lane0;
  private main.LanePanel lane1;
  private main.LanePanel lane2;
  private javax.swing.JLabel lanesLabel;
  private javax.swing.JList<String> partyQueue;
  private javax.swing.JLabel partyQueueLabel;
  // End of variables declaration//GEN-END:variables
}
