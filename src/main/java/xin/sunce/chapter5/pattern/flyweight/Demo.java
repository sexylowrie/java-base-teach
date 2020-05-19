package xin.sunce.chapter5.pattern.flyweight;

/**
 * 享元模式：顾名思义，被共享的单元；我们可以利用其来缓存可复用的对象，以此减少内存开销
 *
 * 例如：
 * 在java中Integer，类加载时缓存，默认缓存范围时-128～127；
 *  可以利用启动参数-Djava.lang.Integer.IntegerCache.high=255或者-XX:AutoBoxCacheMax=255,来提升缓存的范围；
 * 在java中String，使用时缓存，在类加载时，无法确定缓存的范围，JVM中用字符串常量池来缓存
 *
 * 场景：棋牌游戏中，有很多个对局，不用每次都重新生产棋子对象，我们把棋子对象中共享的部分可以缓存起来。
 */
public class Demo {

    public static void main(String[] args) {
        Integer i0 = new Integer(1);
        Integer i1 = 1;
        Integer i2 = 1;
        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i1 == i0);//false ;new Integer(1) 没有使用缓存
        System.out.println(i1 == i2);//true;使用缓存，默认缓存范围时：-128，127
        System.out.println(i3 == i4);//false；默认缓存范围时：-128，127

        System.out.println("===================");

        String str1 = new String("abcd");
        String str2 = "abcd";
        String str3 = "abcd";
        System.out.println(str1 == str2);//false
        System.out.println(str1.intern() == str2.intern());//true
        System.out.println(str2 == str3);//true;使用缓存
    }
}
