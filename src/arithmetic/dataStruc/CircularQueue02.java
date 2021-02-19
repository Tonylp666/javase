package arithmetic.dataStruc;

/**
 * @author liping
 * @description 使用数组实现 环形队列，需要支持：
 *  add(E e); offer(E e); remove(); poll(); peek(); element();isEmpty();
 */
public class CircularQueue02 {
    private int[] arr ;
    private int front ;// 队头指针
    private int rear ;// 队尾指针
    private int maxSize = 0;
    private int index = 0;
    private int count = 0;

    public CircularQueue02(int maxSize) {
        this.arr = new int[maxSize];
        this.maxSize = maxSize;
    }

    // 不指定大小时，队列初始大小设为 16
    public CircularQueue02() {
        this.arr = new int[16];
        this.maxSize = 16;
    }

    void add(int e){
        if (isFull()){
            throw new RuntimeException(" The CircularQueue is full Exception.");
        }
        arr[rear] = e;
        count++;
        rear = (rear) % maxSize;
    }

    // 移除并返回
    int remove(){
        if (isEmpty()){
            throw new RuntimeException(" The CircularQueue is empty Exception.");
        }
        int res = arr[front];
        front = (front) % maxSize;
        count--;
        return res;
    }

    int peek(){
        if (isEmpty()){
            throw new RuntimeException(" The CircularQueue is empty Exception.");
        }
        return arr[front];
    }

    boolean isEmpty(){
        return count == 0;
    }

    boolean isFull(){
        return count == maxSize;
    }

    public static void main(String[] args) {
        CircularQueue02 cq = new CircularQueue02(5);
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
