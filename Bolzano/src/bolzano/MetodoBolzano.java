
package bolzano;
import java.util.function.Function;

public class MetodoBolzano {
    
   

    public Function<Double, Double> crearFuncion(String funcionString) {
        return x -> evaluarFuncion(funcionString, x);
    }

    private double evaluarFuncion(String funcionString, double x) {
        // Evalúa la función utilizando la expresión ingresada por el usuario
        // Puedes utilizar cualquier librería o método para evaluar expresiones matemáticas
        // En este ejemplo, simplemente se devuelve x para funciones lineales
        return x; // Devuelve x para funciones lineales (por defecto)
    }

    public double encontrarAproximacion(Function<Double, Double> funcion, double a, double b ) {
        double fa = funcion.apply(a);
        double fb = funcion.apply(b);
        double epsilon = 0.0001;
        if (fa * fb > 0) {
            System.out.println("La función no cambia de signo en el intervalo.");
            return 0;
        }

        double x = (a + b) / 2;

        while (Math.abs(funcion.apply(x)) > epsilon) {
            double fx = funcion.apply(x);

            if (fa * fx < 0) {
                b = x;
            } else {
                a = x;
            }

            x = (a + b) / 2;
        }

        return x;
    }
}
