package bolzano;

import java.util.Scanner;
import java.util.function.Function;

public class Bolzano {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MetodoBolzano Bolzano = new MetodoBolzano();
        
        System.out.print("Ingrese la función (utilice 'x' como variable): ");
        String funcionString = scanner.nextLine();

        System.out.print("Ingrese el extremo izquierdo del intervalo: ");
        double a = scanner.nextDouble();

        System.out.print("Ingrese el extremo derecho del intervalo: ");
        double b = scanner.nextDouble();

        Function<Double, Double> funcion = Bolzano.crearFuncion(funcionString);

        double x = Bolzano.encontrarAproximacion(funcion, a, b);

        System.out.println("La aproximación de la solución es: " + x);

        scanner.close();
        
    }

    
}

