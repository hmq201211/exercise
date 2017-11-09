package test;

class Fu{
	int num=9;
	{
		System.out.println("test.Fu");
	}
	Fu(){
		show();
	}
	void show() {
		System.out.println("test.Fu show run"+num);
	}
}
class Zi extends Fu{
	int num=8;
	{
		System.out.println("test.Zi");
		show();
		num=10;	
		show();
	}
	Zi(){
		num=11;
		show();
		
	}
	void show() {
		System.out.println("test.Zi show run"+num);
	}
}


public class NewZiDemo {
	public static void main(String[] args) {
		Fu f=new Zi();
		System.out.println(f.num);
	}

}
