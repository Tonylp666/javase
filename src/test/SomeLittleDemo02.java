package test;

import java.util.ArrayDeque;
import java.util.Deque;

public class SomeLittleDemo02 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
//        System.out.println(deque.peekFirst());
//        System.out.println(deque.pollFirst());

//        System.out.println(1/2);
        int i = 6,j = 3;
        for (int l = 0; l < 3; l++) {
            for (int m = 0; m < 3; m++) {
//                if (chess[i - l % 3][j - m % 3] == k) return false;
//                System.out.println("i - l % 3 " + (i - l % 3) + "\t j - m % 3 "+(j - m % 3));
                System.out.print( "["+(l +  ( i / 3) * 3) + ", "+(m +   (j / 3) * 3) + "]\t ");
            }
            System.out.println();
        }
    }
}
