package xin.sunce.chapter5.pattern.adapter;

/**
 * 电源适配器
 *
 * @author lowrie
 * @date 2019-07-25
 */
public class DeviceAdapter extends LocalDevice {


    private OtherDevice device;

    @Override
    protected void doLocalCharging() {
        device.doOtherCharging();
    }

    public DeviceAdapter(OtherDevice device) {
        this.device = device;
    }

}
