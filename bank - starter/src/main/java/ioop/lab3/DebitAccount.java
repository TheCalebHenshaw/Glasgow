package ioop.lab3;

public class DebitAccount extends BankAccount {

    public DebitAccount(String bank, String accountHolderName, String accountHolderTitle, double balance) {
        super(bank, accountHolderName, accountHolderTitle, balance);
    }

    public double processTransaction(char type, double amount) {
        if(type=='d' && amount > super.getBalance()){
            return super.processTransaction('f', amount);
        }
        return super.processTransaction(type, amount);
    }

}
