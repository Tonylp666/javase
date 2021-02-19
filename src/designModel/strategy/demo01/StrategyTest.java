package designModel.strategy.demo01;

public class StrategyTest {
    public static void main(String[] args) {
        Context context01 = new Context(new Strategy01());
        context01.action();


        Context context02 = new Context(new Strategy02());
        context02.action();
    }
}
