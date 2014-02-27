package soundloop.Controller;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.*;
import soundloop.View.ButtonLayout;

public class Starter {

    public static void main(String[] args) {
        int d = 10;
        GridLayout layout = new GridLayout(0,10,70,20);
        ButtonLayout p = new ButtonLayout();
        Toolkit tk = Toolkit.getDefaultToolkit();  
        int xSize = ((int) tk.getScreenSize().getWidth());  
        int ySize = ((int) tk.getScreenSize().getHeight());  
        JButton[] button = new JButton[d * d];
        JFrame frame = new JFrame();
        frame.setResizable(false);
        JButton buttons[] = new JButton[5];
            buttons[0] = new JButton("tone 1");
            buttons[1] = new JButton("tone 2");
            buttons[2] = new JButton("tone 3");
            buttons[3] = new JButton("Save");
            buttons[4] = new JButton("Load");
            for(int i = 0; i < 5; i++) {
                frame.add(buttons[i],i);
            }
        frame.setLayout(layout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(xSize,ySize);
	frame.setBackground(Color.black);
        for(int i = 0;i < (d * d);i++) {
            button[i] = new JButton("");
            frame.add(button[i], i);
        }
        frame.setVisible(true); 
    }
}
