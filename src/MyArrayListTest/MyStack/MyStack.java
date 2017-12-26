package MyArrayListTest.MyStack;

import MyArrayListTest.Hero;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author yejunyu
 * @date 2017/12/25.
 */
public class MyStack implements Stackk{

    LinkedList<Hero> values;

    public MyStack() {
        values = new LinkedList<>();
    }

    @Override
    public String toString() {
        StringBuilder StringBuilder = new StringBuilder();
        for (Hero value : values) {
            StringBuilder.append(value);
            StringBuilder.append("\t");
        }
        return StringBuilder.toString();
    }

    @Override
    public void push(Hero h) {
        values.offer(h);
    }

    @Override
    public Hero pop() {
        return values.removeLast();
    }

    @Override
    public Hero peek() {
        return values.getLast();
    }


    public static void main(String[] args) {
        MyStack MyStack = new MyStack();
        MyStack.push(new Hero("hero1"));
        MyStack.push(new Hero("hero2"));
        MyStack.push(new Hero("hero3"));
        MyStack.push(new Hero("hero4"));
        System.out.println(MyStack.peek());
        System.out.println(MyStack.pop());
        System.out.println(MyStack);
    }
}
