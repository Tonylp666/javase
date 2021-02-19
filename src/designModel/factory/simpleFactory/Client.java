package designModel.factory.simpleFactory;

public class Client {

    // 这个应该是单例的，因为正常情况下，一个销售点会接待相当多的顾客，如果每一个顾客创建一个 工厂对象 那么就炸了。
    ComputerFactory computerFactory = ComputerFactory.getInstance();
    public void wantBuy(String computerType){

        Computer computer = computerFactory.createComputer(computerType);
        computer.printComputer();
    }
    public static void main(String[] args) {
        Client c = new Client();
        // 我不会造电脑呀，台式机还能组装， mac 是真的不行。。。，因此我们需要一个工厂来干这个事
//        c.buy(new SurfaceBookComputer());
        System.out.println(" I want buy a computer.");
        c.wantBuy("mac");

    }
}
