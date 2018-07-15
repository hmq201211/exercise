package test;

public class Single {
    private static Single s =  new Single();
    private Single(){}
    public static Single getSingle(){
        return s;
    }

    public static void main(String[] args) {
        System.out.println(Single2.getSingle2());
    }
}
class Single2{
    private static Single2 s =null;
    private  Single2(){}
    public static Single2 getSingle2(){
        if(s==null){
            s=new Single2();
        }
        return s;
    }
}