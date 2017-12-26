package MyArrayListTest.MyStack;

import MyArrayListTest.Hero;

/**
 * @author yejunyu
 * @date 2017/12/25.
 */
public interface Stackk {
    /**
     * 把英雄推入到最后位置
     * @param h
     */
    public void push(Hero h);

    /**
     * 把最后一个英雄取出来
     * @return
     */
    public Hero pop();

    /**
     * 查看最后一个英雄
     * @return
     */
    public Hero peek();
}
