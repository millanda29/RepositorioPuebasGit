/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conversiones;

/**
 *
 * @author maikd
 */
public class Conversiones {

    public static void main(String[] args) {
        main conv = new main();
        int decimalNumber = 42;
        String binaryString = "101010";
        String hexadecimalString = "2A";
        String octalString = "52";

        String conversionType = "hexadecimal"; // Cambiar a "binary", "hexadecimal" u "octal" para probar otras conversiones

        if (conversionType.equals("binary")) {
            int decimalResult = conv.binaryToDecimal(binaryString);
            System.out.println("El número binario " + binaryString + " en decimal es: " + decimalResult);
        } else if (conversionType.equals("hexadecimal")) {
            int decimalResult = conv.hexadecimalToDecimal(hexadecimalString);
            System.out.println("El número hexadecimal " + hexadecimalString + " en decimal es: " + decimalResult);
        } else if (conversionType.equals("octal")) {
            int decimalResult = conv.octalToDecimal(octalString);
            System.out.println("El número octal " + octalString + " en decimal es: " + decimalResult);
        } else {
            System.out.println("Opción de conversión no válida.");
        }
    }

}
