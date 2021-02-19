package designModel.handler.V3;

public class WashHairFilter  implements PrepareHandler {

    @Override
    public void doFilter(FilterChain filterChain) {
        System.out.println(" WashHair ");
        filterChain.doFilter();
    }
}
