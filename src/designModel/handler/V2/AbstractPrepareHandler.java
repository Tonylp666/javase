package designModel.handler.V2;


public abstract class AbstractPrepareHandler {

    private AbstractPrepareHandler nextAbstractPrepareHandler;

    public AbstractPrepareHandler(AbstractPrepareHandler nextAbstractPrepareHandler) {
        this.nextAbstractPrepareHandler = nextAbstractPrepareHandler;
    }

    public void setNextPrepareHandler(AbstractPrepareHandler nextAbstractPrepareHandler) {
        this.nextAbstractPrepareHandler = nextAbstractPrepareHandler;
    }

    public void doFilter( Study study){
        prepare();
        if (nextAbstractPrepareHandler == null){
            study.study();
        }else {
            nextAbstractPrepareHandler.doFilter(study);
        }
    }

    public abstract void prepare();
}
