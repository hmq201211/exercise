package test;

public class ExceptionTest {
	public static void main(String[] args) {
		int[] i = new int[3];
	new ExceptionTest().	demo(i,-100);
		
	}
	public void demo(int[] i,int index)  {
		if(index<0) {
			throw new NullPointerException("123");
		}
	}
}
