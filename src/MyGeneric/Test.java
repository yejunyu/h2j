package MyGeneric;

import MyArrayListTest.Hero;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author yejunyu
 * @date 2017/12/23.
 */
public class Test {
    static void test(){
        /**
         * 首先初始化一个Hero集合，里面放100个Hero对象，名称分别是从
         hero 0
         hero 1
         hero 2
         ...
         hero 99.

         通过遍历的手段，删除掉名字编号是7的倍数和带7的对象
         */
        // 方法1
        List<Hero> Heros = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Heros.add(new Hero("hero"+i));
        }
        for (int i = 1; i < Heros.size(); i++) {
            String num = Heros.get(i).getName().substring(4);
            if (num.contains("7") || Integer.valueOf(num) % 7 == 0){
                // 一定要减减,因为删除元素的时候索引变了,比如27,28,就会出问题
                Heros.remove(i--);
            }
        }
        System.out.println(Heros);

        // 方法2
        List<Hero> Heros1 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Heros1.add(new Hero("hero"+i));
        }
        // 准备一个 List 存放要删除的元素
        List<Hero> delHeros = new ArrayList<>();
        for (Hero delHero : Heros1) {
            String num = delHero.getName().substring(4);
            if (num.contains("7") || Integer.valueOf(num) % 7 == 0) {
                delHeros.add(delHero);
            }
        }
        System.out.println(delHeros);
        for (Hero delHero : delHeros) {
           Heros1.remove(delHero);
        }
        System.out.println(Heros1);
        // removeAll
//        Heros1.removeAll(delHeros);
//        System.out.println(Heros1);
    }
    public static void main(String[] args) {
        /**
         * List 遍历
         */
        // 迭代器
        List<Hero> Heros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Heros.add(new Hero("hero" + i));
        }
        // Iterator 第一种写法
        Iterator<Hero> Hero = Heros.iterator();
        while (Hero.hasNext()) {
            Hero a = Hero.next();
            System.out.println(a);
        }

        // Iterator 第一种写法
        for (Iterator<Hero> Hero1 = Heros.iterator(); Hero1.hasNext(); ) {
            Hero b = Hero1.next();
            System.out.println(b);
        }

        // foreach
        for (MyArrayListTest.Hero hero : Heros) {
            System.out.println(hero);
        }

        test();
    }
}
