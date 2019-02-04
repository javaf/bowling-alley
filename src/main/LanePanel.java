package main;
import iiit.util.*;
import java.awt.Color;
import javax.swing.*;


public class LanePanel extends JPanel {
  public final EventEmitter events;
  private ScoringStation scoringStation; 

  
  public LanePanel() {
    initComponents();
    events = new EventEmitter();
    scoringStation = new ScoringStation();
    events.on("maintenanceNeeded", (event, value) -> {
      maintenance.setBackground(Color.RED);
    });
  }
  
  public void update(Lane lane) {
    Bowler b = lane.bowler();
    bowler.setText(b==null? "?" : b.id());
    frame.setText(""+lane.frame());
    pinsStanding.setText(""+lane.pinsetter().standing());
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
    gameLabel = new javax.swing.JLabel();
    game = new javax.swing.JLabel();
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

    gameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    gameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    gameLabel.setText("Game");

    game.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    game.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    game.setText("1");

    frameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    frameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    frameLabel.setText("Frame");

    frame.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    frame.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    frame.setText("1");

    maintenance.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    maintenance.setText("Maintenance");
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
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(gameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(game, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        .addComponent(maintenance, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(showScore, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(maintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(gameLabel)
            .addComponent(frameLabel))
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(game)
            .addComponent(frame)))
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
    maintenance.setBackground(Color.GRAY);
    events.emit("maintenanceDone", null);
  }//GEN-LAST:event_maintenanceActionPerformed

  private void showScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showScoreActionPerformed
    scoringStation.setVisible(!scoringStation.isVisible());
  }//GEN-LAST:event_showScoreActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel bowler;
  private javax.swing.JLabel bowlerLabel;
  private javax.swing.JLabel frame;
  private javax.swing.JLabel frameLabel;
  private javax.swing.JLabel game;
  private javax.swing.JLabel gameLabel;
  private javax.swing.JButton maintenance;
  private javax.swing.JLabel pinsStanding;
  private javax.swing.JLabel pinsStandingLabel;
  private javax.swing.JButton showScore;
  // End of variables declaration//GEN-END:variables
}
