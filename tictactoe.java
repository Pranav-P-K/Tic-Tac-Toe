import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class tictactoe implements ActionListener {
    
    static JFrame jf;
    static JPanel jp;
    static JButton b1 = new JButton("-");
    static JButton b2 = new JButton("-");
    static JButton b3 = new JButton("-");
    static JButton b4 = new JButton("-");
    static JButton b5 = new JButton("-");
    static JButton b6 = new JButton("-");
    static JButton b7 = new JButton("-");
    static JButton b8 = new JButton("-");
    static JButton b9 = new JButton("-");
    static JButton[] buttonArray = new JButton[9];
    static int move = 0;

    public static void main(String[] args) {
        
        jf = new JFrame("Tic-Tac-Toe");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400, 400);

        buttonArray[0] = b1;
        b1.addActionListener(new tictactoe());
        buttonArray[1] = b2;
        b2.addActionListener(new tictactoe());
        buttonArray[2] = b3;
        b3.addActionListener(new tictactoe());
        buttonArray[3] = b4;
        b4.addActionListener(new tictactoe());
        buttonArray[4] = b5;
        b5.addActionListener(new tictactoe());
        buttonArray[5] = b6;
        b6.addActionListener(new tictactoe());
        buttonArray[6] = b7;
        b7.addActionListener(new tictactoe());
        buttonArray[7] = b8;
        b8.addActionListener(new tictactoe());
        buttonArray[8] = b9;
        b9.addActionListener(new tictactoe());

        jp = new JPanel();
        jp.setBounds(0, 0, 300, 300);
        jp.setLayout(new GridLayout(3, 3, 0, 0));

        for (int i=1;i<=3;i++) {jp.add(buttonArray[i-1]);}
        for (int i=4;i<=6;i++) {jp.add(buttonArray[i-1]);}
        for (int i=7;i<=9;i++) {jp.add(buttonArray[i-1]);}

        jf.add(jp);
        jf.setVisible(true);
    }

    public void checkWinner() {
        for (int i = 0; i < 9; i += 3) {
            if (buttonArray[i].getText().equals(buttonArray[i+1].getText()) && buttonArray[i].getText().equals(buttonArray[i+2].getText()) && !buttonArray[i].isEnabled()) {
                JOptionPane.showMessageDialog(jf, buttonArray[i].getText() + " wins!");
                jf.dispose();
            }
        }
        for (int i = 0; i < 3; i++) {
            if (buttonArray[i].getText().equals(buttonArray[i+3].getText()) && buttonArray[i].getText().equals(buttonArray[i+6].getText()) && !buttonArray[i].isEnabled()) {
                JOptionPane.showMessageDialog(jf, buttonArray[i].getText() + " wins!");
                jf.dispose();
            }
        }
        if (buttonArray[0].getText().equals(buttonArray[4].getText()) && buttonArray[0].getText().equals(buttonArray[8].getText()) && !buttonArray[0].isEnabled()) {
            JOptionPane.showMessageDialog(jf, buttonArray[0].getText() + " wins!");
            jf.dispose();
        }
        if (buttonArray[2].getText().equals(buttonArray[4].getText()) && buttonArray[2].getText().equals(buttonArray[6].getText()) && !buttonArray[2].isEnabled()) {
                JOptionPane.showMessageDialog(jf, buttonArray[2].getText() + " wins!");
                jf.dispose();
        }
        boolean tie = true;
        for (int i = 0; i < 9; i++) {
            if (buttonArray[i].isEnabled()) {
                tie = false;
                break;
            }
        }
        if (tie) {JOptionPane.showMessageDialog(jf, "Tie game!");}
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (move%2==0) {button.setText("X");}
        else {button.setText("O");}
        button.setEnabled(false);
        move++;
        checkWinner();
        }
}

