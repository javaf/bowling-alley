package main;
import iiit.util.*;
import java.awt.Color;
import javax.swing.*;


public class LanePanel extends JPanel {
  public final EventMap events;
  private final ScoringStation scoringStation; 
  private Lane lane;

  
  public LanePanel() {
    initComponents();
    events = new EventMap();
    scoringStation = new ScoringStation();
    events.on("laneComplete", (e, data) -> {
      scoringStation.events.emit(e, data);
    });
    scoringStation.events.on("roll", (e, data) -> events.emit(e, data));
    scoringStation.events.on("maintenanceNeeded", (e, data) -> {
      maintenance.setBackground(Color.RED);
      maintenance.setText("Maintenance");
    });
  }
  
  public void update(Lane lane) {
    this.lane = lane;
    bowler.setText(lane.isEmpty()? "?" : lane.game().bowler().id());
    frame.setText(""+(lane.isEmpty()? 0 : lane.progress()));
    pinsStanding.setText(""+lane.pinsetter().standing());
    setBackground(lane.complete()? null : Color.LIGHT_GRAY);
    if (scoringStation.isVisible()) scoringStation.update(lane);
  }
  

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    bowlerLabel = new javax.swing.JLabel();
    bowler = new javax.swing.JLabel();
    pinsStandingLabel = new javax.swing.JLabel();
    pinsStanding = new javax.swing.JLabel();
    showScore = new javax.swing.JButton();
    frameLabel = new javax.swing.JLabel();
    frame = new javax.swing.JLabel();
    maintenance = new javax.swing.JButton();

    bowlerLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    bowlerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    bowlerLabel.setText("Bowler");

    bowler.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    bowler.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    bowler.setText("?");

    pinsStandingLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    pinsStandingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    pinsStandingLabel.setText("Pins Standing");

    pinsStanding.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    pinsStanding.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    pinsStanding.setText("10");

    showScore.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    showScore.setText("Show Score");
    showScore.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        showScoreActionPerformed(evt);
      }
    });

    frameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    frameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    frameLabel.setText("Frame");

    frame.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    frame.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    frame.setText("1");

    maintenance.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    maintenance.setText("Lane ok");
    maintenance.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        maintenanceActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(frameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(frame, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(bowlerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(bowler, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(pinsStandingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(pinsStanding, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(showScore, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(maintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(showScore, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(maintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addComponent(frameLabel)
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(frame))
        .addGroup(layout.createSequentialGroup()
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(bowlerLabel)
            .addComponent(pinsStandingLabel))
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(bowler)
            .addComponent(pinsStanding))))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void maintenanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maintenanceActionPerformed
    if (lane!=null) lane.status = "ok";
    maintenance.setBackground(null);
    maintenance.setText("Lane ok");
    scoringStation.events.emit("maintenanceDone", null);
  }//GEN-LAST:event_maintenanceActionPerformed

  private void showScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showScoreActionPerformed
    scoringStation.setVisible(!scoringStation.isVisible());
  }//GEN-LAST:event_showScoreActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel bowler;
  private javax.swing.JLabel bowlerLabel;
  private javax.swing.JLabel frame;
  private javax.swing.JLabel frameLabel;
  private javax.swing.JButton maintenance;
  private javax.swing.JLabel pinsStanding;
  private javax.swing.JLabel pinsStandingLabel;
  private javax.swing.JButton showScore;
  // End of variables declaration//GEN-END:variables
}
