package ThreadTest;

/**
 * @author yejunyu
 * @date 2018/1/7.
 */
public class Test2 {
    static int count = 20;
    public void add(){
        count++;
        System.out.println("add "+count);
    }
    public  void minus(){
        count--;
        System.out.println("minus "+count);
    }
    public static void main(String[] args) {
        /**
         * wait notify
         */
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 61;

        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true) {
                    gareen.hurt();
                    System.out.printf("t1 为%s 减血1点,减少血后，%s的血量是%.0f%n", gareen.name, gareen.name, gareen.hp);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true) {
                    gareen.recover();
                    System.out.printf("t2 为%s 回血1点,增加血后，%s的血量是%.0f%n", gareen.name, gareen.name, gareen.hp);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
