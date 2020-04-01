package xin.sunce.chapter1.base.chapter6;

import java.util.*;

public class CollectionDemo {

    public static void main(String[] args) {
        Set<String> set1 = new HashSet();
        Set<String> set2 = new TreeSet();
        set1.add("1");
        set2.add("1");
        System.out.println(set1 == set2);
        System.out.println(set1.equals(set2));

        HashMap map = new HashMap();
    }


}
