/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package biblioteca;

import vista.Libros;

/**
 *
 * @author Usuario
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Aplicar el tema del sistema (opcional)
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("No se pudo aplicar el tema del sistema: " + e.getMessage());
        }

        // Mostrar la ventana Libro
        java.awt.EventQueue.invokeLater(() -> {
            Libros vista = new Libros();  // 👈 tu JFrame "Libro"
            vista.setLocationRelativeTo(null); // Centrar en pantalla
            vista.setVisible(true); // Mostrar ventana
        });
    }
    
}
