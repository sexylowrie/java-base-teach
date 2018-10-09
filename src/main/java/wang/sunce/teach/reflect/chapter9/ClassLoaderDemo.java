package wang.sunce.teach.reflect.chapter9;

/**
 * 〈反射示例〉
 *
 * @author ce.sun
 * @create 2018-09-25
 */
public class ClassLoaderDemo {


    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        FileClassLoader classLoader1 =new FileClassLoader("C:\\Users\\LENOVO\\Desktop\\");
        FileClassLoader classLoader2 =new FileClassLoader("C:\\Users\\LENOVO\\Desktop\\");
        try {
            Class<?> c1 = classLoader1.loadClass("Hello");
            Class<?> c2 = classLoader1.loadClass("Hello");
            Class<?> c3 = classLoader2.loadClass("Hello");
            Class<?> c4 = classLoader1.loadClass("java.lang.String");
            Class<?> c5 = classLoader2.loadClass("wang.sunce.teach.reflect.chapter9.Hello");
            System.out.println(c1.hashCode());
            System.out.println(c2.hashCode());
            //同一个类，被不同的加载器加载，JVM认为也是不相同的类
            System.out.println(c3.hashCode());
            System.out.println(c4.hashCode());
            System.out.println(c5.hashCode());

            System.out.println(c1.getClassLoader());
            System.out.println(c2.getClassLoader());
            System.out.println(c3.getClassLoader());
            System.out.println(c4.getClassLoader());
            System.out.println(c5.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
