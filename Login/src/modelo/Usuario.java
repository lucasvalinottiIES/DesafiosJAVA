/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDateTime;

/**
 *
 * @author Usuario
 */
public class Usuario {
    private int id;
    private String username;
    private String password; // almacenada como hash
    private String email;
    private LocalDateTime fechaRegistro;
    private LocalDateTime ultimoAcceso;

    public Usuario() {}

    public Usuario(int id, String username, String password, String email, 
                   LocalDateTime fechaRegistro, LocalDateTime ultimoAcceso) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.ultimoAcceso = ultimoAcceso;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public LocalDateTime getUltimoAcceso() { return ultimoAcceso; }
    public void setUltimoAcceso(LocalDateTime ultimoAcceso) { this.ultimoAcceso = ultimoAcceso; }
}
