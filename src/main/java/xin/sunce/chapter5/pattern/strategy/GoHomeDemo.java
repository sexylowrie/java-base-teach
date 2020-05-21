package xin.sunce.chapter5.pattern.strategy;

/**
 * 策略模式演示类
 *
 * @author lowrie
 * @date 2019-08-29
 */
public class GoHomeDemo {

    public static void main(String[] args) throws Exception{
        //乘坐出租车回家
        Content content = new Content(StrategyFactory.createStrategy(TypeConstant.TAXI));
        content.execute();

        Content contentNew = new Content(NewStrategyFactory.createStrategy(TypeConstant.RUN));
        contentNew.execute();

        Content contentNewUp = new Content(NewUpStrategyFactory.createStrategy(TypeConstant.RALIWAY));
        contentNewUp.execute();
    }

}
