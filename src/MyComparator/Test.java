package MyComparator;

import MyArrayListTest.Hero;

import java.util.*;

/**
 * @author yejunyu
 * @date 2017/12/29.
 */
public class Test {
    public static void main(String[] args) {
        Comparator<Hero> comparator = new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                if (o1.getHP() > o2.getHP()){
                    return 1;
                }else {
                    return -1;
                }
            }
        };
        Random r = new Random();
        List<Hero> heroes = new ArrayList<>(10);
        TreeSet<Hero> heroes1 = new TreeSet<>(comparator);
        for (int i = 0; i < 10; i++) {
            Hero hero = new Hero("hero"+i, r.nextInt(1000));
            heroes.add(hero);
            heroes1.add(hero);
        }
        System.out.println(heroes);
        heroes.sort((h1,h2)->(h1.getHP()>=h2.getHP()?1:-1));
        System.out.println(heroes);
        System.out.println(heroes1);
    }
}
