import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;



public class Main
{

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

        //Create Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, 10, 10));
        panel.setBackground(Color.black);


        //Create Clickable BUttons:

        for(int i = 0; i<3; i++)//Create 9 Buttons for the tic tac toe layout
        {
            for(int j = 0; j<3; j++)
            {
                JLabel label = new JLabel(" ");
                label.setOpaque(true);
                label.setBackground(Color.white);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

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
        frame.setVisible(true);
    }
}