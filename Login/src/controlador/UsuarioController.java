/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.UsuarioDAO;
import modelo.Usuario;
import java.time.LocalDateTime;

/**
 *
 * @author Usuario
 */
public class UsuarioController {

    private final UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    /**
     * Registra un nuevo usuario en la base de datos.
     * 
     * @param username nombre de usuario
     * @param email correo electrónico
     * @param password contraseña en texto plano (se encripta en el DAO)
     * @return true si el registro fue exitoso, false si ocurrió un error
     */
    public boolean registrar(String username, String email, String password) {
        Usuario nuevo = new Usuario();
        nuevo.setUsername(username);
        nuevo.setEmail(email);
        nuevo.setPassword(password);
        nuevo.setFechaRegistro(LocalDateTime.now());
        nuevo.setUltimoAcceso(LocalDateTime.now());

        return usuarioDAO.registrar(nuevo);
    }
    
    public Usuario login(String username, String password) {
        return usuarioDAO.login(username, password);
    }
}
