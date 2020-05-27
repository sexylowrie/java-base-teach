package xin.sunce.chapter5.pattern.action.template;

/**
 * 游戏框架模板类
 *
 * @author lowrie
 * @date 2019-09-02
 */
public abstract class GameTemplate {


    /**
     * 初始化游戏资源
     */
    abstract void doInit();

    /**
     * 游戏开始
     */
    abstract void doStart();

    /**
     * 游戏结束
     */
    abstract void doEnd();

    /**
     * 体验游戏
     */
    public void play() {
        doInit();
        doStart();
        doEnd();
    }


}
