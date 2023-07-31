/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serietylor;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

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
        try {
            Expression expression = new ExpressionBuilder(function)
                    .variable("x")
                    .build()
                    .setVariable("x", x);
            return expression.evaluate();
        } catch (Exception e) {
            System.err.println("Error evaluando la función: " + e.getMessage());
            return Double.NaN;
        }
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
    
}
