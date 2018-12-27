package xin.sunce.base.chapter1;

public class CalculateDemo2 {

    public static void main(String[] args) {

        short s = 1;
        // 默认有int --> short 强制类型转换
        s += 1;

        //s = s + 1;//不会有类型转换

        Integer i = new Integer(1);
        Integer ii = new Integer(1);
        System.out.println(i == ii);

        Integer li = 1;
        Integer lii = 1;
        System.out.println(li == lii);

        Integer di = 128;
        Integer dii = 128;
        System.out.println(di == dii);


    }

}
