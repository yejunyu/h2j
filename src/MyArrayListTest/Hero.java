package MyArrayListTest;

/**
 * @author yejunyu
 * @date 2017/12/22.
 */
public class Hero {
    private String name;

    public Hero(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}