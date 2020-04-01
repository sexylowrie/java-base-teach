package xin.sunce.chapter5.pattern.decorator;

/**
 * 颜色装饰器
 *
 * @author lowrie
 * @date 2019-07-26
 */
public class ColorDecorator extends ShapeDecorator {

    public ColorDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        this.color();
        super.draw();
    }

    @Override
    protected void color() {
        System.out.print("Colorful ");
    }
}
