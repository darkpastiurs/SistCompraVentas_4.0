/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Cliente_controller;
import entidades.Cliente;
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
public final class frmAdmonClientes extends javax.swing.JDialog {

    public Cliente clienteActual = new Cliente();
    private Cliente_controller controlador;
    private List<Cliente> filtrado = new ArrayList<>();
    private long numTotal;
    
    private void llenarJTable(List<Cliente> listaDatos){
        numTotal = 0;
        reiniciarJTable(jtClientes);
        String[] columnas = {"DUI", "NIT", "Nombre", "Apellido", "Telefono" };
        DefaultTableModel modelo = new DefaultTableModelImpl();
        modelo.setColumnIdentifiers(columnas);
        listaDatos.stream().forEach((dato) -> {
            if(dato.isEstado() == (!chkEstado.isSelected())){ 
                Object[] nuevaFila = {
                        dato.getDUI(),
                        dato.getNIT(),
                        dato.getNombre(), 
                        (dato.getApellidoPaterno() + " " + dato.getApellidoMaterno()).trim(),
                        dato.getTelefono()
                };
                modelo.addRow(nuevaFila);
                numTotal += 1;
            }           
        });
        jtClientes.setModel(modelo);
        lblResultados.setText("Cantidad de registros en total: " + jtClientes.getRowCount());
    }
    
    private static void reiniciarJTable(JTable jTable){
        DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);       
    }
    
    private void buscarTXT(){
        List<Cliente> encontrado = new ArrayList<>();
        switch (cboFiltro.getSelectedItem().toString()) {
            case "Nombre":
                encontrado = filtrado.stream().filter(
                        datos -> datos.getNombre().toUpperCase().contains(txtBusqueda.getText().toUpperCase()) 
                                && datos.isEstado() == (!chkEstado.isSelected())).collect(Collectors.toList());
                break;
            case "Apellido":
                encontrado = filtrado.stream().filter(
                        datos -> (datos.getApellidoPaterno().toUpperCase().contains(txtBusqueda.getText().toUpperCase())
                                || datos.getApellidoMaterno().toUpperCase().contains(txtBusqueda.getText().toUpperCase()))
                                && datos.isEstado() == (!chkEstado.isSelected())).collect(Collectors.toList());
                break;
            case "DUI":
                encontrado = filtrado.stream().filter(
                        datos -> datos.getDUI().toUpperCase().contains(txtBusqueda.getText().toUpperCase()) 
                                && datos.isEstado() == (!chkEstado.isSelected())).collect(Collectors.toList());
                break;
            case "NIT":
                encontrado = filtrado.stream().filter(
                        datos -> datos.getNIT().toUpperCase().contains(txtBusqueda.getText().toUpperCase()) 
                                && datos.isEstado() == (!chkEstado.isSelected())).collect(Collectors.toList());
                break;
            default:
                break;
        }
        llenarJTable(encontrado);
        lblResultados.setText("Clientes encontrados " + encontrado.size() + " de " + numTotal);
    }
    
    private void changeText(){
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
    
    private int obtenerClienteIndex(String dui){
        for(int i = 0; i < filtrado.size(); i++){
            if(filtrado.get(i).getDUI().equals(dui)){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Creates new form frmBuscarClientes
     * @param parent
     * @param modal
     */
    public frmAdmonClientes(java.awt.Frame parent, boolean modal, boolean btnSel) {
        super(parent, modal);
        initComponents();
        controlador = new Cliente_controller();
        filtrado = controlador.Obtener();
        btnSeleccionar.setEnabled(btnSel);
        llenarJTable(filtrado);
        changeText();
        this.setLocationRelativeTo(null);
        //numTotal = jtClientes.getRowCount();
    }
    
    public frmAdmonClientes(javax.swing.JDialog parent, boolean modal, boolean btnSel) {
        super(parent, modal);
        initComponents();
        controlador = new Cliente_controller();
        filtrado = controlador.Obtener();
        btnSeleccionar.setEnabled(btnSel);
        llenarJTable(filtrado);
        changeText();
        this.setLocationRelativeTo(null);        
        //numTotal = jtClientes.getRowCount();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpData = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtClientes = new javax.swing.JTable();
        chkEstado = new javax.swing.JCheckBox();
        lblResultados = new javax.swing.JLabel();
        jpAcciones = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        cboFiltro = new javax.swing.JComboBox<>();
        btnSeleccionar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Cliente - Sistema de Compras y Ventas");

        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtClientesMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(jtClientes);

        chkEstado.setText("Ver clientes eliminados");
        chkEstado.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkEstadoStateChanged(evt);
            }
        });

        lblResultados.setText("Resultados... de ...");

        javax.swing.GroupLayout jpDataLayout = new javax.swing.GroupLayout(jpData);
        jpData.setLayout(jpDataLayout);
        jpDataLayout.setHorizontalGroup(
            jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpDataLayout.createSequentialGroup()
                        .addComponent(lblResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chkEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpDataLayout.setVerticalGroup(
            jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkEstado)
                    .addComponent(lblResultados))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Buscar por:");

        cboFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Apellido", "DUI", "NIT" }));

        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/search.png"))); // NOI18N
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpAccionesLayout = new javax.swing.GroupLayout(jpAcciones);
        jpAcciones.setLayout(jpAccionesLayout);
        jpAccionesLayout.setHorizontalGroup(
            jpAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpAccionesLayout.setVerticalGroup(
            jpAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnEditar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnEliminar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnNuevo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnNuevo)
                .addGap(15, 15, 15)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addGap(10, 10, 10))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Administracion de Clientes");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jpAcciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpAcciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkEstadoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkEstadoStateChanged
        // TODO add your handling code here:
        //llenarJTable(filtrado);
        buscarTXT();
    }//GEN-LAST:event_chkEstadoStateChanged

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        frmClientes frm = new frmClientes(this, true);
        frm.setVisible(true);
        if(!frm.isVisible()){
            filtrado = controlador.Obtener();
            llenarJTable(filtrado);
            frm.dispose();
        }      
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int fila = jtClientes.getSelectedRow();
        if(fila > -1){
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar estos datos?", "Sistema de Compra y Venta - Clientes",
                    JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){
                if(controlador.Borrar(filtrado.get(obtenerClienteIndex(jtClientes.getValueAt(fila, 0).toString())))){
                    JOptionPane.showMessageDialog(this,
                                "El registro ha sido eliminado exitosamente",
                                "Sistema de Compras y Ventas - Clientes",
                                JOptionPane.INFORMATION_MESSAGE);
                    filtrado = controlador.Obtener();
                    llenarJTable(filtrado);
                }
            }            
        } else {
            JOptionPane.showMessageDialog(this,
                                "Selecciona al cliente primero",
                                "Sistema de Compras y Ventas - Clientes",
                                JOptionPane.WARNING_MESSAGE);
        } 
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        int fila = jtClientes.getSelectedRow();
        if(fila > -1){
            clienteActual = filtrado.get(obtenerClienteIndex(jtClientes.getValueAt(fila, 0).toString()));
            frmClientes frm = new frmClientes(this, true, clienteActual);
            frm.setVisible(true);
            if(!frm.isVisible()){
                filtrado = controlador.Obtener();
                llenarJTable(filtrado);
                frm.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this,
                                "Selecciona al cliente primero",
                                "Sistema de Compras y Ventas - Clientes",
                                JOptionPane.WARNING_MESSAGE);
        }        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void jtClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtClientesMouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jtClientesMouseExited

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
            java.util.logging.Logger.getLogger(frmAdmonClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAdmonClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAdmonClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAdmonClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmAdmonClientes dialog = new frmAdmonClientes(new javax.swing.JFrame(), true, false);
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
    private javax.swing.JCheckBox chkEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpAcciones;
    private javax.swing.JPanel jpData;
    private javax.swing.JTable jtClientes;
    private javax.swing.JLabel lblResultados;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
