package main;
import iiit.swing.*;
import iiit.util.*;
import java.util.*;
import javax.swing.*;


public class ControlDesk extends JFrame implements Publisher {
  private final LanePanel[] lanes;
  private final BowlerData bowlers;
  private final EventMap events;
  
  
  public ControlDesk() {
    this(new BowlerData());
  }
  
  public ControlDesk(BowlerData bowlers) {
    initComponents();
    events = new EventMap();
    lanes = new LanePanel[] {lane0, lane1, lane2};
    this.bowlers = bowlers;
    lane0.events.on("roll", (e, data) -> events.emit("roll0", data));
    lane1.events.on("roll", (e, data) -> events.emit("roll1", data));
    lane2.events.on("roll", (e, data) -> events.emit("roll2", data));
    events.on("laneComplete", (e, data) -> {
      lanes[(int)data].events.emit(e, data);
    });
  }
  
  
  public void update(PartyQueue partyQueue, List<Lane> lanes) {
    this.partyQueue.setListData(partyQueue.names());
    for (int i=0; i<this.lanes.length; i++)
      this.lanes[i].update(lanes.get(i));
  }
  
  @Override
  public EventMap events() {
    return events;
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    partyQueueLabel = new javax.swing.JLabel();
    lanesLabel = new javax.swing.JLabel();
    lane0 = new main.LanePanel();
    lane1 = new main.LanePanel();
    lane2 = new main.LanePanel();
    addParty = new javax.swing.JButton();
    finished = new javax.swing.JButton();
    partyQueuePane = new javax.swing.JScrollPane();
    partyQueue = new javax.swing.JList<>();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Control Desk");

    partyQueueLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    partyQueueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    partyQueueLabel.setText("Party Queue");

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

    partyQueue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    partyQueue.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    partyQueuePane.setViewportView(partyQueue);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(partyQueueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(addParty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(finished, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
          .addComponent(partyQueuePane, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
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
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(lane0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(partyQueuePane, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    PartyDesk partyDesk = new PartyDesk(bowlers);
    JFrames.showCenter(partyDesk);
    partyDesk.events().on("*", (e, data) -> events.emit(e, data));
  }//GEN-LAST:event_addPartyActionPerformed

  private void finishedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishedActionPerformed
    events.emit("close", null);
  }//GEN-LAST:event_finishedActionPerformed

  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton addParty;
  private javax.swing.JButton finished;
  private main.LanePanel lane0;
  private main.LanePanel lane1;
  private main.LanePanel lane2;
  private javax.swing.JLabel lanesLabel;
  private javax.swing.JList<String> partyQueue;
  private javax.swing.JLabel partyQueueLabel;
  private javax.swing.JScrollPane partyQueuePane;
  // End of variables declaration//GEN-END:variables
}
