package xin.sunce.reflect.chapter8;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 〈第八章构造函数的反射〉
 *
 * @author ce.sun
 * @create 2018-09-20
 */
public class ConstructorDemo {

    public static void main(String[] args) {
        Class clazz = Cons.class;
        try {
            Constructor a = clazz.getConstructor();
            Constructor c = clazz.getDeclaredConstructor();
            c.setAccessible(true);
            Cons o = (Cons)c.newInstance();
            System.out.println(o);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class Cons{

    private String name;
    private int age;

    public Cons(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Cons(){
        
    }
}
