package xin.sunce.chapter6.jvm.chapter2.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Copyright (C), 2010-2020, xxx payment. Co., Ltd.
 * <p>
 * 虚引用示例
 *
 * @author lowrie
 * @version 1.0.0
 * @date 2020-04-01
 */
public class PhantomReferenceDemo {

    /**
     * 当软弱虚引用，需要被回收时，会放入到引用队列中保存一下。
     * 虚引用无论何时通过PhantomReference#get都会返回null，虚引用与对象的生命周期无关，
     * 这种引用关系形同虚设；使用时必须与ReferenceQueue配合使用，看其构造函数可知。
     */
    public static void main(String[] args) throws InterruptedException {
        testWeakReference();
        System.out.println("============================");
        testPhantomReference();
    }

    private static void testWeakReference() throws InterruptedException {
        Object o = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o, referenceQueue);
        System.out.println("引用有效：");
        System.out.println(o);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
        o = null;
        System.out.println("引用无效：");
        System.out.println(o);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
        System.gc();
        //保证演示效果使当前线程暂停0.5s
        Thread.sleep(500);
        System.out.println("GC之后：");
        System.out.println(o);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
    }

    private static void testPhantomReference() {
        Object o = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o, referenceQueue);
        System.out.println("引用有效：");
        System.out.println(o);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
        o = null;
        System.out.println("引用无效：");
        System.out.println(o);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
        System.gc();
        System.out.println("GC之后：");
        System.out.println(o);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
    }


}
