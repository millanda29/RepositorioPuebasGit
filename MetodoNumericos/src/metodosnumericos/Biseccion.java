package metodosnumericos;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author maikd
 */
public class Biseccion {
    
    public Function<Double, Double> CrearFuncionBis(String functionStr) {
        return x -> evaluarFuncion(functionStr, x);
    }

    public double evaluarFuncion(String functionStr, double x) {
        // Evaluar la función utilizando la expresión ingresada por el usuario
        // Puedes utilizar cualquier librería o método para evaluar expresiones matemáticas
        // En este ejemplo, simplemente se devuelve x para funciones lineales
        return x; // Devuelve x para funciones lineales (por defecto)
    }

    public static final double TOLERANCE = 0.0001;
    public static final int MAX_ITERATIONS = 100;

    public void solveBisection(double a, double b, Function<Double, Double> functionB) {
        List<IterationResult> iterationResults = new ArrayList<>();

        double c = 0;
        double fA = functionB.apply(a);
        double fC = 0;

        for (int i = 0; i < MAX_ITERATIONS; i++) {
            c = (a + b) / 2;
            fC = functionB.apply(c);

            iterationResults.add(new IterationResult(i + 1, a, c, b, fA, fC, functionB.apply(b)));

            if (Math.abs(fC) < TOLERANCE) {
                break;
            }

            if (fA * fC < 0) {
                b = c;
            } else {
                a = c;
                fA = fC;
            }
        }

        displayIterationResults(iterationResults);
    }

    private void displayIterationResults(List<IterationResult> iterationResults) {
        Object[][] data = new Object[iterationResults.size()][7];
        String[] columnNames = {"iter", "a", "c", "b", "f(a)", "f(c)", "f(b)"};

        for (int i = 0; i < iterationResults.size(); i++) {
            IterationResult result = iterationResults.get(i);
            data[i] = new Object[]{result.getIteration(), result.getA(), result.getC(), result.getB(),
                    result.getfA(), result.getfC(), result.getfB()};
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame("Tabla de Iteraciones");
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }

    public void mostrarGrafica(String functionStr, double a, double b, Function<Double, Double> functionB) {
        // Crear una serie de datos para la función
        XYSeries functionSeries = new XYSeries("Función");
        for (double x = a; x <= b; x += 0.01) {
            functionSeries.add(x, functionB.apply(x));
        }

        // Crear una serie de datos para la línea de la raíz
        double root = findRoot(a, b, functionB);
        XYSeries rootSeries = new XYSeries("Raíz");
        rootSeries.add(root, functionB.apply(root));

        // Agregar las series al conjunto de datos
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(functionSeries);
        dataset.addSeries(rootSeries);

        // Crear el gráfico
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Método de Bisección", "x", "f(x)",
                dataset, PlotOrientation.VERTICAL, true, true, false);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.getRenderer().setSeriesPaint(0, Color.blue);
        plot.getRenderer().setSeriesStroke(0, new BasicStroke(2.0f));
        plot.getRenderer().setSeriesPaint(1, Color.red);
        plot.getRenderer().setSeriesStroke(1, new BasicStroke(2.0f));

        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setRange(a, b);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(functionB.apply(a), functionB.apply(b));

        // Mostrar el gráfico en una ventana
        JFrame frame = new JFrame("Gráfico del Método de Bisección");
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 400));
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public double findRoot(double a, double b, Function<Double, Double> functionB) {
        double c = 0;
        double fA = functionB.apply(a);
        double fC = 0;

        for (int i = 0; i < MAX_ITERATIONS; i++) {
            c = (a + b) / 2;
            fC = functionB.apply(c);

            if (Math.abs(fC) < TOLERANCE) {
                break;
            }

            if (fA * fC < 0) {
                b = c;
            } else {
                a = c;
                fA = fC;
            }
        }

        return c;
    }

    private static class IterationResult {
        private final int iteration;
        private final double a;
        private final double c;
        private final double b;
        private final double fA;
        private final double fC;
        private final double fB;

        public IterationResult(int iteration, double a, double c, double b, double fA, double fC, double fB) {
            this.iteration = iteration;
            this.a = a;
            this.c = c;
            this.b = b;
            this.fA = fA;
            this.fC = fC;
            this.fB = fB;
        }

        public int getIteration() {
            return iteration;
        }

        public double getA() {
            return a;
        }

        public double getC() {
            return c;
        }

        public double getB() {
            return b;
        }

        public double getfA() {
            return fA;
        }

        public double getfC() {
            return fC;
        }

        public double getfB() {
            return fB;
        }
    }
    
}
