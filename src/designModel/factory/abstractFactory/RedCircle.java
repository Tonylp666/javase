package designModel.factory.abstractFactory;

public class RedCircle extends Circle{
    @Override
    public void draw() {
        System.out.println("绘制红色的圆。");
    }
}
