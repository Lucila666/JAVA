
package Implementaciones;
import Interface.*;

public class GrafoLA {
    class NodoGrafo{
    int nodo;
    NodoArista arista;
    NodoGrafo signodo;
    }
    class NodoArista{
    int etiqueta;
    NodoGrafo nodoDestino;
    NodoArista sigArista;
    }
    
    NodoGrafo origen;
    
    public void InicializarGrafo(){
    origen = null;
    }
    
    public void AgregarVertice(int v){
        NodoGrafo aux = new NodoGrafo();
        aux.nodo=v;
        aux.arista=null;
        aux.signodo=origen;
        origen=aux;
    }
    
    public void AgregarArista (int v1, int v2, int peso){
        NodoGrafo n1= Vert2Nodo(v1);
        NodoGrafo n2= Vert2Nodo(v2);
        
        NodoArista aux = new NodoArista();
        aux.etiqueta = peso;
        aux.nodoDestino = n2;
        aux.sigArista = n1.arista;
        n1.arista=aux;
    }
    
    private NodoGrafo Vert2Nodo (int v){
        NodoGrafo aux = origen;
        while (aux!=null && aux.nodo!=v){
            aux=aux.signodo;
        }
        return aux;
    }
    
    public void EliminarVertice(int v){
        if (origen.nodo == v){
            origen=origen.signodo;
        }
        
        NodoGrafo aux = origen;
        while(aux!=null){
            EliminarAristaNodo (aux,v);
            if(aux.signodo!=null && aux.signodo.nodo==v){
                aux.signodo = aux.signodo.signodo;
            }
            aux = aux.signodo;
        }
    }
    
    private void EliminarAristaNodo (NodoGrafo nodo, int v){
        NodoArista aux = nodo.arista;
        if (aux!=null){
            if (aux.nodoDestino.nodo==v){
                nodo.arista = aux.sigArista;
            }
            else{
                while (aux.sigArista!=null && aux.sigArista.nodoDestino.nodo !=v){
                aux=aux.sigArista;
                }
                if(aux.sigArista!=null){
                    aux.sigArista=aux.sigArista.sigArista;
                }
            }
            
        }
    }
    
    public ConjuntoTDA Vertices(){
        ConjuntoTDA c = new ConjuntoTA();
        c.InicializarConjunto();
        NodoGrafo aux=origen;
        while(aux!=null){
            c.Agregar(aux.nodo);
            aux=aux.signodo;
        }
        return c;
    }
    
    public void EliminarArista (int v1, int v2){
        NodoGrafo n1=Vert2Nodo(v1);
        EliminarAristaNodo(n1,v2);
    }
    
    public boolean ExisteArista (int v1, int v2){
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoArista aux = n1.arista;
        while(aux!=null && aux.nodoDestino.nodo!=v2){
            aux=aux.sigArista;
        }
        return aux != null;
    }
    
    public int PesoArista (int v1, int v2){
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoArista aux = n1.arista;
        while(aux!=null && aux.nodoDestino.nodo!=v2){
            aux=aux.sigArista;
        }
        return aux.etiqueta;
    }
}
