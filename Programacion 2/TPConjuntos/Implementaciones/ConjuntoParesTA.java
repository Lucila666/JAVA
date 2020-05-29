
package Implementaciones;
import Interfaces.ConjuntoParesTDA;

/**
 *
 * @author Valentina
 */
public class ConjuntoParesTA implements ConjuntoParesTDA {
        
    class Par{
        int primero;
        int segundo;
    }
    
    Par[] pares;
    int cant;
    
    public void InicializarConjuntoPar(){
        cant=0;
        pares= new Par[100];
    }
     public void Agregar(int n1, int n2){
       
        pares[cant]=new Par();
        pares[cant].primero=n1;
        pares[cant].segundo=n2;
        cant++;
     }
    public boolean ConjuntoParVacio() {
        return cant==0;
    }   
}
