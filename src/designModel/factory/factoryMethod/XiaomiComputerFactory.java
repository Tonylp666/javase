package designModel.factory.factoryMethod;

public class XiaomiComputerFactory implements ComputerFactory{
    @Override
    public Computer createComputer() {
        return new XiaomiComputer();
    }
}
