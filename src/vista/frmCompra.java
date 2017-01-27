/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Compra_controller;
import entidades.Compra;
import entidades.DetalleCompra;
import entidades.Inventario;
import entidades.Proveedor;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author darkpastiursSennin
 */
public final class frmCompra extends javax.swing.JDialog {

    /**
     * Creates new form frmCompra
     */
    Inventario inventarioActual = new Inventario();
    Proveedor proveedorActual = new Proveedor();
    Validaciones validar = new Validaciones();
    public frmCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.btnNuevoProveedor.setMnemonic(KeyEvent.VK_F2);
        this.btnBuscarProv.setMnemonic(KeyEvent.VK_F3);
        this.setLocationRelativeTo(null);                
        String[] columnas = {"Producto", "Precio Unitario", "Cantidad", "Subtotal"};
        DefaultTableModel modelo = new DefaultTableModelImpl();
        modelo.setColumnIdentifiers(columnas);
        jtDetalles.setModel(modelo);
        finalizarIngreso();
    }
    
    public static void reiniciarJTable(JTable jTable){
        DefaultTableModel modelo = (DefaultTableModel) jTable.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);       
    }
    
    public void iniciarIngreso(){
        validar.habilitarComponentes(this.getComponents());
        btnAñadirDetalle.setEnabled(true);
        btnQuitarDetalle.setEnabled(true);
        btnNuevoProveedor.setEnabled(true);
        btnBuscarProv.setEnabled(true);
        btnNuevoProducto.setEnabled(true);
        btnBuscarProducto.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnNuevo.setEnabled(false);        
        btnGuardar.setEnabled(true);
        jtDetalles.setEnabled(true);
        inventarioActual = new Inventario();
        proveedorActual = new Proveedor();        
        reiniciarJTable(jtDetalles);
    }
    
    public void finalizarIngreso(){
        validar.deshabilitarComponentes(this.getComponents());
        btnAñadirDetalle.setEnabled(false);
        btnQuitarDetalle.setEnabled(false);
        btnNuevoProveedor.setEnabled(false);
        btnBuscarProv.setEnabled(false);
        btnNuevoProducto.setEnabled(false);
        btnBuscarProducto.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnNuevo.setEnabled(true);
        jtDetalles.setEnabled(false);
        inventarioActual = new Inventario();
        proveedorActual = new Proveedor();
        reiniciarJTable(jtDetalles);        
    }
    
    private void addCart(){
        DefaultTableModel modelo = (DefaultTableModel) jtDetalles.getModel();
        if(inventarioActual.getId() != 0){
            boolean encontrado = false;
            for (int i = 0; i < modelo.getRowCount(); i++) {
                Inventario comparador = (Inventario) (modelo.getValueAt(i, 0));
                System.out.println(comparador + " = " + inventarioActual);
                if(comparador.getId() == inventarioActual.getId()){
                    encontrado = true;
                    break;
                }
            }
            if(encontrado){
                JOptionPane.showMessageDialog(this, "Ya se agrego este producto","Sistemas de Compras y Ventas - Compras", JOptionPane.WARNING_MESSAGE);
            } else {
                double cantidad = Double.parseDouble(jsCantidad.getValue().toString());
                double subtotal = Double.parseDouble(ftxtPrecio.getText()) * cantidad;
                Object[] nuevaFila = {
                        inventarioActual,
                        ftxtPrecio.getText(),
                        cantidad,
                        new BigDecimal(subtotal).setScale(2, RoundingMode.HALF_UP)
                }; 
                modelo.addRow(nuevaFila);
                jtDetalles.setModel(modelo);
                inventarioActual = new Inventario();
                lblProducto.setText("<Producto>");
                lblMarca.setText("<Marca>");
                lblCategoria.setText("<Categoria>");
                jsCantidad.setValue(1);
                ftxtPrecio.setText("");
                calcularTotal();
            }            
        }
    }
    
    private void quitCart(){
        int fila = jtDetalles.getSelectedRow();
        if(fila > -1){
            DefaultTableModel modelo = (DefaultTableModel) jtDetalles.getModel();
            modelo.removeRow(fila);
            calcularTotal();
        } else {
            JOptionPane.showMessageDialog(this, 
                    "Seleccione producto a quitar",
                    "Sistemas de Compras y Ventas - Compras", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void calcularTotal(){
        double subtotal = 0;
        double iva = 0;
        double total = 0;
        for (int i = 0; i < jtDetalles.getRowCount(); i++) {
            subtotal += Double.parseDouble(jtDetalles.getValueAt(i, 3).toString());
        }
        txtSubtotal.setText(new BigDecimal(subtotal).setScale(2, RoundingMode.HALF_UP).toString());
        iva = subtotal * 0.13;
        txtIVA.setText(new BigDecimal(iva).setScale(2, RoundingMode.HALF_UP).toString());
        total = subtotal + iva;
        txtTotal.setText(new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).toString());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpProveedor = new javax.swing.JPanel();
        jpDatosProveedor = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblNombreProv = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblNRC = new javax.swing.JLabel();
        lblNIT = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNFactura = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jpProvAccion = new javax.swing.JPanel();
        btnNuevoProveedor = new javax.swing.JButton();
        btnBuscarProv = new javax.swing.JButton();
        jpProducto = new javax.swing.JPanel();
        jpProductoDatos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblProducto = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cboUnidadMedida = new javax.swing.JComboBox<>();
        cboUnidadConversion = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jsCantidad = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        ftxtPrecio = new javax.swing.JFormattedTextField();
        btnAñadirDetalle = new javax.swing.JButton();
        btnQuitarDetalle = new javax.swing.JButton();
        jpProdAcciones = new javax.swing.JPanel();
        btnNuevoProducto = new javax.swing.JButton();
        btnBuscarProducto = new javax.swing.JButton();
        jpDetalle = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDetalles = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtIVA = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jpAcciones = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Compra - Sistema de Compra y Venta");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jpDatosProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Proveedor y Factura"));

        jLabel2.setText("Proveedor: ");

        lblNombreProv.setText("<Nombre de Proveedor>");

        jLabel5.setText("Direccion:");

        lblDireccion.setText("<Direccion>");

        jLabel11.setText("Correo: ");

        lblCorreo.setText("<Correo>");

        jLabel3.setText("NIT: ");

        jLabel7.setText("NRC:");

        jLabel9.setText("Telefono: ");

        lblTelefono.setText("<Telefono>");

        lblNRC.setText("<NRC>");

        lblNIT.setText("<NIT>");

        jLabel1.setText("#Factura: ");

        jLabel16.setText("Tipo de Compra");

        javax.swing.GroupLayout jpDatosProveedorLayout = new javax.swing.GroupLayout(jpDatosProveedor);
        jpDatosProveedor.setLayout(jpDatosProveedorLayout);
        jpDatosProveedorLayout.setHorizontalGroup(
            jpDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDatosProveedorLayout.createSequentialGroup()
                        .addGroup(jpDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDatosProveedorLayout.createSequentialGroup()
                                .addGroup(jpDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel11))
                                .addGap(28, 28, 28)
                                .addGroup(jpDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDireccion)
                                    .addComponent(lblCorreo)))
                            .addGroup(jpDatosProveedorLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(lblNombreProv)))
                        .addGap(73, 73, 73)
                        .addGroup(jpDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel3))
                            .addComponent(jLabel9))
                        .addGap(82, 82, 82)
                        .addGroup(jpDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNIT)
                            .addComponent(lblNRC)
                            .addComponent(lblTelefono)))
                    .addGroup(jpDatosProveedorLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpDatosProveedorLayout.setVerticalGroup(
            jpDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosProveedorLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblNombreProv)
                    .addComponent(jLabel3)
                    .addComponent(lblNIT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDatosProveedorLayout.createSequentialGroup()
                        .addGroup(jpDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblNRC))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblTelefono)))
                    .addGroup(jpDatosProveedorLayout.createSequentialGroup()
                        .addGroup(jpDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblDireccion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpDatosProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCorreo)
                            .addComponent(jLabel11))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNuevoProveedor.setText("<html>Nuevo Proveedor<br><center>F2</center></html>");
        btnNuevoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProveedorActionPerformed(evt);
            }
        });

        btnBuscarProv.setMnemonic('F');
        btnBuscarProv.setText("<html>Buscar Proveedor<br><center>F3</center></html>");
        btnBuscarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpProvAccionLayout = new javax.swing.GroupLayout(jpProvAccion);
        jpProvAccion.setLayout(jpProvAccionLayout);
        jpProvAccionLayout.setHorizontalGroup(
            jpProvAccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProvAccionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpProvAccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarProv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jpProvAccionLayout.setVerticalGroup(
            jpProvAccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProvAccionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpProveedorLayout = new javax.swing.GroupLayout(jpProveedor);
        jpProveedor.setLayout(jpProveedorLayout);
        jpProveedorLayout.setHorizontalGroup(
            jpProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProveedorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpDatosProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jpProvAccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpProveedorLayout.setVerticalGroup(
            jpProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProveedorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpDatosProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpProvAccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Producto"));

        jLabel4.setText("Producto: ");

        lblProducto.setText("<Producto>");

        jLabel6.setText("Marca: ");

        lblMarca.setText("<Marca>");

        jLabel8.setText("Categoria: ");

        lblCategoria.setText("<Categoria>");

        jLabel12.setText("Unidad de medida:");

        jLabel10.setText("Unidad de Conversion:");

        jLabel13.setText("Cantidad: ");

        jsCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel14.setText("Precio de Compra: ");

        ftxtPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        btnAñadirDetalle.setText("Añadir");
        btnAñadirDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirDetalleActionPerformed(evt);
            }
        });

        btnQuitarDetalle.setText("Quitar");
        btnQuitarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarDetalleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpProductoDatosLayout = new javax.swing.GroupLayout(jpProductoDatos);
        jpProductoDatos.setLayout(jpProductoDatosLayout);
        jpProductoDatosLayout.setHorizontalGroup(
            jpProductoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProductoDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpProductoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpProductoDatosLayout.createSequentialGroup()
                        .addGroup(jpProductoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpProductoDatosLayout.createSequentialGroup()
                                .addGroup(jpProductoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(22, 22, 22)
                                .addGroup(jpProductoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMarca)
                                    .addComponent(lblProducto)))
                            .addGroup(jpProductoDatosLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(lblCategoria)))
                        .addGap(81, 81, 81)
                        .addGroup(jpProductoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpProductoDatosLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(39, 39, 39)
                                .addComponent(cboUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpProductoDatosLayout.createSequentialGroup()
                                .addGroup(jpProductoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(jpProductoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboUnidadConversion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jsCantidad)))))
                    .addGroup(jpProductoDatosLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ftxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAñadirDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnQuitarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpProductoDatosLayout.setVerticalGroup(
            jpProductoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProductoDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpProductoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpProductoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(lblProducto)
                        .addComponent(jLabel12))
                    .addComponent(cboUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpProductoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpProductoDatosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpProductoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblMarca)))
                    .addGroup(jpProductoDatosLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jpProductoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cboUnidadConversion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jpProductoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpProductoDatosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jpProductoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblCategoria)))
                    .addGroup(jpProductoDatosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13))
                    .addGroup(jpProductoDatosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jsCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpProductoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(ftxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAñadirDetalle)
                    .addComponent(btnQuitarDetalle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNuevoProducto.setText("<html>Nuevo Producto<br><center>F4</center></html>");

        btnBuscarProducto.setText("<html>BuscarProducto<br><center>F5</center></html>");
        btnBuscarProducto.setPreferredSize(new java.awt.Dimension(109, 37));
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpProdAccionesLayout = new javax.swing.GroupLayout(jpProdAcciones);
        jpProdAcciones.setLayout(jpProdAccionesLayout);
        jpProdAccionesLayout.setHorizontalGroup(
            jpProdAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProdAccionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpProdAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpProdAccionesLayout.setVerticalGroup(
            jpProdAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProdAccionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpProductoLayout = new javax.swing.GroupLayout(jpProducto);
        jpProducto.setLayout(jpProductoLayout);
        jpProductoLayout.setHorizontalGroup(
            jpProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProductoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpProductoDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpProdAcciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpProductoLayout.setVerticalGroup(
            jpProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProductoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpProductoDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpProdAcciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpDetalle.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles de la Compra"));

        jtDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtDetalles);

        jLabel15.setText("SubTotal:");

        jLabel17.setText("IVA: ");

        jLabel18.setText("Total: ");

        javax.swing.GroupLayout jpDetalleLayout = new javax.swing.GroupLayout(jpDetalle);
        jpDetalle.setLayout(jpDetalleLayout);
        jpDetalleLayout.setHorizontalGroup(
            jpDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jpDetalleLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal)))
                .addContainerGap())
        );
        jpDetalleLayout.setVerticalGroup(
            jpDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDetalleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jpAcciones.setPreferredSize(new java.awt.Dimension(0, 50));

        btnNuevo.setText("Nueva Compra");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Registrar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnHistorial.setText("Historial de Compras");

        javax.swing.GroupLayout jpAccionesLayout = new javax.swing.GroupLayout(jpAcciones);
        jpAcciones.setLayout(jpAccionesLayout);
        jpAccionesLayout.setHorizontalGroup(
            jpAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAccionesLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnNuevo)
                .addGap(88, 88, 88)
                .addComponent(btnGuardar)
                .addGap(113, 113, 113)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnHistorial)
                .addContainerGap())
        );
        jpAccionesLayout.setVerticalGroup(
            jpAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAccionesLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jpAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(btnHistorial))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpAcciones, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jpProveedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoProveedorActionPerformed

    private void btnBuscarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProvActionPerformed
        // TODO add your handling code here:
        frmBuscarProveedor frm = new frmBuscarProveedor(this, true);
        frm.setVisible(true);
        if(frm.isVisible() == false){
            if(frm.proveedorActual.getId() != 0){
                proveedorActual = frm.proveedorActual;
                lblNombreProv.setText(proveedorActual.getNombre());
                lblDireccion.setText(proveedorActual.getDireccion());
                lblTelefono.setText(proveedorActual.getTelefono());
                lblCorreo.setText(proveedorActual.getEmail().equals("") ? "No posee" : proveedorActual.getEmail());
                lblNIT.setText(proveedorActual.getNIT());
                lblNRC.setText(proveedorActual.getNRC(true));
            }
        }
    }//GEN-LAST:event_btnBuscarProvActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formKeyPressed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        // TODO add your handling code here:
        frmBuscarProducto frm = new frmBuscarProducto(this, true);
        frm.setVisible(true);
        if(frm.isVisible() == false){
            if(!frm.inventarioActual.getProducto().getNombre().equals("")){
                inventarioActual = frm.inventarioActual;
                lblProducto.setText(inventarioActual.getProducto().getNombre());
                lblMarca.setText(inventarioActual.getProducto().getMarca().getNombre());
                lblCategoria.setText(inventarioActual.getProducto().getCategoria().getNombre());
            }
        }
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnAñadirDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirDetalleActionPerformed
        // TODO add your handling code here:
        addCart();
    }//GEN-LAST:event_btnAñadirDetalleActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        Compra nuevaCompra = new Compra();
        if(proveedorActual.getNombre().equals("")){
            JOptionPane.showMessageDialog(this, 
                    "Ingresa un proveedor primero",
                    "Sistemas de Compras y Ventas - Compras", 
                    JOptionPane.ERROR_MESSAGE);
        } else {            
            nuevaCompra.setProveedor(proveedorActual);
            if(txtNFactura.getText().equals("")){
                JOptionPane.showMessageDialog(this, 
                    "Ingresa el numero de la factura",
                    "Sistemas de Compras y Ventas - Compras", 
                    JOptionPane.ERROR_MESSAGE);
            } else {
                nuevaCompra.setnFactura(txtNFactura.getText()); 
                if(jtDetalles.getRowCount() <= 0){
                    JOptionPane.showMessageDialog(this, 
                    "Ingresa productos a comprar",
                    "Sistemas de Compras y Ventas - Compras", 
                    JOptionPane.ERROR_MESSAGE);
                } else{
                    List<DetalleCompra> detalles = new ArrayList<>();
                    for (int i = 0; i < jtDetalles.getRowCount(); i++) {
                        DetalleCompra detalle = new DetalleCompra();
                        Inventario extraer = (Inventario) jtDetalles.getValueAt(i, 0);
                        detalle.setInventario(extraer);
                        detalle.setPrecioUnitario(new BigDecimal(jtDetalles.getValueAt(i, 1).toString()));
                        detalle.setCantidad(new BigDecimal(jtDetalles.getValueAt(i, 2).toString()));
                        detalle.setPrecioTotal(new BigDecimal(jtDetalles.getValueAt(i, 3).toString()));
                        detalles.add(detalle);
                    }
                    nuevaCompra.setDetalleCompra(detalles);
                    nuevaCompra.setSubtotal(new BigDecimal(txtSubtotal.getText()));
                    nuevaCompra.setIva(new BigDecimal(txtIVA.getText()));
                    nuevaCompra.setTotal(new BigDecimal(txtTotal.getText()));
                    nuevaCompra.setEmpleado(frmMenuPrincipal.usuarioActual.getEmpleado());
                    boolean Registrar = new Compra_controller().Registrar(nuevaCompra);
                    if(Registrar){
                        JOptionPane.showMessageDialog(this,"La compra ha sido ingresada correctamente","Sistema de Compras y Ventas - Compra",JOptionPane.ERROR_MESSAGE);
                        finalizarIngreso();
                    }
                }
            }
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        iniciarIngreso();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        finalizarIngreso();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnQuitarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarDetalleActionPerformed
        // TODO add your handling code here:
        quitCart();
    }//GEN-LAST:event_btnQuitarDetalleActionPerformed

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
            java.util.logging.Logger.getLogger(frmCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmCompra dialog = new frmCompra(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAñadirDetalle;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnBuscarProv;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevoProducto;
    private javax.swing.JButton btnNuevoProveedor;
    private javax.swing.JButton btnQuitarDetalle;
    private javax.swing.JComboBox<String> cboUnidadConversion;
    private javax.swing.JComboBox<String> cboUnidadMedida;
    private javax.swing.JFormattedTextField ftxtPrecio;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpAcciones;
    private javax.swing.JPanel jpDatosProveedor;
    private javax.swing.JPanel jpDetalle;
    private javax.swing.JPanel jpProdAcciones;
    private javax.swing.JPanel jpProducto;
    private javax.swing.JPanel jpProductoDatos;
    private javax.swing.JPanel jpProvAccion;
    private javax.swing.JPanel jpProveedor;
    private javax.swing.JSpinner jsCantidad;
    private javax.swing.JTable jtDetalles;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNIT;
    private javax.swing.JLabel lblNRC;
    private javax.swing.JLabel lblNombreProv;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtNFactura;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
