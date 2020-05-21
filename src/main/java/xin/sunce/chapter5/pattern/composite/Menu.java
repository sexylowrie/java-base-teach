package xin.sunce.chapter5.pattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    public Menu(String name, String url) {
        this.name = name;
        this.url = url;
    }

    /**
     * 名称
     */
    private String name;

    /**
     * 链接
     */
    private String url;

    /**
     * 子节点
     */
    private List<Menu> children = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void add(Menu child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", children=" + children +
                '}';
    }
}
