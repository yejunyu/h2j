package ThreadTest;

/**
 * @author yejunyu
 * @date 2018/1/2.
 */
public class Count1 implements Runnable{
    int count = 0;

    private void count(){
        System.out.println(count);
        count++;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            count();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
