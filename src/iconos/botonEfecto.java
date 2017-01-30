/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iconos;

/**
 *
 * @author Gerard
 */
import javax.swing.*;
import java.awt.*;

public class botonEfecto{
	public botonEfecto(){
		JFrame frame=new JFrame("Ejemplo");
		JPanel panel=new JPanel();

		JButtonEfec botton1=new JButtonEfec("C:\\Users\\Gerard\\Documents\\NetBeansProjects\\SistCompraVentas_4.0(working)\\src\\iconos\\All-mail-48.png","Enviar Correo","Ctrl+E");
		JButtonEfec botton2=new JButtonEfec("C:\\Users\\Gerard\\Documents\\NetBeansProjects\\SistCompraVentas_4.0(working)\\src\\iconos\\appearance-48.png","Pintar","Ctrl+P");
		JButtonEfec botton3=new JButtonEfec("C:\\Users\\Gerard\\Documents\\NetBeansProjects\\SistCompraVentas_4.0(working)\\src\\iconos\\Book Library-48.png","Mis Documentos","Ctrl+D");

		panel.add(botton1);
		panel.add(botton2);
		panel.add(botton3);

		frame.add(panel);
		frame.setSize(300,240);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public static void main(String args[]){
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
				new botonEfecto();
			}
		});
	}
}