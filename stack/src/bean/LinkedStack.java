package bean;

public class LinkedStack<T> implements StackInterface<T> {
    private LLNode<T> top;
	public LinkedStack() {
		top=null;
	}
     @Override
	public void push(T element)  {
		// TODO Auto-generated method stub
		LLNode<T> newNode= new LLNode<T>(element);
		newNode.setLink(top);
		top= newNode;
				
	}

	@Override
	public void pop() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new StackUnderflowException("the stack is empty");
		}
		top= top.getLink();
	}

	@Override
	public T top() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new StackUnderflowException("the stack is empty");
		}
		return top.getElement();
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top==null;
	}

}
