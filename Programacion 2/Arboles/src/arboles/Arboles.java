package arboles;
import Interfaces.ABBTDA;
import Implementaciones.ABB;

public class Arboles {
     public static void main(String[] args) {
        ABBTDA arbolito = new ABB();
        arbolito.InicializarArbol();
        arbolito.AgregarElem(9);
        arbolito.AgregarElem(4);
        arbolito.AgregarElem(30);
        arbolito.AgregarElem(3);
        arbolito.AgregarElem(1);
        arbolito.AgregarElem(2);
        arbolito.AgregarElem(10);
        arbolito.AgregarElem(20);
        arbolito.AgregarElem(50);
        arbolito.AgregarElem(40);
        arbolito.AgregarElem(70);
        arbolito.AgregarElem(60);
       
        minimo(arbolito);
        System.out.println("Pre orden: ");
        preOrder(arbolito);
        System.out.println();
        System.out.println("In orden: ");
        inOrder(arbolito);
        System.out.println();
        System.out.println("Post orden: ");
        postOrder(arbolito);
        System.out.println();
        System.out.println("El arbol tiene un total de: " +cantidad(arbolito)+" elementos.");
        System.out.println("y su suma es: " +suma(arbolito));
        
    }
    
     public static boolean existeElemento(ABBTDA t, int x){
         if (t.ArbolVacio()){
             return false;
         }
         else if (t.Raiz()==x){
             return true;
         }
         else if (t.Raiz()>x){
             return existeElemento(t.HijoIzq(),x);
         }
         else{
             return existeElemento(t.HijoDer(),x);
         }
     }
     public static boolean esHoja(ABBTDA t, int x){
        if (existeElemento(t,x)){
            if (t.Raiz()==x){
                if (t.HijoDer().ArbolVacio() && t.HijoIzq().ArbolVacio()){
                    return true;}
                else{
                    return false;}
            }
            else if (t.Raiz()>x){
                return esHoja(t.HijoIzq(),x);
            }
            else{
                return esHoja(t.HijoDer(),x);
            }
        }
        return false;
    }
     public static int profundidad (ABBTDA t, int x){
        if (t.ArbolVacio()){
            return 0;
        }
        else if (t.Raiz()==x){
            return 0;
        }
        else if (t.Raiz() >x){
            return (1+ profundidad(t.HijoIzq(),x));
        }
        else{
            return (1+ profundidad(t.HijoDer(),x));
        }
    }
     public static void minimo(ABBTDA a){
         if (!a.HijoIzq().ArbolVacio()){
             minimo(a.HijoIzq());
         }
         else
             System.out.println("el minimo es: " + a.Raiz());
     }
    public static void preOrder (ABBTDA a){
        if (!a.ArbolVacio()){
            System.out.print(a.Raiz()+"/");
            preOrder(a.HijoIzq());
            preOrder(a.HijoDer());
        }
    } 
    public static void inOrder(ABBTDA a){
        if(!a.ArbolVacio()){
            inOrder(a.HijoIzq());
            System.out.print(a.Raiz()+"/");
            inOrder(a.HijoDer());
        }
    }
    public static void postOrder(ABBTDA a){
        if (!a.ArbolVacio()){
            postOrder(a.HijoIzq());
            postOrder(a.HijoDer());
            System.out.print(a.Raiz()+"/");
        }
    }
    public static int cantidad (ABBTDA a){
        if(!a.ArbolVacio()){
            return 1+cantidad(a.HijoIzq())+cantidad(a.HijoDer());
        }
        
        else
         return 0;
    }
    public static int suma (ABBTDA a){
        if(!a.HijoDer().ArbolVacio() && !a.HijoIzq().ArbolVacio()){
            return a.Raiz()+suma(a.HijoIzq())+suma(a.HijoDer());
        }
        
        else
            System.out.println(a.Raiz());
         return a.Raiz();
    }
    
}
