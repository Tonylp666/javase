package designModel.strategy.demo01;

public class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void action(){
        this.strategy.strategy();
    }
}
