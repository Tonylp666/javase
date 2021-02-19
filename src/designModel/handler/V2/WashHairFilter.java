package designModel.handler.V2;

public class WashHairFilter extends AbstractPrepareHandler{
    public WashHairFilter(AbstractPrepareHandler nextAbstractPrepareHandler) {
        super(nextAbstractPrepareHandler);
    }

    @Override
    public void prepare() {
        System.out.println(" WashHair ");
    }
}
