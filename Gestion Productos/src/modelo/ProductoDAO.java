/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
import modelo.Producto;
import modelo.dbConexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    // Crear producto
    public void agregarProducto(Producto producto) {
        String sql = "INSERT INTO productos (nombre, precio, stock, categoria_id) VALUES (?, ?, ?, ?)";
        try (Connection con = dbConexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            ps.setInt(4, producto.getCategoriaId());
            ps.executeUpdate();
            System.out.println("✅ Producto agregado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Leer todos los productos
    public List<Producto> listarProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Connection con = dbConexion.obtenerConexion(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Producto p = new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"),
                        rs.getInt("categoria_id")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Actualizar producto
    public void actualizarProducto(Producto producto) {
        String sql = "UPDATE productos SET nombre=?, precio=?, stock=?, categoria_id=? WHERE id=?";
        try (Connection con = dbConexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            ps.setInt(4, producto.getCategoriaId());
            ps.setInt(5, producto.getId());
            ps.executeUpdate();
            System.out.println("✅ Producto actualizado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar producto
    public void eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id=?";
        try (Connection con = dbConexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("🗑️ Producto eliminado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método especial: listar productos con nombre de categoría
    public List<String> listarProductosConCategoria() {
        List<String> lista = new ArrayList<>();
        String sql = """
        SELECT p.id, p.nombre AS producto, p.precio, p.stock, c.nombre AS categoria
        FROM productos p
        INNER JOIN categorias c ON p.categoria_id = c.id
    """;

        try (Connection con = dbConexion.obtenerConexion(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                String fila = String.format(
                        "ID: %d | Producto: %s | Precio: %.2f | Stock: %d | Categoría: %s",
                        rs.getInt("id"),
                        rs.getString("producto"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"),
                        rs.getString("categoria")
                );
                lista.add(fila);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
