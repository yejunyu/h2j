package ThreadTest.deadLock;

import ThreadTest.Hero;

/**
 * @author yejunyu
 * @date 2018/2/25.
 */
public class DeadLock {
    public static void main(String[] args) {
        Hero a = new Hero();
        a.name = "a";
        Hero b = new Hero();
        b.name = "b";

        Thread t1 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("占有 a");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("等待 b");
                    synchronized (b){
                        System.out.println("让 b 做 something");
                    }
                }
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                synchronized (b){
                    System.out.println("占有 b");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("等待 a");
                    synchronized (a){
                        System.out.println("让 a 做 something");
                    }
                }
            }
        };
        t2.start();
    }
}
