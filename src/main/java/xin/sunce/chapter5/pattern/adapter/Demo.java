package xin.sunce.chapter5.pattern.adapter;

/**
 * 演示案例
 *
 * @author lowrie
 * @date 2019-07-25
 */
public class Demo {

    public static void main(String[] args) {
        Power.charging(new LocalDevice());
//        Power.charging(new CameraDevice());//编译错误
        Power.charging(new DeviceAdapter(new CameraDevice()));
    }
}
