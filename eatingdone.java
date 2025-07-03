import java.util.Scanner;

public class eatingdone {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void eatingDone() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to order something else? (yes/no)");
        String response = scanner.next();
        if (response.equalsIgnoreCase("yes")) {
            System.out.println("Please choose from the menu again.");
        } else if (response.equalsIgnoreCase("no")) {
            System.out.println("!Thank you for dining with us & Enjoy your meal!");
            //payBill();
        } else {
            System.out.println("Invalid response. Please try again.");
            eatingDone();
        }
        System.out.println("----PLEASE PAY THE BILL AT THE COUNTER----");
        //scanner.close();
    }
}
