package bean;

public class ArrayBoundedStack<T> implements StackInterface<T> {
	protected final int DEFCAP = 100;
	protected T[] elements;
	protected int topIndex=-1;

	public ArrayBoundedStack() {
		elements = (T[]) new Object[DEFCAP];
	}
	
	public ArrayBoundedStack(int i) {
		elements = (T[]) new Object[i];
		
	}

	@Override
	public void push(T element)  {
		if(isFull()) {
			throw new StackOverflowException("the stack is full");
		}
		
		elements[++topIndex]=element;

	}

	@Override
	public void pop(){
		if(isEmpty()) {
			throw new StackUnderflowException("the stack is empty");
		}
		elements[topIndex--]=null;
	

	}

	@Override
	public T top() throws StackUnderflowException {
		if(isEmpty()) {
			throw new StackUnderflowException("the stack is empty");
		}
		return elements[topIndex];
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return topIndex==elements.length-1;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return topIndex==-1;
	}

}
