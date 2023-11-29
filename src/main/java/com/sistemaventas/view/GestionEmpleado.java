package com.sistemaventas.view;

import com.sistemaventas.logic.Controller;
import com.sistemaventas.logic.Usuario;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestionEmpleado extends javax.swing.JFrame {

    Controller control;
    
    public GestionEmpleado(Controller control) {
        initComponents();
        this.control = control;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsers = new javax.swing.JTable();
        btnExit = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();

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
        jLabel2.setText("Gestion de Empleados");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        tableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableUsers);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 750, 510));

        btnExit.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 520, 190, 50));

        btnCreate.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnCreate.setText("Crear Empleado");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 190, 50));

        btnEdit.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnEdit.setText("Editar Empleado");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, 190, 50));

        btnDelete.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnDelete.setText("Borrar Empleado");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 240, 190, 50));

        btnReload.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnReload.setText("Recargar Tabla");
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });
        jPanel1.add(btnReload, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 310, 190, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        CrearUsuario empleadoView = new CrearUsuario(control);
        empleadoView.setVisible(true);
        empleadoView.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if(tableUsers.getSelectedRow() > -1){
            int id = Integer.parseInt(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 0)));
            
            Usuario myUser = control.getUserById(id);
            
            EditarUsuario miEdit = new EditarUsuario(control, myUser);
            miEdit.setVisible(true);
            miEdit.setLocationRelativeTo(null);
            
            cargarTabla();
        }else{
            mostrarMensaje("No has seleccionado ningun usuario", "Error", "Error al editar");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(tableUsers.getSelectedRow() > -1){
            int id = Integer.parseInt(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 0)));
            control.deleteUserById(id);
            mostrarMensaje("Usuario eliminado exitosamente", "Info", "Usuario eliminado");
            cargarTabla();
        }else{
            mostrarMensaje("No has seleccionado ningun usuario", "Error", "Error al eliminar");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        cargarTabla();
    }//GEN-LAST:event_btnReloadActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened

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
        String titles[] = {"Id", "Dni", "Nombre", "Apellido", "Contrasena", "Usuario", "Rol"};
        tableModel.setColumnIdentifiers(titles);
        
        // Traemos Usuarios y cargamos al modelo
        List<Usuario> listUsers = control.getUsers();
        
        if(listUsers != null){
            for(Usuario usu : listUsers){
                Object[] objeto = {usu.getId(), usu.getDni(), usu.getName(), usu.getSurname(), usu.getPassword() , usu.getUsername(), usu.getRol().getName()};
                tableModel.addRow(objeto);
            }
        }
        
        // Cargamos modelo a la tabla
        tableUsers.setModel(tableModel);
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnReload;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableUsers;
    // End of variables declaration//GEN-END:variables
}
