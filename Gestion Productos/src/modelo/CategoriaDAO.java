/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
import modelo.Categoria;
import modelo.dbConexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    // Crear categoría
    public void agregarCategoria(Categoria categoria) {
        String sql = "INSERT INTO categorias (nombre) VALUES (?)";
        try (Connection con = dbConexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, categoria.getNombre());
            ps.executeUpdate();
            System.out.println("✅ Categoría agregada correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar categorías
    public List<Categoria> listarCategorias() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categorias";

        try (Connection con = dbConexion.obtenerConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Categoria c = new Categoria(
                    rs.getInt("id"),
                    rs.getString("nombre")
                );
                lista.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Actualizar categoría
    public void actualizarCategoria(Categoria categoria) {
        String sql = "UPDATE categorias SET nombre=? WHERE id=?";
        try (Connection con = dbConexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, categoria.getNombre());
            ps.setInt(2, categoria.getId());
            ps.executeUpdate();
            System.out.println("✅ Categoría actualizada correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar categoría
    public void eliminarCategoria(int id) {
        String sql = "DELETE FROM categorias WHERE id=?";
        try (Connection con = dbConexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("🗑️ Categoría eliminada correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
