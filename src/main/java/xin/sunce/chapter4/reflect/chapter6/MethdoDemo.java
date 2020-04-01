package xin.sunce.chapter4.reflect.chapter6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈第六章通过方法的反射认识泛型的实质〉
 *
 * @author ce.sun
 * @create 2018-09-20
 */
public class MethdoDemo {

    public static void main(String[] args) {
        List<String> strList=new ArrayList<>();
        List list=new ArrayList();
        Class aClass = strList.getClass();
        Class bClass = list.getClass();
        System.out.println(aClass==bClass);
        //true,执行结果为true，说明集合的泛型在编译之后是去泛型化的
        strList.add("hello");
        //strList.add(1);//编译报错
        try {
            Method add = aClass.getMethod("add", Object.class);
            add.invoke(strList,1);
            System.out.println(strList.size());
            System.out.println(strList);
            // 所以泛型就是在编译阶段限制类型，通过反射可以绕过泛型
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
