package xin.sunce.chapter5.pattern.structure.decorator;

/**
 * 组件实现
 *
 * @author lowrie
 * @date 2019-07-26
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle");
    }
}
