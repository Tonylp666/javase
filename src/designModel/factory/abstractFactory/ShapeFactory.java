package designModel.factory.abstractFactory;

/**
 * 抽象工厂模式定义（Abstract Factory Pattern）
 * 提供一个创建一系列相关或者相互依赖对象的接口，而无需知道他们的具体类，抽象工厂模式也称Kit模式，它属于类创建型模式。
 * 在抽象工厂模式中，每个具体工厂都提供了多个工厂方法用于创建多种不同类型的具体对象，这些被创建的对象就构成一个族。
 */
public interface ShapeFactory {
    Shape getCircle();
    Shape getRectange();
}
