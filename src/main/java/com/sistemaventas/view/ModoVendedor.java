package com.sistemaventas.view;

import com.sistemaventas.logic.Controller;
import com.sistemaventas.logic.Pedido;
import com.sistemaventas.logic.Producto;
import com.sistemaventas.logic.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class ModoVendedor extends javax.swing.JFrame {

    Controller control;
    Usuario user = null;
    
    public ModoVendedor(Controller control, Usuario user) {
        initComponents();
        this.control = control;
        this.user = user;
        
        txtBarcode.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e){
                handleBarcondeChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                handleBarcondeChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
        txtQuantity.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                handleQuantityChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                handleQuantityChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
            
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();
        txtQuantity = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtTotalPrice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBarcode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPriceUnit = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
        btnCancel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtTotalAmmount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(21, 30, 33));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Modo vendedor");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        btnImprimir.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel1.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, 150, 50));

        txtQuantity.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jPanel1.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 60, 30));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Precio total:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        jButton1.setText("Modo Rapido");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 110, 30));

        txtTotalPrice.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jPanel1.add(txtTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 150, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Codigo barra:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        txtBarcode.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txtBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBarcodeActionPerformed(evt);
            }
        });
        jPanel1.add(txtBarcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 490, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cantidad:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, -1, -1));

        txtName.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 490, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Precio unitario:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        txtPriceUnit.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jPanel1.add(txtPriceUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 150, 30));

        tableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableProducts);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 700, 500));

        btnCancel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 530, 160, 50));

        btnAdd.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnAdd.setText("Agregar");
        btnAdd.setEnabled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 150, 50));

        btnSave.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 150, 50));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total: $");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 580, -1, -1));

        txtTotalAmmount.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txtTotalAmmount.setForeground(new java.awt.Color(255, 255, 255));
        txtTotalAmmount.setText("0");
        jPanel1.add(txtTotalAmmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 580, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1406, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String barcode = txtBarcode.getText();
        Producto miProduct = control.getProductByBarcode(barcode);
        
        DefaultTableModel tableModel = (DefaultTableModel) tableProducts.getModel();
        
        Object[] fila = {miProduct.getId_producto(), miProduct.getBarcode(), miProduct.getName(), txtQuantity.getText() ,miProduct.getPrice(), txtTotalPrice.getText()};
        tableModel.addRow(fila);
        
        double totalAmmountOld = Double.parseDouble(txtTotalAmmount.getText());
        
        txtTotalAmmount.setText(String.valueOf(totalAmmountOld + Double.parseDouble(txtTotalPrice.getText())));
        
        cleanForm();
        txtBarcode.setText("");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // Obtenemos modelo de tabla
        DefaultTableModel tableModel = (DefaultTableModel) tableProducts.getModel();
        
        List<Producto> misProductos = new ArrayList<>();
        
        double amountTotal = 0;
        
        // Creamos pedido
        Pedido pedido = new Pedido();
        pedido.setDate_sale(new Date());
        pedido.setState(true);
        
        for(int i=0; i < tableModel.getRowCount(); i++){
            // Obtenemos valores de cada celda en la fila
            int idProducto = (int) tableModel.getValueAt(i, 0);
            String barcode = (String) tableModel.getValueAt(i, 1);
            int quantity = Integer.parseInt(tableModel.getValueAt(i, 3).toString());
            
            // Traemos el producto
            Producto miProduct = control.getProductByBarcode(barcode);
            misProductos.add(miProduct);
            amountTotal += (quantity * miProduct.getPrice());
        }
        
        pedido.setAmount_total(amountTotal);
        
        Usuario vendedor = control.getUserById(user.getId());
        pedido.setVendedor(vendedor);
        pedido.setProductos(misProductos);
        control.savePedido(pedido);

    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBarcodeActionPerformed
    }//GEN-LAST:event_txtBarcodeActionPerformed

    private void cargarTabla() {
        // Definir modelo de la tabla
        DefaultTableModel tableModel = new DefaultTableModel(){
            // Que filas y columnas no sean editables
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        // Establecemos nombres de las columnas
        String titles[] = {"Id", "Codigo Barra", "Nombre", "Cantidad", "Precio U", "Precio Total"};
        tableModel.setColumnIdentifiers(titles);
        
        
        // Cargamos modelo a la tabla
        tableProducts.setModel(tableModel);
    }
    
    public void mostrarMensaje (String mensaje, String tipo, String titulo) {
       JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equals("Info")) {
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        }
        else if (tipo.equals("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
   
    }
    
    private void handleBarcondeChange() {
        String barcode = txtBarcode.getText();

        Producto miProduct = control.getProductByBarcode(barcode);
        
        // Obtenemos el producto
        if(miProduct != null){
            // Actualizamos los campos con la data
            txtName.setText(miProduct.getName());
            txtPriceUnit.setText(String.valueOf(miProduct.getPrice()));
            // Establecemos enfoque en quantity
            txtQuantity.requestFocusInWindow();
            btnAdd.setEnabled(true);
        }else{
            System.out.println("entra");
            btnAdd.setEnabled(false);
            cleanForm();
        }
        
    }
    
    private void handleQuantityChange() {
        // Que no este vacio el quantity
        if(!txtQuantity.getText().equals("")){
            // Verificar que el barcode este valido
            String barcode = txtBarcode.getText();

            Producto miProduct = control.getProductByBarcode(barcode);
            if(miProduct != null){
                if(miProduct.getStock() < Integer.parseInt(txtQuantity.getText())){
                    String messageError = "No hay suficiente stock del producto, stock disponible:" + String.valueOf(miProduct.getStock());
                    btnAdd.setEnabled(false);
                    mostrarMensaje(messageError, "Error", "Error al agregar cantidad");
                }else{
                    double priceUnit = miProduct.getPrice();
                    int quantity = Integer.parseInt(txtQuantity.getText());
                    txtTotalPrice.setText(String.valueOf(priceUnit * quantity));
                    btnAdd.setEnabled(true);
                }
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableProducts;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPriceUnit;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JLabel txtTotalAmmount;
    private javax.swing.JTextField txtTotalPrice;
    // End of variables declaration//GEN-END:variables

    private void cleanForm() {
        txtName.setText("");
        txtPriceUnit.setText("");
        txtQuantity.setText("");
        txtTotalPrice.setText("");
    }
    
}
