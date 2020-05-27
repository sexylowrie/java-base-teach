package xin.sunce.chapter5.pattern.structure.facade;

/**
 * 门面演示类
 */
public class Demo {

    public static void main(String[] args) {
        RegisterFacade registerFacade = new RegisterFacadeImpl();
        registerFacade.register();
    }
}
