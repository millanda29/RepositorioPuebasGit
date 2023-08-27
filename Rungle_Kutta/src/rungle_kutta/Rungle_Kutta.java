/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rungle_kutta;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Rungle_Kutta {
    public static double function(double x, double y, Expression exp) {
        exp.setVariable("x", x);
        exp.setVariable("y", y);
        return exp.evaluate();
    }

    public static double rungeKutta(double x0, double y0, double h, double x, Expression exp, List<String> iterations) {
        double y = y0;

        while (x0 < x) {
            double k1 = h * function(x0, y, exp);

            iterations.add(String.format(Locale.US, "%.6f\t%.6f\t%.6f",
                    x0, y, k1));

            y += k1;

            x0 += h;
        }

        return y;
    }
    
    public static double rungeKutta2(double x0, double y0, double h, double x, Expression exp, List<String> iterations2) {
        double y = y0;

        while (x0 < x) {
            double k1 = h * function(x0, y, exp);
            double k2 = h * function(x0 + h, y + k1, exp);

            iterations2.add(String.format(Locale.US, "%.6f\t%.6f\t%.6f\t%.6f",
                    x0, y, k1, k2));

            y += (k1 + k2) / 2;

            x0 += h;
        }

        return y;
    }
    
    public static double rungeKutta3(double x0, double y0, double h, double x, Expression exp, List<String> iterations3) {
        double y = y0;

        while (x0 < x) {
            double k1 = h * function(x0, y, exp);
            double k2 = h * function(x0 + h / 2, y + k1 / 2, exp);
            double k3 = h * function(x0 + h, y - k1 + 2 * k2, exp);

            iterations3.add(String.format(Locale.US, "%.6f\t%.6f\t%.6f\t%.6f\t%.6f",
                    x0, y, k1, k2, k3));

            y += (k1 + 4 * k2 + k3) / 6;

            x0 += h;
        }

        return y;
    }
    
    public static double rungeKutta4(double x0, double y0, double h, double x, Expression exp, List<String> iterations4) {
        double y = y0;

        while (x0 < x) {
            double k1 = h * function(x0, y, exp);
            double k2 = h * function(x0 + h / 2, y + k1 / 2, exp);
            double k3 = h * function(x0 + h / 2, y + k2 / 2, exp);
            double k4 = h * function(x0 + h, y + k3, exp);

            iterations4.add(String.format(Locale.US, "%.6f\t%.6f\t%.6f\t%.6f\t%.6f\t%.6f",
                    x0, y, k1, k2, k3, k4));

            y += (k1 + 2 * k2 + 2 * k3 + k4) / 6;

            x0 += h;
        }

        return y;
    }
    
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> iterations = new ArrayList<>();
        List<String> iterations2 = new ArrayList<>();
        List<String> iterations3 = new ArrayList<>();
        List<String> iterations4 = new ArrayList<>();

        System.out.print("Ingrese la función en términos de x y y (por ejemplo, x + y): ");
        String functionExpression = scanner.nextLine();

        Expression exp = new ExpressionBuilder(functionExpression)
                .variables("x", "y")
                .build();

        System.out.print("Ingrese el valor inicial de x: ");
        double x0 = scanner.nextDouble();

        System.out.print("Ingrese el valor inicial de y: ");
        double y0 = scanner.nextDouble();

        System.out.print("Ingrese el tamaño del paso (h): ");
        double h = scanner.nextDouble();

        System.out.print("Ingrese el valor de x en el que desea encontrar y: ");
        double x = scanner.nextDouble();

        scanner.close();

        double result = rungeKutta(x0, y0, h, x, exp, iterations);

        System.out.println("xk\tyk\tK1");
        for (String iteration : iterations) {
            System.out.println(iteration);
        }

        System.out.println("\nEl valor de y en x = " + x + " es " + result);
        
        double result2 = rungeKutta2(x0, y0, h, x, exp, iterations2);

        System.out.println("xk\tyk\tK1\tK2");
        for (String iteration2 : iterations2) {
            System.out.println(iteration2);
        }

        System.out.println("\nEl valor de y en x = " + x + " es " + result2);
        
        double result3 = rungeKutta3(x0, y0, h, x, exp, iterations3);

        System.out.println("xk\tyk\tK1\tK2\tK3");
        for (String iteration3 : iterations3) {
            System.out.println(iteration3);
        }

        System.out.println("\nEl valor de y en x = " + x + " es " + result3);
        
        double result4 = rungeKutta4(x0, y0, h, x, exp, iterations4);

        System.out.println("xk\tyk\tK1\tK2\tK3\tK4");
        for (String iteration4 : iterations4) {
            System.out.println(iteration4);
        }

        System.out.println("\nEl valor de y en x = " + x + " es " + result4);
    }
}




 /*
    import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.Scanner;
    
    static double function(double x, double y, Expression expression) {
        expression.setVariable("x", x);
        expression.setVariable("y", y);
        return expression.evaluate();
    }

    static double rungeKuttaFirstOrder(double x0, double y0, double h, double x, Expression expression) {
        while (x0 < x) {
            double k1 = h * function(x0, y0, expression);
            x0 += h;
            y0 += k1;
            System.out.println("x = " + x0 + ", y = " + y0);
        }
        return y0;
    }

    static double rungeKuttaSecondOrder(double x0, double y0, double h, double x, Expression expression) {
        while (x0 < x) {
            double k1 = h * function(x0, y0, expression);
            double k2 = h * function(x0 + h / 2, y0 + k1 / 2, expression);
            x0 += h;
            y0 += 0.5 * (k1 + k2);
            System.out.println("x = " + x0 + ", y = " + y0);
        }
        return y0;
    }

    static double rungeKuttaThirdOrder(double x0, double y0, double h, double x, Expression expression) {
        while (x0 < x) {
            double k1 = h * function(x0, y0, expression);
            double k2 = h * function(x0 + h / 2, y0 + k1 / 2, expression);
            double k3 = h * function(x0 + h, y0 - k1 + 2 * k2, expression);
            x0 += h;
            y0 += (k1 + 4 * k2 + k3) / 6;
            System.out.println("x = " + x0 + ", y = " + y0);
        }
        return y0;
    }

    static double rungeKuttaFourthOrder(double x0, double y0, double h, double x, Expression expression) {
        while (x0 < x) {
            double k1 = h * function(x0, y0, expression);
            double k2 = h * function(x0 + h / 2, y0 + k1 / 2, expression);
            double k3 = h * function(x0 + h / 2, y0 + k2 / 2, expression);
            double k4 = h * function(x0 + h, y0 + k3, expression);
            x0 += h;
            y0 += (k1 + 2 * k2 + 2 * k3 + k4) / 6;
            System.out.println("x = " + x0 + ", y = " + y0);
        }
        return y0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la ecuación diferencial (ejemplo: x + y):");
        String equation = scanner.nextLine();
        Expression expression = new ExpressionBuilder(equation)
                .variable("x")
                .variable("y")
                .build();

        System.out.println("Ingrese el valor inicial de x:");
        double x0 = scanner.nextDouble();

        System.out.println("Ingrese el valor inicial de y:");
        double y0 = scanner.nextDouble();

        System.out.println("Ingrese el tamaño del paso (h):");
        double h = scanner.nextDouble();

        System.out.println("Ingrese el valor de x para el que desea encontrar y(x):");
        double x = scanner.nextDouble();

        System.out.println("Elija el método Runge-Kutta a utilizar:");
        System.out.println("1 - Primer orden");
        System.out.println("2 - Segundo orden");
        System.out.println("3 - Tercer orden");
        System.out.println("4 - Cuarto orden");
        int methodChoice = scanner.nextInt();

        double result = 0;

        switch (methodChoice) {
            case 1:
                System.out.println("Pasos para el método de primer orden:");
                result = rungeKuttaFirstOrder(x0, y0, h, x, expression);
                break;
            case 2:
                System.out.println("Pasos para el método de segundo orden:");
                result = rungeKuttaSecondOrder(x0, y0, h, x, expression);
                break;
            case 3:
                System.out.println("Pasos para el método de tercer orden:");
                result = rungeKuttaThirdOrder(x0, y0, h, x, expression);
                break;
            case 4:
                System.out.println("Pasos para el método de cuarto orden:");
                result = rungeKuttaFourthOrder(x0, y0, h, x, expression);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        System.out.println("El valor de y(" + x + ") es: " + result);

        scanner.close();
    }
    */