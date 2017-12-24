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
        // 头插法
        heroes.addFirst(new Hero("hero1"));
        // 尾插法
        heroes.addLast(new Hero("hero2"));
        System.out.println(heroes);
        heroes.addFirst(new Hero("hero3"));
        System.out.println(heroes);
        System.out.println(heroes.getFirst());
        System.out.println(heroes.getLast());
        System.out.println(heroes);
        // 从头部移除
        heroes.removeFirst();
        System.out.println(heroes);
        // 从尾部移除
        heroes.removeLast();
        System.out.println(heroes);

        // 队列
        Queue<Hero> heroes1 = new LinkedList<>();
        heroes1.offer(new Hero("hero1"));
        heroes1.add(new Hero("hero2"));
        // 取出第一个
        Hero h = heroes1.poll();
        System.out.println(h);
        // 只看不取
        h =  heroes1.peek();
        System.out.println(h);
        System.out.println(heroes1);
        // 往队列添加元素
        heroes1.offer(new Hero("hero3"));
        System.out.println(heroes1);
    }
}
