package concurrent.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;


public class LivelockExample {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        LivelockExample livelock = new LivelockExample();
        new Thread(()-> {
            try {
                livelock.operation1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();
        new Thread(()-> {
            try {
                livelock.operation2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();
    }

    public void operation1() throws InterruptedException {
        while (true) {
            tryLock(lock1, 5);
            print("lock1 acquired, trying to acquire lock2.");
            sleep(50);

            if (tryLock(lock2)) {
                print("lock2 acquired.");
            } else {
                print("cannot acquire lock2, releasing lock1.");
                lock1.unlock();
                continue;
            }

            print("executing first operation.");
            break;
        }
        lock2.unlock();
        lock1.unlock();
    }

    private void print(String s) {
        System.out.println(s);
    }

    private boolean tryLock(Lock lock, int time) throws InterruptedException {
        return lock.tryLock(time, TimeUnit.SECONDS);
    }

    public void operation2() throws InterruptedException {
        while (true) {
            tryLock(lock2, 10);
            print("lock2 acquired, trying to acquire lock1.");
            sleep(50);

            if (tryLock(lock1)) {
                print("lock1 acquired.");
            } else {
                print("cannot acquire lock1, releasing lock2.");
                lock2.unlock();
                continue;
            }

            print("executing second operation.");
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }

    private boolean tryLock(Lock lock) {
        return lock.tryLock();
    }
}
