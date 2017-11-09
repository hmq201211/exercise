package bean;

public class ArrayBoundedFloatingFrontQueue<T> implements QueueInterface<T> {
	protected final int DEFCAP = 100;
	protected T[] elements;
	protected int numElements = 0;
	protected int front = 0;
	protected int rear;
	

	public ArrayBoundedFloatingFrontQueue() {
		elements = (T[]) new Object[DEFCAP];
		rear = DEFCAP - 1;
	}

	public ArrayBoundedFloatingFrontQueue(int maxSize) {
		elements = (T[]) new Object[maxSize];
		rear = maxSize - 1;
	}

	public boolean isEmpty() {
		return numElements == 0;
	}

	public boolean isFull() {
		return numElements == elements.length;
	}

	public int size() {
		return numElements;
	}

	public void enqueue(T element) {
		if (isFull()) {
			throw new QueueOverflowException("the queue is full");
		}
		rear = (rear + 1) % elements.length;
		elements[rear] = element;
		numElements++;
	}

	public T dequeue() {
		if (isEmpty()) {
			throw new QueueUnderflowException("the queue is empty");
		}
		T toReturn = elements[front];
		elements[front] = null;
		front = (front + 1) % elements.length;
		numElements--;
		return toReturn;

	}

}
