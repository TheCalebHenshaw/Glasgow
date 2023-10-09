package ioop.lab3;

public class Bank {
    private BankAccount[] bankAccounts = new BankAccount[5];

    public Bank() {
        bankAccounts[0] = new BankAccount("Batwest", "Jo Smith", "Mr", 0);
        bankAccounts[1] = new BankAccount("Batwest", "Jo Smith", "Mrs", 0);
        bankAccounts[2] = new BankAccount("Batwest", "Jo Smith", "Dr", 0);
        bankAccounts[3] = new BankAccount("Boyds", "Jo Smith", "Dr", 0);
        bankAccounts[4] = new BankAccount("Batwest", "John Smith", "Mr", 0);
    }



    public void addBankAccount(BankAccount newAccount) {
        BankAccount[] newBankAccounts = new BankAccount[bankAccounts.length + 1];
        
        bankAccounts = newBankAccounts;
        bankAccounts[bankAccounts.length+1] = newAccount;
    }


    public int findIndexOfAccount(BankAccount accountToFind)  //Find a bank account based on name, title, and bank
                                                            // checkBank, checkName(String name), 
    {
        int index = 0; 
        for(BankAccount acc : bankAccounts){
            if(acc.checkBank(accountToFind.getBank()) && accountToFind.checkName(acc.getAccountHolderName()) && acc.checkTitle(accountToFind.getAccountHolderTitle()) ){
                return index;
            }
            else{
                index++;
            }
            
        }
        return -1;
    }

    public void removeBankAccount(BankAccount removeAccount)
    {
        BankAccount[] newBankAccounts = new BankAccount[bankAccounts.length -1];
        int removeIndex = findIndexOfAccount(removeAccount);
        for(int i = 0; i<bankAccounts.length;i++){
            if(i==removeIndex){
                i++;
            }
            else{
                newBankAccounts[i] = bankAccounts[i];
            }
        }
        bankAccounts = newBankAccounts;
    }

    public void handleTransaction(BankAccount target, double amount, char type)
    {
        target.processTransaction(type, amount);
    }

    public BankAccount[] getBankAccounts() {
        return bankAccounts;
    }
}
