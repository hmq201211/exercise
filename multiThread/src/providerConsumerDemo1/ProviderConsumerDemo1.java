package providerConsumerDemo1;

class Resource{
    private String name;
    private int count;
    private boolean has;
    public synchronized void set(String name){
        while(has)
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        this.name = name + count++;
        System.out.println(Thread.currentThread().getName() +"  produced    "+ this.name+"+++++++++++");
        has = true;
        notifyAll();
    }
    public synchronized  void out(){
        while (!has)
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println(Thread.currentThread().getName() +"  consumed    "+this.name+"-----------");
        has = false;
        notifyAll();
    }
}
class Provider implements Runnable{
Resource resource;

    public Provider(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true){
            resource.set("duck");
        }
    }
}
class Consumer implements Runnable{
    Resource resource;

    public Consumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while(true){
            resource.out();
        }
    }
}

public class ProviderConsumerDemo1 {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Provider provider = new Provider(resource);
        Consumer consumer = new Consumer(resource);
        Thread t0 = new Thread(provider,"provider0");
        Thread t1 = new Thread(provider,"provider1");
        Thread t2 = new Thread(consumer,"consumer0");
        Thread t3 = new Thread(consumer,"consumer1");
        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
