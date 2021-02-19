package arithmetic.matchstring;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author liping
 * @description 最小生成树，加边法
 */
public class Kruskal {
    List<int[]> res = new ArrayList<>();
    public static void main(String[] args) {
        Kruskal myKruskal = new Kruskal();
        int[][] points = new int[10000][2];
        for (int i = 0; i < points.length; i++) {
            points[i][0] = i+1;
            points[i][1] = new Random().nextInt(10000) + 10;
        }
        int[][] graph = myKruskal.buildGraph(points);
        Arrays.sort(graph, Comparator.comparingInt(o -> o[2]));
/*        for (int[] ints : graph) {
            System.out.println(Arrays.toString(ints));
        }*/
        System.out.println("=======================================");
        long start = System.currentTimeMillis();
        int mincost = myKruskal.kruskal(graph);
        long middle = System.currentTimeMillis();
        int prim = myKruskal.prim(graph);
        long end = System.currentTimeMillis();
/*        for (int[] re : myKruskal.res) {
            System.out.println(Arrays.toString(re));
        }*/

        System.out.println("Kruskal 耗时: " +(middle - start));
        System.out.println("prim 耗时: " +(end - middle));
        System.out.println("Kruskal 最小成本： " +mincost);
        System.out.println("prim 最小成本： " +prim);
    }
    public int prim(int[][] graph){
        int minCost = 0;
        Set<Integer> set = new HashSet<>();
        if (graph.length >0){
            set.add(graph[0][0]);
            set.add(graph[0][1]);
            res.add(graph[0]);
            minCost += graph[0][2];
        }

        for (int i = 0; i < graph.length; i++) {
            if ((set.contains(graph[i][0]) && !set.contains(graph[i][1]))
                    || (!set.contains(graph[i][0]) && set.contains(graph[i][1]))){
                set.add(graph[i][0]);
                set.add(graph[i][1]);
                res.add(graph[i]);
                minCost += graph[i][2];
                i = 0;
            }
        }
        return minCost;
    }

    private int kruskal(int[][] graph) {
        int minCost = 0;
        UnionFind uf = new UnionFind(20000 );
        for (int i = 0; i < graph.length; i++) {
            if (!uf.isConnected(graph[i][0],graph[i][1])){
                uf.unionElements(graph[i][0],graph[i][1]);
                minCost += graph[i][2];
                res.add(graph[i]);
            }
        }
        return minCost;
    }

    /**
     * @param points 点 以及点 的权重 例如：[2,5] ：点:2,权重 5
     * @return int[][][] 边及其权重  例如：[2,3,4] : 点 2 到 点 3 之间的成本，边的权重取点权重差的绝对值。
     */
    private int[][] buildGraph(int[][] points){
        int[][] graph = new int[points.length * (points.length - 1) /2][3];
        int index = 0;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] point01 = points[i];
                int[] point02 = points[j];
                graph[index][0] = point01[0];
                graph[index][1] = point02[0];
                graph[index][2] = Math.abs(point02[1] - point01[1]);
                index++;
            }
        }
        return graph;
    }


   class UnionFind {
        private int[] parent;

        private int size;

        public UnionFind(int size) {
            parent = new int[size];
            this.size = size;
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int element) {
            while (element != parent[element]) {
                parent[element] = parent[parent[element]];
                element = parent[element];
            }
            return element;
        }

        public boolean isConnected(int firstElementr, int secondElement) {
            return find(firstElementr) == find(secondElement);
        }

        public void unionElements(int firstElement, int secondElement) {

            int firstRoot = find(firstElement);
            int secondRoot = find(secondElement);

            if (firstRoot == secondRoot) {
                return;
            }
            parent[firstRoot] = secondRoot;
        }
    }
}
