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

    static class MyStack<T> {
        Stack<Character> values = new Stack<Character>();

        public synchronized void push(T t){
            while (values.size()>10){
                System.out.println("满了");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.notifyAll();
            values.push((Character) t);
        }

        public synchronized Character pop(){
            while (values.empty()){
                System.out.println("空了");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.notifyAll();
            return values.pop();
        }
    }
    public static Character randomABC(){
        Random r = new Random();
        int a = r.nextInt(26) + 65;
        return (char) a;
    }
    static class Producer implements Runnable{
        private MyStack<Character> myStack;
        private String name;

        public Producer(MyStack<Character> myStack,String name) {
            this.myStack = myStack;
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                Character c = randomABC();
                myStack.push(c);
                System.out.println(name + " push :" + c);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class Consumer implements Runnable{
        private MyStack<Character> myStack;
        private String name;

        public Consumer(MyStack<Character> myStack, String name) {
            this.myStack = myStack;
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                Character c = myStack.pop();
                System.out.println(name + " pop :" + c);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        MyStack<Character> myStack = new MyStack<>();
        for (int i = 0; i < 3; i++) {
            Producer producer = new Producer(myStack,"producer"+i);
            new Thread(producer).start();
        }
        for (int i = 0; i < 3; i++) {
            Consumer consumer = new Consumer(myStack,"consumer"+i);
            new Thread(consumer).start();
        }
    }
}
