package myException.exceptionExercise;

/**
 * @author yejunyu
 * @date 2017/12/21.
 */
public class Account {
    /**
     * Account类： 银行账号
     属性： balance 余额
     方法： getBalance() 获取余额
     方法： deposit() 存钱
     方法： withdraw() 取钱
     OverdraftExcetpion： 透支异常，继承Exception
     属性： deficit 透支额
     */
    private Double balance = Double.valueOf(0);

    public Account(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public void deposit(Double balance) {
        this.balance += balance;
        System.out.printf("您存了 %.2f 元%n 当前余额为 %.2f 元%n",balance,this.balance);
    }

    public void withdraw(Double balance) throws OverdraftExcetpion {
        if (balance > this.balance){
            throw new OverdraftExcetpion("余额不足:",balance-this.balance);
        }
        this.balance -= balance;
        System.out.printf("您取了 %.2f 元%n 当前余额为 %.2f 元%n",balance,this.balance);
    }

    public static void main(String[] args) {
        Account me = new Account((double) 10);
        me.deposit( 1000.00);
        try {
            me.withdraw( 100.00);
            me.withdraw((double) 901);
        } catch (OverdraftExcetpion overdraftExcetpion) {
            overdraftExcetpion.printStackTrace();
        }

    }
}
