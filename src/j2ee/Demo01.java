package j2ee;

public class Demo01 {
    static{
        System.out.println("This is class Test static....");
    }
    static A demo01 = new A();


    {
        System.out.println("This is class Test constructor code....");
    }
    public static void main(String[] args) {
//        System.out.println(S.abc);
        S.sayHello();
    }
}
 class P {
    public static int abc = 10;
     {
         System.out.println("This is class P constructor code....");
     }
    static {
        System.out.println("This is class P static code 。。。");
    }
    static void sayHello(){
        System.out.println("Class p sayHello...");
    }
}

class S extends P {
    public static int abc = 15;
    {
        System.out.println("This is class S constructor code....");
    }
    static{
        System.out.println("This is class S static code 。。。");
    }
//    static void sayHello(){
//        System.out.println("Class S sayHello...");
//    }
}

class A {
    {
        System.out.println("This is class A constructor code....");
    }
    static{
        System.out.println("This is class A static code。。。");
    }
}
