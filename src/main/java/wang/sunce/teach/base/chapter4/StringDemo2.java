package wang.sunce.teach.base.chapter4;

public class StringDemo2 {

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = new String("abcd");
        String str = "abc";
        String str3 = str + "d";
        StringBuffer str4 = new StringBuffer("abcd");
        System.out.println(str1.intern() == str2.intern());
        System.out.println(str1.intern() == str3.intern());
        System.out.println(str1.intern() == str4.toString().intern());

        String strX = new StringBuilder("计算机").toString();
        System.out.println(strX.intern() == strX);

        String str11 = new StringBuilder("计算").append("软件").toString();
        System.out.println(str11.intern() == str11);

        String str21 = new StringBuilder("ja").append("va").toString();
        System.out.println(str21.intern() == str21);


    }
}
