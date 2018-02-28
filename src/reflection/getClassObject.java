package reflection;

import ThreadTest.Hero;

/**
 * @author yejunyu
 * @date 18-2-28.
 */
public class getClassObject {
    public static void main(String[] args) {
        try {
            Class pclass1 = Class.forName("ThreadTest.Hero");
            Class pclass2 = new Hero().getClass();
            Class pclass3 = Hero.class;
            System.out.println(pclass1 == pclass2);
            System.out.println(pclass2 == pclass3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
