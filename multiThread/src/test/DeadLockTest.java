package test;

class Test implements Runnable {
    private boolean flag;

    Test(boolean flag) {
        this.flag = flag;
    }

    public void run() {
        if (flag) {
            synchronized (MyLock.lockA) {
                System.out.println("if    lockA....");
                synchronized (MyLock.lockB) {
                    System.out.println("if    lockB....");
                }
            }
        } else {
            synchronized (MyLock.lockB) {
                System.out.println("else    lockB....");
                synchronized (MyLock.lockA) {
                    System.out.println("else    lockA....");
                }
            }
        }
    }
}

class MyLock {
    public static final Object lockA = new Object();
    public static final Object lockB = new Object();

}

public class DeadLockTest {
    public static void main(String[] args) {
        Test t1 = new Test(true);
        Test t2 = new Test(false);
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
    }
}
