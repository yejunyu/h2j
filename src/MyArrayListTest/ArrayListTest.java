package MyArrayListTest;

import java.util.ArrayList;

/**
 * @author yejunyu
 * @date 2017/12/22.
 */
public class ArrayListTest {
    public static void main(String[] args) {
        /**
         * 如果就是要判断集合里是否存在一个 name等于 "hero 1"的对象，应该怎么做？
         */
        ArrayList<Hero> Heros = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Heros.add(new Hero("hero"+i));
        }

    }
}
