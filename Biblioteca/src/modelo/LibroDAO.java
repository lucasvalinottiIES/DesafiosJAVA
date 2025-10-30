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
                        rs.getTimestamp("ano_publicacion").toLocalDateTime(),
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
}
