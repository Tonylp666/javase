package concurrent.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class StampedlockDemo {
    private static final StampedLock lock = new StampedLock();
    final static List<Long> list = new ArrayList<Long>();
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //写任务
        Runnable writeTask = new Runnable(){
            @Override
            public void run() {
                while (true){
                    write();
                }
            }
        };

        //读任务
        Runnable readTask = new Runnable(){

            @Override
            public void run() {
                while(true){
                    read();
                }
            }
        };
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(writeTask);

    }

    public static void write() {
        long stamped = -1;
        try {
            //获取写锁
            stamped = lock.writeLock();
            long current = System.currentTimeMillis();
            list.add(current);
            System.out.println("W-> "+current);
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放写锁
            lock.unlockWrite(stamped);
        }
    }

    public static void read(){
        //获取乐观锁，并返回stamp值，该方法不会使writeLock阻塞
        long stamp = lock.tryOptimisticRead();
        System.out.println("normal R-> "+stamp+"=="+list.size());

        //判断stamp值是否发生变化
        if (!lock.validate(stamp)){

            try{
                stamp = lock.readLock();
                System.out.println("data change R-> "+stamp+"=="+list.size());
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
                lock.unlockRead(stamp);
            }
        }
    }
}
