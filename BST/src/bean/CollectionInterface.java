package bean;

public interface CollectionInterface<T> {
    boolean add(T element);
    T get(T target);
    boolean contains(T element);
    boolean remove(T target);
    boolean isFull();
    boolean isEmpty();
    int size();
}
