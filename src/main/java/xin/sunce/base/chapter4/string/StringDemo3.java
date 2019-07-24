package xin.sunce.base.chapter4.string;

public class StringDemo3 {

    public static void main(String[] args) {
        String strX = new StringBuilder("计算机").toString();
        System.out.println(strX.intern() == strX);

        String str11 = new StringBuilder("计算").append("软件").toString();
        System.out.println(str11.intern() == str11);

        String str21 = new StringBuilder("ja").append("va").toString();
        System.out.println(str21.intern() == str21);
    }
}
