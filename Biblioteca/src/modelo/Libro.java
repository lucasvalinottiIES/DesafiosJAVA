/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private java.time.LocalDateTime anoPublicacion;
    private String isbn;
    private boolean disponible;
    
    // Constructor vacío
    public Libro() {
    }

    // Constructor con parámetros
    public Libro(int id, String titulo, String autor, java.time.LocalDateTime anoPublicacion, String isbn, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
        this.isbn = isbn;
        this.disponible = disponible;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public java.time.LocalDateTime getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(java.time.LocalDateTime anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Método toString
    @Override
    public String toString() {
        return "Libro {" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anoPublicacion=" + anoPublicacion +
                ", isbn='" + isbn + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}
