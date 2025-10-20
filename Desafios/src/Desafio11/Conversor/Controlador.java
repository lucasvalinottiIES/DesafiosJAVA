/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Desafio11.Conversor;
import static Desafio11.Conversor.Modelo.fahrenheitACelsius;
import static Desafio11.Conversor.Modelo.celsiusAFahrenheit;
/**
 *
 * @author Alumno
 */
public class Controlador {
    public static double fahrenheitACelsiusController(double fahrenheit) {
        return fahrenheitACelsius(fahrenheit);
    }

    public static double celsiusAFahrenheitController(double celsius) {
        return celsiusAFahrenheit(celsius);
    }
}
