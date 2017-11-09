package arrayCollection;

public class SortedArrayCollection<T> implements CollectionInterface<T> {
	protected final int DEFCAP = 100;
	protected T[] elements;
	protected int numElements = 0;

	protected boolean found;
	protected int location;
	

	public SortedArrayCollection() {
		elements = (T[]) new Object[DEFCAP];
	}

	public SortedArrayCollection(int capacity) {
		elements = (T[]) new Object[capacity];
	}

	public boolean isFull() {
		return false;
	}

	public boolean isEmpty() {
		return numElements == 0;
	}

	public int size() {
		return numElements;
	}

	public boolean add(T element) {
		if (numElements == elements.length) {
			enlarge();
		}
		findPosition(element);
		for (int i = numElements - 1, j = i + 1; i >= location; i--, j--) {
			swap(elements, i, j);
		}
		elements[location] = element;
		numElements++;
		return true;
	}

	public boolean contains(T target) {
		find(target);
		return found;
	}

	public T get(T target) {
		find(target);
		if (found) {
			return elements[location];
		} else {
			return null;
		}

	}

	public boolean remove(T target) {
		find(target);
		if (found) {

			for (int i = location + 1, j = i - 1; i < numElements; i++, j++) {
				swap(elements, i, j);
			}

			numElements--;

		}
		return found;
	}

	protected void enlarge() {
		T[] newElements = (T[]) new Object[2 * elements.length];
		int index = 0;
		for (T t : elements) {
			newElements[index++] = t;
		}
		elements = newElements;
	}

	protected void findPosition(T target) {
		find(target);
		if (elements[location] == null)
			;
		else {
			if (((Comparable<T>) elements[location]).compareTo(target) > 0)
				;
			else {
				location = location + 1;
			}
		}
	}

	protected void find(T target) {
		location = 0;
		found = false;
		int head = 0;
		int tail = numElements - 1;
		int mid = (head + tail) / 2;
		while (head <= tail) {
			if (((Comparable<T>) elements[mid]).compareTo(target) == 0) {
				found = true;
				break;
			} else {
				if (((Comparable<T>) elements[mid]).compareTo(target) > 0) {
					tail = mid - 1;
				} else {
					head = mid + 1;
				}
				mid = (head + tail) / 2;
			}
		}
		location = mid;
	}

	protected void swap(T[] t, int i, int j) {
		T temp = t[i];
		t[i] = t[j];
		t[j] = temp;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i <= numElements - 1; i++) {
			sb.append(elements[i]);
			sb.append("\n");
		}
		return sb.toString();
	}

}