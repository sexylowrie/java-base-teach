package xin.sunce.chapter5.pattern.action.snapshot;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 输入文本
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-28
 */
public class InputText {


    private StringBuilder content = new StringBuilder();

    public Snapshot createSnapshot() {
        return new Snapshot(content.toString());
    }


    public void restoreSnapshot(Snapshot snapshot) {
        content.replace(0, content.length(), snapshot.getContent());
    }

    public String getText() {
        return content.toString();
    }

    public void append(String text) {
        content.append(text);
    }


}
