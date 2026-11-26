public class BankAccount {
    private int balance = 1000;

    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public int getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.withdraw(300);
        account.withdraw(900);
        System.out.println(account.getBalance());
    }
}
