package bean;

import java.util.ArrayList;

public class ArrayListStack<T> implements StackInterface<T> {
	private ArrayList<T> al;

	public ArrayListStack() {
		// TODO Auto-generated constructor stub
		al = new ArrayList<T>();
	}

	@Override
	public void push(T element) {
		// TODO Auto-generated method stub
		al.add(element);

	}

	@Override
	public void pop() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new StackUnderflowException("the stack is empty");
		}
		al.remove(al.size() - 1);

	}

	@Override
	public T top() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException("the stack is empty");
		}
		return al.get(al.size() - 1);
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return al.size() == 0;
	}

}
