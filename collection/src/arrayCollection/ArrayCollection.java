package arrayCollection;

public class ArrayCollection<T> implements CollectionInterface<T> {
	protected final int DEFCAP=100;
	protected T[] elements;
	protected int numElements=0;
	
	
	protected boolean found;
	protected int location;
	public ArrayCollection() {
		elements= (T[]) new Object[DEFCAP];
	}
	public ArrayCollection(int capacity) {
		elements= (T[]) new Object[capacity];
	}
	public boolean isFull() {
		return elements.length==numElements;
	}
	public boolean isEmpty() {
		return numElements==0;
	}
	public int size() {
		return numElements;
	}
	public boolean add(T element) {
		if(isFull()) {
			return false;
		}
		else {
			elements[numElements]=element;
			numElements++;
			return true;
		}
	}
	protected void find(T target) {
		location=0;
		found=false;
		while(location<numElements) {
			if(elements[location].equals(target)) {
				found=true;
				return;
			}
			else {
				location++;
			}
		}
	}
	public boolean remove(T target) {
		find(target);
		if(found) {
			elements[location]=elements[numElements-1];
			elements[numElements-1]=null;
			numElements--;
			
			
		}
		return found;
	}
	public boolean contains(T target) {
		find(target);
		return found;
	}
	public T get(T target) {
		find(target);
		if(found) {
			return elements[location];
		}
		else {
			return null;
		}
		
	}

}
