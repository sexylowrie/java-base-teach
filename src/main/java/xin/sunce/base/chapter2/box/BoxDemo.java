package xin.sunce.base.chapter2.box;

public class BoxDemo {

    public static void main(String[] args) {
        /**
         * jdk1.4 需要使用
         * Integer integer =new Integer(1);
         *
         * jdk1.5 支持自动拆装箱
         *
         * 装箱：即是把基本类型包装成包装类 调用的Integer.valueOf()方法
         * 拆箱：即是把包装类转换为基本类型，调用的 xxValue()方法，例如：intValue()
         *
         */
        int x = 1;
        Integer a = 1;
        Integer b = Integer.valueOf(1);
        Integer c = new Integer(1);
        System.out.println("x==a? " + (x == a));
        System.out.println("x==b? " + (x == b));
        System.out.println("x==c? " + (x == c));
        System.out.println("a==b? " + (a == b));
        System.out.println("a==c? " + (a == c));
        System.out.println("b==c? " + (b == c));
        System.out.println("a.equals(c)? " + (a.equals(c)));
        System.out.println("b.equals(c)? " + (b.equals(c)));


        int y = 128;
        Integer e = 128;
        Integer f = Integer.valueOf(128);
        Integer g = new Integer(128);
        System.out.println("y==e? " + (y == e));
        System.out.println("y==f? " + (y == f));
        System.out.println("y==g? " + (y == g));
        System.out.println("e==f? " + (e == f));
        System.out.println("e==g? " + (e == g));
        System.out.println("f==g? " + (f == g));
        System.out.println("e.equals(g)? " + (e.equals(g)));
        System.out.println("f.equals(g)? " + (f.equals(g)));

        Integer ai = 1;
        Integer bi = 2;
        Integer ci = 3;
        Integer di = 3;
        Integer ei = 321;
        Integer fi = 321;
        Long gl = 3L;
        Long hl = 2L;

        System.out.println(ci == di);//true
        System.out.println(ei == fi);//false
        System.out.println(ci == (ai + bi));//true
        System.out.println(ci.equals(ai + bi));//true
        System.out.println(gl == (ai + bi));//true
        System.out.println(gl.equals(ai + bi));//false
        System.out.println(gl.equals(ai + hl));//true

    }
}
