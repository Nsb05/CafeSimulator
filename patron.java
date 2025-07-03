
import java.util.Scanner;

public class patron {
    static Scanner scanner = new Scanner(System.in);
    public static void becomepatron(){
        System.out.println("----Notice: You need to donate 5 dollars to become a patron----");
        System.err.println("Do you want to become a patron? (1 for Yes, 2 for No)");
        //Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        if (answer == 1) {
            System.out.println("Thank you for your support!");
            answer();
        } else if (answer == 2) {
            System.out.println("Thank you for considering! Maybe next time.");
        } else {
            System.out.println("Invalid choice! Please try again.");
            becomepatron();
        }
    }

    public static void answer() {
        System.out.println("!!! Congraluations, you've become a Patron now !!!");
    }
}
