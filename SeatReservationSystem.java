import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
//import java.awt.event.ActionListener;

public class SeatReservationSystem {
    private static final int TOTAL_TABLES = 10;
    private static final boolean[] tables = new boolean[TOTAL_TABLES]; // false means available, true means occupied

    public static void showSeatReservationMenu() {
        JFrame frame = new JFrame("Seat Reservation");
        frame.setSize(500, 300);
        frame.setLayout(new GridLayout(2, 5)); // 2 rows, 5 columns
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton[] tableButtons = new JButton[TOTAL_TABLES];

        for (int i = 0; i < TOTAL_TABLES; i++) {
            tableButtons[i] = new JButton("Table " + (i + 1));
            if (tables[i]) {
                tableButtons[i].setEnabled(false);  // Disable button if reserved
                tableButtons[i].setText("Reserved");
            }

            int tableIndex = i;
            tableButtons[i].addActionListener((ActionEvent e) -> {
                tables[tableIndex] = true; // Mark table as reserved
                tableButtons[tableIndex].setText("Reserved");
                tableButtons[tableIndex].setEnabled(false);
                JOptionPane.showMessageDialog(frame, "Table " + (tableIndex + 1) + " reserved!");
            });

            frame.add(tableButtons[i]);
        }

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        showSeatReservationMenu();
    }
}
