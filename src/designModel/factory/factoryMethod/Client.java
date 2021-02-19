package designModel.factory.factoryMethod;

/**
 * @author liping
 * 工厂方法模式，在添加产品类型时只需要添加一个含品类、一个相对应的产品的工厂类，不需要修改代码。
 * 完美践行了：对扩展开放，对修改关闭。
 *
 * 例如，我们现在增加一个 小米电脑产品
 */
public class Client {

    public void wantBuy(Computer computerType){
        computerType.printComputer();
    }

    public static void main(String[] args) {
        Client c = new Client();
//        ComputerFactory factory = new ApplyComputerFactory();
        XiaomiComputerFactory factory = new XiaomiComputerFactory();
        Computer computer = factory.createComputer();
        c.wantBuy(computer);
    }
}
