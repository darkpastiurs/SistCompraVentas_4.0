/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Usuario_controller;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author darkpastiursSennin
 */
public final class frmBuscarEmpleados extends javax.swing.JDialog {

    /**
     * Creates new form frmBuscarEmpleado
     */
    public Usuario usuarioActual = new Usuario();
    Usuario_controller controlador;
    List<Usuario> filtrado = new ArrayList<>();
    
    void llenarJTable(List<Usuario> listaDatos){
        
        reiniciarJTable(jtEmpleados);
        String[] columnas = {"DUI", "NIT", "Nombre", "Apellido", "Telefono" };
        DefaultTableModel modelo = new DefaultTableModelImpl();
        modelo.setColumnIdentifiers(columnas);
        listaDatos.stream().forEach((dato) -> {
            Object[] nuevaFila = {
                    dato.getEmpleado().getDUI(),
                    dato.getEmpleado().getNIT(),
                    dato.getEmpleado().getNombre(), 
                    (dato.getEmpleado().getApellidoPaterno().trim() + " " + dato.getEmpleado().getApellidoMaterno()).trim(),
                    dato.getEmpleado().getTelefono()
            };
            if(dato.getEmpleado().isEstado() == (!chkEstado.isSelected()) && 
                    !(dato.getNivel().getNombre().toUpperCase().contains("administrador".toUpperCase()))){                
                modelo.addRow(nuevaFila); 
            }           
        });
        jtEmpleados.setModel(modelo);
    }
    
    public static void reiniciarJTable(JTable jTable){
        DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);       
    }
    
    public void buscarTXT(){
        List<Usuario> encontrado = new ArrayList<>();
        switch (cboFiltro.getSelectedItem().toString()) {
            case "Nombre":
                encontrado = filtrado.stream().filter(
                        datos -> datos.getEmpleado().getNombre().toUpperCase().contains(txtBusqueda.getText().toUpperCase())).collect(Collectors.toList());
                break;
            case "Apellido":
                encontrado = filtrado.stream().filter(
                        datos -> datos.getEmpleado().getApellidoPaterno().toUpperCase().contains(txtBusqueda.getText().toUpperCase())
                                || datos.getEmpleado().getApellidoMaterno().toUpperCase().contains(txtBusqueda.getText().toUpperCase())).collect(Collectors.toList());
                break;
            case "DUI":
                encontrado = filtrado.stream().filter(
                        datos -> datos.getEmpleado().getDUI().toUpperCase().contains(txtBusqueda.getText().toUpperCase())).collect(Collectors.toList());
                break;
            case "NIT":
                encontrado = filtrado.stream().filter(
                        datos -> datos.getEmpleado().getNIT().toUpperCase().contains(txtBusqueda.getText().toUpperCase())).collect(Collectors.toList());
                break;
            default:
                break;
        }
        llenarJTable(encontrado);
    }
    
    public void changeText(){
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
    
    int obtenerEmpleadoIndex(String dui){
        for(int i = 0; i < filtrado.size(); i++){
            if(filtrado.get(i).getEmpleado().getDUI().equals(dui)){
                return i;
            }
        }
        return -1;
    }
    
    public frmBuscarEmpleados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);  
        controlador = new Usuario_controller();
        filtrado = controlador.Obtener();
        llenarJTable(filtrado);
        changeText();
    }
    
    public frmBuscarEmpleados(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        controlador = new Usuario_controller();
        filtrado = controlador.Obtener();
        llenarJTable(filtrado);
        changeText();
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
        jtEmpleados = new javax.swing.JTable();
        jpAcciones = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        cboFiltro = new javax.swing.JComboBox<>();
        btnSeleccionar = new javax.swing.JButton();
        chkEstado = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Empleado - Sistema de Compra y Venta");
        setResizable(false);

        jtEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtEmpleados);

        javax.swing.GroupLayout jpDataLayout = new javax.swing.GroupLayout(jpData);
        jpData.setLayout(jpDataLayout);
        jpDataLayout.setHorizontalGroup(
            jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jpDataLayout.setVerticalGroup(
            jpDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setText("Buscar:");

        cboFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Apellido", "DUI", "NIT" }));

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        chkEstado.setText("Ver empleados despedidos");
        chkEstado.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkEstadoStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jpAccionesLayout = new javax.swing.GroupLayout(jpAcciones);
        jpAcciones.setLayout(jpAccionesLayout);
        jpAccionesLayout.setHorizontalGroup(
            jpAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAccionesLayout.createSequentialGroup()
                        .addComponent(chkEstado)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpAccionesLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar)))
                .addContainerGap())
        );
        jpAccionesLayout.setVerticalGroup(
            jpAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkEstado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpAcciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpAcciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        int fila = jtEmpleados.getSelectedRow();
        if(fila > -1){
            String dui = jtEmpleados.getValueAt(fila, 0).toString();
            int obtenerUsuario = this.obtenerEmpleadoIndex(dui);
            if(obtenerUsuario > -1){  
                usuarioActual = filtrado.get(obtenerUsuario);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void chkEstadoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkEstadoStateChanged
        // TODO add your handling code here:
        //llenarJTable(filtrado);
        btnSeleccionar.setEnabled(!(chkEstado.isSelected()));
        buscarTXT();
    }//GEN-LAST:event_chkEstadoStateChanged

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
            java.util.logging.Logger.getLogger(frmBuscarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBuscarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBuscarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBuscarEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmBuscarEmpleados dialog = new frmBuscarEmpleados(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> cboFiltro;
    private javax.swing.JCheckBox chkEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpAcciones;
    private javax.swing.JPanel jpData;
    private javax.swing.JTable jtEmpleados;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables

    private static class DefaultTableModelImpl extends DefaultTableModel {

        public DefaultTableModelImpl() {
        }

        @Override
        public boolean isCellEditable(int rowIndex, int vColIndex) {
            return false;
        }
    }
}
