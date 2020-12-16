
package grafos;
import Interface.*;
import Implementaciones.*;
public class Grafos {

    public static void main(String[] args) {
        // Se usa el valor 0 para nodos que no estan conectados
        // Se usa el valor 1 para nodos que estan conectados
        int [][] alternativo={ {0,0,0,0,1,0,1,0,0,0},
                                    {1,0,1,0,0,0,1,0,0,0},
                                    {0,0,0,1,0,0,1,0,0,0},
                                    {0,1,0,0,0,0,0,0,1,0},
                                    {0,0,0,0,0,1,1,0,0,0},
                                    {0,0,0,0,0,0,1,0,0,0},
                                    {0,0,0,0,0,0,0,1,1,1},
                                    {0,0,0,0,0,0,0,0,1,1},
                                    {0,0,1,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,1,0,0,0,0}};

        
        caminos(alternativo,1,5);
       
    
    
    }  
    public static int[] opciones(int[][] M,int v){
        // Para un dado nodo v se crea un array con los 
        //nodos hacia donde puede dirigirse el nodo v
        int[] opcion=new int[100];
        int cant=0;
        for (int i=0; i<M.length;i++){
            if (M[v][i]!=0){
                    opcion[cant]=i;
                }
        }
        return opcion;
    }
    public static boolean caminos(int[][] M,int A,int B){
        int[] opcion=new int[100];
        int cant=0;
        System.out.print("empezamos");
        for (int i=0; i<M.length;i++){
            System.out.print("primer for");
            if (M[A][i]!=0){
                    opcion[cant]=i;
                    cant++;
                }
        }
        System.out.print("holis");
        for (int i=0; i<cant;i++){
            if (opcion[i]!=B){
                caminos(M,i,B);
            }
            else{
                return true;
            }
        }
        return false;
    }
    
}
