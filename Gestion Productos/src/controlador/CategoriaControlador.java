/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Usuario
 */
import modelo.Categoria;
import java.util.List;
import modelo.CategoriaDAO;

public class CategoriaControlador {
    private final CategoriaDAO categoriaDAO;

    public CategoriaControlador() {
        this.categoriaDAO = new CategoriaDAO();
    }

    // Crear una nueva categoría
    public void agregarCategoria(String nombre) {
        Categoria categoria = new Categoria(nombre);
        categoriaDAO.agregarCategoria(categoria);
    }

    // Listar todas las categorías
    public List<Categoria> listarCategorias() {
        return categoriaDAO.listarCategorias();
    }

    // Actualizar categoría
    public void actualizarCategoria(int id, String nuevoNombre) {
        Categoria categoria = new Categoria(id, nuevoNombre);
        categoriaDAO.actualizarCategoria(categoria);
    }

    // Eliminar categoría
    public void eliminarCategoria(int id) {
        categoriaDAO.eliminarCategoria(id);
    }

    // Mostrar todas las categorías (para consola)
    public void mostrarCategorias() {
        List<Categoria> categorias = listarCategorias();
        if (categorias.isEmpty()) {
            System.out.println("⚠️ No hay categorías registradas.");
        } else {
            System.out.println("📂 Lista de categorías:");
            for (Categoria c : categorias) {
                System.out.println(" - " + c.getId() + ": " + c.getNombre());
            }
        }
    }
}
