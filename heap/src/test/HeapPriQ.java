package test;

import java.util.ArrayList;
import java.util.Comparator;

public class HeapPriQ<T extends Comparable<T>> implements PriQueueInterface<T> {
    protected ArrayList<T> elements;
    protected int lastIndex;
    protected int maxIndex;
    protected Comparator<T> comp;

    public HeapPriQ() {
        elements = new ArrayList<T>();
        lastIndex = -1;
        maxIndex = 1000;
        comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        };
    }

    @Override
    public void enqueue(T element) throws PriQOverflowException {
        if (lastIndex == maxIndex) {
            throw new PriQOverflowException("Priority queue is full");
        } else {
            lastIndex++;
            elements.add(lastIndex, element);
            reheapUp(element);
        }

    }

    private void reheapUp(T element) {
        int hole = lastIndex;
        while ((hole > 0) && (comp.compare(element, elements.get((hole - 1) / 2)) > 0)) {
            elements.set(hole, elements.get((hole - 1) / 2));
            hole = (hole - 1) / 2;
        }
        elements.set(hole, element);
    }

    @Override
    public T dequeue() throws PriQUnderflowException {
        T hold;
        T toMove;
        if (lastIndex == -1) {
            throw new PriQUnderflowException("Priority queue is empty");
        } else {
            hold = elements.get(0);
            toMove = elements.get(lastIndex);
            lastIndex--;
            if (lastIndex != -1) {
                reheapDown(toMove);

            }
            return hold;
        }
    }

    private void reheapDown(T element) {
        int hole = 0;
        int next;
        next = newHole(hole, element);
        while (next != hole) {
            elements.set(hole, elements.get(next));
            hole = next;
            next = newHole(hole, element);
        }
        elements.set(hole, element);
    }

    private int newHole(int hole, T element) {
        int left = (hole * 2) + 1;
        int right = (hole * 2) + 2;
        if (left > lastIndex) {
            return hole;
        } else if (left == lastIndex)
            if (comp.compare(element, elements.get(left)) < 0)
                return left;
            else
                return hole;
        else if (comp.compare(elements.get(left), elements.get(right)) < 0)
            if (comp.compare(elements.get(right), element) <= 0)
                return hole;
            else
                return right;
        else if (comp.compare(elements.get(left), element) <= 0)
            return hole;
        else
            return left;
    }

    @Override
    public boolean isEmpty() {
        return lastIndex == -1;
    }

    @Override
    public boolean isFull() {
        return lastIndex == maxIndex;
    }

    @Override
    public int size() {
        return lastIndex;
    }
}
