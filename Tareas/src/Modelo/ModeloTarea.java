/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class ModeloTarea {
    private List<Tarea> tareas;
    
    // Constructor
    public ModeloTarea() {
        this.tareas = new ArrayList<>();
    }

    // Método para agregar una tarea
    public void agregarTarea(String nombre) {
        tareas.add(new Tarea(nombre, false));
    }

    // Método para eliminar una tarea por índice
    public boolean eliminarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.remove(indice);
            return true;
        }
        return false;
    }

    // Método para marcar una tarea como completada por índice
    public boolean completarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.get(indice).setCompletada(true);
            return true;
        }
        return false;
    }

    // Método para obtener la lista de tareas
    public List<Tarea> getTareas() {
        return tareas;
    }
}
