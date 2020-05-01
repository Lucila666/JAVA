/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Valentina
 */
public interface ColaPrioridadTDA {
    void InicializarCola();
    void AcolarPrioridad (int x, int prioridad);
    void Desacolar();
    int Primero();
    boolean ColaVacia();
    int Prioridad();
    
}
