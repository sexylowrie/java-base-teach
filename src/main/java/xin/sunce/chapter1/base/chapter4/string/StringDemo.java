package xin.sunce.chapter1.base.chapter4.string;

public class StringDemo {


    public static void main(String[] args) {

        String str1 = "ab" + "cd";
        String str2 = "abcd";
        String str3 = new String("abcd");
        String str4 = new String("abc") + "d";
        String str5 = "abc";
        String str6 = str5 + "d";
        StringBuffer strBuf = new StringBuffer("abcd");
        StringBuilder strBud = new StringBuilder("abcd");
        System.out.println("1: " + (str1 == str2));
        System.out.println("2: " + (str1 == str3));
        System.out.println("3: " + (str1 == str6));
        System.out.println("4: " + (str3 == str4));
        System.out.println("5: " + (str1 == strBuf.toString()));
        System.out.println("6: " + (str1 == strBud.toString()));
        System.out.println("7: " + (str1.equals(strBud)));

        changeBuf(strBuf);
        System.out.println(strBuf.toString());
        changeBud(strBud);
        System.out.println(strBud.toString());
        changeStr(str3);
        System.out.println(str3);

    }


    public static void changeBuf(StringBuffer buffer) {
        buffer = buffer.append("ab");
    }

    public static void changeBud(StringBuilder builder) {
        builder = builder.append("ab");
    }

    public static void changeStr(String str) {
        str = str + "ab";
    }


}
