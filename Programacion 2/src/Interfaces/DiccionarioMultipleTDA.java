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
public interface DiccionarioMultipleTDA {
    void InicializarDiccionario();
    void Agregar (int clave, int valor);
    void Eliminar (int clave);
    void EliminarValor (int clave, int valor);
    ConjuntoTDA Recuperar(int Clave);
    ConjuntoTDA Claves();
    
}
