import java.util.ArrayList;
import java.util.Scanner;


public class Customer {
    String name;
    String password;
    ArrayList<Account> accountList = new ArrayList<>();

    public void addClient() {
        Scanner sc = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);

        System.out.println("******************************");
        System.out.print("Enter Client Name: ");
        name = sc.nextLine();

        System.out.println("******************************");
        while(true){
            System.out.print("Enter Client Password: ");
            password = sc.next();

            if(password.length() < 8 ){
                System.out.println("Your password is not secure! Try again...");
            } else{
                System.out.println("Your password has been successfully saved.");
                break;
            }
        }
        System.out.println("******************************");
        System.out.print("How many accounts do you want to open:  ");
        int hesapSayisi = scInt.nextInt();

        for(int i = 0; i< hesapSayisi; i++ ) {
            Account account = new Account();
            System.out.println("******************************");
            System.out.print("Your Account Number:  ******");
            account.accountName = Account.accNameGenerator();
            System.out.println(account.accountName + "******");

            System.out.print("Deposit for account opening: ");
            int money = scInt.nextInt();
            account.depositMoney(money);

            accountList.add(account);
        }
    }

    public boolean confirmLogin(String choosenAccount, String password){
        return name.equals(choosenAccount) && this.password.equals(password);
    }
    public void customerInfo() {
        System.out.println("Client Name: " + name);
        System.out.println("Client Accounts: ");
        for (Account a: accountList) {
            System.out.println("* Balance of "+ a.accountName + " numbered Account: " + a.showFund() + " $");
        }
    }

}
