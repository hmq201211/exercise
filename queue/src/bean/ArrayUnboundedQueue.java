package bean;

public class ArrayUnboundedQueue<T> implements QueueInterface<T> {
	protected final int DEFCAP=100;
	protected T[] elements;
	protected int origCap;
	protected int numElements=0;
	protected int front=0;
	protected int rear;
	public ArrayUnboundedQueue() {
		// TODO Auto-generated constructor stub
		elements=(T[]) new Object[DEFCAP];
		origCap= DEFCAP;
		rear=DEFCAP-1;
	}
	public ArrayUnboundedQueue(int origCap) {
		// TODO Auto-generated constructor stub
		elements=(T[]) new Object[origCap];
		this.origCap= origCap;
		rear=origCap-1;
	}
	public boolean isFull() {
		return false;
	}
	public boolean isEmpty() {
		return numElements==0;
	}
	public int size() {
		return numElements;				
	}
	public T dequeue() {
		if(isEmpty()) {
			throw new QueueUnderflowException("the queue is empty");
		}
		T toReturn =elements[front];
		elements[front]=null;
		front= (front+1)%elements.length;
		numElements--;
		return toReturn;
	}
	public void enqueue(T element) {
		if(numElements==elements.length) {
			enlarge();
		}
		rear= (rear+1)%elements.length;
		elements[rear]=element;
		numElements++;
		
	}
	private void enlarge() {
		T[] larger= (T[])new Object[elements.length+origCap];
		int currSmaller=front;
		for(int currLarger=0;currLarger<numElements;currLarger++) {
			larger[currLarger]=elements[currSmaller];
			currSmaller=(currSmaller+1)%elements.length;
		}
		elements= larger;
		front=0;
		rear=numElements-1;		
	}
	
	
	

}
