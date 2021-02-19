package test;

import java.util.*;

public class SomeLittleDemo {
    public static void main(String[] args) {
//        boolean isSafe = false;
//
////        assert isSafe;
//        assert isSafe : "isSafe == false.";
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa");

//        System.out.println("start.");
//        assert true;
//        System.out.println("go on.");
//        assert false:"stop";
//        System.out.println("end.");


//        System.out.println(1 << 14);

        Map<String, String> map = new HashMap<>();
        String put0 = map.put("aaa", "abc");
        System.out.println(put0);

        String put1 = map.put("aaa", "bcd");
        System.out.println(put1);
        map.put("aaa", "bcd");
        map.put("bbb", "bcd");
        map.put("ccc", "bcd");
        HashMap<String, String> newmap = new HashMap<>(map);
        newmap.put("ddd", "bcd");
        newmap.put("eee", "bcd");
        System.out.println("=============================================");

        for (String key : newmap.keySet()) {
            System.out.println("key: " + key + "\t value: " +map.get(key));
        }
        System.out.println("=============================================");

        map = Collections.unmodifiableMap(newmap);

        for (String key : map.keySet()) {
            System.out.println("key: " + key + "\t value: " +map.get(key));
        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        //检查左对角线
        for (int k = 2 - 1, m = 3 - 1; k >= 0 && m >= 0; k--, m--) {
            System.out.println(k + "\t" +m);
        }

        //检查右对角线
        for (int k = 2 - 1, m = 3 + 1; k >= 0 && m <= 7; k--, m++) {
            System.out.println(k + "\t" +m);
        }


        System.out.println("=============================");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        System.out.println(list);

    }
}
