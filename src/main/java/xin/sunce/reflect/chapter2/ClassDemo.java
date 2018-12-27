package xin.sunce.reflect.chapter2;

/**
 * 〈第二章类的动态加载〉
 *
 * @author ce.sun
 * @create 2018-09-20
 */
public class ClassDemo {

    public static void main(String[] args) {
        //类的加载方式有两种一种是静态加载，一种是动态加载
        //1.静态加载,编译时期已经明确了类的信息
        if ("Word".equals(args[0])) {
            Word word = new Word();
            word.start();
        }

        if ("Excel".equals(args[0])) {
            Excle excle = new Excle();
            excle.start();
        }

        //2.动态加载,运行时才明确需要的类信息
        try {
            Class office = Class.forName("wang.sunce.teach.reflect.chapter2." + args[0]);
            Office o = (Office) office.newInstance();
            o.start();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}

interface Office {
    void start();
}

class Word implements Office {

    @Override
    public void start() {
        System.out.println("this is Word");
    }
}


class Excle implements Office {

    @Override
    public void start() {
        System.out.println("this is Excle");
    }
}
