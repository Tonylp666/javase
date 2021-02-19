package concurrent.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalDemo {
    public static void main(String[] args) {

        ThreadLocal<Person> threadLocal01 = new ThreadLocal<>();//每个线程局部变量都需要创建一个ThreadLocal对象
        ThreadLocal<String> threadLocal02 = new ThreadLocal<>();
        AtomicInteger atomicInteger = new AtomicInteger(1000);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                Person person = new Person();
                person.setCardId(atomicInteger.getAndIncrement());
                person.setName(Thread.currentThread().getName());
                threadLocal01.set(person);
                threadLocal02.set("hahahaha");

                System.out.println(threadLocal01.get());
                System.out.println(threadLocal02.get());
                System.out.println();
                threadLocal01.remove();
            }).start();
        }

/*        executorService.submit(()->{
            Person person = new Person();
            person.setCardId(atomicInteger.getAndIncrement());
            person.setName(Thread.currentThread().getName());
            threadLocal01.set(person);
            threadLocal02.set("hahahaha");

            System.out.println(threadLocal01.get());
            System.out.println(threadLocal02.get());
            System.out.println();
            threadLocal01.remove();
        });*/
        executorService.shutdown();

    }


}
class Person {
    private int cardId;
    private     String name;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "cardId=" + cardId +
                ", name='" + name + '\'' +
                '}';
    }
}