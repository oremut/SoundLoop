package soundloop.Controller;
import Models.Button;
import java.awt.Color;
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
        JButton[][] button = new JButton[d][d];
        JFrame frame = new JFrame();
        frame.setResizable(false);
        Button buttons[] = new Button[5];
            buttons[0] = new Button("tone 13");
            buttons[1] = new Button("tone 2");
            buttons[2] = new Button("tone 3");
            buttons[3] = new Button("Save");
            buttons[4] = new Button("Load");
            for(int i = 0; i < 5; i++) {
                frame.add(buttons[i],i);
        }
        frame.setLayout(layout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(xSize,ySize);
	frame.setBackground(Color.black);
        for(int i = 0;i < (d);i++) {
             for(int o = 0; o < d; o++) {
                 button[i][o] = new JButton("");
             frame.add(button[i][o], i);
            }
        }
        frame.setVisible(true); 
    }
}
