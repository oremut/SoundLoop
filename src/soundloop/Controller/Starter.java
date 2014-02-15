package soundloop.Controller;
import java.awt.Color;
import java.awt.Toolkit;
import soundloop.View.ButtonLayout;
import javax.swing.*;

public class Starter {

    public static void main(String[] args) {
        ButtonLayout p = new ButtonLayout();
        Toolkit tk = Toolkit.getDefaultToolkit();  
        int xSize = ((int) tk.getScreenSize().getWidth());  
        int ySize = ((int) tk.getScreenSize().getHeight());  
        JButton button = new JButton("C");
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(p);
	frame.pack();
        frame.setSize(xSize,ySize);  
        frame.add(button);
	frame.setVisible(true);
	frame.setBackground(Color.black); 
    }
}
