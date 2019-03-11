package xin.sunce.base.chapter1;

public class CalculateDemo3 {

    public static void main(String[] args) {
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
    }
}
