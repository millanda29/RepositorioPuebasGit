/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serietylor;

import java.util.Scanner;

/**
 *
 * @author maikd
 */
public class SerieTylor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MetodoClass met = new MetodoClass(); 
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa la función (por ejemplo, 'x^2 + 3*x + 5'): ");
        String function = scanner.nextLine();

        System.out.print("Ingresa el valor de x para calcular la serie de Taylor: ");
        double x = scanner.nextDouble();

        System.out.print("Ingresa el número de términos de la serie de Taylor: ");
        int n = scanner.nextInt();

        double result = met.calculateCustomTaylorSeries(function, x, n);

        System.out.println("Resultado de la serie de Taylor: " + result);
    }
    
}
