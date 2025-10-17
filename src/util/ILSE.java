/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package util;

/**
 *
 * @author Juan Esteban
 */
public interface ILSE<T> {

    public void addFirst(T dato);

    public T get(int index);

    public void add(T dato, int index);

    public void remove(int index);

    public int size();

    public boolean isEmpty();
}
