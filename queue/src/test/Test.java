package test;

import bean.ArrayBoundedFixedFrontQueue;

public class Test {
	public static void main(String[] args) {
		ArrayBoundedFixedFrontQueue<Integer> a = new ArrayBoundedFixedFrontQueue<Integer>();
		a.enqueue(1);
		a.enqueue(2);
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
		

		
	}

}
