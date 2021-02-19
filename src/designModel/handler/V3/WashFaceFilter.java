package designModel.handler.V3;

public class WashFaceFilter implements PrepareHandler  {

    @Override
    public void doFilter(FilterChain filterChain) {
        System.out.println(" WashFace ");
       // filterChain.doFilter();
    }
}
