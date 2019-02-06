package main;
import iiit.swing.*;
import iiit.util.*;
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.*;


public class ScoringStation extends JFrame {
  public final EventEmitter events;
  private final GamePanel[] games;

  public ScoringStation() {
    initComponents();
    events = new EventEmitter();
    games = new GamePanel[] {game0, game1, game2, game3, game4};
    JFrames.screenCenter(this);
    events.on("maintenanceDone", (event, value) -> {
      maintenance.setBackground(null);
    });
  }
  
  public void update(Lane lane) {
    party.setText(lane.name());
    bowler.setText(lane.bowler().id());
    frame.setText(""+(lane.frame()+1));
    pinsetter.update(lane.pinsetter());
    for (int i=0; i<games.length; i++) {
      Game game = i<lane.size()? lane.get(i) : null;
      if (game!=null) game.score();
      games[i].setBackground(game==null? null : Color.YELLOW);
      ((TitledBorder) games[i].getBorder()).setTitle(game==null? "No Game" : game.name());
      games[i].update(game);
    }
  }


  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    pinsetter = new main.PinsetterPanel();
    game1 = new main.GamePanel();
    game0 = new main.GamePanel();
    game2 = new main.GamePanel();
    game3 = new main.GamePanel();
    game4 = new main.GamePanel();
    party = new javax.swing.JLabel();
    bowlerLabel = new javax.swing.JLabel();
    frameLabel = new javax.swing.JLabel();
    bowler = new javax.swing.JLabel();
    frame = new javax.swing.JLabel();
    pause = new javax.swing.JButton();
    abort = new javax.swing.JButton();
    maintenance = new javax.swing.JButton();

    setTitle("Scoring Station");

    game1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bowler's Game", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

    game0.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bowler's Game", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

    game2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bowler's Game", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

    game3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bowler's Game", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

    game4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bowler's Game", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

    party.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    party.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    party.setText("Bowler's Party");

    bowlerLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    bowlerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    bowlerLabel.setText("Bowler");

    frameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    frameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    frameLabel.setText("Frame");

    bowler.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    bowler.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    bowler.setText("?");

    frame.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    frame.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    frame.setText("1");

    pause.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    pause.setText("Pause Game");
    pause.setMaximumSize(new java.awt.Dimension(110, 25));
    pause.setMinimumSize(new java.awt.Dimension(110, 25));
    pause.setPreferredSize(new java.awt.Dimension(110, 25));
    pause.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        pauseActionPerformed(evt);
      }
    });

    abort.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    abort.setText("Abort Game");
    abort.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        abortActionPerformed(evt);
      }
    });

    maintenance.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    maintenance.setText("Call Maintenance");
    maintenance.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        maintenanceActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(frameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(bowlerLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(bowler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(frame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
          .addGroup(layout.createSequentialGroup()
            .addComponent(party, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(pinsetter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(pause, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(abort, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(maintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(game0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(game1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(game2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(game3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(game4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addGroup(layout.createSequentialGroup()
            .addComponent(party)
            .addGap(16, 16, 16)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(bowlerLabel)
              .addComponent(bowler))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(frameLabel)
              .addComponent(frame)))
          .addComponent(game0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(1, 1, 1)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(game1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(game2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(game3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(game4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(pinsetter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(pause, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(abort)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(maintenance)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseActionPerformed
    events.emit("pauseGame", null);
  }//GEN-LAST:event_pauseActionPerformed

  private void abortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abortActionPerformed
    events.emit("abortGame", null);
  }//GEN-LAST:event_abortActionPerformed

  private void maintenanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maintenanceActionPerformed
    maintenance.setBackground(Color.RED);
    maintenance.setText("Maintenance called");
    events.emit("maintenanceNeeded", null);
  }//GEN-LAST:event_maintenanceActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton abort;
  private javax.swing.JLabel bowler;
  private javax.swing.JLabel bowlerLabel;
  private javax.swing.JLabel frame;
  private javax.swing.JLabel frameLabel;
  private main.GamePanel game0;
  private main.GamePanel game1;
  private main.GamePanel game2;
  private main.GamePanel game3;
  private main.GamePanel game4;
  private javax.swing.JButton maintenance;
  private javax.swing.JLabel party;
  private javax.swing.JButton pause;
  private main.PinsetterPanel pinsetter;
  // End of variables declaration//GEN-END:variables
}
