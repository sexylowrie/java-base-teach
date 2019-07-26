package xin.sunce.pattern.decorator;

/**
 * 图形装饰器
 *
 * @author lowrie
 * @date 2019-07-26
 */
public abstract class ShapeDecorator implements Shape {

    protected Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    /**
     * 装饰颜色
     */
    protected abstract void color();

    @Override
    public void draw() {
        shape.draw();
    }
}
