package ThreadTest;

/**
 * @author yejunyu
 * @date 18-1-3.
 */
public class Test1 {
    static int count = 1000;
    public void add(){
        count++;
    }
    public void minus(){
        count--;
    }
    public static void main(String[] args) {
        /**
         * 线程安全
         */
        final Object object = new Object();
        int n = 1000;
        Thread[] addThread = new Thread[n];
        Thread[] minusThread = new Thread[n];
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    try {
                        synchronized (object) {
                            new Test1().add();
                        }
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThread[i] = t;
        }

        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    try {
                        synchronized (object) {
                            new Test1().minus();
                        }
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            minusThread[i] = t;
        }

        for (Thread thread : addThread) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Thread thread : addThread) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("count值为:"+count);
    }
}
