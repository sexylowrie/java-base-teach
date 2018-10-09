package wang.sunce.teach.reflect.chapter3;

/**
 * 〈第三章获取类的方法〉
 *
 * @author ce.sun
 * @create 2018-09-20
 */
public class ClassDemo {

    public static void main(String[] args) {
        Class c1 = int.class;
        Class c2 = String.class;
        Class c3 = Double.class;
        Class c4 = void.class;
        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c3.getSimpleName());
        System.out.println(c4.getName());

        String hello = "Hello";
        ClassUtil.printClassMessage(hello);
        ClassUtil.printClassMessage(new Integer("1"));
    }
}
