package test;

import java.util.Collection;
import java.util.Iterator;

public class Test {
	private <W> void p(Collection<W> c) {
		Iterator<W> it= c.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	private void b(Collection<?> c){
		Iterator<?> it= c.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	private <T extends Person>void c(Collection<T> c){
		Iterator<T> it= c.iterator();
		while(it.hasNext()) {
			Person p= it.next();
			System.out.println(p);
		}
	}


}
class  Employee extends Person{
	
}
class  Student extends Person{
	
}
class Person{
	
}
