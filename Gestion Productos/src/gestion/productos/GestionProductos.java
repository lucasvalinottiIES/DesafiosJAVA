/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestion.productos;

import vista.ProductosForm;

/**
 *
 * @author Usuario
 */
public class GestionProductos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Inicia la interfaz gráfica en el hilo de eventos de Swing
        javax.swing.SwingUtilities.invokeLater(() -> {
            ProductosForm form = new ProductosForm();
            form.setLocationRelativeTo(null); // Centrar en pantalla
            form.setVisible(true);            // Mostrar ventana
        });
    }
    
}
