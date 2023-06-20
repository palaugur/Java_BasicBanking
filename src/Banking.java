import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Banking {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        ArrayList<String> actions = new ArrayList<>(Arrays.asList("Deposit Money", "Withdrawn Money", "Transfer", "Exit"));
        ArrayList<Customer> clientList = new ArrayList<>();

        Customer client1 = new Customer();
        client1.addClient();
        clientList.add(client1);

        Customer client2 = new Customer();
        client2.addClient();
        clientList.add(client2);

        client1.customerInfo();
        client2.customerInfo();

        int userIndex = -1;

        while (true) {
            System.out.println("Welcome to the Main Screen!");


            System.out.print("Please enter your username: ");
            String username = scan.nextLine();

            System.out.print("Please enter your password: ");
            String password = scan.nextLine();

            boolean isUserFound = false;

            for (int i = 0; i < clientList.size(); i++) {
                if (clientList.get(i).name.equals(username)) {
                    userIndex = i;
                    isUserFound = true;
                    break;
                }
            }

            if (!isUserFound) {
                System.out.println("User not found. Please try again with a valid username.");
                continue;
            }

            boolean isTrue = clientList.get(userIndex).confirmLogin(username, password);

            if (isTrue) {
                System.out.println("Successful Login!");
                break;
            } else {
                System.out.println("Your password is incorrect. Please try again!");
            }
        }

        while (true) {
            System.out.println("Choose the action you want to do...");
            for (int i = 0; i < actions.size(); i++) {
                System.out.println(actions.get(i) + " - " + (i + 1));
            }
            System.out.print("Your Choice: ");
            int userChoice = scan.nextInt();

            switch (userChoice) {

                case 1: {

                    System.out.println("Please select the account you want to deposit money into:");
                    for (int i = 0; i < clientList.get(userIndex).accountList.size(); i++) {
                        System.out.println((i + 1) + " - " + clientList.get(userIndex).accountList.get(i).accountName);
                    }
                    System.out.print("Account:");
                    int chosenAccount = scan.nextInt();

                    if (chosenAccount > 0 && chosenAccount <= clientList.get(userIndex).accountList.size()) {
                        System.out.print("Please enter the amount you would like to deposit: ");
                        int amountToDeposit = scan.nextInt();
                        clientList.get(userIndex).accountList.get(chosenAccount - 1).depositMoney(amountToDeposit);
                        break;
                    } else {
                        System.out.println("Your choice is invalid. Try Again!");
                    }
                }
                break;

                case 2: {

                    while (true) {
                        System.out.println("Please select the account you want to withdraw money from: ");
                        for (int i = 0; i < clientList.get(userIndex).accountList.size(); i++) {
                            System.out.println((i + 1) + " - " + clientList.get(userIndex).accountList.get(i).accountName
                                    + " balance is: "+ clientList.get(userIndex).accountList.get(i).showFund() + " $");
                        }
                        System.out.print("Account:");
                        int chosenAccount = scan.nextInt();

                        if (chosenAccount > 0 && chosenAccount <= clientList.get(userIndex).accountList.size()) {
                            System.out.print("Please enter the amount you want to withdraw: ");
                            int amountToWithdraw = scan.nextInt();
                            clientList.get(userIndex).accountList.get(chosenAccount - 1).withdrawMoney(amountToWithdraw);
                            break;
                        } else {
                            System.out.println("Your choice is invalid. Try Again!");
                        }
                    }
                    break;
                }

                case 3: {
                    System.out.println("We are not able to perform this operation at the moment...");
                    break;
                }

                case 4:
                    System.out.println("Have a Good Day!");
                    System.exit(1);

                default: {
                    System.out.println("You have not made a valid choice...");
                }

            }
        }
    }

}


