/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundloop.Models;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener {

    private int curX;
    private int curY;
    private int numOfButtons = 10;
    private int a = 0;
    private int b = 0;
    private int xvalue = 40;
    private int yvalue = 120;
    ToneButton t;
    ActionListener e;
    private SoundButton[][] button = new SoundButton[numOfButtons][numOfButtons];
    private JButton buttons[] = new JButton[6];

    public Board() {
        buttons[0] = new ToneButton("tone 1");
        buttons[1] = new ToneButton("tone 2");
        buttons[2] = new ToneButton("tone 3");
        buttons[3] = new SaveButton("Save");
        buttons[4] = new LoadButton("Load");
        buttons[5] = new PlayButton("Pause");
        this.setLayout(null);

        for (int i = 0; i < numOfButtons; i++) {
            for (int o = 0; o < numOfButtons; o++) {
                button[i][o] = new SoundButton("i" + i + " o"+ o);
                button[i][o].setTinySound("sound"+(i+1)+".wav");
                button[i][o].addActionListener(this);
                this.add(button[i][o]);
                button[i][o].setLocation(xvalue, yvalue);
                xvalue += 88;
            }
            xvalue = 40;
            yvalue += 88;
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

    //Tell this method the column number we want all the buttons from
//and it will return an array with all the SoundButtons from that column
    public SoundButton[] getButtonsInColumn(int columnNumber) {
        SoundButton columnSoundButtons[] = new SoundButton[10];
        for (int i = 0; i < numOfButtons; i++) {

            columnSoundButtons[i] = button[i][columnNumber];
        }

        return columnSoundButtons;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < numOfButtons; i++) {
            for (int j = 0; j < numOfButtons; j++) {
                if (e.getSource() == button[i][j]) {
                    button[i][j].setActive();
                }
            }
        }
    }
}
