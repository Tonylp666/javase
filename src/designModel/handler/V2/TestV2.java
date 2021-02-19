package designModel.handler.V2;

// 改变责任链调用，客户端改变较大。。。
public class TestV2 {
    public static void main(String[] args) {
        Study study = new Study();
        AbstractPrepareHandler haveBreakfastFilter = new HaveBreakfastFilter(null);
        AbstractPrepareHandler washFaceFilter = new WashFaceFilter(haveBreakfastFilter);
        AbstractPrepareHandler washHairFilter = new WashHairFilter(washFaceFilter);
        washHairFilter.doFilter(study);
    }
}
