package lab07;

/* BankAccount

 * A bank account has a balance and an interest rate.
 * (note - in real life, NEVER use floating point numbers
 * to represent currency - use a specialized data type like
 * Java's BigDecimal instead.
 *
 * The rules of bank accounts:
 *
 *  Interest rates and balances can never be negative
 *  Accounts are either open or closed - if they're open,
 *  they can be closed if they have < 1 cent left in them.
 *  Attempting to close an account with >= 1 cent should
 *  throw an IllegalStateException.
 *
 */

public class BankAccount {

    private float balance;
    private float interestRate;
    private boolean open;

    public BankAccount() {
        this(0, 0);
    }

    public BankAccount(float balance, float interestRate) throws IllegalArgumentException{
        if(balance <= 0) throw new IllegalArgumentException();
        if(interestRate <= 0) throw new IllegalArgumentException();
        this.balance = balance;
        this.interestRate = interestRate;
        this.open = true;
        assert invariant() : "State remains the same";
    }

    public float getBalance() {
        return this.balance;
    }

    public void setBalance(float newBalance) {
        this.balance = newBalance;
    }

    public float getInterestRate() { return this.interestRate; }

    public void setInterestRate(float newInterestRate) {
        this.interestRate = newInterestRate;
    }

    public void applyInterest() throws IllegalArgumentException{
        if(this.balance <= 0) throw new IllegalArgumentException();
        if(this.calculateInterest() <= 0) throw new IllegalArgumentException();
        float oldBalance = this.balance;
        float newInterest = this.calculateInterest();
        this.setBalance(oldBalance + newInterest);
        assert this.balance > oldBalance : "Interest not applied";
    }

    // Private methods can't have exceptions
    private float calculateInterest(){
        assert this.balance <= 0 : "Balance needs to be positive";
        assert this.interestRate <= 0 : "Interest Rate needs to be positive";
        return this.balance * this.interestRate;
    }

    // invariant applied if the state doesn't changes
    private boolean invariant() throws IllegalStateException{
        if (this.balance <= 0) return false;
        if (this.interestRate <= 0) return false;
        if (!this.open) {
            if(this.balance >= 1) {
                throw new IllegalStateException();
            }
        }
        return true;
    }

    public void close() {
        if (!this.open) return;
        this.open = false;
    }
}
