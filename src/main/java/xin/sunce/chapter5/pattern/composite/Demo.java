package xin.sunce.chapter5.pattern.composite;

/**
 * 演示类
 */
public class Demo {

    public static void main(String[] args) {
        Menu root  = new Menu("根结点","root");
        Menu first = new Menu("节点一","first");
        Menu second = new Menu("节点二","second");
        Menu firstSubA = new Menu("节点一子A","subA");
        Menu firstSubB = new Menu("节点一子B","subB");
        root.add(first);
        root.add(second);
        first.add(firstSubA);
        first.add(firstSubB);
        System.out.println(root);

    }
}
