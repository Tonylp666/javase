package concurrent.atomic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class DeadlockExample {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) throws InterruptedException {
        DeadlockExample deadlock = new DeadlockExample();
        new Thread(()-> {
            try {
                deadlock.operation1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();
        new Thread(()-> {
            try {
                deadlock.operation2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();
    }

    public void operation1() throws InterruptedException {
        lock1.lock();
        print("lock1 acquired, waiting to acquire lock2.");
        sleep(50);

        lock2.lock();
        print("lock2 acquired");

        print("executing first operation.");

        lock2.unlock();
        lock1.unlock();
    }

    private void print(String s) {
        System.out.println(s);
    }

    public void operation2() throws InterruptedException {
        lock2.lock();
        print("lock2 acquired, waiting to acquire lock1.");
        sleep(50);

        lock1.lock();
        print("lock1 acquired");

        print("executing second operation.");

        lock1.unlock();
        lock2.unlock();
    }
}
