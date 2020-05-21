package xin.sunce.chapter5.pattern.decorator;

/**
 * @author lowrie
 * @date 2019-07-26
 */
public class DecoratorDemo {


    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.draw();
        ColorShape colorfulCircle=new ColorShape(circle);
        colorfulCircle.draw();
    }
}
