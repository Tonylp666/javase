package concurrent.atomic;

public class ReorderingDemo {

    static int x= 0,y = 0,a = 0,b = 0;

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            x=y=a=b=0;
            Thread thread01 = new Thread(() -> {
                a = 1;
                x = b;
            });

            Thread thread02 = new Thread(() -> {
                b = 1;
                y = a;
            });

            thread01.start();
            thread02.start();
            thread01.join();
            thread02.join();
            System.out.println(x + "\t" + y);
        }
    }
}
