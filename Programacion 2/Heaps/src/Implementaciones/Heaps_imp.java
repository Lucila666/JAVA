/**
 Se utilizo como guia de estas implementaciones la info de la siguiente pagina web https://www.geeksforgeeks.org/max-heap-in-java/
 */
package Implementaciones;
import Interfaces.*;
/**
 *
 * @author Valentina
 */
public class Heaps_imp implements Heaps_inter {
       
    private int[] heapArreglo; 
    private int dimension; 
    private int size;
     
    public void InicializarHeaps(){
        dimension = 100; 
        size = 0; 
        heapArreglo = new int [dimension]; 
        heapArreglo[0] = Integer.MAX_VALUE; 
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
        int aux; 
        aux = heapArreglo[ipos]; 
        heapArreglo[ipos] = heapArreglo[fpos]; 
        heapArreglo[fpos]  = aux; 
    } 
  
    // Funcion recursiva para reacomodar desde una cierta posicion.  
    // Esta funcion asume que los subarboles Der e Izq
    // ya estan ordenados 
    
    private void maxRaiz(int pos){ 
        if (esHoja(pos)) 
            return; 
        if (heapArreglo[pos]  < heapArreglo[hijoIzq(pos)]||  
            heapArreglo[pos]  < heapArreglo[hijoDer(pos)] ) { 
  
            if (heapArreglo[hijoIzq(pos)] > heapArreglo[hijoDer(pos)] ) { 
                intercambiar(pos, hijoIzq(pos)); 
                maxRaiz(hijoIzq(pos)); 
            } 
            else { 
                intercambiar(pos, hijoDer(pos)); 
                maxRaiz(hijoDer(pos)); 
            } 
        } 
    } 
  
    public void cargar(int[] arr){
        //Cargar el arreglo de valores. Esto nos da un árbol que 
        //no puede no estar ordeando según las caracteristicas 
        //descriptas de los heaps.
        for (int i=0; i<=arr.length-1;i++){
            heapArreglo[++size] = arr[i];
            
        }
        //Recorremos las hojas y las comparamos con sus padres.
        //A su vez los padres se comparan con los suyos hasta llegar a la raiz.
        for (int i=0; i<=size;i++){
            if (esHoja(i)){
                int aux=i;
                   while (heapArreglo[aux] > heapArreglo[padre(aux)] ) { 
                       intercambiar(aux, padre(aux)); 
                       aux = padre(aux); 
                    }
            }
        }    
    }
    public void insertar(int x){
        heapArreglo[++size] = x;
        int aux=size;
        while (heapArreglo[aux]  > heapArreglo[padre(aux)] ) { 
                       intercambiar(aux, padre(aux)); 
                       aux = padre(aux); 
                    }
    }
    
    public void print(){ 
        for (int i = 1; i <= size / 2; i++) { 
            if (2 * i + 1<=size){
                System.out.print(" PADRE : " + heapArreglo[i] + " HIJO IZQUIERDA : " + 
                    heapArreglo[2 * i] + " HIJO DERECHA :" + heapArreglo[2 * i + 1]) ; 
                System.out.println(); 
            }
            else{
                System.out.print(" PADRE : " + heapArreglo[i] + " HIJO IZQUIERDA : " + 
                    heapArreglo[2 * i] + " HIJO DERECHA : Vacío"); 
                System.out.println(); 
            }
        } 
    } 
  
    
    public void eliminar(){ 
       //Hago el intercambio de valores del nodo
        heapArreglo[1]=heapArreglo[size];
        size=--size;
        //Reacomodo
        maxRaiz(1);
    }  
}
      
   
   
