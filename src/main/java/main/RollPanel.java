package main;
import java.awt.Color;
import javax.swing.*;


public class RollPanel extends JPanel {
  private final JButton[] pins;

  
  public RollPanel() {
    initComponents();
    pins = new JButton[] {pin0, pin1, pin2, pin3, pin4, pin5, pin6, pin7, pin8, pin9};
  }
  
  public void update(Pinsetter pinsetter) {
    // turnValue.setText(""+pinsetter.turn());
    // standingValue.setText(""+pinsetter.standing());
    for(int i=0; i<pins.length; i++)
      pins[i].setBackground(pinsetter.pins()[i]? null : Color.GRAY);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel5 = new javax.swing.JLabel();
    rollLabel = new javax.swing.JLabel();
    dataPanel = new javax.swing.JPanel();
    gutter = new javax.swing.JTextField();
    jPanel1 = new javax.swing.JPanel();
    foul = new javax.swing.JTextField();
    foulLabel = new javax.swing.JLabel();
    pin6 = new javax.swing.JButton();
    pin7 = new javax.swing.JButton();
    pin8 = new javax.swing.JButton();
    pin9 = new javax.swing.JButton();
    pin3 = new javax.swing.JButton();
    pin4 = new javax.swing.JButton();
    pin5 = new javax.swing.JButton();
    pin1 = new javax.swing.JButton();
    pin2 = new javax.swing.JButton();
    pin0 = new javax.swing.JButton();
    gutterLabel = new javax.swing.JLabel();

    jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel5.setText("_");

    rollLabel.setBackground(new java.awt.Color(204, 204, 204));
    rollLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    rollLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    rollLabel.setText("Roll");
    rollLabel.setBorder(new javax.swing.border.MatteBorder(null));

    gutter.setText("0");

    javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
    dataPanel.setLayout(dataPanelLayout);
    dataPanelLayout.setHorizontalGroup(
      dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(gutter, javax.swing.GroupLayout.Alignment.TRAILING)
    );
    dataPanelLayout.setVerticalGroup(
      dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(gutter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    foul.setText("0");

    foulLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    foulLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    foulLabel.setText("Foul");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(foulLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(foul, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(foul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(foulLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pin6.setText("7");
    pin6.setFocusable(false);

    pin7.setText("8");
    pin7.setFocusable(false);

    pin8.setText("9");
    pin8.setFocusable(false);

    pin9.setText("10");
    pin9.setFocusable(false);

    pin3.setText("4");
    pin3.setFocusable(false);

    pin4.setText("5");
    pin4.setFocusable(false);

    pin5.setText("6");
    pin5.setFocusable(false);

    pin1.setText("2");
    pin1.setFocusable(false);

    pin2.setText("3");
    pin2.setFocusable(false);

    pin0.setText("1");
    pin0.setFocusable(false);

    gutterLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    gutterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    gutterLabel.setText("Gutter");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(gutterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(dataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(rollLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addComponent(pin6)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(pin7)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(pin8)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(pin9))
      .addGroup(layout.createSequentialGroup()
        .addGap(48, 48, 48)
        .addComponent(pin1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(pin2)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(pin3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(pin4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(pin5)
            .addGap(28, 28, 28))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(pin0)
            .addGap(69, 69, 69))))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(rollLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(dataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(gutterLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(pin6)
          .addComponent(pin7)
          .addComponent(pin8)
          .addComponent(pin9))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(pin5)
          .addComponent(pin4)
          .addComponent(pin3))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(pin1)
          .addComponent(pin2))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(pin0))
    );

    dataPanel.getAccessibleContext().setAccessibleName("Data");
  }// </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel dataPanel;
  private javax.swing.JTextField foul;
  private javax.swing.JLabel foulLabel;
  private javax.swing.JTextField gutter;
  private javax.swing.JLabel gutterLabel;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JButton pin0;
  private javax.swing.JButton pin1;
  private javax.swing.JButton pin2;
  private javax.swing.JButton pin3;
  private javax.swing.JButton pin4;
  private javax.swing.JButton pin5;
  private javax.swing.JButton pin6;
  private javax.swing.JButton pin7;
  private javax.swing.JButton pin8;
  private javax.swing.JButton pin9;
  private javax.swing.JLabel rollLabel;
  // End of variables declaration//GEN-END:variables
}
