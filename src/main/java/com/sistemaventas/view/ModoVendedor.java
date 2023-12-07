package com.sistemaventas.view;

import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import com.sistemaventas.logic.Controller;
import com.sistemaventas.logic.Pedido;
import com.sistemaventas.logic.Producto;
import com.sistemaventas.logic.Usuario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
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
        btnDeleteProduct = new javax.swing.JButton();
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
        btnBack = new javax.swing.JButton();

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

        btnDeleteProduct.setText("Eliminar Producto");
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeleteProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 160, 40));

        txtTotalPrice.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txtTotalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPriceActionPerformed(evt);
            }
        });
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

        btnBack.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 0, 0));
        btnBack.setText("<");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 50, -1));

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
        PrinterMatrix printer = new PrinterMatrix();
        
        String numberFacture = "ABC0";        
        String nameVendedor = user.getName() + user.getSurname();
        
        Extenso e = new Extenso();
        
        e.setNumber(101.85);
        
        printer.setOutSize(40, 32);
        
        printer.printCharAtCol(1, 1, 32, "=");
        printer.printTextWrap(1, 2, 8, 32, "FACTURA DE VENTA");        
        printer.printTextWrap(2, 3, 1, 32, "Num.Factura: " + numberFacture);
        printer.printTextWrap(3, 3, 1, 32, "Fecha de Emision: " + new Date().toString());
        printer.printTextWrap(5, 3, 1, 32, "Vendedor: " + nameVendedor);

        // Agregar los productos al ticket
        DefaultTableModel tableModel = (DefaultTableModel) tableProducts.getModel();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String productName = (String) tableModel.getValueAt(i, 2);
            int quantity = Integer.parseInt(tableModel.getValueAt(i, 3).toString());
            double priceUnit = Double.parseDouble(tableModel.getValueAt(i, 4).toString());
            double totalPrice = Double.parseDouble(tableModel.getValueAt(i, 5).toString());

            printer.printTextWrap(7 + i, 3, 1, 32, productName + " x" + String.valueOf(quantity));
            printer.printTextWrap(8 + i, 3, 1, 32, "  Precio Unitario: $" + String.valueOf(priceUnit));
            printer.printTextWrap(9 + i, 3, 1, 32, "  Precio Total: $" + String.valueOf(totalPrice));
        }
        
        printer.toFile("impresion.txt");
        FileInputStream inputStream = null;
        
        try{
            inputStream = new FileInputStream("impresion.txt");
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        
        if(inputStream == null){
            return;
        }
        
        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc document = new SimpleDoc(inputStream, docFormat, null);
        
        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
        
        if(defaultPrintService != null){
            DocPrintJob printJob = defaultPrintService.createPrintJob();
            try {
                printJob.print(document, attributeSet);
            } catch (Exception ex) {
                System.out.println("Error: " + ex.toString());
            }
        }else{
            System.err.println("No hay una impresora instalada");
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        boolean confirm = mostrarConfirmacion("Quieres cancelar el pedido?");
        if(confirm){
            this.dispose();
            ModoVendedor nuevaVentana = new ModoVendedor(control, user);
            nuevaVentana.setVisible(true);
            nuevaVentana.setLocationRelativeTo(null);
        }
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

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed
        if(tableProducts.getSelectedRow() != -1){
            DefaultTableModel tableModel = (DefaultTableModel) tableProducts.getModel();
            
            double totalProduct = Double.parseDouble(tableProducts.getValueAt(tableProducts.getSelectedRow(), 5).toString());
            double totalAmmountOld = Double.parseDouble(txtTotalAmmount.getText());

            txtTotalAmmount.setText(String.valueOf(totalAmmountOld - totalProduct));
            
            tableModel.removeRow(tableProducts.getSelectedRow());
            
            tableProducts.setModel(tableModel);
        }else{
            mostrarMensaje("No has seleccionado ningun producto de la tabla", "Error", "Error al eliminar producto");
        }
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtTotalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPriceActionPerformed

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
    
    public boolean mostrarConfirmacion(String mensaje) {
        int respuesta = JOptionPane.showConfirmDialog(null, mensaje, "Confirmación", JOptionPane.YES_NO_OPTION);
        return respuesta == JOptionPane.YES_OPTION;
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
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnSave;
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
