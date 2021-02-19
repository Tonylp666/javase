package concurrent.threadpool;

/**
 *
 */

public class ThreadPoolDemo {

    public static void main(String[] args) {
         int COUNT_BITS = Integer.SIZE - 3;
         int CAPACITY   = (1 << COUNT_BITS) - 1;


         int RUNNING    = -1 << COUNT_BITS;
         int SHUTDOWN   =  0 << COUNT_BITS;
         int STOP       =  1 << COUNT_BITS;
         int TIDYING    =  2 << COUNT_BITS;
         int TERMINATED =  3 << COUNT_BITS;
        System.out.println(RUNNING);
        System.out.println(SHUTDOWN);
        System.out.println(STOP);
        System.out.println(TIDYING);
        System.out.println(TERMINATED);


    }
}
