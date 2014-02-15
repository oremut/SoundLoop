package soundloop.Controller;
import java.awt.Button;
import java.awt.Color;
import soundloop.View.ButtonLayout;
import javax.swing.*;

public class Starter {

    public static void main(String[] args) {
        ButtonLayout p = new ButtonLayout();
        JButton button = new JButton("C");
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(p);
	frame.pack();
        frame.add(button);
	frame.setVisible(true);
	frame.setSize(600,600);
	frame.setBackground(Color.black); 
    }
}
