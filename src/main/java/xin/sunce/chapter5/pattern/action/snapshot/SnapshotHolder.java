package xin.sunce.chapter5.pattern.action.snapshot;

import java.util.Stack;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 快照Holder
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-28
 */
public class SnapshotHolder {

    Stack<Snapshot> snapshots = new Stack<>();

    public Snapshot pop() {
        return snapshots.pop();
    }

    public void push(Snapshot snapshot) {
        snapshots.push(snapshot);
    }
}
