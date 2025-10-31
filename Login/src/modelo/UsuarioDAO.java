/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import modelo.Usuario;
import modelo.dbConexion;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 *
 * @author Usuario
 */
public class UsuarioDAO {

    // Registrar nuevo usuario (guarda la contraseña con hash)
    public boolean registrar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (username, password, email, fecha_registro, ultimo_acceso) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = dbConexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            String hashed = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
            ps.setString(1, usuario.getUsername());
            ps.setString(2, hashed);
            ps.setString(3, usuario.getEmail());
            ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            ps.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }

    // Cambiar contraseña
    public boolean cambiarPassword(int id, String nuevaPassword) {
        String sql = "UPDATE usuarios SET password=? WHERE id=?";
        try (Connection conn = dbConexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            String hashed = BCrypt.hashpw(nuevaPassword, BCrypt.gensalt());
            ps.setString(1, hashed);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al cambiar contraseña: " + e.getMessage());
            return false;
        }
    }

    // Login (valida credenciales)
    public Usuario login(String username, String password) {
        String sql = "SELECT * FROM usuarios WHERE username=?";
        try (Connection conn = dbConexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String hashed = rs.getString("password");
                if (BCrypt.checkpw(password, hashed)) {
                    actualizarUltimoAcceso(rs.getInt("id"));
                    return mapUsuario(rs);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error en login: " + e.getMessage());
        }
        return null;
    }

    // Actualizar último acceso
    private void actualizarUltimoAcceso(int id) {
        String sql = "UPDATE usuarios SET ultimo_acceso=? WHERE id=?";
        try (Connection conn = dbConexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al actualizar último acceso: " + e.getMessage());
        }
    }

    // Mapea el resultado SQL → objeto Usuario
    private Usuario mapUsuario(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();
        u.setId(rs.getInt("id"));
        u.setUsername(rs.getString("username"));
        u.setPassword(rs.getString("password"));
        u.setEmail(rs.getString("email"));
        u.setFechaRegistro(rs.getTimestamp("fecha_registro")
                .toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        u.setUltimoAcceso(rs.getTimestamp("ultimo_acceso")
                .toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        return u;
    }
}
