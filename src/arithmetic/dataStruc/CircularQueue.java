package arithmetic.dataStruc;

import java.util.List;
import java.util.Queue;

/**
 * @author liping
 * @description 使用数组实现 环形队列，需要支持：
 *  add(E e); offer(E e); remove(); poll(); peek(); element();isEmpty();
 */
public class CircularQueue {
    private int[] arr ;
    private int front ;// 队头指针
    private int rear ;// 队尾指针
    private int maxSize = 0;
    private int index = 0;

    public CircularQueue(int maxSize) {
        this.arr = new int[maxSize + 1];
        this.maxSize = maxSize + 1;
    }

    // 不指定大小时，队列初始大小设为 16
    public CircularQueue() {
        this.arr = new int[16];
        this.maxSize = 16;
    }

    void add(int e){
        if (isFull()){
            throw new RuntimeException(" The CircularQueue is full Exception.");
        }
        arr[rear] = e;
        rear = (rear + 1) % maxSize;
    }

    // 移除并返回
    int remove(){
        if (isEmpty()){
            throw new RuntimeException(" The CircularQueue is empty Exception.");
        }
        int res = arr[front];
        front = (front + 1) % maxSize;
        return res;
    }

    int peek(){
        if (isEmpty()){
            throw new RuntimeException(" The CircularQueue is empty Exception.");
        }
        return arr[front];
    }

    boolean isEmpty(){
        return front == rear;
    }

    boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue();
        cq.add(1);
        cq.add(2);
        cq.add(3);
        cq.add(4);
        System.out.println(cq.peek());
        System.out.println(cq.remove());
        cq.add(6);
        System.out.println(cq.peek());
        System.out.println(cq.remove());
        cq.add(5);
        System.out.println(cq.remove());
        cq.add(8);
        System.out.println(cq.peek());
        System.out.println(cq.remove());
        System.out.println(cq.remove());
        cq.add(7);
        cq.add(7);
        cq.add(7);
        cq.add(7);
        cq.add(7);
        cq.add(7);
        cq.add(7);
        cq.add(7);
        cq.add(7);
        cq.add(7);
        System.out.println(cq.remove());
        System.out.println(cq.remove());
        System.out.println(cq.remove());
        System.out.println(cq.remove());
    }

}
