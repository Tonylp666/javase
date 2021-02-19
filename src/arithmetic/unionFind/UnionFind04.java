package arithmetic.unionFind;

import java.util.Arrays;

/**
 * 上面介绍的是，当两个集合合并时，谁的重量大，谁就来当合并之后的根。是比以前好多了。但还是有并查集深度太深的问题。并查集越深，就越接近线性，find函数就越接近O(n)
 * 所以有了这种基于高度的union。合并时，谁的深度深，谁就是新的根。这样集合的深度最多是最大深度的集合的深度，而不会让深度增加。
 * 比如上面的例子中，元素2的深度是2，元素6的深度是3，按基于重量的union合并后，新的集合深度是4。
 */

public class UnionFind04 {

    // 数组，表示所有的元素
    private int[] parent;
    private int[] height;

    //并查集的元素个数
    private int size;

    //构造一个并查集,初始化元素个数以及初始化数组
    public UnionFind04(int size){
        parent = new int[size];
        height = new int[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            height[i] = 1;
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

        if (height[firstRoot] < height[secondRoot]){
            parent[firstRoot] = secondRoot;
        }else  if (height[firstRoot] > height[secondRoot]){
            parent[secondRoot] = firstRoot;
        }else {
            parent[firstRoot] = secondRoot;
            height[secondRoot] +=1;
        }
    }

    public void printArr(){
        System.out.println("parent: " +Arrays.toString(parent));
        System.out.println("height: " +Arrays.toString(height));
    }

    public static void main(String[] args) {
        int n = 10;
        UnionFind04 union = new UnionFind04(n);
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
