package test;


public class InnerClassDemo {
	 static class Inner {
		private static  int i=3;
		static void show() {
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		Inner.show();;
	}
	void method() {
		new Inner();
	}

}
