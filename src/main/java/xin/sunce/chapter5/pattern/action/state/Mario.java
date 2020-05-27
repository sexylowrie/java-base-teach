package xin.sunce.chapter5.pattern.action.state;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-27
 */
public interface Mario {

    /**
     * 获得姓名
     *
     * @return
     */
    String getName();


    void obtainMushRoom(MarioStateMachine stateMachine);

    void obtainCap(MarioStateMachine stateMachine);

    void obtainFireFlower(MarioStateMachine stateMachine);

    void meetMonster(MarioStateMachine stateMachine);


}
