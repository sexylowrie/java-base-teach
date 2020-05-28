package xin.sunce.chapter5.pattern.action.snapshot;

import java.util.Scanner;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 备忘录模式演示类
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-05-28
 */
public class Demo {


    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder holder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (":list".equals(input)) {
                System.out.println(inputText.getText());
            } else if (":undo".equals(input)) {
                //取出快照，替换
                Snapshot snapshot = holder.pop();
                inputText.restoreSnapshot(snapshot);
            } else {
                //创建快照拼接
                holder.push(inputText.createSnapshot());
                inputText.append(input);
            }
        }
    }
}
