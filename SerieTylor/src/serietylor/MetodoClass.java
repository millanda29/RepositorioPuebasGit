/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serietylor;

/**
 *
 * @author maikd
 */
public class MetodoClass {
    
    public static double calculateCustomTaylorSeries(String function, double x, int n) {
        double result = 0.0;

        for (int i = 0; i < n; i++) {
            double term = evaluateFunction(function, x) / factorial(i);
            result += term;
            x = x * x; // Incrementa el valor de x para el siguiente término de la serie.
        }

        return result;
    }

    public static double evaluateFunction(String function, double x) {
        // Aquí debes implementar un evaluador de expresiones matemáticas.
        // Puedes usar bibliotecas como JEP (Java Expression Parser) o implementar uno simple.
        // En este ejemplo, se asume que la función es del tipo "ax^2 + bx + c".
        // Debes cambiar esta implementación según tus necesidades.
        String[] coefficients = function.split("\\+|-");
        double a = Double.parseDouble(coefficients[0]);
        double b = Double.parseDouble(coefficients[1]);
        double c = Double.parseDouble(coefficients[2]);
        return a * x * x + b * x + c;
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
    
}
