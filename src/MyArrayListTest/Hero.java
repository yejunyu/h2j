package MyArrayListTest;

/**
 * @author yejunyu
 * @date 2017/12/22.
 */
public class Hero {
    private String name;

    private double HP;

    public Hero(String name) {
        this.name = name;
    }

    public Hero(String name, double HP) {
        this.name = name;
        this.HP = HP;
    }

    @Override
    public String toString() {
        return name+","+HP+"\t";
    }

    public String getName() {
        return name;
    }

    public double getHP() {
        return HP;
    }

    public void setHP(double HP) {
        this.HP = HP;
    }

    public void setName(String name) {
        this.name = name;
    }
}
