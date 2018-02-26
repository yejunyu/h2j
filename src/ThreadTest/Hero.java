package ThreadTest;

/**
 * @author yejunyu
 * @date 2018/1/8.
 */
public class Hero {
    public String name;
    public float hp;

    public int damage;

    public synchronized void recover(){
        hp = hp + 1;
        if (hp >= 60){
            this.notify();
        }
    }

    public synchronized void hurt(){
        if (hp <= 10){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp = hp - 1;
    }

    public void attackHero(Hero h){
        h.hp -= damage;
        System.out.printf("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
        if (h.isDead()){
            System.out.println(h.name + "死了!");
        }
    }

    public boolean isDead(){
        return 0>=hp?true:false;
    }
}
