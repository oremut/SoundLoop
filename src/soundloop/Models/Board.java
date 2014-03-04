/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundloop.Models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener, MouseMotionListener {
    private int curX;
    private int curY;
    private  int numOfButtons = 10;
    private boolean[][] active = new boolean[numOfButtons][numOfButtons];
    private int a = 0;
    private int b = 0;
    private int xvalue = 40;
    private int yvalue = 120;
    ToneButton t;
    ActionListener e;
    private  SoundButton[][] button = new SoundButton[numOfButtons][numOfButtons];
    private  JButton buttons[] = new JButton[6];
    public Board() {
        this.addMouseMotionListener(this);
        buttons[0] = new ToneButton("tone 1");
        buttons[1] = new ToneButton("tone 2");
        buttons[2] = new ToneButton("tone 3");
        buttons[3] = new SaveButton("Save");
        buttons[4] = new LoadButton("Load");
        buttons[5] = new PlayButton("Pause");
        this.setLayout(null);

        for (int i = 0; i < numOfButtons; i++) {
            for (int o = 0; o < numOfButtons; o++) {
                button[i][o] = new SoundButton("");
                button[i][o].addActionListener(this);
                active[i][o] = false;
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
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Mouse at (" + curX + ", " + curY + ")" + a + "" + b, 5, this.getHeight() - 25);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(active[a][b]) {
           button[a][b].setBackground(Color.DARK_GRAY); 
           active[a][b] = false;
        } else if (!active[a][b]) {
            button[a][b].setBackground(Color.WHITE);
            active[a][b] = true;
        }
    }
    
    

    @Override
    public void mouseDragged(MouseEvent e) {
       
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.curX = e.getX();
        this.curY = e.getY();
        for(int i = 0; i < 10; i++) {
            if(curX > 38 + (i * 87)) {
                b = i;
            }
        }
        for(int i = 0; i < 10; i++) {
            if(curY > 118 + (i * 87)) {
                a = i;
            }
        }
//            
        this.repaint();
    }

//    public String getButton() {
//        for(int i = 0;  i < 10; i++) {
//         for(int o = 0; o < 10; o++) {
//             if(active[i][o]) {
//                 return "tone" + i;
//             }
//         }
//        }
//     return "";   
//    }
}
