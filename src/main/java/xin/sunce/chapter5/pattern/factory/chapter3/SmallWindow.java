package xin.sunce.chapter5.pattern.factory.chapter3;

/**
 * 小型车窗
 *
 * @author lowrie
 * @date 2019-07-15
 */
public class SmallWindow implements Window {

    @Override
    public String getModel() {
        return "Small";
    }
}
