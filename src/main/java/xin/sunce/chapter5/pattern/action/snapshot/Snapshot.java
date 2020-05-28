package xin.sunce.chapter5.pattern.action.snapshot;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 快照
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-28
 */
public class Snapshot {


    public Snapshot(String content) {
        this.content = content;
    }

    /**
     * 内容
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
