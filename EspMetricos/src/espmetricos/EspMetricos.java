/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package espmetricos;

import java.util.Scanner;

/**
 *
 * @author maikd
 */
public class EspMetricos {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Obtener las coordenadas del primer punto
        System.out.println("Ingrese las coordenadas del primer punto:");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        // Obtener las coordenadas del segundo punto
        System.out.println("Ingrese las coordenadas del segundo punto:");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        // Calcular la distancia entre los dos puntos
        Metodos calculadora = new Metodos ();
        double distancia = calculadora.calcularDistancia(x1, y1, x2, y2);

        // Mostrar la distancia
        System.out.println("La distancia entre los dos puntos es: " + distancia);

        // Generar el gráfico
        calculadora.generarGrafico(x1, y1, x2, y2);
    }
}
