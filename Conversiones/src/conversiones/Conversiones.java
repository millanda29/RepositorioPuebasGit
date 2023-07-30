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
        System.out.println("Ingrese el numero que desea ingresar");
        numero1 = leer.next();
        System.out.println("Ingrese el tipo de numero(decimal, binario, hexadecimal, octal)");
        tipo1=leer.next();
        System.out.println("Ingrese a que desea convertir (decimal, binario, hexadecimal, octal)");
        tipo2=leer.next();
        
        
        if ( tipo1.equalsIgnoreCase(d)) {
            int number = Integer.parseInt(numero1);
            if ( tipo2.equalsIgnoreCase(b)) {
                System.out.println("El numero: "+numero1+" en binario es: "+conv.decimalToBinary(number));
            } else if (tipo2.equalsIgnoreCase(h)) {
                System.out.println("El numero: "+numero1+" en hexadecimal es: "+conv.decimalToHexadecimal(number));
            } else if (tipo2.equalsIgnoreCase(o)) {
                System.out.println("El numero: "+numero1+" en octal  es: "+conv.decimalToOctal(number));
            } else if (tipo2.equalsIgnoreCase(d)) {
                System.out.println("El numero: "+numero1+" en decimal es: "+numero1);
            }
        } else if (tipo1.equalsIgnoreCase(b)){
            if ( tipo2.equalsIgnoreCase(d)) {
                System.out.println("El numero: "+numero1+" en decimal es: "+conv.binaryToDecimal(numero1));
            } else if (tipo2.equalsIgnoreCase(h)) {
                System.out.println("El numero: "+numero1+" en hexadecimal es: "+conv.binaryToHexadecimal(numero1));
            } else if (tipo2.equalsIgnoreCase(o)) {
                System.out.println("El numero: "+numero1+" en octal es: "+conv.binaryToOctal(numero1));
            } else if (tipo2.equalsIgnoreCase(b)) {
                System.out.println("El numero: "+numero1+" en binario es: "+numero1);
            }
        } else if (tipo1.equalsIgnoreCase(h)){
            if ( tipo2.equalsIgnoreCase(d)) {
                System.out.println("El numero: "+numero1+" en decimal es: "+conv.hexadecimalToDecimal(numero1));
            } else if (tipo2.equalsIgnoreCase(b)) {
                System.out.println("El numero: "+numero1+" en binario es: "+conv.hexadecimalToBinary(numero1));
            } else if (tipo2.equalsIgnoreCase(o)) {
                System.out.println("El numero: "+numero1+" en octal es: "+conv.hexadecimalToOctal(numero1));
            } else if (tipo2.equalsIgnoreCase(h)){
                System.out.println("El numero: "+numero1+" en hexadecimal es: "+numero1);
            }
        } else if (tipo1.equalsIgnoreCase(o)){
            if ( tipo2.equalsIgnoreCase(d)) {
                System.out.println("El numero: "+numero1+" en decimal es: "+conv.octalToDecimal(numero1));
            } else if (tipo2.equalsIgnoreCase(h)) {
                System.out.println("El numero: "+numero1+" en hexadecimal es: "+conv.octalToHexadecimal(numero1));
            } else if (tipo2.equalsIgnoreCase(b)) {
                System.out.println("El numero: "+numero1+" en binario es: "+conv.octalToBinary(numero1));
            } else if (tipo2.equalsIgnoreCase(o)){
                System.out.println("El numero: "+numero1+" en octal es: "+numero1);
            }
        }
        leer.close();
        
    }

}
