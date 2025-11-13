/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Usuario
 */
import modelo.Producto;
import java.util.List;
import modelo.ProductoDAO;

public class ProductoControlador {
    private final ProductoDAO productoDAO;

    public ProductoControlador() {
        this.productoDAO = new ProductoDAO();
    }

    // Crear nuevo producto
    public void agregarProducto(String nombre, double precio, int stock, int categoriaId) {
        Producto producto = new Producto(nombre, precio, stock, categoriaId);
        productoDAO.agregarProducto(producto);
    }

    // Listar todos los productos
    public List<Producto> listarProductos() {
        return productoDAO.listarProductos();
    }

    // Actualizar producto
    public void actualizarProducto(int id, String nombre, double precio, int stock, int categoriaId) {
        Producto producto = new Producto(id, nombre, precio, stock, categoriaId);
        productoDAO.actualizarProducto(producto);
    }

    // Eliminar producto
    public void eliminarProducto(int id) {
        productoDAO.eliminarProducto(id);
    }

    // Listar productos con categoría (INNER JOIN)
    public List<String> mostrarProductosConCategoria() {
        List<String> lista = productoDAO.listarProductosConCategoria();
        return lista;
    }

    // Mostrar todos los productos (sin JOIN)
    public void mostrarProductos() {
        List<Producto> productos = listarProductos();
        if (productos.isEmpty()) {
            System.out.println("⚠️ No hay productos registrados.");
        } else {
            System.out.println("📦 Lista de productos:");
            for (Producto p : productos) {
                System.out.println(" - " + p);
            }
        }
    }
}
