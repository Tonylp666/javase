package designModel.handler.V2;

public class WashFaceFilter extends AbstractPrepareHandler{
    public WashFaceFilter(AbstractPrepareHandler nextAbstractPrepareHandler) {
        super(nextAbstractPrepareHandler);
    }

    @Override
    public void prepare() {
        System.out.println(" WashFace ");
    }
}
