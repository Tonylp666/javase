package designModel.factory.simpleFactory;

public class ComputerFactory {
    // e汉式
//    public final static ComputerFactory INSTANCE = new ComputerFactory();
    public static ComputerFactory INSTANCE ;
    private ComputerFactory(){

    }
    public static ComputerFactory getInstance(){
        if (INSTANCE == null){
            INSTANCE = new ComputerFactory();
        }
        return INSTANCE;
    }
    private Computer computer;
    // 简单工厂模式：专门定义一个类用来创建其它类的实例，被创建的实例通常都具有共同的父类。
    public Computer  createComputer(String type){
        if (type.contains("MacbookPro".toLowerCase())){
            computer = new MacbookProComputer();
        }else if (type.contains("surface".toLowerCase())) {
            computer = new SurfaceBookComputer();
        }
        return computer;
    }
}
