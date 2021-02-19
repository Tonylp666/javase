package concurrent.atomic;

public class SynchronizedTest02 {
    long value = 0l;

    long get(){
        return value;
    }

    synchronized void add(){
        value += 1;
    }
}
