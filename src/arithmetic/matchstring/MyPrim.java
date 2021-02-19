package arithmetic.matchstring;

import java.util.*;
/**
 * @author liping
 * @description 最小生成树，加边法
 */
public class MyPrim {
    List<int[]> res = new ArrayList<>();
    public static void main(String[] args) {
        MyPrim myPrim = new MyPrim();
        int[][] points = {{1,6},{2,2},{3,5},{4,8},{5,9}};
        int[][] graph = myPrim.buildGraph(points);
        Arrays.sort(graph, Comparator.comparingInt(o -> o[2]));
        for (int[] ints : graph) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("=======================================");
        int mincost = myPrim.prim(graph);
        for (int[] re : myPrim.res) {
            System.out.println(Arrays.toString(re));
        }
        System.out.println(" 最小成本： " +mincost);
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

    // 加点
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

}
