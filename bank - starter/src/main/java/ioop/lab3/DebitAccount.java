package ioop.lab3;

public class DebitAccount extends BankAccount {

    public DebitAccount(String bank, String accountHolderName, String accountHolderTitle, double balance) {
        super(bank, accountHolderName, accountHolderTitle, balance);
    }
    @Override
    public double processTransaction(char type, double amount) {
        if(type=='d' && amount > getBalance()){
            System.out.println("Changes in funds have been refused : insufficient funds");
            return super.processTransaction('f', amount);
        }
        return super.processTransaction(type, amount);
    }

}
