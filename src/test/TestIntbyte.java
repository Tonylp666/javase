package test;

import java.io.IOException;

public class TestIntbyte {
    public static void main(String[] args) {
//        int2bytes(600);
        System.out.println(impl("BEST_COMPRESSION"));
        System.out.println(impl02("BEST_COMPRESSION"));
        System.out.println(impl03("BEST_COMPRESSION"));
    }
    private static void int2bytes(int value)  {
        System.out.println(((byte)((value >>> 24) & 0xff)));
        System.out.println(((byte)((value >>> 16) & 0xff)));
        System.out.println(((byte)((value >>>  8) & 0xff)));
        System.out.println(((byte)((value >>>  0) & 0xff)));
    }

    static String impl(String mode) {
        switch (mode) {
            case "BEST_SPEED":
                return "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
            case "BEST_COMPRESSION":
                return "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
            case "DATABOX_COMPRESSION":
                return "cccccccccccccccccccccccccccccccccc";
            default:
                return "dddddddddddddddddddddddddddddddddd";
        }
    }

    static String impl02(String mode) {
        String res;
        switch (mode) {
            case "BEST_SPEED":
                res = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
                break;
            case "BEST_COMPRESSION":
                res = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
                break;
            case "DATABOX_COMPRESSION":
                res = "cccccccccccccccccccccccccccccccccc";
                break;
            default:
                res = "dddddddddddddddddddddddddddddddddd";
                break;

        }
        return res;
    }

    static String impl03(String mode) {
        String res;
        switch (mode) {
            case "BEST_SPEED":
                res = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
            case "BEST_COMPRESSION":
                res = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
            case "DATABOX_COMPRESSION":
                res = "cccccccccccccccccccccccccccccccccc";
            default:
                res = "dddddddddddddddddddddddddddddddddd";
        }
        return res;
    }
}
