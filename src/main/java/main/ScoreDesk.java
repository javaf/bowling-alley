package main;
import javax.swing.*;
import javax.swing.table.*;


public class ScoreDesk extends JFrame {
  private final RecordData recordData;
  
  
  public ScoreDesk() {
    this(null);
  }
  
  public ScoreDesk(RecordData recordData) {
    initComponents();
    this.recordData = recordData;
    setVisible(true);
  }


  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    query = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    rows = new javax.swing.JTable();
    queryButton = new javax.swing.JButton();

    setTitle("Score Desk");

    query.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    rows.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null}
      },
      new String [] {
        "Bowler", "Date", "Score"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.Integer.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(rows);

    queryButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    queryButton.setText("Query");
    queryButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        queryButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(query)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(queryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(query, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(queryButton))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void queryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryButtonActionPerformed
    try {
      DefaultTableModel model = (DefaultTableModel) rows.getModel();
      model.setRowCount(0);
      for (Record record : recordData.query(query.getText())) {
        model.addRow(new Object[] {record.id(), record.date(), record.score()});
        System.out.println(record);
      }
      model.fireTableStructureChanged();
    }
    catch (Exception e) {}
  }//GEN-LAST:event_queryButtonActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextField query;
  private javax.swing.JButton queryButton;
  private javax.swing.JTable rows;
  // End of variables declaration//GEN-END:variables
}
