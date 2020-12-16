package heaps;
import Interfaces.Heaps_inter;
import Implementaciones.Heaps_imp;
// * @author Valentina

public class Heaps {

    public static void main(String[] args) {
        
        Heaps_inter maxHeap = new Heaps_imp();
        int [] valores = new int[] {1,6,9,2,7,5,2,7,4,10};
        
        maxHeap.InicializarHeaps();
        maxHeap.cargar(valores);
        System.out.println("El heap original es:");
        maxHeap.print();
        maxHeap.insertar(15);
        System.out.println("El heap con un nuevo elemento es:");
        maxHeap.print();
        maxHeap.eliminar();
        System.out.println("Si sacamos la raiz queda el siguiente heap:");
        maxHeap.print();
    }
}
        
        

    
