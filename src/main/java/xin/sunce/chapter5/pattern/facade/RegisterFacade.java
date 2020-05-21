package xin.sunce.chapter5.pattern.facade;

/**
 * 注册门面接口/抽象类
 */
public abstract class RegisterFacade implements UserInterface, AccountInterface {

    public abstract boolean register();
}
