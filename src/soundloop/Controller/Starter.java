package soundloop.Controller;
import java.awt.event.ActionListener;
import javax.swing.*;
import soundloop.Models.Board;

public class Starter {
    
public static void main(String[] args) {
     JFrame frame = new JFrame();
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(945,1030);       
            frame.setLayout(null);
            Board board = new Board();
            frame.getContentPane().add(board);
          frame.setVisible(true);
        }
}
