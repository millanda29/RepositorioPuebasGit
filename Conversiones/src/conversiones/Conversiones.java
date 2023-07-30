/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conversiones;
import java.util.Scanner;

/**
 *
 * @author maikd
 */
public class Conversiones {

    public static void main(String[] args) {
        main conv = new main();
        Scanner leer = new Scanner(System.in);
        String d ="decimal", b ="binario", h ="hexadecimal", o ="octal";
        String tipo1, tipo2;
        String numero1;
        int numero;
        System.out.println("Ingrese el numero que desea ingresar");
        numero1 = leer.next();
        System.out.println("Ingrese el tipo de numero(decimal, binario, hexadecimal, octal)");
        tipo1=leer.next();
        System.out.println("Ingrese a que desea convertir (decimal, binario, hexadecimal, octal)");
        tipo2=leer.next();
        
        if ( tipo1.equalsIgnoreCase(d)) {
            if ( tipo2.equalsIgnoreCase(b)) {
                int number = Integer.parseInt(numero1);
                conv.decimalToBinary(number);
            } 
            
        } else {
            
        }
        leer.close();
        
    }

}
