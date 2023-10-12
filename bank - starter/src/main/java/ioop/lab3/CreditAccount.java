package ioop.lab3;

public class CreditAccount extends BankAccount {
    private double overdraft;

    public CreditAccount(String bank, String accountHolderName, String accountHolderTitle, double balance, double overdraft) {
        super(bank, accountHolderName, accountHolderTitle, balance);
        if(overdraft<0.0){
            this.overdraft = 0.0;
        }
        else{
            this.overdraft = overdraft;
        }
        //TODO Auto-generated constructor stub
    }
    public double getOverdraft(){
        return this.overdraft;
    }
    @Override
    public double processTransaction(char type, double amount){
        double allowance = getOverdraft()*-1;
        if(type=='d' && (super.getBalance()-amount)>=allowance ){
            return super.processTransaction(type, amount);
        }
        else{
            System.out.println("Transaction declined - overdraft limit reached");
            return super.processTransaction('f', amount);
        }
    }
    
}
