/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodosnumericos;

/**
 *
 * @author pablo
 */
public class PuntoFlotante {

    public boolean verficarHexa(String Pfloat) {
        if (Pfloat.startsWith("0x") || Pfloat.startsWith("0X")) {
            String numero = Pfloat.substring(2); // Elimina los primeros dos caracteres (0x o 0X)

            // Verifica si los caracteres restantes son dígitos hexadecimales
            for (char c : numero.toCharArray()) {
                if (!Character.isDigit(c) && (c < 'A' || c > 'F') && (c < 'a' || c > 'f')) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

}
