/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heaps;

/**
 *
 * @author Valentina
 */
public class auxiliar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ColaP_inter ejemplo = new ColaP();
        ejemplo.InicializarCola();
        ejemplo.AcolarPrioridad(100, 3);
        ejemplo.AcolarPrioridad(150, 1);
        ejemplo.AcolarPrioridad(124, 2);
        ejemplo.AcolarPrioridad(130, 5);
        ejemplo.AcolarPrioridad(160, 4);
        
        System.out.println("El heap original es: ");
        ejemplo.print();
        System.out.println( ejemplo.Raiz());
        ejemplo.Desacolar();
        System.out.println("Luego de desacolar el elemento de mayor prioridad nos queda: ");
        ejemplo.print();
    }
    
}
