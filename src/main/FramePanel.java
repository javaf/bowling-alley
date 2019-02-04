package main;
import javax.swing.*;

public class FramePanel extends JPanel {
  private final JLabel[] rolls;
  
  public FramePanel() {
    initComponents();
    rolls = new JLabel[] {roll0, roll1, roll2};
  }
  
  public void update(String id, Frame frame) {
    this.id.setText(id);
    for(int i=0; i<rolls.length; i++)
      rolls[i].setText(rollText(frame==null? null : (i<frame.size()? frame.get(i) : null)));
    score.setText(frame==null? "0" : ""+frame.score());
  }
  
  private String rollText(Roll roll) {
    if(roll==null) return "";
    if(roll.strike()) return "X";
    if(roll.spare()) return "/";
    if(roll.miss()) return "-";
    if(roll.foul()) return "F";
    if(roll.split()) return "S"+roll.score();
    if(roll.wide()) return "W"+roll.score();
    return ""+roll.score();
  }
  

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    id = new javax.swing.JLabel();
    roll0 = new javax.swing.JLabel();
    roll1 = new javax.swing.JLabel();
    roll2 = new javax.swing.JLabel();
    score = new javax.swing.JLabel();

    id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    id.setText("1");
    id.setPreferredSize(new java.awt.Dimension(8, 10));

    roll0.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    roll0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    roll0.setText(" ");
    roll0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    roll0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

    roll1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    roll1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    roll1.setText(" ");
    roll1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    roll1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

    roll2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    roll2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    roll2.setText(" ");
    roll2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    roll2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    roll2.setMaximumSize(new java.awt.Dimension(50, 50));
    roll2.setMinimumSize(new java.awt.Dimension(50, 50));

    score.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    score.setText("0");
    score.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    score.setPreferredSize(new java.awt.Dimension(11, 15));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(score, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(roll0, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(roll1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(roll2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addGap(0, 0, 0))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(roll0, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(roll1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(roll2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel id;
  private javax.swing.JLabel roll0;
  private javax.swing.JLabel roll1;
  private javax.swing.JLabel roll2;
  private javax.swing.JLabel score;
  // End of variables declaration//GEN-END:variables
}
