package xin.sunce.chapter5.pattern.singleton;

import java.io.*;

/**
 * serializable解决方案测试
 */
public class SingletonSerializable {

    /**
     * 私有化构造函数
     */
    private SingletonSerializable() {
    }

    /**
     * 声明公有的 获取实例方法
     */
    public static SingletonSerializable getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 私有内部静态类
     */
    private static class SingletonHolder {

        private static final SingletonSerializable INSTANCE = new SingletonSerializable();

    }

    public Object readResolve() {
        return SingletonSerializable.SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        SingletonSerializable instance = SingletonSerializable.getInstance();
        try {
            /**将该对象序列化输出*/
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("single.obj"));
            out.writeObject(instance);
            out.flush();
            out.close();

            /**将该对象反序列化读入*/
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("single.obj"));
            SingletonSerializable instance2 = (SingletonSerializable) in.readObject();
            in.close();

            System.out.println("instance 与 instance2 是同一个实例: " + (instance == instance2));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
