import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

class XO extends JFrame {
    private char currentPlayer = 'X';
    private JButton[] buttons = new JButton[9]; 
    private boolean gameOver = false; 
    private Queue<Integer> xx, oo;
    int x=0,o=0;

    XO() {
        xx = new LinkedList<>();
        oo = new LinkedList<>();
        
      
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3));

       
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.BOLD, 40)); 
            buttons[i].setFocusable(false);
            final int index = i; 
            buttons[i].addActionListener(e -> handleClick(index)); 
            frame.add(buttons[i]); 
        }

        frame.setVisible(true); 
    }

   
    private void handleClick(int index) {
        if (gameOver || !buttons[index].getText().isEmpty()) return; 

        buttons[index].setText(String.valueOf(currentPlayer)); 
        buttons[index].setEnabled(false); 

        
        if (currentPlayer == 'X') {
            xx.add(index);x++;
            if(x>3) {
            	int u=xx.poll();
            	buttons[u].setEnabled(true);
            	buttons[u].setText("");
            }
        } else {
            oo.add(index);o++;
            if(o>3) {
            	int u=oo.poll();
            	buttons[u].setEnabled(true);
            	buttons[u].setText("");
            	
            }
        }
        
        if (checkWin()) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
            gameOver = true;
            disableAllButtons();
        } else if (checkDraw()) {
            JOptionPane.showMessageDialog(null, "It's a draw!");
            gameOver = true;
        } else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; 
        }
    }

   
    private boolean checkWin() {
        int[][] winningCombos = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},  
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},  
            {0, 4, 8}, {2, 4, 6}              
        };

        for (int[] combo : winningCombos) {
            if (buttons[combo[0]].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[combo[1]].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[combo[2]].getText().equals(String.valueOf(currentPlayer))) {
                return true;
            }
        }
        return false;
    }

   
    private boolean checkDraw() {
        for (JButton button : buttons) {
            if (button.getText().isEmpty()) {
                return false; 
            }
        }
        return true; 
    }

    
    private void disableAllButtons() {
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(XO::new); 
    }
}
