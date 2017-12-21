package myException.exceptionExercise2;

import myException.exceptionExercise.Account;
import myException.exceptionExercise.OverdraftExcetpion;

/**
 * @author yejunyu
 * @date 2017/12/21.
 */
public class CheckingAccount extends Account{
    /**
     * 类： CheckingAccount 支票账户，具备透支额度，继承Account
     属性：overdraftProtection 透支额度
     */
    private Double overdraftProtection;

    public CheckingAccount(Double balance, Double overdraftProtection) {
        super(balance);
        this.overdraftProtection = overdraftProtection;
    }

    public Double getOverdraftProtection() {
        return overdraftProtection;
    }

    public void setOverdraftProtection(Double overdraftProtection) {
        this.overdraftProtection = overdraftProtection;
    }

    @Override
    public void withdraw(Double balance) throws OverdraftExcetpion {
        if (balance > (this.getBalance()+overdraftProtection)){
            double deflict = balance - (this.getBalance() + overdraftProtection);
            throw new OverdraftExcetpion("余额不足:",deflict);
        }
        if (balance < this.getBalance()){
            super.withdraw(balance);
        }
        if (balance > this.getBalance()){
            super.withdraw(this.getBalance());
            overdraftProtection = overdraftProtection - (balance - this.getBalance());
        }
    }

    public static void main(String[] args) {
        CheckingAccount me = new CheckingAccount(100.00,1000.00);
        me.deposit(100.00);
        try {
            me.withdraw(50.00);
            me.withdraw(100.0);
            me.withdraw(1000.0);
        } catch (OverdraftExcetpion overdraftExcetpion) {
            overdraftExcetpion.printStackTrace();
        }
    }
}
