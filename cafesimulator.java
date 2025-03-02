import java.util.Scanner;

public class cafesimulator {
    static Scanner scanner = new Scanner(System.in);

    private static void eatingDone() {
        System.out.println("Enjoy your meal!");
    }

    public static void main(String[] args) {
        OUTER:
        while (true) {
            System.out.println("*****Welcome to THE NOKOTAN CAFE*****");
            System.out.println("1. Show me the menu");
            System.out.println("2. Seat reservation");
            System.out.println("3. I would like to become a patron");
            System.out.println("4. Play the jukebox");
            System.out.println("5. Exit");
            int number = scanner.nextInt();
            switch (number) {
                case 1 -> {
                    System.out.println("1. Americano");
                    System.out.println("2. Cold coffee");
                    System.out.println("3. Croissant");
                    System.out.println("4. White sauce pasta");
                    System.out.println("5. Do you already ordered something?");
                    int order = scanner.nextInt();
                    switch (order) {
                        case 1, 2, 3, 4 -> eatingDone();
                        case 5 -> System.out.println("The customer has already ordered something.");
                        default -> System.out.println("Invalid choice! Please try again.");
                    }
                }
                case 2 -> SeatReservationSystem.showSeatReservationMenu();
                case 3 -> {
                    patron.becomepatron();
                    int answer = scanner.nextInt();
                    if (answer == 1) {
                        patron.answer();
                    }
                }
                case 4 -> jukebox.showJukeboxMenu(); 
                // Call the jukebox menu
                case 5 -> {
                    System.out.println("Exiting the program. Thank you!");
                    break OUTER;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
