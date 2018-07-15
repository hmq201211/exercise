package lockDemo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource{
    private String name;
    private int count;
    private boolean has;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public  void set(String name){
        lock.lock();
        try {
            while(has)
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            this.name = name + count++;
            System.out.println("new "+Thread.currentThread().getName() +"  produced    "+ this.name+"+++++++++++");
            has = true;
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }
    public   void out(){
        lock.lock();
        try {
            while (!has)
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            System.out.println("new "+Thread.currentThread().getName() +"  consumed    "+this.name+"-----------");
            has = false;
            condition.signalAll();
        }finally {
            lock.unlock();
        }

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

public class LockDemo1 {
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
