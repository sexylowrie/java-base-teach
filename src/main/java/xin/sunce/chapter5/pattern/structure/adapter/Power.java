package xin.sunce.chapter5.pattern.structure.adapter;

/**
 * 源电源接口
 *
 * @author lowrie
 * @date 2019-07-25
 */
public class Power {

    public static void charging(LocalDevice device) {
        device.doLocalCharging();
    }
}
