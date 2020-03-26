package xin.sunce.concurrent;

/**
 * @author lowrie
 * @date 2019-09-03
 */
public class Demo2 {

    final int x;
    int y;

    static Demo2 d;

    public Demo2() {
        x = 3;
        y = 4;
    }


    public static void writer() {
        d = new Demo2();
    }


    public static void reader() {
        if (d != null) {
            System.out.println(d.x);
            System.out.println(d.y);
        }
    }


}
