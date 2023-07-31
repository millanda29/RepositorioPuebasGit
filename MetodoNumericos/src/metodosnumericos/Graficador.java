/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodosnumericos;

import java.util.function.Function;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.DefaultXYDataset;
/**
 *
 * @author maikd
 */
public class Graficador {
     public void generarGrafica(String funcionString, double minX, double maxX) {
        Function<Double, Double> funcion = crearFuncion(funcionString);

        // Crear los datos de la función
        DefaultXYDataset dataset = new DefaultXYDataset();
        double[][] data = generarDatosFuncion(funcion, minX, maxX);
        dataset.addSeries("Función", data);

        // Crear el gráfico
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Gráfico de la Función", // Título del gráfico
                "X", // Etiqueta del eje X
                "Y", // Etiqueta del eje Y
                dataset // Datos
        );

        // Mostrar el gráfico en una ventana
        ChartFrame frame = new ChartFrame("Gráfico", chart);
        frame.pack();
        frame.setVisible(true);
    }

    // Generar los datos de la función
    private double[][] generarDatosFuncion(Function<Double, Double> funcion, double minX, double maxX) {
        int puntos = 100; // Número de puntos para generar

        double[][] data = new double[2][puntos];
        double paso = (maxX - minX) / (puntos - 1);

        for (int i = 0; i < puntos; i++) {
            double x = minX + i * paso;
            double y = funcion.apply(x);
            data[0][i] = x;
            data[1][i] = y;
        }

        return data;
    }

    private Function<Double, Double> crearFuncion(String functionStr) {
        Expression expression = new ExpressionBuilder(functionStr)
                .variables("x")
                .build();

        return x -> evaluarFuncion(expression, x);
    }

    private double evaluarFuncion(Expression expression, double x) {
        // Evaluar la función utilizando la expresión ingresada por el usuario
        expression.setVariable("x", x);
        return expression.evaluate();
    }
}
