package arithmetic.matchstring;

import java.util.Arrays;

public class MyKMP {

    public int[] getNextArr(char[] t){
        int t_len = t.length;
        int[] next = new int[t_len];
        next[0] = -1;
        next[1] = 0;
        int k = 0;
        int j = 2;
        while (j < t_len - 1){
            if (k == -1){
                next[j++] = 0;
                k = 0;
            }
            if (t[k ] == t[j]){
                next[j++] = ++k;
            }else{
                k = next[k];
            }
        }

        return next;
    }

    public  int kmpMatch(String s, String t){
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        int[] next = getNextArr(t_arr);
        System.out.println(Arrays.toString(next));
        int i = 0, j = 0;
        while (i < s_arr.length && j < t_arr.length){
            if (j == -1 || s_arr[i] == t_arr[j]){
                j ++;
                i ++;
            }else {
                j = next[j];
            }
        }
        if (j == t_arr.length ) return i-j;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new MyKMP().kmpMatch("abcabaabaabcaaabcac", "baabaab"));
    }
}
