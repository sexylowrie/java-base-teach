package xin.sunce.chapter5.pattern.action.command;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-28
 */
public class Application {

    private Queue<Command> queue = new LinkedList<>();

    private int MAX_HANDLE_COUNT = 100;

    private boolean state;


    public void setState(boolean state) {
        this.state = state;
    }

    public void handle() {
        while (state) {
            //省略从epoll或者select中获取数据，并封装成Request的逻辑，
            //注意设置超时时间，如果很⻓时间没有接收到请求，就继续下⾯的逻辑处理。
            List<String> list = mockRequest();
            for (String request : list) {
                Command command = null;
                if (request.equals("Q-EVENT")) {
                    command = new Q();
                } else if (request.equals("W-EVENT")) {
                    command = new W();
                } else if (request.equals("E-EVENT")) {
                    command = new E();
                } else if (request.equals("R-EVENT")) {
                    command = new R();
                }
                queue.add(command);
            }

            int handleCount = 0;
            while (handleCount < MAX_HANDLE_COUNT) {
                if (queue.isEmpty()) {
                    break;
                }
                Command poll = queue.poll();
                poll.execute();
                handleCount++;
            }
        }
    }

    private List<String> mockRequest() {
        List<String> request = new ArrayList<>();
        request.add("Q-EVENT");
        request.add("W-EVENT");
        request.add("E-EVENT");
        request.add("R-EVENT");
        return request;
    }


}
