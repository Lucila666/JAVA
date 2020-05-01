
package programacion.pkg2;
import Interfaces.PilaTDA;
import implementaciones.PilaTF;

public class TP1Pilas {

    
    public static void main(String[] args) {
        PilaTDA uno= new PilaTF();
        PilaTDA dos=new PilaTF();
        
        uno.InicializarPila();
        dos.InicializarPila();
        
        uno.Apilar(1);
        uno.Apilar(2);
        uno.Apilar(3);
        
        System.out.println("Primer pila");
        ImprimirPila(uno);
        System.out.println("Segunda pila");
        ImprimirPila(dos);
        
              
        PasarPila(uno,dos);
        
        System.out.println("Primer pila despues de ser pasada");
        ImprimirPila(uno);
        System.out.println("Segunda pila al recibir un pase");
        ImprimirPila(dos);
        
        CopiarPila(dos,uno);
        System.out.println("Primer pila a la que se copio la segunda");
        ImprimirPila(uno);
        System.out.println("Segunda pila que se copio a la primera");
        ImprimirPila(dos);
        
        InvertirPila(uno);
        System.out.println("Primer pila invertida");
        ImprimirPila(uno);
        
        int CantidadElementos = ContarElementos(uno);
        System.out.println("La pila tiene la siguiente cantidad de elementos: " + CantidadElementos);
    
        int sumatoria = SumarElementos(uno);
        System.out.println("La suma de sus elementos es: " + sumatoria);
        
        double promedios = Promediar(uno);
        System.out.println("El promedio de los elementos es: " + promedios);
}

    public static void PasarPila(PilaTDA origen, PilaTDA destino){
            
            while (!origen.PilaVacia()){
               
                destino.Apilar(origen.Tope());
                origen.Desapilar();
                 
            }
        }
    public static void CopiarPila(PilaTDA origen, PilaTDA destino){
        PilaTDA aux1=new PilaTF();
	aux1.InicializarPila();
        PilaTDA aux2=new PilaTF();
	aux2.InicializarPila();
            if (!origen.PilaVacia()){
		while(!origen.PilaVacia()){
		aux1.Apilar(origen.Tope());
                aux2.Apilar(origen.Tope());
		origen.Desapilar();
		}
		PasarPila(aux1,destino);
                PasarPila(aux2,origen);
		}
    }
    
    public static void InvertirPila(PilaTDA origen){
            PilaTF aux=new PilaTF();
            aux.InicializarPila();
            while (!origen.PilaVacia()){
                aux.Apilar(origen.Tope());
                origen.Desapilar();
            }
            CopiarPila(aux,origen);
        }
    
    public static int ContarElementos(PilaTDA pila){
        int contador=0;
        PilaTF aux=new PilaTF();
	aux.InicializarPila();
            if (!pila.PilaVacia()){
		while(!pila.PilaVacia()){
                    contador++;
                    aux.Apilar(pila.Tope());
                    pila.Desapilar();
		}
		PasarPila(aux,pila);
            }
        return contador;    
   }
    
    public static int SumarElementos(PilaTDA pila){
        int suma=0;
        PilaTF aux=new PilaTF();
	aux.InicializarPila();
            if (!pila.PilaVacia()){
		while(!pila.PilaVacia()){
                    suma=suma+pila.Tope();
                    aux.Apilar(pila.Tope());
                    pila.Desapilar();
		}
		PasarPila(aux,pila);
            }
        return suma;    
   }
    
    public static double Promediar(PilaTDA pila){
        int contador=0;
        double suma=0;
        double promedio;
        PilaTF aux=new PilaTF();
	aux.InicializarPila();
            if (!pila.PilaVacia()){
		while(!pila.PilaVacia()){
                    contador++;
                    suma=suma+pila.Tope();
                    aux.Apilar(pila.Tope());
                    pila.Desapilar();
		}
		PasarPila(aux,pila);
            }
        promedio=suma/contador;
        return promedio;    
   }
    
    public static void ImprimirPila(PilaTDA pila){
        PilaTF aux=new PilaTF();
	aux.InicializarPila();
            if (!pila.PilaVacia()){
		while(!pila.PilaVacia()){
                    System.out.println(pila.Tope());
                    aux.Apilar(pila.Tope());
                    pila.Desapilar();
		}
		PasarPila(aux,pila);
                System.out.println("Fin pila");
		}
                else
                    System.out.println("Pila Vacia");
    }
}
    
    
    
    