package xin.sunce.base.chapter7.collection;

import java.util.*;

public class ListDemo {


    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        list1.add(0, 1);

//        List<Integer> list2 = new ArrayList();
//        list2.set(0, 1);
//        System.out.println(list2.get(0));


        List<Integer> list3 = new Vector<>();

        List<Integer> list4 = new LinkedList<>();
        list4.add(1);
        list4.add(2);
        list4.add(3);
        list4.add(4);
        Iterator<Integer> iterator = list4.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
