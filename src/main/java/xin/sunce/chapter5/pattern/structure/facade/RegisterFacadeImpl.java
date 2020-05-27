package xin.sunce.chapter5.pattern.structure.facade;

/**
 * 注册门面实现
 *
 * 场景描述：
 * 用户注册时需要创建一个用户user，同时需要创建一个账户account，客服端调用时需要调用两次，对接两个接口；
 * 我们可以将其包装成一个注册门面直接供客户端调用，减少网络IO次数；
 *
 * 备注：addAccount，addUser 接口非必须在门面实现类中实现，此处用于演示案例。
 * 具体场景中可能包含更多的接口，并且这些接口可能分布在不同的子系统中。
 *
 */
public class RegisterFacadeImpl extends RegisterFacade{

    @Override
    public boolean register() {
        addUser();
        addAccount();
        System.out.println("register success");
        return true;
    }

    @Override
    public boolean addAccount() {
        System.out.println("create a account");
        return true;
    }

    @Override
    public boolean addUser() {
        System.out.println("create a user");
        return true;
    }
}
