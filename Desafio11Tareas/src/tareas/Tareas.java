/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tareas;
import Vista.VistaTareas;
/**
 *
 * @author Alumno
 */
public class Tareas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VistaTareas().setVisible(true);
            }
        });
    }
    
}
