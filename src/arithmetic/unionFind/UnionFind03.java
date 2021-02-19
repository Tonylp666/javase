package arithmetic.unionFind;

import java.util.Arrays;

/**
 * 其实上面讲的union函数，没有采取合理的手段去进行合并。每次都以secondElement为主，每次合并两个集合都让secondElement的根来继续充当合并之后的根。这样很可能达到线性的链表的状态。
 * 那合并的时候怎么处理更好呢？
 * 比如：有下面两个集合。其中 2 和 6 是两个集合的根。下面要让这两个集合合并，但是，合并之后只能有一个老大啊，到底谁来当呢？
 * 在基于重量的union里，谁的人手多，就由谁来当合并之后的大哥。
 *
 *          2
 *         ***
 *        * * *
 *       *  *  *
 *      1   3   4
 *
 *
 *          6
 *           *
 *            5
 *
 *
 *          2
 *       * * * *
 *      *  *  *  *
 *     *   *   *   *
 *    1    3    4   6
 *                   *
 *                     *
 *                       5
 *
 *
 * 2元素有4个手下，再算上自己，那就是5个人。
 * 6元素有2个手下，再算上自己，那就是3个人。
 * 很明显是2元素的人手多，所以2来充当合并之后的根节点。
 */

public class UnionFind03 {

    // 数组，表示所有的元素
    private int[] parent;
    private int[] weight;

    //并查集的元素个数
    private int size;

    //构造一个并查集,初始化元素个数以及初始化数组
    public UnionFind03(int size){
        parent = new int[size];
        weight = new int[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            weight[i] = 1;
        }
    }

    /**
     * 查看元素属于那个集合
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

        if (weight[firstRoot] > weight[secondRoot]){
            parent[secondRoot] = firstRoot;
            weight[firstRoot] += weight[secondRoot];;
        }else {
            parent[firstRoot] = secondRoot;
            weight[secondRoot] += weight[firstRoot];;
        }
    }

    public void printArr(){
        System.out.println("parent: " +Arrays.toString(parent));
        System.out.println("weight: " +Arrays.toString(weight));
    }

    public static void main(String[] args) {
        int n = 10;
        UnionFind03 union = new UnionFind03(n);
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
