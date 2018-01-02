package ThreadTest;


/**
 * @author yejunyu
 * @date 2018/1/2.
 */
public class Test {
    int count = 0;

    public void count(){
        System.out.println(count);
        count++;
    }
    public static void main(String[] args) {
        // 继承Thread类
//        Count c1 = new Count();
//        Count c2 = new Count();
//        c1.start();
//        c2.start();

        // 实现 runnable 接口,借助线程对象来运行 run 方法
        Count1 c3 = new Count1();
        Count1 c4 = new Count1();
        new Thread(c3).start();
        new Thread(c4).start();

        // 匿名类
        Thread t1 = new Thread(){
            @Override
            public void run() {
                new Test().count();
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                new Test().count();
            }
        };
        t1.start();
        t2.start();
    }
}
