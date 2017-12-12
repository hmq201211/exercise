package test;

public interface PriQueueInterface<T> {
    void enqueue(T element) throws PriQOverflowException;

    T dequeue() throws PriQUnderflowException;

    boolean isEmpty();

    boolean isFull();

    int size();
}
