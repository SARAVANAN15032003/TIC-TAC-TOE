import java.awt.*;
import java.awt.*;
import java.awt.event.*;

public class XO extends Frame {
    char c = 'X';
    Button[] buttons = new Button[9];
    boolean gameOver = false;

    XO() {
        Frame f = new Frame();
        for (int i = 0; i < 9; i++) {
            buttons[i] = new Button();
            f.add(buttons[i]);
        }
TextField t=new TextField();
        // Set frame properties
        f.setVisible(true);
        f.setLayout(null);
        f.setSize(450, 450);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f.dispose();
            }
        });
f.add(t);
        buttons[0].setBounds(100, 100, 100, 100);
        buttons[1].setBounds(200, 100, 100, 100);
        buttons[2].setBounds(300, 100, 100, 100);
        buttons[3].setBounds(100, 200, 100, 100);
        buttons[4].setBounds(200, 200, 100, 100);
        buttons[5].setBounds(300, 200, 100, 100);
        buttons[6].setBounds(100, 300, 100, 100);
        buttons[7].setBounds(200, 300, 100, 100);
        buttons[8].setBounds(300, 300, 100, 100);
t.setBounds(100,400,150,30);
      
        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                if (gameOver) return;

                Button clickedButton = (Button) a.getSource();
                clickedButton.setLabel(c + "");
                clickedButton.setEnabled(false);

                if (checkWin()) {
                    System.out.println("Player " + c + " wins!");
                    t.setText("Player " + (c+"") + " wins!");
                    gameOver = true;
                    disableAllButtons();
                } else if (checkDraw()) {
                    System.out.println("It's a draw!");
                    t.setText("It's a draw");
                    gameOver = true;
                } else {
                    c = (c == 'X') ? 'O' : 'X';  // Toggle between X and O
                }
            }
        };
        for (Button button : buttons) {
            button.addActionListener(action);
        }
    }

    boolean checkWin() {
       int[][] winningCombos = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},  // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},  // Columns
            {0, 4, 8}, {2, 4, 6}              // Diagonals
        };

        for (int[] combo : winningCombos) {
 if (buttons[combo[0]].getLabel().equals(c + "")&&buttons[combo[1]].getLabel().equals(c + "") &&
                buttons[combo[2]].getLabel().equals(c + "")) {
                return true;
            }
        }
        return false;
    }

    // Check if it's a draw
    boolean checkDraw() {
        for (Button button : buttons) {
            if (button.getLabel().equals("")) {
                return false;  // If there is at least one empty button, it's not a draw
            }
        }
        return true;
    }

    // Disable all buttons after game ends
    void disableAllButtons() {
        for (Button button : buttons) {
            button.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        new XO();
    }
}
