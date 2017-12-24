package MyArrayListTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yejunyu
 * @date 2017/12/24.
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Hero> heroes = new LinkedList<>();
        heroes.addFirst(new Hero("hero1"));
        heroes.addLast(new Hero("hero2"));
        System.out.println(heroes);
        heroes.addFirst(new Hero("hero3"));
        System.out.println(heroes);
        System.out.println(heroes.getFirst());
        System.out.println(heroes.getLast());
        System.out.println(heroes);
        heroes.removeFirst();
        System.out.println(heroes);
        heroes.removeLast();
        System.out.println(heroes);
        List<Hero> heroes1 = new LinkedList<>();

    }
}
