package j2ee.innerclass;

public class HelloWorldAnonymousClasses {

    interface HelloWorld{
        void greet();
        void greetSomeone(String someone);
    }
    public void sayHello(){

        //1、 局部类 EnglishGreeting 实现了 HelloWorld 接口
        class EnglishGreeting implements HelloWorld{

            @Override
            public void greet() {
                greetSomeone("world");
            }

            @Override
            public void greetSomeone(String someone) {
                System.out.println("Hello " + someone);
            }
        }

        HelloWorld englishGreeting = new EnglishGreeting();

        //2、匿名内部类实现 Helloworld  接口

        HelloWorld helloWorld = new HelloWorld() {

            @Override
            public void greet() {
                greetSomeone("bbb");
            }

            @Override
            public void greetSomeone(String someone) {
                System.out.println("aaa " + someone);
            }
        };

    }
}
