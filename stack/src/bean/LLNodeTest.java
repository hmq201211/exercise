package bean;

public class LLNodeTest {
	public static void main(String[] args) {
		
		LLNode<String> l = new LLNode<String>("123");
		l.setLink(new LLNode<String>("321"));
		recPrintList(l);
		iterPrintList(l);
		recRevPrintList(l);
		recInsertEnd("3211", l);
		recRevPrintList(l);
		iterRevPrintList(l);
//		t(l);
//		System.out.println(l.getLink().getElement());
		LLNode<String> l2= null;
		recInsertEnd("1233333",l2);
		System.out.println(l2);
		l2=recInsertEnd("1233333",l2);
		System.out.println(l2.getElement());

		
		
	}
	
	public static void changeValue(LLNode<String> l) {
		l= new LLNode<String>("haha");
	}

	public static void t(LLNode<String> ll) {
		if (ll == null) {
			ll = new LLNode<String>("123");
		}
		else
//			ll= new LLNode<String>("3222");
			ll.setLink(new LLNode<String>("233"));
	}

	public static void recPrintList(LLNode<String> l) {
		if(l!=null) {
			System.out.println(l.getElement());
			recPrintList(l.getLink());
		}
	}
	public static void iterPrintList(LLNode<String> l) {
		while(l!=null) {
			System.out.println(l.getElement());
			l=l.getLink();
		}
	}
	public static void recRevPrintList(LLNode<String> l) {
		if(l!=null) {
			recRevPrintList(l.getLink());
			System.out.println(l.getElement());
		}
		
	}
	public static void iterRevPrintList(LLNode<String> l) {
		ArrayListStack<String> als = new ArrayListStack<String>();
		while(l!=null) {
			als.push(l.getElement());
			l=l.getLink();
		}
		while(!als.isEmpty()) {
			System.out.println(als.top());
			als.pop();
		}
	}
	public static LLNode<String> recInsertEnd(String newInfo,LLNode<String> l) {
		if(l!=null) {
			l.setLink(recInsertEnd(newInfo, l.getLink()));
		}
		else
			l=new LLNode<String>(newInfo);
		return l;
	}
	

}
