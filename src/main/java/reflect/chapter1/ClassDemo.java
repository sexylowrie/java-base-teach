package reflect.chapter1;

/**
 * 〈第一章 Class Demo〉
 *
 * @author ce.sun
 * @create 2018-09-20
 */
public class ClassDemo {


    public static void main(String[] args) {
        // Foo 类的一个实例对象
        Foo foo = new Foo();
        // Class 类的实例对象如何表示呢？有如下三种方法
        //Class c=new Class(); 不可以，因为Class 的构造方法是private

        /**方法1：任何一个类都隐含一个静态的成员变量class*/
        Class c1 = Foo.class;
        /**方法2：通过已知该类的对象通过getClass方法获取*/
        Class c2 =foo.getClass();
        /**方法3：通过Class类的静态方法forName 获取*/
        Class c3 = null;
        try{
            c3 = Class.forName("wang.sunce.teach.reflect.chapter1.Foo");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        //c1==c2 true
        System.out.println(c1==c2);
        //c2==c3 true
        System.out.println(c2==c3);
        /**无论c1,c2,c3；表示的都是Foo的类类型*/

        //通过类类型创建类对象
        try {
            Foo foo2 = (Foo)c1.newInstance();
            foo2.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}


class Foo {
    void print(){
        System.out.println("my name is foo.");
    }
}
