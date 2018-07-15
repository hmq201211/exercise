package test;

class Fu {
    int num = 9;

    {
        System.out.println("test.Fu");
    }

    Fu() {
        show();
    }

    void show() {
        System.out.println("test.Fu show run" + num);
    }
    void function() throws IndexOutOfBoundsException{
        System.out.println("hhhhhhh");
    }
}

class Zi extends Fu {
    int num = 8;

    {
        System.out.println("test.Zi");
        show();
        num = 10;
        show();
    }

    Zi() {
        num = 11;
        show();

    }

    void show() {
        System.out.println("test.Zi show run" + num);
    }
    void function(){
        System.out.println("hhhhhh123");
    }

}


public class NewZiDemo {
    public static void main(String[] args) {
        Fu f = new Zi();
        System.out.println(f.num);
        f.function();
    }

}
