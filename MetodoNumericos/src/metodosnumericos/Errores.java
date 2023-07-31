/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodosnumericos;

/**
 *
 * @author pablo
 */
public class Errores {
    
    public double errAbs(double err1, double err2){
        double Ea;
        Ea = err2-err1;
        return Ea;
    }
    
    public double errRel(double Ea, double err2){
        double Er;
        Er = Ea/err2;
        return Er;
    }
    
}
