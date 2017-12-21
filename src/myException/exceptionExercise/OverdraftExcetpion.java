package myException.exceptionExercise;

/**
 * @author yejunyu
 * @date 2017/12/21.
 */
public class OverdraftExcetpion extends Exception {
    private Double deficit = Double.valueOf(0);

    public Double getDeficit() {
        return deficit;
    }

    public OverdraftExcetpion(String message, Double deficit) {
        super(message+" 透支了"+deficit);
        this.deficit = deficit;
    }


}
