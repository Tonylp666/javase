package designModel.handler.V2;

public class HaveBreakfastFilter extends AbstractPrepareHandler {
    public HaveBreakfastFilter(AbstractPrepareHandler nextAbstractPrepareHandler) {
        super(nextAbstractPrepareHandler);
    }

    @Override
    public void prepare() {
        System.out.println(" HaveBreakfast ");
    }
}
