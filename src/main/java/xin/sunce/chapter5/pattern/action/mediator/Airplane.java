package xin.sunce.chapter5.pattern.action.mediator;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-28
 */
public class Airplane {

    private String id;

    private boolean state;

    public Airplane(String id, boolean state) {
        this.id = id;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    /**
     * 请求起飞，true：可以起飞，false：不可以起飞
     *
     * @return
     */
    public boolean request(Mediator mediator) {
        return mediator.check(this);
    }


    /**
     * 检查状态，true：正在备飞，false：等待中
     *
     * @return
     */
    public boolean check() {
        return state;
    }
}
