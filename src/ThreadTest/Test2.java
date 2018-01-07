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
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true) {
                    new Test2().add();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true){
                    new Test2().minus();
                    while (count <= 10){
                        continue;
                    }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
            }
        };
        t2.start();
    }
}
