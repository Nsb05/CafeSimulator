import java.util.Scanner;

public class cafesimulator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        OUTER:
        while (true) {
            System.out.println("***** Welcome to THE NOKOTAN CAFE *****");
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
                    System.out.println("5. Latte");
                    System.out.println("6. Cappuccino");
                    System.out.println("7. Hot chocolate");
                    System.out.println("8. Black coffee");
                    System.out.println("9. Green tea");
                    System.out.println("10. Iced tea");
                    System.out.println("11. Cheesecake");
                    System.out.println("12. Matcha Latte");
                    System.out.println("13. Chocolate Lava Cake ");
                    System.out.println("14. Tiramisu - A classic Italian dessert");
                    System.out.println("15. Fruit Tart");
                    System.out.println("16. Red Velvet Cake");
                    System.out.println("17. Chocolate Mousse");
                    System.out.println("18. Vanilla Ice Cream");
                    System.out.println("19. Strawberry Shortcake");
                    System.out.println("20. Blueberry Muffin");
                    System.out.println("21. Chocolate Chip Cookies");
                    System.out.println("22. French Onion Soup");
                    System.out.println("23. Chicken Caesar Salad");
                    System.out.println("24. Mini Pizza - A small non-veg/veg pizza");
                    System.out.println("25. Grilled Cheese Sandwich");   
                    System.out.println("26. Did you already order something?");
                    int order = scanner.nextInt();
                    switch (order) {
                        case 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25 -> eatingdone.eatingDone();
                        case 26 -> System.out.println("The customer has already ordered something. Please wait for the order to be served.");
                        default -> System.out.println("Invalid choice! Please try again.");
                    }
                }
                case 2 -> {
                    SeatManager seatManager = new SeatManager();
                    seatManager.showSeatReservationMenu();
                }                
                case 3 -> {
                    patron.becomepatron();
                    //int answer = scanner.nextInt();
                    //if (answer == 1) {
                      //  patron.answer();
                    //}
                }
                case 4 -> jukebox.showJukeboxMenu(); 
                // Call the jukebox menu
                case 5 -> {
                    System.out.println("----Please come again!----");
                    break OUTER;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
