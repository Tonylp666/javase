package arithmetic.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liping
 * @Date 2021.02.01
 * @description 回溯解决排列问题
 */
public class PaiLie {
    public static void main(String[] args) {
        PaiLie paiLie = new PaiLie();
        System.out.println(paiLie.permutation(new int[]{1,2,3,4}));
    }

    public List<List<Integer>> permutation(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        backTrace(nums,res,item,isUsed);
        return res;
    }

    private void backTrace(int[] nums, List<List<Integer>> res, List<Integer> item, boolean[] isUsed) {

        if (item.size() == nums.length) res.add(new ArrayList<>(item));
        for (int i = 0; i < nums.length; i++) {
            if (!isUsed[i]){
                item.add(nums[i]);
                isUsed[i] = true;
                backTrace(nums, res, item, isUsed);
                item.remove(item.size()-1);
                isUsed[i] = false;
            }
        }
    }
}
