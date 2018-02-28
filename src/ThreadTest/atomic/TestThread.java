package ThreadTest.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yejunyu
 * @date 18-2-28.
 */
public class TestThread {
    public static void main(String[] args) {
        AtomicInteger atomicI = new AtomicInteger();
        int i = atomicI.decrementAndGet();
        int j = atomicI.incrementAndGet();
        int k = atomicI.addAndGet(3);
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);

    }
}
