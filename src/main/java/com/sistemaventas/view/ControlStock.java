package com.sistemaventas.view;

public class ControlStock extends javax.swing.JFrame {

    public ControlStock() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCreate = new javax.swing.JButton();
        btnCreate1 = new javax.swing.JButton();
        btnCreate2 = new javax.swing.JButton();
        btnCreate3 = new javax.swing.JButton();
        btnCreate4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(21, 30, 33));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Control de Stock");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 790, 510));

        btnCreate.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnCreate.setText("Crear Producto");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, 190, 50));

        btnCreate1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnCreate1.setText("Salir");
        btnCreate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreate1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 530, 190, 50));

        btnCreate2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnCreate2.setText("Editar Producto");
        btnCreate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreate2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 180, 190, 50));

        btnCreate3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnCreate3.setText("Eliminar Producto");
        btnCreate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreate3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreate3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 250, 190, 50));

        btnCreate4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnCreate4.setText("Recargar Tabla");
        btnCreate4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreate4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreate4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 320, 190, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnCreate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreate1ActionPerformed
        
    }//GEN-LAST:event_btnCreate1ActionPerformed

    private void btnCreate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreate2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreate2ActionPerformed

    private void btnCreate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreate3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreate3ActionPerformed

    private void btnCreate4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreate4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreate4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnCreate1;
    private javax.swing.JButton btnCreate2;
    private javax.swing.JButton btnCreate3;
    private javax.swing.JButton btnCreate4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
