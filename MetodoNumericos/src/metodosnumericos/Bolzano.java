/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodosnumericos;
import java.util.function.Function;
/**
 *
 * @author maikd
 */
public class Bolzano {
   
    public Function<Double, Double> CrearFuncion(String funcionString) {
        return x -> EvaluarFuncion(funcionString, x);
        
    }
   
    public double EvaluarFuncion(String funcionString, double x) {
        return x;
    }
    
    public double EncontrarAproximacion(Function<Double, Double> funcion, double a, double b) {
        double epsilon = 0.0001;
        double fa = funcion.apply(a);
        double fb = funcion.apply(b);

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
