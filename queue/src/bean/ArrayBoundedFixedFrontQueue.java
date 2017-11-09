package bean;

public class ArrayBoundedFixedFrontQueue<T> implements QueueInterface<T> {
	protected final int DEFCAP = 100;
	protected T[] elements;
	protected int numElements = 0;
	protected int front = 0;
	protected int rear = -1;

	public ArrayBoundedFixedFrontQueue() {
		elements = (T[]) new Object[DEFCAP];

	}

	public ArrayBoundedFixedFrontQueue(int maxSize) {
		elements = (T[]) new Object[maxSize];

	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		// TODO Auto-generated method stub
		rear = rear + 1;
		elements[rear] = element;

		numElements++;

	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new QueueUnderflowException("the queue is empty");
		}
		T toReturn = elements[front];
		numElements--;
		if (isEmpty()) {
			elements[front] = null;
		} else
			rellocate();
		rear--;

		return toReturn;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return numElements == elements.length;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numElements == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numElements;
	}

	private void rellocate() {
		for (int i = 1, j = 0; i <= rear; i++, j++) {
			elements[j] = elements[i];
		}
		elements[rear] = null;
	}
	
	

}
