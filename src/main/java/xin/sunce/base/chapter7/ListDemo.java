package xin.sunce.base.chapter7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListDemo {


    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        list1.add(0, 1);
        System.out.println(list1.get(0));

//        List<Integer> list2 = new ArrayList();
//        list2.set(0, 1);
//        System.out.println(list2.get(0));


        List<Integer> list3 = new Vector<>();

        List<Integer> list4 = new LinkedList<>();

    }
}
