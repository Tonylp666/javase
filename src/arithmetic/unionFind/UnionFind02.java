package arithmetic.unionFind;

import java.util.Arrays;

/**
 * 并查集是一种数据结构, 常用于描述集合,经常用于解决此类问题:
 *      某个元素是否属于某个集合,或者 某个元素 和 另一个元素是否同属于一个集合
 *
 *      使用数组实现并查集
 *
 *      UnionFind01中，合并操作太低效了，合并一次就O(n)。所以采用快速Union方式。
 */
public class UnionFind02 {
    // 数组，表示所有的元素
    private int[] parent;

    //并查集的元素个数
    private int size;

    //构造一个并查集,初始化元素个数以及初始化数组
    public UnionFind02(int size){
        parent = new int[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    /**
     * 查看元素属于那个集合，因为最顶层父元素的父元素是自己，
     * 因此从底层向顶层遍历，直到找到该子元素的最顶层父元素。
     *
     * @param element 要查找的元素
     * @return element 元素所在的集合
     */

    public int find(int element){
        while(element != parent[element]){
            element = parent[element];
        }
        return element;
    }


    /**
     * 判断两个元素是否属于同一个集合
     * @param firstElementr
     * @param secondElement
     * @return
     */
    public boolean isConnected(int firstElementr,int secondElement){
        return find(firstElementr) == find(secondElement);
    }

    /**
     * 合并两个元素所在的集合，也就是连接两个元素
     * @param firstElement
     * @param secondElement
     */
    public void unionElements(int firstElement,int secondElement ){

        int firstRoot = find(firstElement);
        int secondRoot  = find(secondElement);

        if (firstRoot == secondRoot){
            return;
        }
        parent[firstRoot] = secondRoot;
    }

    public void printArr(){
        System.out.println(Arrays.toString(parent));
    }

    public static void main(String[] args) {
        int n = 10;
        UnionFind02 union = new UnionFind02(n);
        System.out.println("初始：");
        union.printArr();

        System.out.println("连接了5 6");
        union.unionElements(5, 6);
        union.printArr();

        System.out.println("连接了1 2");
        union.unionElements(1, 2);
        union.printArr();

        System.out.println("连接了2 3");
        union.unionElements(2, 3);
        union.printArr();

        System.out.println("连接了1 4");
        union.unionElements(1, 4);
        union.printArr();

        System.out.println("连接了1 5");
        union.unionElements(1, 5);
        union.printArr();

        System.out.println("1  6 是否连接：" + union.isConnected(1, 6));

        System.out.println("1  8 是否连接：" + union.isConnected(1, 8));
    }

}
