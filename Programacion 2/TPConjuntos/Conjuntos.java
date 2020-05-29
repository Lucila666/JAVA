
package conjuntos;
import Interfaces.*;
import Implementaciones.*;

public class Conjuntos {

    public static void main(String[] args) {
     ConjuntoTDA A= new ConjuntoTA();
     ConjuntoTDA B= new ConjuntoTA();
     ConjuntoParesTDA C= new ConjuntoParesTA();
     A.InicializarConjunto();
     B.InicializarConjunto();
     C.InicializarConjuntoPar();
     
     A.Agregar(1);
     A.Agregar(3);
     A.Agregar(7);
     B.Agregar(2);
     B.Agregar(4);
     B.Agregar(6);
     
     C=MultiplicarConjuntos(A,B);
     
     
    }
    
    public static ConjuntoParesTDA MultiplicarConjuntos(ConjuntoTDA c1, ConjuntoTDA c2){
    ConjuntoParesTDA c3= new ConjuntoParesTA();
    c3.InicializarConjuntoPar();
    int[] aux1= new int[100];
    int[] aux2= new int[100];
    int i=0;       
    //Asumo que los conjuntos de entrada tienen el mismo tamaño
    while(c1.ConjuntoVacio()!=true){
        aux1[i]=c1.Elegir();
        aux2[i]=c2.Elegir();
        c1.Sacar(aux1[i]);
        c2.Sacar(aux2[i]);
                
    }
    for (int x=0; x<=i; x++){
        c1.Agregar(aux1[x]);
        c2.Agregar(aux2[x]);
        for (int y=0; y<=i; y++){
            c3.Agregar(aux1[x], aux2[y]);
            
        }
    }
    return c3;
    }
     public static void imprimirConjunto(ConjuntoTDA recibir){
        int a;
        while (recibir.ConjuntoVacio()!=true){
            a=recibir.Elegir();
            System.out.println(a);
            recibir.Sacar(a);
        }
     public static void imprimirConjuntoPares(ConjuntoParesTDA recibir){
        int a;
        //while (recibir.ConjuntoVacio()!=true){
       //     a=recibir.Elegir();
       //     System.out.println(a);
       //     recibir.Sacar(a);
        }
}
