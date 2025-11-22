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
import java.util.List;


public class Pass extends javax.swing.JFrame {

    /**
     * Creates new form Pass
     */
    public Pass() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        ButtonForgot = new javax.swing.JButton();
        tfHobi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORGOT PASSWORD");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("USERNAME");

        tfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsernameActionPerformed(evt);
            }
        });

        ButtonForgot.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ButtonForgot.setText("FORGOT PASSWORD");
        ButtonForgot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonForgotActionPerformed(evt);
            }
        });

        tfHobi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHobiActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("HOBI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfHobi, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ButtonForgot, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHobi, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(ButtonForgot, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUsernameActionPerformed

    private void ButtonForgotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonForgotActionPerformed
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBKeduaPU");
        EntityManager em = emf.createEntityManager();

        try {
            String username = tfUsername.getText();
            String hobi = tfHobi.getText();

            if (username.isEmpty() || hobi.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Isi username dan hobi terlebih dahulu!");
                return;
            }

            // Cek username + hobi cocok
            TypedQuery<Pw> query = em.createQuery(
                    "SELECT p FROM Pw p WHERE p.username = :u AND p.hobi = :h", Pw.class);
            query.setParameter("u", username);
            query.setParameter("h", hobi);

            List<Pw> result = query.getResultList();

            if (!result.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Data cocok. Silakan ubah password Anda.");
                new ResetPass(username).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Username atau hobi salah!");
            }

        } finally {
            em.close();
            emf.close();
        }
    }//GEN-LAST:event_ButtonForgotActionPerformed

    private void tfHobiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHobiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHobiActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonForgot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tfHobi;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
