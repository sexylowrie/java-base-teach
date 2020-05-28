package xin.sunce.chapter5.pattern.action.command;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-28
 */
public class Demo {

    public static void main(String[] args) throws Exception {
        Application application = new Application();
        application.setState(true);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                application.handle();
            }
        });
        System.out.println("game starting");
        thread.start();
        Thread.sleep(1000L);
        application.setState(false);
        System.out.println("game over");
    }

}
