package designModel.handler.V3;

public class HaveBreakfastFilter implements PrepareHandler {

    @Override
    public void doFilter(FilterChain filterChain) {
        System.out.println(" HaveBreakfast ");
        filterChain.doFilter();
    }
}
