import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;



public class Main
{

    //Create Local Variables
    private static JLabel title2;
    private static char turn = 'X';

    public static void main(String[] args)
    {

        //Create Frame
        JFrame frame = new JFrame("ICS3UE3");
        //Set Frame Attributes
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setBackground(Color.WHITE);


        //Create Label Title
        JLabel title = new JLabel("ICS3UE3 Tic Tac Toe");
        title.setBackground(Color.WHITE);
        title.setOpaque(true);
        title.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        frame.add(title, BorderLayout.NORTH);

        //Create Second Title For Other Player
        JPanel x = new JPanel();
        title2 = new JLabel("Player One Make Your Move: ");
        title2.setHorizontalAlignment(SwingConstants.CENTER);
        title2.setBackground(Color.white);
        title2.setOpaque(true);
        title2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        //Create Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, 10, 10));
        panel.setBackground(Color.black);


        //Create Clickable Labels:

        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<3; j++)//Nested loop for the turns
            {
                JLabel label = new JLabel(" ");
                label.setOpaque(true);
                label.setBackground(Color.white);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.addMouseListener(new MouseListener() { // Get Mouse Input using MouseListener
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        if (label.getText().toString().equals(" "))
                        {
                            label.setText(String.valueOf(turn));
                            if(turn == 'X')
                            {
                                label.setForeground(Color.blue);
                                turn = 'O';
                                title2.setText("Player Two Make Your Move: ");
                                System.out.println("Mouse Input Registered: X");
                            } else
                            {
                                label.setForeground(Color.red);
                                turn = 'X';
                                title2.setText("Player One Make Your Move: ");
                                System.out.println("Mouse Input Registered: O");
                            }
                        }else
                        {

                        }
                    }
                    @Override
                    public void mousePressed(MouseEvent e) {
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                });
                panel.add(label);

            }
        }

        frame.add(panel, BorderLayout.CENTER);
        //Create Button:
        JButton button = new JButton("NEW GAME");
        button.setBackground(Color.GRAY);
        button.setForeground(Color.white);
        //Create Action Listener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        //Add To X Panel
        x.add(button);
        x.add(title2);


        //Make WIndow Visible and set Exit condition
        frame.add(x, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}