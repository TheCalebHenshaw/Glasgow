package ioop.lab3;

public class AccountManagement {
    private static String bankLine = "| Bank: ";
    private static String accountHolderLine = "| Account Holder: ";
    private static String balanceLine = "| Balance: ";
    

    public static void printFormattedAccount(BankAccount account) {
        bankLine+=account.getBank();
        accountHolderLine+=account.getAccountHolderTitle() + " "
                + account.getAccountHolderName();
        balanceLine+= account.getBalance();
        int maxLength = Math.max(bankLine.length(), Math.max(accountHolderLine.length(), balanceLine.length()));
        int separatorLength = maxLength + 4;
        int barPosition = separatorLength;
        String separator = "+" + "-".repeat(separatorLength - 2) + "+";
        bankLine = padLine(bankLine, barPosition);
        accountHolderLine = padLine(accountHolderLine, barPosition);
        balanceLine = padLine(balanceLine, barPosition);
        System.out.println(separator);
        System.out.println(bankLine);
        System.out.println(separator);
        System.out.println(accountHolderLine);
        System.out.println(separator);
        System.out.println(balanceLine);
        System.out.println(separator);
    }

    private static String padLine(String line, int barPosition) {
        StringBuilder paddedLine = new StringBuilder(line);
        while (paddedLine.length() < barPosition - 1) {
            paddedLine.append(" ");
        }
        return paddedLine.toString() + "|";
    }
    public static boolean fraudDetected(BankAccount suspiciousAccount, double amount){
        if(amount > suspiciousAccount.getHighestStoredAmount()*0.5){
            return true;
        }
        return false;
    }

}
