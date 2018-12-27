package xin.sunce.base.chapter4;

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

    }
}
