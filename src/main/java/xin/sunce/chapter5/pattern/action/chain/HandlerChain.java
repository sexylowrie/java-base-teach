package xin.sunce.chapter5.pattern.action.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链
 */
public class HandlerChain {

    List<Handler> handlers = new ArrayList<>();

    public void addHandler(Handler handler) {
        handlers.add(handler);
    }

    public void handler() {
        for(Handler handler :handlers){
            handler.doHandle();
        }
    }


}
