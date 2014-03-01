/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundloop.Models;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Board extends JPanel {

    private  int numOfButtons = 10;
    private  SoundButton[][] button = new SoundButton[numOfButtons][numOfButtons];

    public Board() {
        JButton buttons[] = new JButton[6];
        buttons[0] = new ToneButton("tone 1");
        buttons[1] = new ToneButton("tone 2");
        buttons[2] = new ToneButton("tone 3");
        buttons[3] = new SaveButton("Save");
        buttons[4] = new LoadButton("Load");
        buttons[5] = new PlayButton("Pause");
        int xvalue = 47;
        int yvalue = 120;
        this.setLayout(null);

        for (int i = 0; i < numOfButtons; i++) {
            for (int o = 0; o < numOfButtons; o++) {
                button[i][o] = new SoundButton("");
                this.add(button[i][o]);
                button[i][o].setLocation(xvalue, yvalue);
                xvalue += 85;
            }
            xvalue = 47;
            yvalue += 85;
        }
        int nothaY = 47;
        for (int i = 0; i < 6; i++) {
            this.add(buttons[i], i);
            buttons[i].setLocation(nothaY, 20);
            nothaY += 153;
        }
        this.setBackground(Color.black);
        this.setSize(945, 1025);
        this.setVisible(true);
    }
}
