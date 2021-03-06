/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Inventario_controller;
import entidades.Categoria;
import entidades.Inventario;
import entidades.Marca;
import entidades.Producto;
import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author darkpastiursSennin
 */
public class frmProductos extends javax.swing.JDialog {

    Validaciones validar = new Validaciones();
    JButton[] arrayBotones;
    boolean editar = false;
    Marca marcaActual = new Marca();
    Categoria categoriaActual = new Categoria();
    Inventario_controller controlador = new Inventario_controller();
    long idInventario = 0;
    
    public void iniciarIngreso(){    
        validar.estadosBotones(2, arrayBotones);
        validar.habilitarComponentes(this.getComponents());
        btnBuscarMarca.setEnabled(true);
        btnBuscarCategoria.setEnabled(true);
        txtMarca.setEnabled(false);
        txtCategoria.setEnabled(false);
    }
    
    private void finalizarIngreso(){        
        validar.limpiarComponentes(this.getComponents());
        validar.deshabilitarComponentes(this.getComponents());
       // validar.deshabilitarComponentes(dcFechaIngreso);
        validar.estadosBotones(1, arrayBotones);
        marcaActual = new Marca();
        categoriaActual = new Categoria();
        btnBuscarMarca.setEnabled(false);
        btnBuscarCategoria.setEnabled(false);
        editar = false;
    }
    /**
     * Creates new form frmProductos
     * @param parent
     * @param modal
     */
    public frmProductos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.arrayBotones = new JButton[]{btnNuevo, btnGuardar, btnEditar, btnEliminar, btnBuscar, btnCancelar, btnSalir};
        validar.preciosFormato(jftxtPrecio, this);
        finalizarIngreso();
    }
    public frmProductos(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.arrayBotones = new JButton[]{btnNuevo, btnGuardar, btnEditar, btnEliminar, btnBuscar, btnCancelar, btnSalir};
        validar.preciosFormato(jftxtPrecio, this);
        finalizarIngreso();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dcFechaIngreso = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        btnBuscarMarca = new javax.swing.JButton();
        btnBuscarCategoria = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaDescripcion = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jftxtPrecio = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jpImagen = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        btnExaminarImagen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Producto - Sistema de Compra y Venta");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Productos");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Codigo:");

        lblCodigo.setText("Evaluar codigo");

        jLabel4.setText("Fecha:");

        dcFechaIngreso.setPreferredSize(new java.awt.Dimension(120, 20));

        jLabel5.setText("Marca:");

        jLabel6.setText("Categoria:");

        jLabel7.setText("Descripcion:");
        jLabel7.setToolTipText("");

        btnBuscarMarca.setText("Buscar");
        btnBuscarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMarcaActionPerformed(evt);
            }
        });

        btnBuscarCategoria.setText("Buscar");
        btnBuscarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCategoriaActionPerformed(evt);
            }
        });

        txtaDescripcion.setColumns(20);
        txtaDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtaDescripcion);

        jLabel8.setText("Precio:");

        jftxtPrecio.setFormatterFactory(null);

        javax.swing.GroupLayout jpDatosLayout = new javax.swing.GroupLayout(jpDatos);
        jpDatos.setLayout(jpDatosLayout);
        jpDatosLayout.setHorizontalGroup(
            jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(25, 25, 25)
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpDatosLayout.createSequentialGroup()
                                .addComponent(lblCodigo)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dcFechaIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtNombre)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpDatosLayout.createSequentialGroup()
                                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                    .addComponent(txtMarca))
                                .addGap(18, 18, 18)
                                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBuscarMarca)
                                    .addComponent(btnBuscarCategoria))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jpDatosLayout.createSequentialGroup()
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jftxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpDatosLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(21, 21, 21)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpDatosLayout.setVerticalGroup(
            jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(lblCodigo)
                        .addComponent(jLabel4))
                    .addComponent(dcFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarMarca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jftxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 51, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalir)
                    .addComponent(btnBuscar))
                .addContainerGap())
        );

        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagen.setText("Evaluar si hacer esto de lo de imagen");

        btnExaminarImagen.setText("Examinar");

        javax.swing.GroupLayout jpImagenLayout = new javax.swing.GroupLayout(jpImagen);
        jpImagen.setLayout(jpImagenLayout);
        jpImagenLayout.setHorizontalGroup(
            jpImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpImagenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(btnExaminarImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpImagenLayout.setVerticalGroup(
            jpImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpImagenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExaminarImagen)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        iniciarIngreso();
        editar = false;
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        boolean validarTextos = (validar.validarCamposTexto(txtNombre)) && (validar.validarCamposTexto(txtaDescripcion));
        if(validarTextos && (marcaActual.toString() != null && categoriaActual.toString() != null)){
            Producto producto = new Producto();
            producto.setNombre(txtNombre.getText().trim());
            producto.setDescripcion(txtaDescripcion.getText().trim());
            producto.setMarca(marcaActual);
            producto.setCategoria(categoriaActual);
            Inventario inventario = new Inventario();
            inventario.setProducto(producto);
            BigDecimal precio = new BigDecimal(txtPrecio.getText());
            inventario.setPrecio(precio);
            if(editar == false){
                if(controlador.Registrar(inventario)){
                    JOptionPane.showMessageDialog(this,
                    "El producto se registro exitosamente", "Sistema de Compras y Ventas - Productos",
                    JOptionPane.INFORMATION_MESSAGE);
                    finalizarIngreso();
                }
            } else {
                int respuesta = JOptionPane.showConfirmDialog(this, 
                        "¿Estas seguro de editar estos datos?", "Sistema de Compra y Ventas", JOptionPane.YES_OPTION);
                if(respuesta == JOptionPane.YES_OPTION){
                    inventario.setId(idInventario);                    
                    if(controlador.Editar(inventario)){
                        JOptionPane.showMessageDialog(this,
                        "El producto se edito exitosamente", "Sistema de Compras y Ventas - Productos",
                        JOptionPane.INFORMATION_MESSAGE);
                        finalizarIngreso();
                    }                    
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMarcaActionPerformed
        // TODO add your handling code here:
        frmBuscarMarca frmBuscar = new frmBuscarMarca(this, true);
        frmBuscar.setVisible(true);
        if(frmBuscar.isVisible() == false){
            if(frmBuscar.marcaActual.toString() != null){
                marcaActual = frmBuscar.marcaActual;
                txtMarca.setText(marcaActual.getNombre());
            }
        }
    }//GEN-LAST:event_btnBuscarMarcaActionPerformed

    private void btnBuscarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCategoriaActionPerformed
        // TODO add your handling code here:
        frmAdmonCategoria frmBuscar = new frmAdmonCategoria (true);
        frmBuscar.setVisible(true);
        if(frmBuscar.isVisible() == false){
            if(frmBuscar.getCategoriaActual().toString() != null){
                categoriaActual = frmBuscar.getCategoriaActual();
                txtCategoria.setText(categoriaActual.getNombre());
            }
        }
    }//GEN-LAST:event_btnBuscarCategoriaActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        iniciarIngreso();
        editar = true;
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        frmBuscarProducto frmBuscar = new frmBuscarProducto(this, true);
        frmBuscar.setVisible(true);
        if(frmBuscar.isVisible() == false){
            if(frmBuscar.inventarioActual != null){
                idInventario = frmBuscar.inventarioActual.getId();
                txtNombre.setText(frmBuscar.inventarioActual.getProducto().getNombre());
                txtMarca.setText(frmBuscar.inventarioActual.getProducto().getMarca().getNombre());
                marcaActual = frmBuscar.inventarioActual.getProducto().getMarca();
                txtCategoria.setText(frmBuscar.inventarioActual.getProducto().getCategoria().getNombre());
                categoriaActual = frmBuscar.inventarioActual.getProducto().getCategoria();
                txtaDescripcion.setText(frmBuscar.inventarioActual.getProducto().getDescripcion());
                validar.estadosBotones(3, arrayBotones);
                frmBuscar.dispose();
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(this, 
                "¿Esta seguro de eliminar este dato?", "Sistema de Compra y Venta - Productos", JOptionPane.YES_NO_OPTION);
        if(respuesta == JOptionPane.YES_OPTION){
            if(controlador.Borrar(new Inventario(idInventario))){
                JOptionPane.showMessageDialog(this,
                        "El producto se elimino exitosamente", "Sistema de Compras y Ventas - Productos",
                        JOptionPane.INFORMATION_MESSAGE);
                        finalizarIngreso();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        finalizarIngreso();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmProductos dialog = new frmProductos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarCategoria;
    private javax.swing.JButton btnBuscarMarca;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExaminarImagen;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private com.toedter.calendar.JDateChooser dcFechaIngreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFormattedTextField jftxtPrecio;
    private javax.swing.JPanel jpDatos;
    private javax.swing.JPanel jpImagen;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextArea txtaDescripcion;
    // End of variables declaration//GEN-END:variables
}
