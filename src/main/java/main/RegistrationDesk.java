package main;
import iiit.util.*;
import java.util.*;
import java.util.regex.*;
import javax.swing.*;


public class RegistrationDesk extends JFrame implements Publisher {
  private final EventMap events;
  private final Map<String, Bowler> bowlers;
  

  public RegistrationDesk() {
    this(new HashMap<>());
  }
  
  public RegistrationDesk(Map<String, Bowler> bowlers) {
    initComponents();
    events = new EventMap();
    this.bowlers = bowlers;
  }
  
  @Override
  public EventMap events() {
    return events;
  }

  
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    newPatron = new javax.swing.JPanel();
    idLabel = new javax.swing.JLabel();
    id = new javax.swing.JTextField();
    nameLabel = new javax.swing.JLabel();
    name = new javax.swing.JTextField();
    emailLabel = new javax.swing.JLabel();
    email = new javax.swing.JTextField();
    message = new javax.swing.JLabel();
    skill = new javax.swing.JTextField();
    skillLabel = new javax.swing.JLabel();
    register = new javax.swing.JButton();
    cancel = new javax.swing.JButton();

    setTitle("Registration Desk");

    newPatron.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Patron", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

    idLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    idLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    idLabel.setText("Nickname");

    id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    nameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    nameLabel.setText("Fullname");

    name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    emailLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    emailLabel.setText("Email");

    email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    message.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    message.setText(" ");

    skill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    skill.setText("0");

    skillLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    skillLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    skillLabel.setText("Skill (for AI)");

    javax.swing.GroupLayout newPatronLayout = new javax.swing.GroupLayout(newPatron);
    newPatron.setLayout(newPatronLayout);
    newPatronLayout.setHorizontalGroup(
      newPatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(newPatronLayout.createSequentialGroup()
        .addGroup(newPatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(newPatronLayout.createSequentialGroup()
            .addGroup(newPatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newPatronLayout.createSequentialGroup()
                .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newPatronLayout.createSequentialGroup()
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newPatronLayout.createSequentialGroup()
                .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(0, 0, Short.MAX_VALUE))
          .addGroup(newPatronLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newPatronLayout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(skillLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(skill, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );
    newPatronLayout.setVerticalGroup(
      newPatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newPatronLayout.createSequentialGroup()
        .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(newPatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(idLabel)
          .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(newPatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(nameLabel)
          .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(newPatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(newPatronLayout.createSequentialGroup()
            .addGap(3, 3, 3)
            .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(newPatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(skillLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(skill))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    register.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    register.setText("Register");
    register.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        registerActionPerformed(evt);
      }
    });

    cancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    cancel.setText("Cancel");
    cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cancelActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(newPatron, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(newPatron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(register)
          .addComponent(cancel))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
    setVisible(false);
  }//GEN-LAST:event_cancelActionPerformed

  private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
    Bowler bowler = fieldsBowler();
    if (bowler==null) return;
    setVisible(false);
    bowlers.put(bowler.id(), bowler);
    events.emit("bowlerRegister", bowler);
  }//GEN-LAST:event_registerActionPerformed
  
  
  private Bowler fieldsBowler() {
    String error = null;
    if (!patternMatches("^\\w+$", id.getText())) error = "Nickname not valid!";
    else if (!patternMatches("^[\\w\\s]+$", name.getText())) error = "Fullname not valid!";
    else if (!patternMatches("^.+@.+\\..+$", email.getText())) error = "Email not valid!";
    else if (bowlers.containsKey(id.getText())) error = "Nickname already exists!";
    if (error!=null) { message.setText(error); return null; }
    return new Bowler(id.getText(), name.getText(), email.getText());
  }
  
  private static boolean patternMatches(String pattern, String text) {
    return Pattern.compile(pattern).matcher(text).matches();
  }
  
    
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton cancel;
  private javax.swing.JTextField email;
  private javax.swing.JLabel emailLabel;
  private javax.swing.JTextField id;
  private javax.swing.JLabel idLabel;
  private javax.swing.JLabel message;
  private javax.swing.JTextField name;
  private javax.swing.JLabel nameLabel;
  private javax.swing.JPanel newPatron;
  private javax.swing.JButton register;
  private javax.swing.JTextField skill;
  private javax.swing.JLabel skillLabel;
  // End of variables declaration//GEN-END:variables
}
