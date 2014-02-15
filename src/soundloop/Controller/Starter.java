package soundloop.Controller;
import java.awt.Color;
import soundloop.View.ButtonLayout;
import javax.swing.*;

public class Starter {

    public static void main(String[] args) {
        ButtonLayout p = new ButtonLayout();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(p);
	frame.pack();
	frame.setVisible(true);
	frame.setSize(600,600);
	frame.setBackground(Color.black); 
    }
}
