package arithmetic.backtrack;

import java.util.ArrayList;
import java.util.List;
/**
 * @author liping
 * @Date 2021.02.01
 * @description 回溯解决组合问题
 */
public class ZuHe {
    public static void main(String[] args) {
        ZuHe zuhe = new ZuHe();
        System.out.println(zuhe.combination(new int[]{1,2,3,4},4));
        System.out.println("=============================");
        System.out.println(zuhe.combination00(new int[]{1,2,3,4},4));
        System.out.println("=============================");
        System.out.println("count: "+zuhe.calCount);
        System.out.println("count00: "+zuhe.calCount00);
    }
    int calCount = 0;
    int calCount00 = 0;

    public List<List<Integer>> combination(int[] nums,int k){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        backTrace(nums,0,res,item,k);
        return res;
    }

    public List<List<Integer>> combination00(int[] nums,int k){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        backTrace00(nums,0,res,item,k);
        return res;
    }

    private void backTrace(int[] nums, int index, List<List<Integer>> res, List<Integer> item,int k) {

        if (item.size() == k) res.add(new ArrayList<>(item));

        for (int i = index; i < nums.length  ; i++) {
                calCount++;
            item.add(nums[i] );
            //System.out.println(item);
            backTrace(nums, i+1, res, item,k);
            item.remove(item.size()-1);
        }
    }

        private void backTrace00(int[] nums, int index, List<List<Integer>> res, List<Integer> item,int k) {

            if (item.size() == k) res.add(new ArrayList<>(item));
            // 如果for循环选择的起始位置之后的元素个数 已经不⾜ 我们需要的元素个数了，那么就没有必要搜索了。
            // 已经选择：item.size
            // 需要选择：k - item.size
            // i 起始位置最小为：　nums.length - (k -  item.size())
            for (int i = index; i < nums.length && i <= nums.length - (k -  item.size())  ; i++) {
                    calCount00++;
                    item.add(nums[i] );
                    System.out.println(item);
                    backTrace00(nums, i+1, res, item,k);
                    item.remove(item.size()-1);
                }
            }
}
