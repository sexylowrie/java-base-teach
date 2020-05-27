package xin.sunce.chapter5.pattern.action.state;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-27
 */
public class SmallMario implements Mario {

    private final static SmallMario SMALL = new SmallMario();

    private SmallMario() {
    }

    @Override
    public String getName() {
        return "SMALL";
    }

    public static SmallMario getInstance() {
        return SMALL;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
        stateMachine.setScore(stateMachine.getScore() + 100);
        stateMachine.setCurrent(SuperMario.getInstance());
    }

    @Override
    public void obtainCap(MarioStateMachine stateMachine) {
        stateMachine.setScore(stateMachine.getScore() + 200);
        stateMachine.setCurrent(CapMario.getInstance());
    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {
        stateMachine.setScore(stateMachine.getScore() + 400);
        stateMachine.setCurrent(FireMario.getInstance());
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        System.out.println("I meet monster");
    }
}
