import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.Function;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class App implements ActionListener
{
    //Create Window
    JFrame window = new JFrame("Tic Tac Toe");
    Random random = new Random();
    //Create JPANEL:
    JPanel title_pnl = new JPanel();
    JPanel button_pnl = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    //Create Turn Decider
    boolean turn;

    //Create Main Function:

    TicTacToe()
    {
        //Set Frame Border Sizes
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800,800);
        window.getContentPane().setBackground(new Color(50,50,50));
        window.setLayout(new BorderLayout());
        window.setVisible(true);

        //Set Textfield Sizes
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe");
        textfield.setOpaque(true);

        //Set Panel And Button Sizes:

        title_pnl.setLayout(new BorderLayout());
        title_pnl.setBounds(0,0,800,10);
        
        button_pnl.setLayout(new GridLayout(3,3));
        button_pnl.setBackground(new Color(150,150,150));

        //Button Creation Forloop
        for(int i =0; i<9; i++)
        {
            buttons[i] = new JButton();
            button_pnl.add(buttons[i]);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        //Title Panel

        title_pnl.add(textfield);
        window.add(title_pnl, BorderLayout.NORTH);
        window.add(button_pnl);

        //firstTurn();
    }
    public static void main(String[] args)
    {
    
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}