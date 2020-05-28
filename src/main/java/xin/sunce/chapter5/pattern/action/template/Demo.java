package xin.sunce.chapter5.pattern.action.template;

/**
 * 测试demo
 *
 * @author lowrie
 * @date 2019-09-02
 */
public class Demo {


    public static void main(String[] args) {
        GameTemplate template = new PokerGame();
        template.play();

        template = new RpgGame();
        template.play();
    }
}
