package designModel.handler.V3;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
    List<PrepareHandler> prepareHandlerList;
    int pos = 0;
    Study study;

    public FilterChain(Study study) {
        this.study = study;
    }

    public void addFilter(PrepareHandler prepareHandler) {
        if (prepareHandlerList == null){
            this.prepareHandlerList = new ArrayList<>();
        }
        prepareHandlerList.add(prepareHandler);
    }

    public void doFilter() {
        if (pos == prepareHandlerList.size()){
            this.study.study();
            return;
        }
        prepareHandlerList.get(pos++).doFilter(this);
    }
}
