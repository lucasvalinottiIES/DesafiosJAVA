/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.ModeloTarea;
import Modelo.Tarea;
import java.util.List;
/**
 *
 * @author Alumno
 */
public class Controlador {
    private ModeloTarea modelo;

    // Constructor
    public Controlador() {
        this.modelo = new ModeloTarea();
    }

    // Método para agregar tarea
    public void agregarTarea(String nombre) {
        modelo.agregarTarea(nombre);
    }

    // Método para eliminar tarea por índice
    public boolean eliminarTarea(int indice) {
        return modelo.eliminarTarea(indice);
    }

    // Método para completar tarea por índice
    public boolean completarTarea(int indice) {
        return modelo.completarTarea(indice);
    }

    // Método para obtener lista de tareas
    public List<Tarea> obtenerTareas() {
        return modelo.getTareas();
    }
}
