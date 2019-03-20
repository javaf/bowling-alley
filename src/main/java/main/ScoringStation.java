package main;
import iiit.util.*;
import java.awt.Color;
import javax.swing.*;


public class ScoringStation extends JFrame {
  public final EventMap events;
  private final GamePanel[] games;
  private Lane lane;

  public ScoringStation() {
    initComponents();
    events = new EventMap();
    games = new GamePanel[] {game0, game1, game2, game3, game4, game5};
    events.on("maintenanceDone", (e, data) -> {
      maintenance.setBackground(null);
    });
    events.on("rollRequest", (e, data) -> roll.events().emit(e, data));
    roll.events().on("*", (e, data) -> events.emit(e, data));
  }
  
  public void update(Lane lane) {
    this.lane = lane;
    party.setText(lane.name());
    bowler.setText(lane.isEmpty()? "?" : lane.game().bowler().id());
    frame.setText(""+lane.progress());
    roll.update(lane.pinsetter());
    pinsetter.update(lane.pinsetter());
    for (int i=0; i<games.length; i++) {
      Game game = i<lane.size()? lane.get(i) : null;
      games[i].update(game);
      if (lane.game()==game) games[i].setBackground(Color.YELLOW);
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
    maintenance = new javax.swing.JButton();
    game5 = new main.GamePanel();
    roll = new main.RollPanel();

    setTitle("Scoring Station");

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
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(maintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
              .addComponent(pinsetter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(party, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(roll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(game1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(game2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(game3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(game5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(game0, javax.swing.GroupLayout.PREFERRED_SIZE, 1098, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(roll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(pinsetter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(maintenance))
          .addGroup(layout.createSequentialGroup()
            .addComponent(game1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(game2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(game3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(game4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(game5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(17, 17, 17)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void maintenanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maintenanceActionPerformed
    if (lane!=null) lane.status = "paused";
    maintenance.setBackground(Color.RED);
    maintenance.setText("Maintenance called");
    events.emit("maintenanceNeeded", null);
  }//GEN-LAST:event_maintenanceActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel bowler;
  private javax.swing.JLabel bowlerLabel;
  private javax.swing.JLabel frame;
  private javax.swing.JLabel frameLabel;
  private main.GamePanel game0;
  private main.GamePanel game1;
  private main.GamePanel game2;
  private main.GamePanel game3;
  private main.GamePanel game4;
  private main.GamePanel game5;
  private javax.swing.JButton maintenance;
  private javax.swing.JLabel party;
  private main.PinsetterPanel pinsetter;
  private main.RollPanel roll;
  // End of variables declaration//GEN-END:variables
}
