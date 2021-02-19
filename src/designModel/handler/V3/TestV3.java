package designModel.handler.V3;

// 改变责任链调用，客户端改变较大。。。
public class TestV3 {
    public static void main(String[] args) {
        Study study = new Study();
        FilterChain chain = new FilterChain(study);
        PrepareHandler haveBreakfastFilter = new HaveBreakfastFilter();
        PrepareHandler washFaceFilter = new WashFaceFilter();
        PrepareHandler washHairFilter = new WashHairFilter();
        chain.addFilter(haveBreakfastFilter);
        chain.addFilter(washFaceFilter);
        chain.addFilter(washHairFilter);
        chain.doFilter();
    }
}
