package xin.sunce.chapter5.pattern.create.builder;

public class Demo {

    public static void main(String[] args) {
        ResourceConfig config = new ResourceConfig.Builder().setTimeout(100)
                .setRetry(true).setMaxTotal(5).setMaxIdle(60).build();
        System.out.println("config = " + config);
        ResourceConfig defaultConfig = new ResourceConfig.Builder().build();
        System.out.println("config = " + defaultConfig);
    }
}
