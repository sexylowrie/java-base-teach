package xin.sunce.pattern.decorator;

/**
 * @author lowrie
 * @date 2019-07-26
 */
public class DecoratorDemo {


    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.draw();
        ColorDecorator colorfulCircle=new ColorDecorator(circle);
        colorfulCircle.draw();
    }
}
