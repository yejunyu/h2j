package ThreadTest;

import java.util.Random;
import java.util.Stack;

/**
 * @author yejunyu
 * @date 18-2-26.
 */
public class ProducerAndConsumer {
    /**
     * 生产者消费者问题是一个非常典型性的线程交互的问题。
     1. 使用栈来存放数据
     1.1 把栈改造为支持线程安全
     1.2 把栈的边界操作进行处理，当栈里的数据是0的时候，访问pull的线程就会等待。 当栈里的数据时200的时候，访问push的线程就会等待
     2. 提供一个生产者（Producer）线程类，生产随机大写字符压入到堆栈
     3. 提供一个消费者（Consumer）线程类，从堆栈中弹出字符并打印到控制台
     例:
     弹出: C
     弹入: F
     弹出: F
     弹入: X
     */
    private static Stack<String> myStack;

    public static Character randomABC(){
        Random r = new Random();
        int a = r.nextInt(26) + 65;
        return (char) a;
    }
    public synchronized void push(char a){
        if(myStack.size() > 10){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        myStack.push(String.valueOf(a));
    }
    public synchronized String pop(){
        if (myStack.size() > 0){
            return myStack.pop();
        }
        return null;
    }
    class Producer implements Runnable{

        @Override
        public void run() {

        }
    }
    class Consumer implements Runnable{

        @Override
        public void run() {

        }
    }
    public static void main(String[] args) {
        System.out.println(randomABC());
    }
}
