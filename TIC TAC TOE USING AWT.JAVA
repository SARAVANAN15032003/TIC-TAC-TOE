import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XO extends JFrame {
    char c = 'X'; // Variable to track the current player's symbol
    JButton[] buttons = new JButton[9]; // Array to hold the buttons
    boolean gameOver = false; // Flag to track if the game is over

    XO() {
        // Initialize JFrame
        setTitle("Tic-Tac-Toe");
        setSize(450, 450);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize buttons
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            add(buttons[i]);
        }

        // Set button positions
        buttons[0].setBounds(100, 100, 100, 100);
        buttons[1].setBounds(200, 100, 100, 100);
        buttons[2].setBounds(300, 100, 100, 100);
        buttons[3].setBounds(100, 200, 100, 100);
        buttons[4].setBounds(200, 200, 100, 100);
        buttons[5].setBounds(300, 200, 100, 100);
        buttons[6].setBounds(100, 300, 100, 100);
        buttons[7].setBounds(200, 300, 100, 100);
        buttons[8].setBounds(300, 300, 100, 100);

        // Create ActionListener for buttons
        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                if (gameOver) return; // If the game is over, ignore further clicks

                JButton clickedButton = (JButton) a.getSource();
                clickedButton.setText(c + ""); // Set the button's text to the current player's symbol
                clickedButton.setEnabled(false); // Disable the button to prevent further clicks

                if (checkWin()) {
                    JOptionPane.showMessageDialog(null, "Player " + c + " wins!");
                    gameOver = true; // Set the gameOver flag to true
                    disableAllButtons(); // Disable all buttons
                } else if (checkDraw()) {
                    JOptionPane.showMessageDialog(null, "It's a draw!");
                    gameOver = true; // Set the gameOver flag to true
                } else {
                    c = (c == 'X') ? 'O' : 'X'; // Toggle between 'X' and 'O'
                }
            }
        };

        // Add ActionListener to each button
        for (JButton button : buttons) {
            button.addActionListener(action);
        }

        setVisible(true); // Make the frame visible
    }

    // Check if there is a winner
    boolean checkWin() {
        // Winning combinations
        int[][] winningCombos = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},  // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},  // Columns
            {0, 4, 8}, {2, 4, 6}              // Diagonals
        };

        for (int[] combo : winningCombos) {
            if (buttons[combo[0]].getText().equals(c + "") &&
                buttons[combo[1]].getText().equals(c + "") &&
                buttons[combo[2]].getText().equals(c + "")) {
                return true;
            }
        }
        return false;
    }

    // Check if it's a draw
    boolean checkDraw() {
        for (JButton button : buttons) {
            if (button.getText().equals("")) {
                return false;  // If there is at least one empty button, it's not a draw
            }
        }
        return true;
    }

    // Disable all buttons after game ends
    void disableAllButtons() {
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        // Ensure Swing components are created on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> new XO());
    }
}
