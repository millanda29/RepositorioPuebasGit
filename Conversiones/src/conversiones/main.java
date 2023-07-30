/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversiones;

/**
 *
 * @author maikd
 */
public class main {
    
    // Método para convertir decimal a binario
    public static String decimalToBinary(int decimalNumber) {
        StringBuilder binaryString = new StringBuilder();
        while (decimalNumber > 0) {
            int remainder = decimalNumber % 2;
            binaryString.insert(0, remainder);
            decimalNumber /= 2;
        }
        return binaryString.toString();
    }
    // Método para convertir decimal a hexadecimal
    public static String decimalToHexadecimal(int decimalNumber) {
        StringBuilder hexString = new StringBuilder();
        while (decimalNumber > 0) {
            int remainder = decimalNumber % 16;
            if (remainder < 10) {
                hexString.insert(0, (char) ('0' + remainder));
            } else {
                hexString.insert(0, (char) ('A' + (remainder - 10)));
            }
            decimalNumber /= 16;
        }
        return hexString.toString();
    }
    // Método para convertir decimal a octal
    public static String decimalToOctal(int decimalNumber) {
        StringBuilder octalString = new StringBuilder();
        while (decimalNumber > 0) {
            int remainder = decimalNumber % 8;
            octalString.insert(0, remainder);
            decimalNumber /= 8;
        }
        return octalString.toString();
    }
    
    
    // Método para convertir binario a decimal
    public static int binaryToDecimal(String binaryString) {
        int decimalNumber = 0;
        int base = 1;
        int binaryLength = binaryString.length();

        for (int i = binaryLength - 1; i >= 0; i--) {
            if (binaryString.charAt(i) == '1') {
                decimalNumber += base;
            }
            base *= 2;
        }
        return decimalNumber;
    }
    // Método para convertir binario a hexadecimal
    public static String binaryToHexadecimal(String binaryString) {
        int decimalNumber = binaryToDecimal(binaryString);
        return decimalToHexadecimal(decimalNumber);
    }
    // Método para convertir binario a octal
    public static String binaryToOctal(String binaryString) {
        int decimalNumber = binaryToDecimal(binaryString);
        return decimalToOctal(decimalNumber);
    }
    
    // Método para convertir hexadecimal a decimal
    public static int hexadecimalToDecimal(String hexString) {
        String digits = "0123456789ABCDEF";
        int decimalNumber = 0;

        for (int i = 0; i < hexString.length(); i++) {
            char ch = hexString.charAt(i);
            int digit = digits.indexOf(ch);
            decimalNumber = decimalNumber * 16 + digit;
        }
        return decimalNumber;
    }
    // Método para convertir hexadecimal a binario
    public static String hexadecimalToBinary(String hexadecimalString) {
        int decimalNumber = hexadecimalToDecimal(hexadecimalString);
        return decimalToBinary(decimalNumber);
    }
    // Método para convertir hexadecimal a octal
    public static String hexadecimalToOctal(String hexadecimalString) {
        int decimalNumber = hexadecimalToDecimal(hexadecimalString);
        return decimalToOctal(decimalNumber);
    }
    
    
    // Método para convertir octal a decimal
    public static int octalToDecimal(String octalString) {
        int decimalNumber = 0;
        int base = 1;
        int octalLength = octalString.length();

        for (int i = octalLength - 1; i >= 0; i--) {
            int digit = octalString.charAt(i) - '0';
            decimalNumber += digit * base;
            base *= 8;
        }
        return decimalNumber;
    }
    // Método para convertir octal a hexadecimal
    public static String octalToHexadecimal(String octalString) {
        int decimalNumber = octalToDecimal(octalString);
        return Integer.toHexString(decimalNumber).toUpperCase();
    }
    // Método para convertir octal a binario
    public static String octalToBinary(String octalString) {
        int decimalNumber = octalToDecimal(octalString);
        return Integer.toBinaryString(decimalNumber);
    }
    
}
