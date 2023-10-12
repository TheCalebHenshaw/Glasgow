package ioop.lab3;

public class ChildrensAccount extends DebitAccount {
    private double maximumAmount;
    
    public ChildrensAccount(String bank, String accountHolderName,String accountHolderTitle, double balance, double maximumAmount){
        super(bank, accountHolderName, accountHolderTitle, balance);
        this.maximumAmount = maximumAmount;
    }
    @Override
    public double processTransaction(char type, double amount){
        if(type=='c' && balance+amount>maximumAmount){
            return super.processTransaction('f',amount);
        }
        else{
            return super.processTransaction(type, amount);
        }
    }
}

