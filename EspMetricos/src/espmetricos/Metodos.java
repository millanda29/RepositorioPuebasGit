/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espmetricos;

/**
 *
 * @author maikd
 */

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;

public class Metodos {

    public double calcularDistancia(double x1, double y1, double x2, double y2) {
        double distanciaX = x2 - x1;
        double distanciaY = y2 - y1;
        double distancia = Math.sqrt(distanciaX * distanciaX + distanciaY * distanciaY);
        return distancia;
    }

    public void generarGrafico(double x1, double y1, double x2, double y2) {
        // Crear la serie de datos para los puntos
        XYSeries series = new XYSeries("Puntos");
        series.add(x1, y1);
        series.add(x2, y2);

        // Crear la serie de datos para la distancia
        XYSeries distanciaSeries = new XYSeries("Distancia");
        distanciaSeries.add(x1, y1);
        distanciaSeries.add(x2, y2);

        // Crear la colección de series de datos
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        dataset.addSeries(distanciaSeries);

        // Crear el gráfico
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Espacio Métrico", "X", "Y", dataset);

        // Personalizar la apariencia del gráfico
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLUE); // Puntos
        renderer.setSeriesPaint(1, Color.RED); // Distancia
        plot.setRenderer(renderer);

        // Mostrar el gráfico en una ventana
        ChartFrame frame = new ChartFrame("Espacio Métrico", chart);
        frame.pack();
        frame.setVisible(true);
    }
}

