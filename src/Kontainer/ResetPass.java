/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Kontainer;

/**
 *
 * @author Alif
 */
import javax.persistence.*;
import javax.swing.JOptionPane;

public class ResetPass extends javax.swing.JFrame {

    private String username;
    
    /**
     * Creates new form ResetPass
     */
    public ResetPass(String username) {
        initComponents();
        setLocationRelativeTo(null);
        this.username = username;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pfPassword = new javax.swing.JPasswordField();
        pfConfirmPassword = new javax.swing.JPasswordField();
        ButtonResetPassword = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RESET PASSWORD");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PASSWORD");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CONFIRM PASSWORD");

        ButtonResetPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonResetPassword.setText("RESET PASSWORD");
        ButtonResetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonResetPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pfConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(ButtonResetPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pfConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(34, 34, 34)
                .addComponent(ButtonResetPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonResetPasswordActionPerformed
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBKeduaPU");
        EntityManager em = emf.createEntityManager();

        try {
            String newPass1 = new String(pfPassword.getPassword());
            String newPass2 = new String(pfConfirmPassword.getPassword());

            if (newPass1.isEmpty() || newPass2.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Password tidak boleh kosong!");
                return;
            }

            if (!newPass1.equals(newPass2)) {
                JOptionPane.showMessageDialog(this, "Password tidak cocok!");
                return;
            }

            Kontainer.Pw user = em.find(Kontainer.Pw.class, username);

            if (user != null) {
                em.getTransaction().begin();
                user.setPassword(newPass1);
                em.getTransaction().commit();

                JOptionPane.showMessageDialog(this, "Password berhasil diubah!");
                this.dispose();
                new LoginMain().setVisible(true); // ganti dengan nama form login kamu
            } else {
                JOptionPane.showMessageDialog(this, "Username tidak ditemukan!");
            }

        } finally {
            em.close();
            emf.close();
        }
    }//GEN-LAST:event_ButtonResetPasswordActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonResetPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField pfConfirmPassword;
    private javax.swing.JPasswordField pfPassword;
    // End of variables declaration//GEN-END:variables
}
