/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alumno
 */
public class Tarea {

    private String nombre;
    private boolean completada;

    // Constructor
    public Tarea(String nombre, boolean completada) {
        this.nombre = nombre;
        this.completada = completada;
    }

    // Getter y Setter para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para completada
    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        String estadoTexto = completada ? "Completada" : "Pendiente";
        return nombre + " - " + estadoTexto;
    }

}
