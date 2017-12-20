package numberAndString.MyStringBuffer;

import java.util.Arrays;

/**
 * @author yejunyu
 * @date 2017/12/17.
 */
public class Test {
    public static void main(String[] args) {
        // 无参构造
        MyStringBuffer a = new MyStringBuffer();
        a.append("a");
        System.out.println(a);
        a.append('b');
        System.out.println(a);
        a.insert(0,'c');
        System.out.println(a);
        a.insert(3,"d");
        System.out.println(a);
        a.delete(3);
        System.out.println(a);
        a.delete(1,2);
        System.out.println(a);
        a.reverse();
        System.out.println(a);
        System.out.println(a.length());
        // 有参构造
        MyStringBuffer b = new MyStringBuffer("1234567890");
        b.append("a");
        System.out.println(b);
        b.append('b');
        System.out.println(b);
        b.insert(0,'c');
        System.out.println(b);
        b.insert(3,"d");
        System.out.println(b);
        b.delete(3);
        System.out.println(b);
        b.delete(1,2);
        System.out.println(b);
        b.reverse();
        System.out.println(b);
        System.out.println(b.length());
    }
}
