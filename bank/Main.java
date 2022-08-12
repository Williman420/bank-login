package bank;

import java.util.Scanner;

public class Main {

    private boolean accStart = true;
    private String accOp;
    private String userData;
    private String pswData;
    private String NewUsernameData;
    private String newPswData;
    private int newUserBalance;
    private int userPos;
    private int amountIn;
    private int totalAddBalance;
    private int totalSubBalance;
    private int amountOut;
    private int picAction;

    public static void main(String[] args) {
        Main mainObj = new Main();
        Account NewObj = new Account();

        // admin
        NewObj.setAccUsername("admin");
        NewObj.setAccPassword("admin22");
        NewObj.setAccBalance(15000);
        // Start
        while (mainObj.accStart) {

            System.out.println("do you already have an account? ");
            Scanner newInput = new Scanner(System.in);
            String stOp = newInput.next();
            if (stOp.equals("yes") || stOp.equals("login")) {

                // username
                System.out.print("Username: ");

                mainObj.userData = newInput.next();

                // password
                System.out.print("Password: ");
                mainObj.pswData = newInput.next();
                mainObj.userPos = mainObj.userPos = NewObj.getAccUsername().indexOf(mainObj.userData);
                if (NewObj.getAccUsername().contains(mainObj.userData)
                        && NewObj.getAccPassword().contains(mainObj.pswData)) {

                    while (mainObj.accStart) {
                        NewObj.clearScreen();
                        System.out.println("wellcome to your account");
                        System.out.print("your balance is: ");
                        System.out.println(NewObj.getAccBalancePos(mainObj.userPos));
                        System.out.println("[1] add money to balance");
                        System.out.println("[2] get money from balance");
                        System.out.println("[3] exit");
                        System.out.println("pick action:");
                        mainObj.picAction = newInput.nextInt();

                        if (mainObj.picAction == 1) {
                            // putting money
                            System.out.println("your balance is:");
                            System.out.println(NewObj.getAccBalancePos(mainObj.userPos));
                            System.out.println("put your amount that you want to put in your bank account: ");
                            mainObj.amountIn = newInput.nextInt();

                            mainObj.totalAddBalance = NewObj.getAccBalancePos(mainObj.userPos) + mainObj.amountIn;
                            System.out.println("your total balance in your account is: " + mainObj.totalAddBalance);
                            NewObj.getAccBalance().set(mainObj.userPos, mainObj.totalAddBalance);
                            System.out.println("type menu to go back to menu");
                            mainObj.accOp = newInput.next();
                            if (mainObj.accOp.equalsIgnoreCase("menu")) {
                                mainObj.accStart = true;

                            }

                        }

                        else if (mainObj.picAction == 2) {
                            // getting money
                            System.out.println("your balance is:");
                            System.out.println(NewObj.getAccBalancePos(mainObj.userPos));
                            System.out.println("put your amount that you want to get from your account: ");
                            mainObj.amountOut = newInput.nextInt();

                            if (mainObj.amountOut <= NewObj.getAccBalancePos(mainObj.userPos)) {
                                mainObj.totalSubBalance = NewObj.getAccBalancePos(mainObj.userPos) - mainObj.amountOut;
                                System.out.println("your total balance is: ");
                                System.out.println(mainObj.totalSubBalance);
                                NewObj.getAccBalance().set(mainObj.userPos, mainObj.totalSubBalance);
                                System.out.println("type menu to go back to menu");
                                mainObj.accOp = newInput.next();
                                if (mainObj.accOp.equalsIgnoreCase("menu")) {
                                    mainObj.accStart = true;
                                }
                            } else {
                                System.out.println("the amount " + mainObj.amountOut
                                        + " that you put in is over than your balance");
                                System.out.println("type menu to go back to menu");
                                mainObj.accOp = newInput.next();
                                if (mainObj.accOp.equalsIgnoreCase("menu")) {
                                    mainObj.accStart = true;
                                }
                            }
                        } else if (mainObj.picAction == 3) {
                            mainObj.accStart = false;
                        }
                    }
                }

                else {
                    System.out.println("ur password and username is wrong");
                    System.out.println(mainObj.userData + mainObj.pswData);
                }

                // new account
            } else if (stOp.equalsIgnoreCase("no")) {
                // username
                System.out.println("please enter your new username here: ");
                mainObj.NewUsernameData = newInput.next();
                NewObj.setAccUsername(mainObj.NewUsernameData);

                // password
                System.out.println("put your password here");
                mainObj.newPswData = newInput.next();
                NewObj.setAccPassword(mainObj.newPswData);
                System.out.print("place you first balance here: ");
                mainObj.newUserBalance = newInput.nextInt();
                NewObj.setAccBalance(mainObj.newUserBalance);
            } else {
                System.out.println(mainObj.userData + "your input is wrong");

            }

        }

    }
}
