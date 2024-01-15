import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.Function;
import java.awt.*;
import javax.swing.*;


public class App 
{
    public static void main(String[] args)
    {
        //Create Window
        JFrame window = new JFrame("Tic Tac Toe");
        window.setSize(500,500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel container = new JPanel();
        container.setBackground(Color.WHITE);

        window.setVisible(true);
        
    }   
}