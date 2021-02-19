package j2ee;

public class Demo02 {
    static Class[] classArray = {
      MyClass.class
    };

    public static void main(String[] args) {
        System.out.println("Hello ...");

    }

}
class MyClass{
    static {
        System.out.println("This is MyClass static code....");
    }
}
