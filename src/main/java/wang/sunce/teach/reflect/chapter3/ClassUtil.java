package wang.sunce.teach.reflect.chapter3;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 〈Class工具类〉
 *
 * @author ce.sun
 * @create 2018-09-20
 */
public class ClassUtil {
    /**
     * 打印类的信息，类的成员变量，类的方法
     *
     * @param object
     */
    public static void printClassMessage(Object object) {
        Class clazz = object.getClass();
        System.out.println("类类型是：" + clazz);
        String name = clazz.getName();
        System.out.println("类名称是：" + name);
        String simpleName = clazz.getSimpleName();
        System.out.println("类简称是：" + simpleName);

        /**
         * 获取类方法
         * getMethods 获取到所有的public 函数，包含父类继承的方法
         * getDeclaredMethods 获取到自己声明的 函数，没有访问限制
         */
        Method[] methods = clazz.getMethods();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method method:methods){
            Class returnType = method.getReturnType();
            String methodName = method.getName();
            System.out.print(Modifier.toString(method.getModifiers()) +" "+returnType+" " + methodName + "(");
            Class[] parameterTypes = method.getParameterTypes();
            for(Class c:parameterTypes){
                System.out.print(c.getName()+",");
            }
            System.out.println(")");
        }

    }
}
