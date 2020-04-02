package xin.sunce.chapter6.jvm.chapter3.error;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 栈溢出模拟
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-04-02
 */
public class StackOverflowErrorDemo {


    private static int i = 0;

    /**
     * 启动参数设置：
     * -Xss160k
     * java.lang.StackOverflowError
     */
    public static void main(String[] args) {
        deep();
    }

    private static void deep() {
        try {
            i += 1;
            deep();
        } catch (Throwable e) {
            System.out.println("深度：" + i);
            e.printStackTrace();
        }
    }
}
