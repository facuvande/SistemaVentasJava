package com.sistemaventas.view;

import com.sistemaventas.logic.Controller;
import com.sistemaventas.logic.Pedido;
import com.sistemaventas.logic.Producto;
import com.sistemaventas.logic.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VisualizacionPedido extends javax.swing.JFrame {

    Controller control = null;
    int idPedido;
    
    public VisualizacionPedido(Controller control, int idPedido) {
        initComponents();
        this.control = control;
        this.idPedido = idPedido;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVentas = new javax.swing.JTable();
        lblId = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(21, 30, 33));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableVentas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 670, 480));

        lblId.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        lblId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

        jButton1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 500, 190, 40));

        btnBack.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 0, 0));
        btnBack.setText("<");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 50, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Productos de pedido con id:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();
        lblId.setText(String.valueOf(idPedido));
    }//GEN-LAST:event_formWindowOpened

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cargarTabla(){
        // Definir modelo de la tabla
        DefaultTableModel tableModel = new DefaultTableModel(){
            // Que filas y columnas no sean editables
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        // Establecemos nombres de las columnas
        String titles[] = {"Id Producto", "Nombre", "Precio", "Stock", "Cod. Barra"};
        tableModel.setColumnIdentifiers(titles);
        
        // Traemos Ventas y cargamos al modelo
        Pedido pedido = control.getPedidosById(idPedido);
        List<Producto> productos = pedido.getProductos();
        
        if(pedido != null){
            for(Producto producto : productos){
                Object[] objeto = {producto.getId_producto(), producto.getName(), producto.getPrice(), producto.getStock(), producto.getBarcode()};
                tableModel.addRow(objeto);
            }
        }
        
        // Cargamos modelo a la tabla
        tableVentas.setModel(tableModel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JTable tableVentas;
    // End of variables declaration//GEN-END:variables

    
}
