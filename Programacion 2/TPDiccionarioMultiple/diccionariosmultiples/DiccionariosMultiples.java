/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diccionariosmultiples;
import Interfaces.*;
import Implementaciones.*;

/**
 *
 * @author Valentina
 */
public class DiccionariosMultiples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello world");
        DiccionarioMultipleTDA probando = new DicMultipleA();
        ConjuntoTDA guardar = new ConjuntoTA();
        
        probando.InicializarDiccionario();
        probando.Agregar(3, 5);
        probando.Agregar(1, 6);
        probando.Agregar(2, 8);
        probando.Agregar(2, 10);
        
        guardar=probando.Claves();
        imprimirConjunto(guardar);
        
        }
        
    public static void imprimirConjunto(ConjuntoTDA recibir){
        int a;
        while (recibir.ConjuntoVacio()!=true){
            a=recibir.Elegir();
            System.out.println(a);
            recibir.Sacar(a);
        }
        
        
    }
    
}
