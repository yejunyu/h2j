package ThreadTest.ThreadPool;

/**
 * @author yejunyu
 * @date 18-2-28.
 */
public class test {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();

        int sleep = 1000;
        for (int i = 0; i < 20; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务");
                }
            };
            threadPool.add(task);
            try {
                Thread.sleep(sleep);
                sleep = sleep>100?sleep-i*100:100;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
