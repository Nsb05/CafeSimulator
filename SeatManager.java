import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SeatManager {
    private static final String FILE_NAME = "seats.txt";
    private static final int TOTAL_TABLES = 10;
    private static final Map<Integer, String> seats = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public SeatManager() {
        loadSeats(); // Load existing seat reservations from file
    }

    private void loadSeats() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                seats.put(Integer.parseInt(parts[0]), parts[1]); // Store seat number & status
            }
        } catch (IOException e) {
            System.out.println("No existing reservations found. Creating a new seat list.");
            initializeSeats(); // If file doesn't exist, create default seat list
        }
    }

    private void initializeSeats() {
        for (int i = 1; i <= TOTAL_TABLES; i++) {
            seats.put(i, "Available");
        }
        saveSeats();
    }

    private void saveSeats() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<Integer, String> entry : seats.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving seat reservations: " + e.getMessage());
        }
    }

    public void showSeatReservationMenu() {
        while (true) {
            System.out.println("\n **** Seat Reservation System ****");
            System.out.println("1. View available tables");
            System.out.println("2. Reserve a table");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> viewAvailableTables();
                case 2 -> reserveTable();
                case 3 -> cancelReservation();
                case 4 -> {
                    System.out.println("Returning to main menu...");
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void viewAvailableTables() {
        System.out.println("\n Available tables:");
        for (int i = 1; i <= TOTAL_TABLES; i++) {
            if ("Available".equals(seats.get(i))) {
                System.out.println("Table " + i);
            }
        }
    }

    private void reserveTable() {
        System.out.print("Enter table number to reserve (1-10): ");
        int tableNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (tableNumber < 1 || tableNumber > TOTAL_TABLES || !"Available".equals(seats.get(tableNumber))) {
            System.out.println(" Table " + tableNumber + " is already reserved or invalid.");
            return;
        }

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        seats.put(tableNumber, "Reserved by " + name);
        saveSeats();
        System.out.println(" Table " + tableNumber + " reserved for " + name + "!");
    }

    private void cancelReservation() {
        System.out.print("Enter the table number to cancel reservation: ");
        int tableNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (!seats.containsKey(tableNumber) || "Available".equals(seats.get(tableNumber))) {
            System.out.println(" No reservation found for table " + tableNumber + ".");
            return;
        }

        seats.put(tableNumber, "Available");
        saveSeats();
        System.out.println(" Reservation for table " + tableNumber + " has been canceled.");
    }
}
