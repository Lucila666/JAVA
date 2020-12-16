package Interfaces;

public interface ABBTDA {
    int Raiz();
    ABBTDA HijoIzq();
    ABBTDA HijoDer();
    boolean ArbolVacio();
    void InicializarArbol();
    void EliminarElem(int x);
    void AgregarElem(int x);
    
}
