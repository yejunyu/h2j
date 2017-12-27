package bTree;

import MyArrayListTest.Hero;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yejunyu
 * @date 2017/12/27.
 */
public class HeroNode {

    HeroNode leftNode;

    HeroNode rightNode;

    Hero value;

    public void add(Hero v){
        if (null == value){
            value = v;
        } else {
            if (v.getHP() <= value.getHP()){
                if (null == leftNode){
                    leftNode = new HeroNode();
                }
                leftNode.add(v);
            } else {
                if (null == rightNode){
                    rightNode = new HeroNode();
                }
                rightNode.add(v);
            }
        }
    }

    public List<Hero> values(){
        List<Hero> heroes = new ArrayList<>();
        if (null != leftNode){
            heroes.addAll(leftNode.values());
        }
        heroes.add(value);
        if (null != rightNode){
            heroes.addAll(rightNode.values());
        }
        return heroes;
    }

    public static void main(String[] args) {
        /**
         * 可以向这个英雄二叉树插入不同的Hero对象，并且按照Hero的血量倒排序。
         随机生成10个Hero对象，每个Hero对象都有不同的血量值，插入这个HeroNode后，把排序结果打印出来。
         */
        HeroNode root = new HeroNode();
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Hero hero = new Hero("hero"+i, (int)(Math.random()*1000));
            heroes.add(hero);
        }
        System.out.println(heroes);
        for (int i = 0; i < 10; i++) {
            root.add(heroes.get(i));
        }
        System.out.println(root.values());
    }
}
