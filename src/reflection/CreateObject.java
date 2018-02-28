package reflection;

import ThreadTest.Hero;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yejunyu
 * @date 18-2-28.
 */
public class CreateObject {
    public static void main(String[] args) {
        String className = "ThreadTest.Hero";
        try {
            Class pClass = Class.forName(className);
            Constructor c = pClass.getConstructor();
            Hero h = (Hero) c.newInstance();
            h.name = "yy";
            // 用反射获取属性
            Field f1 = h.getClass().getDeclaredField("name");
            f1.set(h,"bbb");
            System.out.println(h.name);
            // 调用方法
            Method m1 = h.getClass().getMethod("toString");
            String msg = (String) m1.invoke(h);
            System.out.println(msg);
            Method m2 = h.getClass().getMethod("setName",String.class);
            m2.invoke(h,"yy");
            System.out.println(h.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
