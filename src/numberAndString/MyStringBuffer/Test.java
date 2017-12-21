package numberAndString.MyStringBuffer;

import myException.IndexIsNegativeException;
import myException.IndexIsOutofRangeException;

/**
 * @author yejunyu
 * @date 2017/12/17.
 */
public class Test {
    public static void main(String[] args) {

        MyStringBuffer a = new MyStringBuffer();
        MyStringBuffer b = new MyStringBuffer("1234567890");
        try {
            // 无参构造
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
        } catch (IndexIsNegativeException e) {
            e.printStackTrace();
        } catch (IndexIsOutofRangeException e) {
            e.printStackTrace();
        }



        try {
           MyStringBuffer c = new MyStringBuffer("a");
//           c.insert(-1,"a");
           c.insert(4,"a");
        } catch (IndexIsNegativeException e) {
            e.printStackTrace();
        } catch (IndexIsOutofRangeException e) {
            e.printStackTrace();
        }

    }
}
