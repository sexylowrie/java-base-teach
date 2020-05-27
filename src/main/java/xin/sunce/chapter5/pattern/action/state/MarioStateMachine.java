package xin.sunce.chapter5.pattern.action.state;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 状态机
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-27
 */
public class MarioStateMachine {

    private int score;
    private Mario current;

    public MarioStateMachine() {
        this.score = 0;
        this.current = SmallMario.getInstance();
    }

    public void obtainMushRoom() {
        current.obtainMushRoom(this);
    }

    public void obtainCap() {
        current.obtainCap(this);
    }

    public void obtainFireFlower() {
        current.obtainFireFlower(this);
    }

    public void meetMonster() {
        current.meetMonster(this);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Mario getCurrent() {
        return current;
    }

    public void setCurrent(Mario current) {
        this.current = current;
    }
}
