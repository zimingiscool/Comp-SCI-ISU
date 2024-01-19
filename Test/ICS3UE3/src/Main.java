import com.sun.security.auth.UnixNumericUserPrincipal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.File;



public class Main
{

    //Create Local Variables
    private static JLabel title2;
    private static boolean muted = false;
    private static Clip audioClip;
    private static char turn = 'X';
    private static char[][] pos = new char[3][3];//Directional Array used to store the position of the x and o's
    private static String winner = " ";
    private static boolean enabled = true;
    private static ArrayList<JLabel> labels = new ArrayList<JLabel>(); //Create ArrayList for JLabel for the new_game() method
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
        panel.setLayout(new GridLayout(3, 3, 5, 5));
        panel.setBackground(Color.black);


        //Create Clickable Labels:

        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<3; j++)//Nested loop for the turns
            {
                int m = i;
                int n = j;
                JLabel label = new JLabel(" ");
                label.setOpaque(true);
                label.setFont(new Font("Serif", Font.BOLD, 60));
                label.setBackground(Color.white);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.addMouseListener(new MouseListener() { // Get Mouse Input using MouseListener
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        if(enabled)
                        {
                            if (label.getText().toString().equals(" "))
                            {
                                label.setText(String.valueOf(turn));
                                pos[m][n] = turn;
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
                                title2.setText("Box Already Ticked.");
                            }
                            if(winCondition() && winner.equals("X"))
                            {
                                title2.setText("Player 1 Won");
                                title2.setForeground(Color.blue);
                                enabled = false;
                            }else if(winCondition() && winner.equals("O"))
                            {
                                title2.setText("Player 2 Won");
                                title2.setForeground(Color.red);
                                enabled = false;
                            } else if (!draw())
                            {
                                title2.setText("Draw");
                                enabled = false;
                            }
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
                labels.add(label);

            }
        }

        frame.add(panel, BorderLayout.CENTER);
        //Create New Game Button:
        JButton button = new JButton("NEW GAME");
        button.setBackground(Color.GRAY);
        button.setForeground(Color.white);
        //Create Action Listener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new_game();
            }
        });


        //Add To X Panel
        x.add(button);
        x.add(title2);


        //Add Music Player:

        JPanel musicPlayer = new JPanel();


        JButton playButton = new JButton("Play Music");
        JButton muteButton = new JButton("Mute");


        //Add Pause Play Function
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(audioClip == null || !audioClip.isRunning())
                {
                    playMusic();
                    playButton.setText("Mute");
                } else {
                    pauseMusic();
                    playButton.setText("Unmute");
                }
            }
        });


        //Set Image:

        ImageIcon image = new ImageIcon("C:\\Users\\canad\\Documents\\GitHub\\Comp-SCI-ISU\\Test\\ICS3UE3\\Music-Images\\Image.jpg");
        JLabel imageLabel = new JLabel(image);




        //Make WIndow Visible and set Exit condition and others
        frame.add(x, BorderLayout.SOUTH);
        frame.setVisible(true);
        musicPlayer.add(playButton);//Add Playbutton
        frame.add(musicPlayer, BorderLayout.WEST);
        frame.add(imageLabel, BorderLayout.EAST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    //Check Win Conditions Using the 2 Dimensional Array:

    private static boolean winCondition() {
        boolean win = false;
        if (pos[0][0]==pos[0][1] && pos[0][0]==pos[0][2] && pos[0][0]!=0) {
            win = true;
            winner = String.valueOf(pos[0][0]);
        } else if (pos[1][0]==pos[1][1] && pos[1][0]==pos[1][2] && pos[1][0]!=0) {
            win = true;
            winner = String.valueOf(pos[1][0]);
        } else if (pos[2][0]==pos[2][1] && pos[2][0]==pos[2][2] && pos[2][0]!=0) {
            win = true;
            winner = String.valueOf(pos[2][0]);
        } else if (pos[0][0]==pos[1][0] && pos[0][0]==pos[2][0] && pos[0][0]!=0) {
            win = true;
            winner = String.valueOf(pos[0][0]);
        } else if (pos[0][1]==pos[1][1] && pos[0][1]==pos[2][1] && pos[0][1]!=0) {
            win = true;
            winner = String.valueOf(pos[0][1]);
        } else if (pos[0][2]==pos[1][2] && pos[0][2]==pos[2][2] && pos[0][2]!=0) {
            win = true;
            winner = String.valueOf(pos[0][2]);
        } else if (pos[0][0]==pos[1][1] && pos[0][0]==pos[2][2] && pos[0][0]!=0) {
            win = true;
            winner = String.valueOf(pos[0][0]);
        } else if (pos[2][0]==pos[1][1] && pos[2][0]==pos[0][2] && pos[2][0]!=0) {
            win = true;
            winner = String.valueOf(pos[2][0]);
        }
        return win;
    }

    //Create New Game Function
    private static void new_game()
    {
        pos = new char[3][3];
        winner = " ";
        title2.setText("Player One Make Your Move: ");
        title2.setForeground(Color.black);
        turn = 'X';
        enabled = true;
        for(JLabel label : labels)//For loop iterates over arraylist to remove the x and o's from the board/grid
        {
            label.setText(" ");
        }
    }

    //Create Grid Clearing Function
    private static boolean draw()
    {
        boolean draw = false;
        for(char[] a : pos)// Nested Loop iterates through two dementional array
        {
            for(char b : a)
            {
                if(b==0)// Nested Loop
                {
                    draw = true;//Sets draw function to true so that it can clear out the grid
                    break; // Break Loop
                }
            }
        }
        return draw;
    }

    //Music Player:


    //Play Pause Function
    private void PlayPause()
    {
        if(audioClip == null || !audioClip.isRunning())
        {
            playMusic();
        }else
        {
            pauseMusic();
        }
    }

    //Play Music Function
    private static void playMusic()
    {
        try
        {
            //Imports Audio using IO, lesson 3

            File audioFile = new File("C:\\Users\\canad\\Documents\\GitHub\\Comp-SCI-ISU\\Test\\ICS3UE3\\Music-Images\\AudioFile.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
            audioClip.start();

        }catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex)
        {
            ex.printStackTrace();
        }
    }

    //Pause Music Function

    private static void pauseMusic()
    {
        if(audioClip != null)
        {
            audioClip.stop();
        }
    }
}


