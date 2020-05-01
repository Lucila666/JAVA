/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package implementaciones;
import TDA.PilaTDA;

/**
 *
 * @author Valentina
 */

public class PilaTF implements PilaTDA{
            int [] a;
            int indice;
            public void InicializarPila(){
                a=new int[100];
                indice=0;
            }
            public void Apilar(int x){
            a[indice]=x;
            indice++;
            }
            public void Desapilar(){
            indice--;
            }
            public boolean PilaVacia(){
            return (indice==0);
            }
            public int Tope(){
            return a[indice-1];
            }
            
}

    
