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

    // -------------------------------
    // MÉTODOS DE CONTROL
    // -------------------------------

    // Listar todos los libros
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

    // Insertar un nuevo libro
    public void agregarLibro(Libro libro) {
        if (libroDAO.insertar(libro)) {
            System.out.println("Libro agregado correctamente: " + libro.getTitulo());
        } else {
            System.out.println("Error al agregar el libro.");
        }
    }

    // Actualizar un libro existente
    public void actualizarLibro(Libro libro) {
        if (libroDAO.actualizar(libro)) {
            System.out.println("Libro actualizado correctamente: " + libro.getTitulo());
        } else {
            System.out.println("Error al actualizar el libro.");
        }
    }

    // Eliminar un libro por ID
    public void eliminarLibro(int id) {
        if (libroDAO.eliminar(id)) {
            System.out.println("Libro eliminado correctamente. ID: " + id);
        } else {
            System.out.println("Error al eliminar el libro con ID: " + id);
        }
    }

    // Buscar libros por autor (nombre parcial o completo)
    public List<Libro> buscarPorAutor(String autor) {
        List<Libro> lista = libroDAO.buscarPorAutor(autor);

        if (lista.isEmpty()) {
            System.out.println("No se encontraron libros del autor: " + autor);
        } else {
            System.out.println("Libros del autor '" + autor + "':");
            for (Libro libro : lista) {
                System.out.println(libro);
            }
        }

        return lista;
    }

    // Buscar libros disponibles o no
    public List<Libro> buscarPorDisponibilidad(boolean disponible) {
        List<Libro> lista = libroDAO.buscarPorDisponibilidad(disponible);

        String estado = disponible ? "disponibles" : "no disponibles";
        if (lista.isEmpty()) {
            System.out.println("No se encontraron libros " + estado + ".");
        } else {
            System.out.println("Libros " + estado + ":");
            for (Libro libro : lista) {
                System.out.println(libro);
            }
        }

        return lista;
    }
}
