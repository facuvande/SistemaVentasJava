package com.sistemaventas.view;

import com.sistemaventas.logic.Controller;
import com.sistemaventas.logic.Pedido;
import com.sistemaventas.logic.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class HistorialVentas extends javax.swing.JFrame {

    Controller control = null;
    
    public HistorialVentas(Controller control) {
        initComponents();
        this.control = control;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVentas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cmbUsers = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

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

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Historial de Ventas");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        cmbUsers.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cmbUsers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin filtro" }));
        cmbUsers.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbUsersItemStateChanged(evt);
            }
        });
        jPanel1.add(cmbUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, 150, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Filtrar Ventas por usuarios:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, -1, -1));

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
        List<Usuario> myUsers = control.getUsers();
        
        for(Usuario usu : myUsers){
            cmbUsers.addItem(usu.getName());
        }
    }//GEN-LAST:event_formWindowOpened

    private void cmbUsersItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbUsersItemStateChanged
        if(cmbUsers.getSelectedIndex() != 0){
            filtrarPorUsuario(cmbUsers.getItemAt(cmbUsers.getSelectedIndex()));
        }else{
            cargarTabla();
        }
    }//GEN-LAST:event_cmbUsersItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
        String titles[] = {"Id Pedido", "Fecha", "Monto Total", "Estado", "Vendedor"};
        tableModel.setColumnIdentifiers(titles);
        
        // Traemos Ventas y cargamos al modelo
        List<Pedido> listPedidos = control.getPedidos();
        
        if(listPedidos != null){
            for(Pedido pedi : listPedidos){
                Object[] objeto = {pedi.getId_pedido(), pedi.getDate_sale().toString(), pedi.getAmount_total(), pedi.getState(), pedi.getVendedor().getName()};
                tableModel.addRow(objeto);
            }
        }
        
        // Cargamos modelo a la tabla
        tableVentas.setModel(tableModel);
        
        tableVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                if(evt.getClickCount() == 2){
                    // se detecto doble click
                    int row = tableVentas.rowAtPoint(evt.getPoint());
                    int idPedido = (int) tableVentas.getValueAt(row, 0);
                    
                    VisualizacionPedido miVista = new VisualizacionPedido(control, idPedido);
                    miVista.setVisible(true);
                    miVista.setLocationRelativeTo(null);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<String> cmbUsers;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableVentas;
    // End of variables declaration//GEN-END:variables

    private void filtrarPorUsuario(String itemAt) {
        DefaultTableModel tableModel = (DefaultTableModel) tableVentas.getModel();

        List<Pedido> misPedidos = new ArrayList<>();
        
        for(int i=0; i < tableModel.getRowCount(); i++){
            // Obtenemos valores de cada celda en la fila
            int idPedido = (int) tableModel.getValueAt(i, 0);
            Pedido miPedi = control.getPedidosById(idPedido);
            Date fechaPedido = miPedi.getDate_sale();
            double ammount_total = (double) tableModel.getValueAt(i, 2);
            boolean state = (boolean) tableModel.getValueAt(i, 3);
            String vendedor = (String) tableModel.getValueAt(i, 4);
            
            if(vendedor.equalsIgnoreCase(itemAt)){
                Usuario miVendedor = new Usuario();
                miVendedor.setName(itemAt);
                
                Pedido miPedido = new Pedido();
                miPedido.setId_pedido(idPedido);
                miPedido.setDate_sale(fechaPedido);
                miPedido.setAmount_total(ammount_total);
                miPedido.setState(state);            
                miPedido.setVendedor(miVendedor);
                
                misPedidos.add(miPedido);
            }
            
        }
            tableModel.setRowCount(0);
        
            for(Pedido pedido : misPedidos){
                Object[] fila = {pedido.getId_pedido(), pedido.getDate_sale().toString(), pedido.getAmount_total(), pedido.getState(), pedido.getVendedor().getName()};
                tableModel.addRow(fila);
            }
    }
}
