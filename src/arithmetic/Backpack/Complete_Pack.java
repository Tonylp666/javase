package arithmetic.Backpack;

//完全背包，物品件数不限
public class Complete_Pack {
    private int[] weight ;
    private int[] value ;
    private int totalLoad;

    int[][] W ;

    public Complete_Pack(int[] weight, int[] value, int totalLoad) {
        this.weight = weight;
        this.value = value;
        this.totalLoad = totalLoad;
        W = new int[weight.length+1][totalLoad+1];
        W[0][0] = 0;
    }

    public int getMaxValue(){
        for (int i = 1; i <= weight.length; i++) {
            for (int j = 0; j < totalLoad+1; j++) {
                //W[i][j] = W[i-1][j];
                W[i][j] = Math.max(W[i-1][j],W[i-1][j-weight[i]] + value[i]);
            }
        }
        return W[weight.length][totalLoad];
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,5,7,8,9,5,7,3,1,6,4, 1, 3, 5, 7,9, 6,7,12,11,13,10,9,6,4};
        int[] value =   {1,3,3,5,8,4,5,5,7,8,9,5,7,3,12,5,13,10,9,60,1,3,5,7,20,18,19,3,5,2};
        Complete_Pack complete_pack = new Complete_Pack(weights, value, 20);
        System.out.println(complete_pack.getMaxValue());
    }

}
