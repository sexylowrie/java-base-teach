package xin.sunce.chapter5.pattern.action.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 中介类-类似于机场塔台
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-28
 */
public class Mediator {

    private List<Airplane> airplanes = new ArrayList<>();

    public void register(Airplane airplane) {
        airplanes.add(airplane);
    }

    /**
     * 检查除了自己以外其他飞机的状态
     * <p>
     * 有备飞状态的飞机就等待
     *
     * @return
     */
    public boolean check(Airplane airplane) {
        for (Airplane plane : airplanes) {
            if (plane.getId().equals(airplane.getId())) {
                continue;
            }
            if (plane.check()) {
                return false;
            }
        }
        return true;
    }
}
