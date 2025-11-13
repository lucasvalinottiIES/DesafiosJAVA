/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Libro;

/**
 *
 * @author Usuario
 */
public class LibroTableModel extends AbstractTableModel {
    private final String[] columnas = {"ID", "Título", "Autor", "Año Publicación", "ISBN", "Disponible"};
    private List<Libro> libros;

    public LibroTableModel(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public int getRowCount() {
        return libros.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnas[col];
    }

    @Override
    public Object getValueAt(int fila, int col) {
        Libro libro = libros.get(fila);
        return switch (col) {
            case 0 -> libro.getId();
            case 1 -> libro.getTitulo();
            case 2 -> libro.getAutor();
            case 3 -> libro.getAnoPublicacion();
            case 4 -> libro.getIsbn();
            case 5 -> libro.isDisponible() ? "Sí" : "No";
            default -> null;
        };
    }
}
