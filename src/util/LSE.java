/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.Serializable;

/**
 *
 * @author Juan Esteban
 */
public class LSE<T> implements Serializable, ILSE<T> {

    private int size;
    private Nodo<T> primero;

    public LSE() {
        this.size = 0;
        this.primero = null;
    }

    @Override
    public void addFirst(T dato) {
        Nodo<T> nodoNuevo = new Nodo<>(dato);
        if (isEmpty()) {
            this.primero = nodoNuevo;
        } else {
            Nodo<T> nodoActual = this.primero;
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nodoNuevo);
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
    public void add(T dato, int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Para el indice" + index);
        } else {
            Nodo<T> nodoNuevo = new Nodo<>(dato);
            if (index == 0) {
                nodoNuevo.setSiguiente(primero);
                this.primero = nodoNuevo;
            } else {
                Nodo<T> nodoActual = this.primero;
                int contador = 0;
                while (contador < index - 1) {
                    nodoActual = nodoActual.getSiguiente();
                    contador++;
                }
                nodoNuevo.setSiguiente(nodoActual.getSiguiente());
                nodoActual.setSiguiente(nodoNuevo);
            }
            size++;
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Para el indice" + index);
        } else {
            if (index == 0) {
                primero = primero.getSiguiente();
            } else {
                Nodo<T> nodoActual = this.primero;
                int contador = 0;
                while (contador < index - 1) {
                    nodoActual = nodoActual.getSiguiente();
                    contador++;
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
