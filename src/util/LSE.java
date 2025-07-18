package util;

import java.io.Serializable;

public class LSE<T> implements ILSE<T>, Serializable {

    private int size;
    private Nodo<T> primero;

    public LSE() {
        this.size = 0;
        this.primero = null;
    }

    @Override
    public void add(T dato) {
        Nodo<T> NodoNuevo = new Nodo(dato);
        if (primero == null) {
            this.primero = NodoNuevo;
        } else {
            Nodo<T> nodoActual = this.primero;
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(NodoNuevo);
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Para el indice" + index);
        } else {
            if (index == 0) {
                return primero.getDato();
            } else {
                Nodo<T> nodoActual = this.primero;
                int contador = 0;
                while (contador < index) {
                    nodoActual = nodoActual.getSiguiente();
                    contador++;
                }
                return nodoActual.getDato();
            }
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Para el indice" + index);
        } else {
            if (index == 0) {
                this.primero = primero.getSiguiente();
            } else {
                Nodo<T> nodoActual = this.primero;
                int contador = 0;
                while (contador < index - 1) {
                    nodoActual = nodoActual.getSiguiente();
                }
                nodoActual.setSiguiente(nodoActual.getSiguiente().getSiguiente());
            }
            size--;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
