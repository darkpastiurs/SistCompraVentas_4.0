/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import entidades.Usuario;

/**
 *
 * @author darkpastiursSennin
 */
public class frmMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmMenuPrincipal
     */
    
    Validaciones validar = new Validaciones();  
    public static Usuario usuarioActual;    
    //Para generar controles graficos de java se debe crear una base de datos
    //donde se almacene la jerarquia de los componentes por ejemplo
    //JPanel campos nombre, ancho, alto, x, y en tabla contenedor
    //JMenuBar nombre, x, y, en la tabla menus.
    public frmMenuPrincipal() {
        initComponents();
        lblUsuario.setText("Bienvenido: " + usuarioActual.getEmpleado().toString());
        validar.iniciarSesion(usuarioActual, jmbMenu.getSubElements());
        this.btnLogin.setEnabled(false);
        this.setExtendedState(MAXIMIZED_BOTH);  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbEstado = new javax.swing.JToolBar();
        lblUsuario = new javax.swing.JLabel();
        jpPrincipal = new javax.swing.JPanel();
        lblFondo = new javax.swing.JLabel();
        jpAccesoDirecto = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        jmbMenu = new javax.swing.JMenuBar();
        jmArchivo = new javax.swing.JMenu();
        jmiSkins = new javax.swing.JMenuItem();
        jmiImpresora = new javax.swing.JMenuItem();
        jmiSesion = new javax.swing.JMenuItem();
        jmiSalir = new javax.swing.JMenuItem();
        jmMantenimiento = new javax.swing.JMenu();
        jmiCliente = new javax.swing.JMenuItem();
        jmiProducto = new javax.swing.JMenuItem();
        jmiMarca = new javax.swing.JMenuItem();
        jmiCategoria = new javax.swing.JMenuItem();
        jmiProveedores = new javax.swing.JMenuItem();
        jmInventario = new javax.swing.JMenu();
        jmiCompra = new javax.swing.JMenuItem();
        jmiHistorialCompras = new javax.swing.JMenuItem();
        jmiPrecios = new javax.swing.JMenuItem();
        jmVentas = new javax.swing.JMenu();
        jmiVenta = new javax.swing.JMenuItem();
        jmiHistorialVentas = new javax.swing.JMenuItem();
        jmBusquedas = new javax.swing.JMenu();
        jmiBuscarCliente = new javax.swing.JMenuItem();
        jmiBuscarEmpleado = new javax.swing.JMenuItem();
        jmiInventario = new javax.swing.JMenuItem();
        jmReportes = new javax.swing.JMenu();
        jmiExistencias = new javax.swing.JMenuItem();
        jmiRPTCliente = new javax.swing.JMenuItem();
        jmiRPTVentas = new javax.swing.JMenuItem();
        jmSistema = new javax.swing.JMenu();
        jmAdministrar = new javax.swing.JMenu();
        jmiUsuarios = new javax.swing.JMenuItem();
        jmiNiveles = new javax.swing.JMenuItem();
        jmiPermisos = new javax.swing.JMenuItem();
        jmiCambiarPass = new javax.swing.JMenuItem();
        jmiRespaldar = new javax.swing.JMenuItem();
        jmiRestaurar = new javax.swing.JMenuItem();
        jmAyuda = new javax.swing.JMenu();
        jmiManual = new javax.swing.JMenuItem();
        jmiAcercade = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal - Sistema de Compra y Venta");
        setResizable(false);

        jtbEstado.setRollover(true);

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblUsuario.setText("jLabel1");
        jtbEstado.add(lblUsuario);

        btnLogin.setText("Identificarse");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpAccesoDirectoLayout = new javax.swing.GroupLayout(jpAccesoDirecto);
        jpAccesoDirecto.setLayout(jpAccesoDirectoLayout);
        jpAccesoDirectoLayout.setHorizontalGroup(
            jpAccesoDirectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAccesoDirectoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jpAccesoDirectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrarSesion)
                    .addComponent(btnLogin))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jpAccesoDirectoLayout.setVerticalGroup(
            jpAccesoDirectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAccesoDirectoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnLogin)
                .addGap(59, 59, 59)
                .addComponent(btnCerrarSesion)
                .addContainerGap(287, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                .addComponent(jpAccesoDirecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpAccesoDirecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jmArchivo.setMnemonic('f');
        jmArchivo.setText("Archivo");

        jmiSkins.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmiSkins.setMnemonic('o');
        jmiSkins.setText("Skins");
        jmArchivo.add(jmiSkins);

        jmiImpresora.setMnemonic('s');
        jmiImpresora.setText("Configurar Impresora");
        jmiImpresora.setToolTipText("");
        jmArchivo.add(jmiImpresora);

        jmiSesion.setMnemonic('a');
        jmiSesion.setText("Cerrar Sesion");
        jmArchivo.add(jmiSesion);

        jmiSalir.setMnemonic('x');
        jmiSalir.setText("Salir del Sistema");
        jmiSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalirActionPerformed(evt);
            }
        });
        jmArchivo.add(jmiSalir);

        jmbMenu.add(jmArchivo);

        jmMantenimiento.setMnemonic('e');
        jmMantenimiento.setText("Mantenimiento");

        jmiCliente.setMnemonic('t');
        jmiCliente.setText("Registrar Clientes");
        jmiCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiClienteActionPerformed(evt);
            }
        });
        jmMantenimiento.add(jmiCliente);

        jmiProducto.setMnemonic('y');
        jmiProducto.setText("Registrar Productos");
        jmiProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiProductoActionPerformed(evt);
            }
        });
        jmMantenimiento.add(jmiProducto);

        jmiMarca.setMnemonic('p');
        jmiMarca.setText("Registrar Marcas");
        jmiMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMarcaActionPerformed(evt);
            }
        });
        jmMantenimiento.add(jmiMarca);

        jmiCategoria.setMnemonic('d');
        jmiCategoria.setText("Registrar Categorias");
        jmiCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCategoriaActionPerformed(evt);
            }
        });
        jmMantenimiento.add(jmiCategoria);

        jmiProveedores.setText("Registrar Proveedores");
        jmiProveedores.setToolTipText("");
        jmiProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiProveedoresActionPerformed(evt);
            }
        });
        jmMantenimiento.add(jmiProveedores);

        jmbMenu.add(jmMantenimiento);

        jmInventario.setText("Inventario");

        jmiCompra.setText("Registrar Compras");
        jmiCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCompraActionPerformed(evt);
            }
        });
        jmInventario.add(jmiCompra);

        jmiHistorialCompras.setText("Historial de Compras");
        jmiHistorialCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiHistorialComprasActionPerformed(evt);
            }
        });
        jmInventario.add(jmiHistorialCompras);

        jmiPrecios.setText("Control de Precios");
        jmInventario.add(jmiPrecios);

        jmbMenu.add(jmInventario);

        jmVentas.setText("Ventas");

        jmiVenta.setText("Punto de Venta");
        jmVentas.add(jmiVenta);

        jmiHistorialVentas.setText("Historial Ventas");
        jmVentas.add(jmiHistorialVentas);

        jmbMenu.add(jmVentas);

        jmBusquedas.setText("Busquedas");

        jmiBuscarCliente.setText("Buscar Clientes");
        jmBusquedas.add(jmiBuscarCliente);

        jmiBuscarEmpleado.setText("Buscar Empleado");
        jmiBuscarEmpleado.setToolTipText("");
        jmBusquedas.add(jmiBuscarEmpleado);

        jmiInventario.setText("Buscar en Inventario");
        jmBusquedas.add(jmiInventario);

        jmbMenu.add(jmBusquedas);

        jmReportes.setText("Reportes");

        jmiExistencias.setText("Existencias de Productos");
        jmReportes.add(jmiExistencias);

        jmiRPTCliente.setText("Reporte de Clientes");
        jmReportes.add(jmiRPTCliente);

        jmiRPTVentas.setText("Reporte de Ventas");
        jmiRPTVentas.setToolTipText("");
        jmReportes.add(jmiRPTVentas);

        jmbMenu.add(jmReportes);

        jmSistema.setText("Sistema");

        jmAdministrar.setText("Administrar");
        jmAdministrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jmiUsuarios.setText("Registrar Empleados y Usuarios");
        jmiUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUsuariosActionPerformed(evt);
            }
        });
        jmAdministrar.add(jmiUsuarios);

        jmiNiveles.setText("Registrar Niveles de Permisos");
        jmiNiveles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNivelesActionPerformed(evt);
            }
        });
        jmAdministrar.add(jmiNiveles);

        jmiPermisos.setText("Permisos de los Niveles");
        jmiPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPermisosActionPerformed(evt);
            }
        });
        jmAdministrar.add(jmiPermisos);

        jmiCambiarPass.setText("Cambiar Contraseña");
        jmAdministrar.add(jmiCambiarPass);

        jmSistema.add(jmAdministrar);

        jmiRespaldar.setText("Respaldar Base de Datos");
        jmSistema.add(jmiRespaldar);

        jmiRestaurar.setText("Restaurar Base de Datos");
        jmSistema.add(jmiRestaurar);

        jmbMenu.add(jmSistema);

        jmAyuda.setMnemonic('h');
        jmAyuda.setText("Ayuda");

        jmiManual.setMnemonic('c');
        jmiManual.setText("Manual de Usuario");
        jmAyuda.add(jmiManual);

        jmiAcercade.setMnemonic('a');
        jmiAcercade.setText("Acerca de");
        jmAyuda.add(jmiAcercade);

        jmbMenu.add(jmAyuda);

        setJMenuBar(jmbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtbEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmiSalirActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        frmLogin login = new frmLogin(this, true);
        login.setVisible(true);        
        this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        // TODO add your handling code here:      
        validar.cerrarSesion(jmbMenu.getSubElements());
        btnLogin.setEnabled(true);
        btnCerrarSesion.setEnabled(false);
        //btnInventario.setEnabled(false);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void jmiUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUsuariosActionPerformed
        // TODO add your handling code here:
        frmEmpleados empleadoFrm = new frmEmpleados(this, true);
        empleadoFrm.setVisible(true);
        if(empleadoFrm.isVisible() == false){
            empleadoFrm.dispose();
        }
    }//GEN-LAST:event_jmiUsuariosActionPerformed

    private void jmiNivelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNivelesActionPerformed
        // TODO add your handling code here:
        frmNiveles nivelFrm = new frmNiveles(this, true);
        nivelFrm.setVisible(true);
        if(nivelFrm.isVisible() == false){
            nivelFrm.dispose();
        }
    }//GEN-LAST:event_jmiNivelesActionPerformed

    private void jmiPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPermisosActionPerformed
        // TODO add your handling code here:
        frmPermisosNiveles frmPermisos = new frmPermisosNiveles(this, true);
        frmPermisos.setVisible(true);
        if(frmPermisos.isVisible() == false){
            frmPermisos.dispose();
        }
    }//GEN-LAST:event_jmiPermisosActionPerformed

    private void jmiClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiClienteActionPerformed
        // TODO add your handling code here:
        frmClientes clienteFrm = new frmClientes(this, true);
        clienteFrm.setVisible(true);
        if(clienteFrm.isVisible() == false){
            clienteFrm.dispose();
        }
    }//GEN-LAST:event_jmiClienteActionPerformed

    private void jmiMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMarcaActionPerformed
        // TODO add your handling code here:
        frmMarca marcaFrm = new frmMarca(this, true);
        marcaFrm.setVisible(true);
        if(marcaFrm.isVisible() == false){
            marcaFrm.dispose();
        }
    }//GEN-LAST:event_jmiMarcaActionPerformed

    private void jmiCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCategoriaActionPerformed
        // TODO add your handling code here:
        frmCategoria categoriaFrm = new frmCategoria(this, true);
        categoriaFrm.setVisible(true);
        if(categoriaFrm.isVisible() == false){
            categoriaFrm.dispose();
        }
    }//GEN-LAST:event_jmiCategoriaActionPerformed

    private void jmiProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiProductoActionPerformed
        // TODO add your handling code here:
        frmProductos productoFrm = new frmProductos(this, true);
        productoFrm.setVisible(true);
        if(productoFrm.isVisible() == false){
            productoFrm.dispose();
        }
    }//GEN-LAST:event_jmiProductoActionPerformed

    private void jmiProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiProveedoresActionPerformed
        // TODO add your handling code here:
        frmProveedores proveedorFrm = new frmProveedores(this, true);
        proveedorFrm.setVisible(true);
        if(proveedorFrm.isVisible() == false){
            proveedorFrm.dispose();
        }
    }//GEN-LAST:event_jmiProveedoresActionPerformed

    private void jmiCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCompraActionPerformed
        // TODO add your handling code here:
        frmCompra compraFrm = new frmCompra(this, true);
        compraFrm.setVisible(true);
        if(!compraFrm.isVisible()){
            compraFrm.dispose();
        }
    }//GEN-LAST:event_jmiCompraActionPerformed

    private void jmiHistorialComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiHistorialComprasActionPerformed
        // TODO add your handling code here:
        frmHistorialCompras historialFrm = new frmHistorialCompras(this, true);
        historialFrm.setVisible(true);
        if(!historialFrm.isVisible()){
            historialFrm.dispose();
        }
    }//GEN-LAST:event_jmiHistorialComprasActionPerformed

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
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnLogin;
    private javax.swing.JMenu jmAdministrar;
    private javax.swing.JMenu jmArchivo;
    private javax.swing.JMenu jmAyuda;
    private javax.swing.JMenu jmBusquedas;
    private javax.swing.JMenu jmInventario;
    private javax.swing.JMenu jmMantenimiento;
    private javax.swing.JMenu jmReportes;
    private javax.swing.JMenu jmSistema;
    private javax.swing.JMenu jmVentas;
    private javax.swing.JMenuBar jmbMenu;
    private javax.swing.JMenuItem jmiAcercade;
    private javax.swing.JMenuItem jmiBuscarCliente;
    private javax.swing.JMenuItem jmiBuscarEmpleado;
    private javax.swing.JMenuItem jmiCambiarPass;
    private javax.swing.JMenuItem jmiCategoria;
    private javax.swing.JMenuItem jmiCliente;
    private javax.swing.JMenuItem jmiCompra;
    private javax.swing.JMenuItem jmiExistencias;
    private javax.swing.JMenuItem jmiHistorialCompras;
    private javax.swing.JMenuItem jmiHistorialVentas;
    private javax.swing.JMenuItem jmiImpresora;
    private javax.swing.JMenuItem jmiInventario;
    private javax.swing.JMenuItem jmiManual;
    private javax.swing.JMenuItem jmiMarca;
    private javax.swing.JMenuItem jmiNiveles;
    private javax.swing.JMenuItem jmiPermisos;
    private javax.swing.JMenuItem jmiPrecios;
    private javax.swing.JMenuItem jmiProducto;
    private javax.swing.JMenuItem jmiProveedores;
    private javax.swing.JMenuItem jmiRPTCliente;
    private javax.swing.JMenuItem jmiRPTVentas;
    private javax.swing.JMenuItem jmiRespaldar;
    private javax.swing.JMenuItem jmiRestaurar;
    private javax.swing.JMenuItem jmiSalir;
    private javax.swing.JMenuItem jmiSesion;
    private javax.swing.JMenuItem jmiSkins;
    private javax.swing.JMenuItem jmiUsuarios;
    private javax.swing.JMenuItem jmiVenta;
    private javax.swing.JPanel jpAccesoDirecto;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JToolBar jtbEstado;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables

}
