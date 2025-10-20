/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import static Modelo.Conversor.celsiusAFahrenheit;
import static Modelo.Conversor.fahrenheitACelsius;
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
