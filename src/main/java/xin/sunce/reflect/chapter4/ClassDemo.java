package xin.sunce.reflect.chapter4;

/**
 * 〈获取类的成员变量〉
 *
 * @author ce.sun
 * @create 2018-09-20
 */
public class ClassDemo {

    public static void main(String[] args) {
        String s="hello";
        ClassUtil.printClassFieldMessage(s);
        ClassUtil.printConstructorMessage(s);
    }

}
