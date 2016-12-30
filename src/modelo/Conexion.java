/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author darkpastiursSennin
 */
public class Conexion {
    private final String _dbname = "db_sistemaventas";
    private final String _host = "localhost";
    private final String _port = "5432";
    private final String _user = "postgres";
    private final String _password = "adminroot";
    private String _url;
    private Connection _conn;
    
    public Conexion(){
        this._conn = null;
        this._url = "";
        _url = "jdbc:postgresql://"+_host+":"+_port+"/"+_dbname;
    }
    
    public Connection getConexion(){
        return _conn;
    }
    
    public boolean conectar(){
        boolean exito = false;
        try{
            Class.forName("org.postgresql.Driver");
            _conn = DriverManager.getConnection(_url, _user, _password);
            System.out.println("Conexion con la base de datos " + _dbname + " ha sido exitosa");
            exito = true;
        }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, 
                    "Ha ocurrido un error al conectar a la base de datos: \n" + ex.getMessage(), 
                    "Sistema de Compra Venta",
                    JOptionPane.ERROR_MESSAGE);
        }
        return exito;
    }
    
    public void desconectar(){
        _conn = null;
        System.out.println("Se ha desconectado de la base de datos " + _dbname);
    }
}
