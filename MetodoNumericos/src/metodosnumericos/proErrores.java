/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodosnumericos;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author pablo
 */
public class proErrores {
    public XYDataset createDataset(BigDecimal x, int iterations) {
        DefaultXYDataset dataset = new DefaultXYDataset();
        double[][] data = new double[2][iterations];

        for (int i = 1; i <= iterations; i++) {
            BigDecimal numerator = exp(x, i);
            BigDecimal denominator = exp(x, i).subtract(BigDecimal.ONE);
            BigDecimal result = numerator.divide(denominator, 128, RoundingMode.HALF_UP);

            data[0][i-1] = i;
            data[1][i-1] = result.doubleValue();
        }

        dataset.addSeries("Resultados", data);

        return dataset;
    }

    public BigDecimal exp(BigDecimal x, int iterations) {
        BigDecimal result = BigDecimal.ONE;
        BigDecimal term = BigDecimal.ONE;
        int scale = 128;

        for (int i = 1; i <= iterations; i++) {
            term = term.multiply(x).divide(new BigDecimal(i), scale, RoundingMode.HALF_UP);
            result = result.add(term);
        }

        return result;
    }

    public JFreeChart createChart(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Gráfico de Iteraciones",
                "Iteración",
                "Resultado",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        return chart;
    }
}
