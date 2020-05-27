package xin.sunce.chapter5.pattern.action.state;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 演示案例
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-27
 */
public class Demo {

    public static void main(String[] args) {
        MarioStateMachine stateMachine = new MarioStateMachine();
        String name = stateMachine.getCurrent().getName();
        System.out.println(String.format("I am %s Mario.", name));
        stateMachine.obtainMushRoom();
        System.out.println(String.format("%s Mario become %s, get %d score", name, stateMachine.getCurrent().getName(), stateMachine.getScore()));
        name = stateMachine.getCurrent().getName();
        stateMachine.obtainCap();
        System.out.println(String.format("%s Mario become %s, get %d score", name, stateMachine.getCurrent().getName(), stateMachine.getScore()));
        name = stateMachine.getCurrent().getName();
        stateMachine.obtainFireFlower();
        System.out.println(String.format("%s Mario become %s, get %d score", name, stateMachine.getCurrent().getName(), stateMachine.getScore()));
    }
}
