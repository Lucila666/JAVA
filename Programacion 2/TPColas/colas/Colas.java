/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;
import Interfaces.ColaTDA;
import Implementaciones.ColaPU;

public class Colas {

    
    public static void main(String[] args) {
        ColaTDA uno = new ColaPU();
        ColaTDA dos = new ColaPU();
        
        uno.InicializarCola();
        dos.InicializarCola();
        uno.Acolar(4);
        uno.Acolar(5);
        uno.Acolar(6);
        
         
        System.out.println("Primera cola original: ");
        ImprimirCola(uno);
        System.out.println("Segunda cola original: ");
        ImprimirCola(dos);
        
        PasarCola(uno,dos);
        System.out.println("Primera cola pasada: ");
        ImprimirCola(uno);
        System.out.println("Segunda cola pasada : ");
        ImprimirCola(dos);
        
        InvertirCola(dos);
        System.out.println("Segunda cola invertida: ");
        ImprimirCola(dos);
        uno.Acolar(4);
        uno.Acolar(5);
        uno.Acolar(6);
        System.out.println("Son los finales de las colas iguales?  "+ CompararFinales(uno,dos));
        System.out.println("Es la cola capicua?  "+ Capicua(uno));
        System.out.println("Son inversas entre si?  "+ SerInversas(uno,dos));
    }
    public static void PasarCola(ColaTDA origen, ColaTDA destino){
            
            while (!origen.ColaVacia()){
               
                destino.Acolar(origen.Primero());
                origen.Desacolar();
                 
            }
    }  
    
    public static void CopiarCola(ColaTDA origen, ColaTDA destino){
        ColaPU auxiliar=new ColaPU();
	auxiliar.InicializarCola();    
        while (!origen.ColaVacia()){
                destino.Acolar(origen.Primero());
                auxiliar.Acolar(origen.Primero());
                origen.Desacolar();
            }
            PasarCola(auxiliar,origen);
    } 
    
    public static void InvertirCola(ColaTDA cola){
        int[] aux = new int[100];
        int inx=0;
        ColaPU auxiliar=new ColaPU();
	auxiliar.InicializarCola();
        while(!cola.ColaVacia()){
            aux[inx]=cola.Primero();
            cola.Desacolar();
            inx++;
        }
       
        for(int i=inx; i>0; i--){
            auxiliar.Acolar(aux[i-1]);
        }
        PasarCola(auxiliar,cola);
    }
    
    public static boolean CompararFinales(ColaTDA cola1, ColaTDA cola2){
        int guardar1=0;
        int guardar2=0;
        ColaPU aux1=new ColaPU();
        ColaPU aux2=new ColaPU();
	aux1.InicializarCola();
        aux2.InicializarCola();
        
        while (!cola1.ColaVacia()){
            guardar1=cola1.Primero();
            aux1.Acolar(cola1.Primero());
            cola1.Desacolar();
        }
        while (!cola2.ColaVacia()){
            guardar2=cola2.Primero();
            aux2.Acolar(cola2.Primero());
            cola2.Desacolar();
        }
        
        PasarCola(aux1,cola1);
        PasarCola(aux2,cola2);
        return guardar1==guardar2;
    }
    
    public static boolean Capicua(ColaTDA cola){
        ColaPU aux=new ColaPU();
	aux.InicializarCola();
        CopiarCola(cola,aux);
	InvertirCola(aux);
        while(!cola.ColaVacia()){
            if (cola.Primero()==aux.Primero()){
                cola.Desacolar();
                aux.Desacolar();
            } else{
                return(cola.Primero()==aux.Primero());
            }
        }
        return cola.ColaVacia();
    }
    
    public static boolean SerInversas(ColaTDA cola1, ColaTDA cola2){
        ColaPU aux1=new ColaPU();
        ColaPU aux2=new ColaPU();
	aux1.InicializarCola();
        aux2.InicializarCola();
        CopiarCola(cola1,aux1);
        CopiarCola(cola2,aux2);
        InvertirCola(aux2);
        while(!aux1.ColaVacia() && !aux2.ColaVacia()){
            if (aux1.Primero()==aux2.Primero()){
                aux1.Desacolar();
                aux2.Desacolar();
            } else{
                return(aux1.Primero()==aux2.Primero());
            }
        }
        return (aux1.ColaVacia() && aux2.ColaVacia());
    }
    public static void ImprimirCola(ColaTDA cola){
        ColaPU aux=new ColaPU();
	aux.InicializarCola();
            if (!cola.ColaVacia()){
		while(!cola.ColaVacia()){
                    System.out.println(cola.Primero());
                    aux.Acolar(cola.Primero());
                    cola.Desacolar();
		}
		PasarCola(aux,cola);
                System.out.println("Fin cola");
		}
                else
                    System.out.println("Cola Vacia");
    }
}
