package com.sistemaventas.view;

import com.sistemaventas.logic.Controller;
import com.sistemaventas.logic.Usuario;

public class AdminMenu extends javax.swing.JFrame {
    
    Controller control = null;
    Usuario userLoged = null; 
    
    public AdminMenu(Usuario user) {
        initComponents();
        control = new Controller();
        userLoged = user;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNameUser = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnGestionEmpleados = new javax.swing.JButton();
        btnControlStock = new javax.swing.JButton();
        btnHistorialVentas = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnModoVendedor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNameUser.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtNameUser.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtNameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 310, 30));

        jPanel2.setBackground(new java.awt.Color(21, 30, 33));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        btnGestionEmpleados.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnGestionEmpleados.setText("Gestion de Empleados");
        btnGestionEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionEmpleadosActionPerformed(evt);
            }
        });

        btnControlStock.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnControlStock.setText("Control de Stock");
        btnControlStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlStockActionPerformed(evt);
            }
        });

        btnHistorialVentas.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnHistorialVentas.setText("Historial de Ventas");
        btnHistorialVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialVentasActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnModoVendedor.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnModoVendedor.setText("Modo vendedor");
        btnModoVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModoVendedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(323, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHistorialVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnControlStock, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGestionEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(314, 314, 314))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(btnGestionEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnModoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnHistorialVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnControlStock, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestionEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionEmpleadosActionPerformed
        GestionEmpleado miGestion = new GestionEmpleado(control);
        miGestion.setVisible(true);
        miGestion.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnGestionEmpleadosActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txtNameUser.setText("Bienvenid@ " + userLoged.getName());
    }//GEN-LAST:event_formWindowOpened

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
        Login miLogin = new Login();
        miLogin.setVisible(true);
        miLogin.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnControlStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControlStockActionPerformed
        ControlStock miControlStock = new ControlStock(control);
        miControlStock.setVisible(true);
        miControlStock.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnControlStockActionPerformed

    private void btnModoVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModoVendedorActionPerformed
        ModoVendedor vistaVendedor = new ModoVendedor(control, userLoged);
        vistaVendedor.setVisible(true);
        vistaVendedor.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnModoVendedorActionPerformed

    private void btnHistorialVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialVentasActionPerformed
        HistorialVentas myView = new HistorialVentas(control);
        myView.setVisible(true);
        myView.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHistorialVentasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnControlStock;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGestionEmpleados;
    private javax.swing.JButton btnHistorialVentas;
    private javax.swing.JButton btnModoVendedor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel txtNameUser;
    // End of variables declaration//GEN-END:variables
}
