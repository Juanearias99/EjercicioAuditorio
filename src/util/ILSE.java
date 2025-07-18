package util;

public interface ILSE<T> {

    public void add(T dato);

    public T get(int index);

    public void remove(int index);

    public int size();

    public boolean isEmpty();
}
