package wang.sunce.teach.reflect.chapter4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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
     * 打印类的信息，类的方法
     *
     * @param object
     */
    public static void printClassMethodMessage(Object object) {
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
        for (Method method : methods) {
            Class returnType = method.getReturnType();
            int modifiers = method.getModifiers();
            String methodName = method.getName();
            System.out.print(Modifier.toString(modifiers) + " " + returnType + " " + methodName + "(");
            Class[] parameterTypes = method.getParameterTypes();
            for (Class c : parameterTypes) {
                System.out.print(c.getName() + ",");
            }
            System.out.println(")");
        }


    }

    /**
     * 打印类的信息，类的成员变量
     *
     * @param object
     */
    public static void printClassFieldMessage(Object object) {
        Class clazz = object.getClass();
        System.out.println("类类型是：" + clazz);
        String name = clazz.getName();
        System.out.println("类名称是：" + name);
        String simpleName = clazz.getSimpleName();
        System.out.println("类简称是：" + simpleName);
        /**
         * 获取类的成员变量
         * getFields 获取到所有的public 成员变量，包含父类继承的成员变量
         * getDeclaredMethods 获取到自己声明的 函数，没有访问限制
         */
        Field[] fields = clazz.getFields();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Class type = field.getType();
            int modifiers = field.getModifiers();
            String fieldName = field.getName();
            System.out.print(Modifier.toString(modifiers) + " " + type.getName() + " " + fieldName + "(");
        }
        System.out.println(")");
    }

    /**
     * 打印构造函数信息
     *
     * @param object
     */
    public static void printConstructorMessage(Object object) {
        Class clazz = object.getClass();
        /**
         * 获取类的成员变量
         * getConstructors 获取到所有的public构造函数
         * getDeclaredConstructors 获取到所有构造函数
         */
        Constructor[] constructors = clazz.getConstructors();
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            String name = constructor.getName();
            int modifiers = constructor.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " " + name + " " + "(");
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class c : parameterTypes) {
                System.out.print(c.getName() + ",");
            }
            System.out.println(")");
        }
    }

}
