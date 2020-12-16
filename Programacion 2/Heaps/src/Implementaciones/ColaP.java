/**
 Se utilizo como guia de estas implementaciones la info de la siguiente pagina web https://www.geeksforgeeks.org/max-heap-in-java/
 */
package Implementaciones;
import Interfaces.*;
/**
 *
 * @author Valentina
 */
public class ColaP implements ColaP_inter {
    
    class ColaPrioridad {
    int prioridad;
    int valor;
    }
    
    private ColaPrioridad [] heapArreglo; 
    private int dimension; 
    private int size;
     
    public void InicializarCola(){
        dimension = 100; 
        size = 0; 
        heapArreglo = new ColaPrioridad [dimension]; 
        heapArreglo[size]= new ColaPrioridad();
        heapArreglo[0].prioridad = Integer.MAX_VALUE; 
        heapArreglo[0].valor = Integer.MAX_VALUE; 
    } 
    private int padre(int pos){ 
        return pos / 2; 
    } 
    private int hijoIzq (int pos){ 
        return (2 * pos); 
    } 
    private int hijoDer(int pos){ 
        return (2 * pos) + 1; 
    } 
    private boolean esHoja(int pos){ 
        if (pos >= (size / 2) && pos <= size) { 
            return true; 
        } 
        return false; 
    } 
    private void intercambiar(int ipos, int fpos){ 
        ColaPrioridad aux = new ColaPrioridad();
        aux = heapArreglo[ipos]; 
        heapArreglo[ipos]= heapArreglo[fpos]; 
        heapArreglo[fpos] = aux; 
    } 
  
    // Funcion recursiva para reacomodar desde una cierta posicion.  
    // Esta funcion asume que los subarboles Der e Izq
    // ya estan ordenados 
    
    private void maxRaiz(int pos){ 
        if (esHoja(pos)) 
            return; 
        if (heapArreglo[pos].prioridad  < heapArreglo[hijoIzq(pos)].prioridad ||  
            heapArreglo[pos].prioridad  < heapArreglo[hijoDer(pos)].prioridad ) { 
  
            if (heapArreglo[hijoIzq(pos)].prioridad > heapArreglo[hijoDer(pos)].prioridad ) { 
                intercambiar(pos, hijoIzq(pos)); 
                maxRaiz(hijoIzq(pos)); 
            } 
            else { 
                intercambiar(pos, hijoDer(pos)); 
                maxRaiz(hijoDer(pos)); 
            } 
        } 
    } 
  
    public void ordenar(){
        for (int i=0; i<=size;i++){
            int aux=i;
            while (heapArreglo[aux].prioridad  > heapArreglo[padre(aux)].prioridad ) { 
                intercambiar(aux, padre(aux)); 
                aux = padre(aux); 
            }
        }
    }
    public void AcolarPrioridad(int v, int p){
        size=size+1;
        heapArreglo[size]= new ColaPrioridad();
        heapArreglo[size].prioridad = p;
        heapArreglo[size].valor= v;
        int aux=size;
        while (heapArreglo[aux].prioridad  > heapArreglo[padre(aux)].prioridad ) { 
            intercambiar(aux, padre(aux)); 
            aux = padre(aux); 
        }
       
        
    }
    
    public void print(){ 
        for (int i = 1; i <= size / 2; i++) { 
            if (2 * i + 1<=size){
                System.out.print(" PADRE : " + heapArreglo[i].prioridad +"/" + heapArreglo[i].valor + " HIJO IZQUIERDA : " + 
                 heapArreglo[2 * i].prioridad +"/" + heapArreglo[2 * i].valor + " HIJO DERECHA :" + heapArreglo[2 * i+1].prioridad +"/" + heapArreglo[2 * i+1].valor); 
                System.out.println(); 
            }
            else{
                System.out.print(" PADRE : " + heapArreglo[i].prioridad +"/" + heapArreglo[i].valor  + " HIJO IZQUIERDA : " + 
                    heapArreglo[2 * i].prioridad +"/" + heapArreglo[2 * i].valor + " HIJO DERECHA : Vacío"); 
                System.out.println(); 
            }
        } 
    } 
  
    
    public void Desacolar(){ 
       //Hago el intercambio de valores del nodo
        heapArreglo[1]=heapArreglo[size];
        size=--size;
        //Reacomodo
        
       if (esHoja(1)) 
            return; 
        if (heapArreglo[1].prioridad  < heapArreglo[hijoIzq(1)].prioridad||  
            heapArreglo[1].prioridad  < heapArreglo[hijoDer(1)].prioridad ) { 
  
            if (heapArreglo[hijoIzq(1)].prioridad > heapArreglo[hijoDer(1)].prioridad ) { 
                intercambiar(1, hijoIzq(1)); 
                maxRaiz(hijoIzq(1)); 
            } 
            else { 
                intercambiar(1, hijoDer(1)); 
                maxRaiz(hijoDer(1)); 
            } 
        } 
    }
     
    public boolean ColaVacia(){
    return(size==0);
    }
    
    public int Raiz(){
        System.out.println("El valor del elemento con mayor prioridad es: ");
    return(heapArreglo[1].valor);
    }
   
}
  
   
