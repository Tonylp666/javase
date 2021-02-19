package designModel.factory.factoryMethod;

public class ApplyComputerFactory implements ComputerFactory{
    @Override
    public Computer createComputer() {
        return new MacbookProComputer();
    }
}
