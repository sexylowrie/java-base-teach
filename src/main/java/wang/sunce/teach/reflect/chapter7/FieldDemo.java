package wang.sunce.teach.reflect.chapter7;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 〈第七章成员变量的反射〉
 *
 * @author ce.sun
 * @create 2018-09-20
 */
public class FieldDemo {

    public static void main(String[] args) {

        System.out.println(String.class.getSuperclass());
        //需求：将字符串类型为String 的成员变量的值，所有的'b' 替换成 'a'
        SourceStr source = new SourceStr();
        System.out.println("source = " + source + "");
        Class clazz = source.getClass();
        Field[] fields = clazz.getFields();
        for(Field field :fields){
            if(String.class==field.getType()){
                try {
                    String oldValue = (String)field.get(source);
                    String newValue = oldValue.replace('a','b');
                    field.set(source,newValue);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("source = " + source + "");
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field field :declaredFields){
            if(String.class==field.getType()){
                try {
                    int modifiers = field.getModifiers();
                    if(Modifier.isPrivate(modifiers)){
                        //不执行以下代码则会抛出IllegalAccessException 异常
                        field.setAccessible(true);
                    }
                    String oldValue = (String)field.get(source);
                    String newValue = oldValue.replace('a','b');
                    field.set(source,newValue);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("source = " + source + "");
    }

}

class SourceStr {

    public String a = "aaa";
    public String b = "bbb";
    public String c = "ccc";

    private String d="aaa";

    String e="aaa";

    protected String f="aaa";

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("a", a)
                .append("b", b)
                .append("c", c)
                .append("d", d)
                .append("e", e)
                .append("f", f)
                .toString();
    }
}