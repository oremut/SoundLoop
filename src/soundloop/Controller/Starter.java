package soundloop.Controller;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.*;
import soundloop.View.ButtonLayout;

public class Starter {

    public static void main(String[] args) {
        GridLayout layout = new GridLayout(4,4,10,10);
        ButtonLayout p = new ButtonLayout();
        Toolkit tk = Toolkit.getDefaultToolkit();  
        int xSize = ((int) tk.getScreenSize().getWidth());  
        int ySize = ((int) tk.getScreenSize().getHeight());  
        
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setLayout(layout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(p);
	frame.pack();
        frame.setSize(xSize,ySize);  
	frame.setVisible(true); 
	frame.setBackground(Color.black);
       
    }
}
