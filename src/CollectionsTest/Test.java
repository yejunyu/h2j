package CollectionsTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yejunyu
 * @date 17-12-28.
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        System.out.println("翻转前");
        System.out.println(numbers);
        System.out.println("翻转后");
        Collections.reverse(numbers);
        System.out.println(numbers);
        System.out.println("重组数组");
        Collections.shuffle(numbers);
        System.out.println(numbers);
        System.out.println("排序");
        Collections.sort(numbers);
        System.out.println(numbers);
        System.out.println("交换下标位置");
        Collections.swap(numbers,0,8);
        System.out.println(numbers);
        System.out.println("数组向右滚动");
        Collections.rotate(numbers,2);
        System.out.println(numbers);
        System.out.println("线程安全");
        List<Integer> synchronizedNumbers = Collections.synchronizedList(numbers);
    }
}
