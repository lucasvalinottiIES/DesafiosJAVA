/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class LibroDAO {

    public List<Libro> obtenerTodos() {
        List<Libro> estudiantes = new ArrayList<>();
        String sql = "SELECT * FROM Libros ORDER BY id";

        try (Connection conn = dbConexion.obtenerConexion(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            // Iterar sobre los resultados
            while (rs.next()) {
                Libro est = new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("ano_publicacion"),
                        rs.getString("isbn"),
                         rs.getBoolean("disponible")
                );
                estudiantes.add(est);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener estudiantes: " + e.getMessage());
        }

        return estudiantes;
    }
    
     // Insertar un nuevo libro
    public boolean insertar(Libro libro) {
        String sql = "INSERT INTO Libros (titulo, autor, ano_publicacion, isbn, disponible) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = dbConexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, libro.getTitulo());
            pstmt.setString(2, libro.getAutor());
            pstmt.setString(3, libro.getAnoPublicacion());
            pstmt.setString(4, libro.getIsbn());
            pstmt.setBoolean(5, libro.isDisponible());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar libro: " + e.getMessage());
            return false;
        }
    }

    // Actualizar un libro existente
    public boolean actualizar(Libro libro) {
        String sql = "UPDATE Libros SET titulo = ?, autor = ?, ano_publicacion = ?, isbn = ?, disponible = ? WHERE id = ?";
        try (Connection conn = dbConexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, libro.getTitulo());
            pstmt.setString(2, libro.getAutor());
            pstmt.setString(3, libro.getAnoPublicacion());
            pstmt.setString(4, libro.getIsbn());
            pstmt.setBoolean(5, libro.isDisponible());
            pstmt.setInt(6, libro.getId());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar libro: " + e.getMessage());
            return false;
        }
    }

    // Eliminar un libro por ID
    public boolean eliminar(int id) {
        String sql = "DELETE FROM Libros WHERE id = ?";
        try (Connection conn = dbConexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar libro: " + e.getMessage());
            return false;
        }
    }

    // Buscar libros por nombre de autor (coincidencia parcial)
    public List<Libro> buscarPorAutor(String autor) {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM Libros WHERE autor LIKE ? ORDER BY titulo";

        try (Connection conn = dbConexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + autor + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Libro libro = new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("ano_publicacion"),
                        rs.getString("isbn"),
                        rs.getBoolean("disponible")
                );
                libros.add(libro);
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar libros por autor: " + e.getMessage());
        }

        return libros;
    }

    // Buscar libros disponibles o no
    public List<Libro> buscarPorDisponibilidad(boolean disponible) {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM Libros WHERE disponible = ? ORDER BY titulo";

        try (Connection conn = dbConexion.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setBoolean(1, disponible);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Libro libro = new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("ano_publicacion"),
                        rs.getString("isbn"),
                        rs.getBoolean("disponible")
                );
                libros.add(libro);
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar libros por disponibilidad: " + e.getMessage());
        }

        return libros;
    }
    
}
