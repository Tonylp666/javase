package arithmetic.miniSpanTree;

/**
 * Prim 在prim算法中，通过加入最小邻接边的方法来建立最小生成树算法。
 * 首先构造一个零图，在选一个初始顶点加入到新集合中，然后分别在原先的顶点集合中抽取一个顶点，
 * 使得构成的边为权值最小，然后将该笔边加入到图中，并将抽出的顶点加入到新集合中，重复这个过程，知道新集合等于原先的集合。
 */
public class Prim {

    public static void prim(int num, float[][] weight){//num 顶点数，weight 权重
        float[] lowcost = new float[num + 1]; //到新集合的最小权
        int[] closest = new int[num + 1];

        boolean[] s = new boolean[num + 1];// s[i] =true ,代表 i 点在 s 集合中

        s[1] = true;//将第一个点放入集合

        for (int i = 2; i <= num ; i++) {
            lowcost[i] = weight[i][i];
            closest[i] = 1;
            s[i] =false;
        }

        for(int i = 1; i < num; i++) {
            float min = Float.MAX_VALUE;
            int j = 1;
            for(int k = 2; k <= num; k++) {
                if((lowcost[k] < min) && (!s[k])) {//根据最小权加入新点
                    min = lowcost[k];
                    j = k;
                }
            }

            System.out.println("加入点" + j + ". " + j + "---" + closest[j]);//新加入点的j和与j相连的点

            s[j] = true;//加入新点j

            for(int k = 2; k <= num; k++) {
                if((weight[j][k] < lowcost[k]) && !s[k]) {//根据新加入的点j,求得最小权
                    lowcost[k] = weight[j][k];
                    closest[k] = j;
                }
            }
        }
    }

    public static void main(String[] args) {
        //              ①
        //            /  |  /
        //           6   1   5
        //          /    |    /
        //        ②-5--③--5--④
        //         /    //    /
        //          3  6  4  2
        //           //    //
        //           ⑤--6-⑥
        //最小生成树为：
        //              ①
        //               |
        //               1
        //               |
        //        ②-5--③        ④
        //         /     /    /
        //          3     4  2
        //           /     //
        //           ⑤        ⑥
        //
        float m = Float.MAX_VALUE;
        float[][] weight = {
                {0, 0, 0, 1, 0, 0, 0},
                {0, m, 6, 0, 5, m, m},
                {0, 6, m, 5, m, 3, m},
                {0, 1, 5, m, 5, 6, 4},
                {0, 5, m, 5, m, m, 2},
                {0, m, 3, 6, m, m, 6},
                {0, m, m, 4, 2, 6, m}
        };//上图的矩阵
        prim(weight.length - 1, weight);
        //加入点3. 3---1
        //加入点6. 6---3
        //加入点4. 4---6
        //加入点2. 2---3
        //加入点5. 5---2
    }
}
