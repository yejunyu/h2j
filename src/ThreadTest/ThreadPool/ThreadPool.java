package ThreadTest.ThreadPool;

import java.util.LinkedList;

/**
 * @author yejunyu
 * @date 18-2-28.
 */
public class ThreadPool {
    // 线程池大小
    int threadPoolSize;
    // 任务容器
    LinkedList<Runnable> tasks = new LinkedList<>();

    // 创建消费者线程
    class TaskConsumerThread extends Thread{
        Runnable task;
        public TaskConsumerThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            System.out.println("启动: "+this.getName());
            while (true){
                synchronized (tasks){
                    while (tasks.isEmpty()){
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task = tasks.pop();
                    tasks.notifyAll();
                }
                System.out.println(this.getName()+"得到任务,执行...");
                task.run();
            }
        }
    }

    public void add(Runnable r){
        synchronized (tasks){
            tasks.add(r);
            tasks.notifyAll();
        }
    }
    public ThreadPool() {
        threadPoolSize = 10;
        // 启动线程
        synchronized (tasks){
            for (int i = 0; i < threadPoolSize; i++) {
                new TaskConsumerThread("任务消费者线程 "+i).start();
            }
        }
    }
}
