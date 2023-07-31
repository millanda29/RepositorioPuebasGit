package biseccion;

import java.util.Scanner;
import java.util.function.Function;

public class Biseccion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MetodoBiseccion biseccion = new MetodoBiseccion();

        System.out.print("Ingrese la función: ");
        String functionStr = scanner.nextLine();

        Function<Double, Double> funcionB = biseccion.crearFuncion(functionStr);

        System.out.print("Ingrese el límite inferior del intervalo (a): ");
        double a = scanner.nextDouble();

        System.out.print("Ingrese el límite superior del intervalo (b): ");
        double b = scanner.nextDouble();
        
        double root = biseccion.findRoot(a, b, funcionB);
        System.out.println("La raíz se encuentra en x = " + root);

        biseccion.solveBisection(a, b, funcionB);
        biseccion.mostrarGrafica(functionStr, a, b, funcionB);

        scanner.close();
    }
}


