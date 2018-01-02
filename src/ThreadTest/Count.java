package ThreadTest;

/**
 * @author yejunyu
 * @date 2018/1/2.
 */
public class Count extends Thread{
    int count = 0;

    private void count(){
        System.out.println(count);
        count++;
    }

    @Override
    public void run(){
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count();
        }
    }
}
