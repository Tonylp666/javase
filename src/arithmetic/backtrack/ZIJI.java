package arithmetic.backtrack;

import java.util.ArrayList;
import java.util.List;

public class ZIJI {
    // 子集
    public static void main(String[] args) {
        ZIJI ziji = new ZIJI();
        int[] arr = {1,2,3};
        List<List<Integer>> lists = ziji.subSets(arr);
        System.out.println(lists);
    }
    public List<List<Integer>> subSets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> iterm = new ArrayList<>();
        backTrace(nums,0,res,iterm);
        return res;
    }

    public void backTrace(int[] nums, int start, List<List<Integer>> res, ArrayList<Integer> iterm){
        res.add(new ArrayList<>(iterm));
        for (int i = start; i < nums.length; i++) {
            iterm.add(nums[i]);
            //System.out.println("i = "+i+"\t"+res);
            backTrace(nums, i+1, res, iterm);
            iterm.remove(iterm.size()-1);
        }

    }
}
