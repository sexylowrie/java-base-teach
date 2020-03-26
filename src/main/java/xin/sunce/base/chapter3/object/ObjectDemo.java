package xin.sunce.base.chapter3.object;

/**
 * 基本类型是值传递，传递的是值的副本
 * 引用类型是引用传递，传递的是引用地址；
 * 引用类型调用ObjectDemo#exchage的形参将指针执行实参的内存地址，
 * 在局部方法中new等操作会在堆中创建一个新的对象，并将形参指针执行该对象的内存地址，未改变实参的指针
 */
public class ObjectDemo {

    public static void main(String[] args) {
        String str = "lowrie";
        char arr[] = {'a', 'b', 'c'};
        int i = 128;
        Integer integer = 128;
        Test test = new Test("sunce");
        O o =new ObjectDemo().new O();
        exchange(str);
        exchange(arr);
        exchange(i);
        exchange(integer);
        exchange(test);
        System.out.println("String exchange: " + str);
        System.out.println("Char[] exchange: " + String.valueOf(arr));
        System.out.println("int exchange: " + i);
        System.out.println("Integer exchange: " + integer);
        System.out.println("Tset Class exchange: " + test.getName());
    }


    public static void exchange(String str) {
        str = "hello";
    }

    public static void exchange(char[] arr) {
        if (arr.length >= 1) {
            arr[0] = 'g';
        }
    }

    public static void exchange(int i) {
        i = 127;
    }

    public static void exchange(Integer i) {
        i = 127;
    }

    public static void exchange(Test test) {
        test = new Test("java");
    }

    static class Test {

        public Test(String name) {
            this.name = name;
        }

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class O {
        String name;
    }
}
