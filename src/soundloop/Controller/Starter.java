package soundloop.Controller;
import Models.Button;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Starter {
    private static int d = 10;
    private static Button[][] button = new Button[d][d];
    private static JPanel p = new JPanel();
    public static void main(String[] args) {
        Toolkit tk = Toolkit.getDefaultToolkit();    
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(945,1025);
           frame.setLayout(null);          
           Button buttons[] = new Button[6];
            buttons[0] = new Button("tone 1");
            buttons[1] = new Button("tone 2");
            buttons[2] = new Button("tone 3");
            buttons[3] = new Button("Save");
            buttons[4] = new Button("Load");
            buttons[5] = new Button("Pause");
            int xvalue = 47;
            int yvalue = 120;
        frame.setForeground(Color.white);
            for(int i = 0;i < d;i++) {
             for(int o = 0; o < d; o++) {
                button[i][o] = new Button("");
                frame.add(button[i][o]);
                button[i][o].setLocation(xvalue, yvalue);
                xvalue += 85;
            }
             xvalue = 47;
             yvalue += 85;
        }
            int nothaY = 47;
            for(int i = 0; i < 6; i++) {
                frame.add(buttons[i], i);
                buttons[i].setLocation(nothaY, 20);
                nothaY += 153;
           }
        frame.getContentPane().add(p);
        p.setBackground(Color.black);
        p.setSize(945,1025);
        frame.setVisible(true); 
    }
    
    public static boolean sendPressed() {
        if(button[1][1].isSelected()) {
            return true;
        } else {
            return false;
        }
    }
}
