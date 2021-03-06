/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Proveedor_controller;
import entidades.Proveedor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author darkpastiursSennin
 */
public class frmAdmonProveedores extends javax.swing.JDialog {

    /**
     * Creates new form frmBuscarProveedor
     */
    private Proveedor_controller controlador = new Proveedor_controller();
    private List<Proveedor> filtrado = new ArrayList<>();
    public Proveedor proveedorActual = new Proveedor();
    
     final void llenarJTable(List<Proveedor> listaDatos){
        
        reiniciarJTable(jtProveedores);
        String[] columnas = {"Nombre", "NIT", "NRC", "Telefono", "Email", "Sitio Web" };
        DefaultTableModel modelo = new DefaultTableModelImpl();
        modelo.setColumnIdentifiers(columnas);
        listaDatos.stream().forEach((dato) -> {
            if(dato.isEstado()){ 
                Object[] nuevaFila = {
                        dato.getNombre(),                         
                        dato.getNIT(),
                        dato.getNRC(true),
                        dato.getTelefono(),
                        dato.getEmail(),
                        dato.getWebsite()
                };
                modelo.addRow(nuevaFila); 
            }           
        });
        jtProveedores.setModel(modelo);
    }
    
    private static void reiniciarJTable(JTable jTable){
        DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);       
    }
    
    private void buscarTXT(){
        List<Proveedor> encontrado = new ArrayList<>();
        switch (cboFiltro.getSelectedItem().toString()) {
            case "Nombre":
                encontrado = filtrado.stream().filter(
                        datos -> datos.getNombre().toUpperCase().contains(txtBusqueda.getText().toUpperCase())).collect(Collectors.toList());
                break;
            case "NIT":
                encontrado = filtrado.stream().filter(
                        datos -> datos.getNIT().toUpperCase().contains(txtBusqueda.getText().toUpperCase())).collect(Collectors.toList());
                break;
            case "NRC":
                encontrado = filtrado.stream().filter(
                        datos -> datos.getNRC(true).toUpperCase().contains(txtBusqueda.getText().toUpperCase())).collect(Collectors.toList());
                break;
            default:
                break;
        }
        llenarJTable(encontrado);
    }
    
    private final void changeText(){
        txtBusqueda.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent de) {
                buscarTXT();
            }
            @Override
            public void removeUpdate(DocumentEvent de) {
                buscarTXT();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                buscarTXT();
            }
        
        });
    }
    
    private int obtenerProveedorIndex(String nit){
        for(int i = 0; i < filtrado.size(); i++){
            if(filtrado.get(i).getNIT().equals(nit)){
                return i;
            }
        }
        return -1;
    }
    
    public frmAdmonProveedores(java.awt.Frame parent, boolean modal, boolean btnSel) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        filtrado = controlador.Obtener();
        btnSeleccionar.setEnabled(btnSel);
        changeText();
        llenarJTable(filtrado);
    }
    public frmAdmonProveedores(javax.swing.JDialog parent, boolean modal, boolean btnSel) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        btnSeleccionar.setEnabled(btnSel);
        filtrado = controlador.Obtener();
        changeText();
        llenarJTable(filtrado);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProveedores = new javax.swing.JTable();
        jpBusqueda = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboFiltro = new javax.swing.JComboBox<>();
        txtBusqueda = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Proveedor - Sistema de Compras y Ventas");

        jtProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtProveedores);

        javax.swing.GroupLayout jpDatosLayout = new javax.swing.GroupLayout(jpDatos);
        jpDatos.setLayout(jpDatosLayout);
        jpDatosLayout.setHorizontalGroup(
            jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpDatosLayout.setVerticalGroup(
            jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Buscar:");

        cboFiltro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "NIT", "NRC" }));

        txtBusqueda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/search.png"))); // NOI18N
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBusquedaLayout = new javax.swing.GroupLayout(jpBusqueda);
        jpBusqueda.setLayout(jpBusquedaLayout);
        jpBusquedaLayout.setHorizontalGroup(
            jpBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBusqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jpBusquedaLayout.setVerticalGroup(
            jpBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBusquedaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Administracion de Proveedores");

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/new.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setToolTipText("");
        btnEditar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEditar.setBorderPainted(false);
        btnEditar.setContentAreaFilled(false);
        btnEditar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpDatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jpBusqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        frmProveedores frm = new frmProveedores(this, true);
        frm.setVisible(true);
        if(!frm.isVisible()){
            filtrado = controlador.Obtener();
            llenarJTable(filtrado);
            frm.dispose();
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        int fila = jtProveedores.getSelectedRow();
        if(fila > -1){
            proveedorActual = filtrado.get(obtenerProveedorIndex(jtProveedores.getValueAt(fila, 1).toString()));
            frmProveedores frm = new frmProveedores(this, true, proveedorActual);
            frm.setVisible(true);
            if(!frm.isVisible()){
                filtrado = controlador.Obtener();
                llenarJTable(filtrado);
                frm.dispose();
            }
        } else {
             JOptionPane.showMessageDialog(this,
                                "Selecciona al proveedor primero",
                                "Sistema de Compras y Ventas - Proveedores",
                                JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int fila = jtProveedores.getSelectedRow();
        if(fila > -1){
            proveedorActual = filtrado.get(obtenerProveedorIndex(jtProveedores.getValueAt(fila, 1).toString()));
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar estos datos?", "Sistema de Compra y Venta - Proveedores",
                    JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){
                if(controlador.Borrar(proveedorActual)){
                    JOptionPane.showMessageDialog(this,
                                    "El registro ha sido eliminado exitosamente",
                                    "Sistema de Compras y Ventas - Proveedores",
                                    JOptionPane.INFORMATION_MESSAGE);
                        filtrado = controlador.Obtener();
                        llenarJTable(filtrado);
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        int fila = jtProveedores.getSelectedRow();
        if(fila > -1){            
            proveedorActual = filtrado.get(obtenerProveedorIndex(jtProveedores.getValueAt(fila, 1).toString()));
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmAdmonProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAdmonProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAdmonProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAdmonProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmAdmonProveedores dialog = new frmAdmonProveedores(new javax.swing.JFrame(), true, false);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
        
    private static class DefaultTableModelImpl extends DefaultTableModel {

        public DefaultTableModelImpl() {
        }

        @Override
        public boolean isCellEditable(int rowIndex, int vColIndex) {
            return false;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> cboFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpBusqueda;
    private javax.swing.JPanel jpDatos;
    private javax.swing.JTable jtProveedores;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
