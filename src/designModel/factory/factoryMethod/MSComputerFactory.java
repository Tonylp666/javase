package designModel.factory.factoryMethod;

public class MSComputerFactory implements ComputerFactory{
    @Override
    public Computer createComputer() {
        return new SurfaceBookComputer();
    }
}
