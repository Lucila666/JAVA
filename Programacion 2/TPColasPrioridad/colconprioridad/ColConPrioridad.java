
package colconprioridad;
import Implementaciones.ColaPrioridadDA;
import Interfaces.ColaPrioridadTDA;

public class ColConPrioridad {

    
    public static void main(String[] args) {
        ColaPrioridadTDA uno = new ColaPrioridadDA();
        ColaPrioridadTDA dos = new ColaPrioridadDA();
        
        uno.InicializarCola();
        dos.InicializarCola();
        
        uno.AcolarPrioridad(4,1);
        uno.AcolarPrioridad(2, 3);
        uno.AcolarPrioridad(3, 2);
        dos.AcolarPrioridad(1, 1);
        dos.AcolarPrioridad(2, 1);
        dos.AcolarPrioridad(3, 1);
        
        ImprimirColaP(uno);
        ImprimirColaP(dos);
        Unificar(uno,dos);
        ImprimirColaP(uno);
        ImprimirColaP(dos);
    }
    public static void Unificar (ColaPrioridadTDA primera, ColaPrioridadTDA segunda){
        int a=0;
        int p=0;
        ColaPrioridadTDA aux = new ColaPrioridadDA();
        aux.InicializarCola();
        while (!segunda.ColaVacia()){
            a = segunda.Primero();
            p = segunda.Prioridad();
            primera.AcolarPrioridad(a, p);
            aux.AcolarPrioridad(a, p);
            segunda.Desacolar();
        }
        PasarColaP(aux,segunda);
    }
    
    public static void PasarColaP(ColaPrioridadTDA origen, ColaPrioridadTDA destino){
            
            while (!origen.ColaVacia()){
               
                destino.AcolarPrioridad(origen.Primero(), origen.Prioridad());
                origen.Desacolar();
            }
    }  
    
    public static void ImprimirColaP(ColaPrioridadTDA cola){
        ColaPrioridadTDA aux = new ColaPrioridadDA();
	aux.InicializarCola();
            if (!cola.ColaVacia()){
		while(!cola.ColaVacia()){
                    System.out.println(cola.Primero() + "-" + cola.Prioridad());
                    aux.AcolarPrioridad(cola.Primero(), cola.Prioridad());
                    cola.Desacolar();
		}
		PasarColaP(aux,cola);
                System.out.println("Fin cola");
		}
                else
                    System.out.println("Cola Vacia");
    }
}
