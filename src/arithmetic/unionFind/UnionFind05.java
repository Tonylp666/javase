package arithmetic.unionFind;

import java.util.Arrays;

/**
 * 路径压缩就是处理并查集中的深的结点。实现方法很简单，
 * 就是在find函数里加上一句 parent[element] = parent[parent[element]];
 * 就好了，就是让当前结点指向自己父亲的父亲，减少深度，同时还没有改变根结点的weight(非根节点的weight改变了无所谓)。
 * 注：只能在基于重量的并查集上改find函数，而不能在基于高度的并查集上采用这种路径压缩。因为路径压缩后根的重量不变，但高度会变，然而高度改变后又不方便重新计算。
 */

public class UnionFind05 {

    // 数组，表示所有的元素
    private int[] parent;
    private int[] weight;

    //并查集的元素个数
    private int size;

    //构造一个并查集,初始化元素个数以及初始化数组
    public UnionFind05(int size){
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
            parent[element] = parent[parent[element]];
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
        UnionFind05 union = new UnionFind05(n);
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
