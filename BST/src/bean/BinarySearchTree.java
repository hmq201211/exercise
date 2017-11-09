package bean;

import java.util.Comparator;
import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T> {
    protected BSTNode<T> root;
    protected Comparator c;

    @Override
    public T min() {
        return null;
    }

    @Override
    public T max() {
        return null;
    }

    @Override
    public Iterator<T> getIterator(Traversal orderType) {
        return null;
    }

    @Override
    public boolean add(T element) {
        return false;
    }

    @Override
    public T get(T target) {
        return null;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public boolean remove(T target) {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
