/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import modelo.Libro;
import modelo.LibroDAO;

/**
 *
 * @author Usuario
 */
public class controlador {
    private LibroDAO libroDAO;

    public controlador() {
        libroDAO = new LibroDAO();
    }

    public List<Libro> listarLibros() {
        List<Libro> lista = libroDAO.obtenerTodos();

        if (lista.isEmpty()) {
            System.out.println("No hay libros registrados en la base de datos.");
        } else {
            System.out.println("Lista de libros disponibles:");
            for (Libro libro : lista) {
                System.out.println(libro);
            }
        }

        return lista;
    }
}
