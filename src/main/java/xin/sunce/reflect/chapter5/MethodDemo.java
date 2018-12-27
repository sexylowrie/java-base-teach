package xin.sunce.reflect.chapter5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 〈第五章通过反射操作方法〉
 *
 * @author ce.sun
 * @create 2018-09-20
 */
public class MethodDemo {

    public static void main(String[] args) {
        A a = new A();
        Class aClazz = a.getClass();
        try {
            Method print = aClazz.getMethod("print", new Class[]{int.class, int.class});
            Method print2 = aClazz.getMethod("print", String.class, String.class);
            print.invoke(a, 1,1);
            print2.invoke(a, "Hello","world");
            //方法的反射式利用 方法的对象来调用，而不是通过a.print来调用;实现的效果跟a.print 相同
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class A {
    public void print(int a, int b) {
        System.out.println("a = [" + a + "], b = [" + b + "]");
    }

    public void print(String a, String b) {
        System.out.println("a = [" + a.toUpperCase() + "], b = [" + b.toLowerCase() + "]");
    }


}
