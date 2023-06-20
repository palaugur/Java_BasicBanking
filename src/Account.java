public class Account {
    String accountName;
    private int balance;

    public static String accNameGenerator(){

        return Integer.toString((int)(Math.random()*9000+1000));

    }
    public int showFund(){
        return balance;
    }
    public void depositMoney(int depositM) {
        if (depositM >0) {
            balance += depositM;

            System.out.println("Deposit Amount: " + depositM + " $");
            System.out.println("Last Balance: " + balance + " $");
        } else{
            System.out.println("Invalid Value!");
        }
    }
    public void withdrawMoney(int withdrawM) {
        if (balance >= withdrawM ) {
            balance -= withdrawM;

            System.out.println("Withdrawn Amount: " + withdrawM + " $");
            System.out.println("Last Balance: " + balance + " $");
        } else{
            System.out.println("Low Balance!");
        }
    }
}
