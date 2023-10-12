package ioop.lab3;

public class BankAccount {
    private String bank;
    private String accountHolderName;
    private String accountHolderTitle;
    protected double balance;  //check this is correct (default maybe?)
    protected double HighestStoredAmount;

    public BankAccount(String bank, String accountHolderName, String accountHolderTitle, double balance) {
        this.bank = bank;
        this.accountHolderTitle = accountHolderTitle;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.HighestStoredAmount = (balance > 0) ? balance : 0;


    }

    public double processTransaction(char type, double amount) {
        switch (type) {
            case 'c':
                balance += amount;
                System.out.println("Credited:£" + amount);
                System.out.println("Account balance: £" + balance);
                break;
            case 'd':
                balance -= amount;
                System.out.println("Debited:£" + amount);
                System.out.println("Account balance: £" + balance);
                break;
            case 'f':
                System.out.println("Account has been flagged so no action taken.");
                System.out.println("Account balance: £" + balance);
                break;
        }
        updateHighestStoredAmount();
        return balance;
    }

    public boolean checkBank(String bankToCheck) {
        return bank.equals(bankToCheck);
    }

    public boolean checkTitle(String titleToCheck) {
        return accountHolderTitle.toLowerCase().equals(titleToCheck.toLowerCase());
    }

    public boolean checkTwoNames() {
        String[] names = accountHolderName.split(" ");
        return (names.length == 2);
    }

    public boolean checkName(String name) {
        String[] splitCompare = name.toLowerCase().split(" ");
        String[] splitAccount = accountHolderName.toLowerCase().split(" ");

        if (!splitCompare[1].equals(splitAccount[1])) {
            return false;
        }
        if (!splitCompare[0].equals(splitAccount[0])) {
            if (splitCompare[0].charAt(0) != splitAccount[0].charAt(0)) {
                return false;
            }
            if (splitCompare[0].length() != 1) {
                return false;
            }
        }
        return true;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccountHolderTitle() {
        return accountHolderTitle;
    }

    public void setAccountHolderTitle(String accountHolderTitle) {
        this.accountHolderTitle = accountHolderTitle;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getHighestStoredAmount() {
        return HighestStoredAmount;
    }

    public void updateHighestStoredAmount(){
        if(balance>HighestStoredAmount){
            HighestStoredAmount = balance;
        }
    }
    public static void main(String[] args) {
        BankAccount accountOne = new BankAccount("Batwest", "Bruce Wayne", "Mr", 1000);
        BankAccount accountTwo = new BankAccount("Natwest", "DONT REMOVED", "Mr", 0);
        DebitAccount accountThree = new DebitAccount("BatBank", "Cousin Ricky", "Mr", 200);
        ChildrensAccount accountFour = new ChildrensAccount("CrapBank", "Sharquisha Rigg", "Mrs", 200, 1000);
        CreditAccount accountFive = new CreditAccount("CrapBank", "Caleb Henshaw","Mr", 200, 500);


        AccountManagement.printFormattedAccount(accountTwo);
        AccountManagement.printFormattedAccount(accountFive);
        AccountManagement.printFormattedAccount(accountFour);

    }
}
