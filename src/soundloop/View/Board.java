package soundloop.View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import soundloop.Models.ControllButton;
import soundloop.Models.ControllButton;
import soundloop.Models.SoundButton;
import soundloop.Models.SoundButton;

public class Board extends JPanel implements ActionListener {
    
    private int numOfRows = 10;
    private int numOfColumns = 20;
    private int buttonWidth = 35;
    private int buttonHeight = 35;
    private int buttonSpacing = 5;
    private int boardWidth;
    private int boardHeight;
    private int curX;
    private int curY;
    private int a = 0;
    private int b = 0;
    private int xvalue = buttonSpacing;
    private int yvalue = 120;
    private int tempo = 250;

    private boolean paused = false;
    ActionListener e;
    private SoundButton[][] button = new SoundButton[numOfRows][numOfColumns];
    private JButton buttons[] = new JButton[7];

    public Board() {
        this.boardWidth = (numOfColumns * buttonWidth) + (numOfColumns * buttonSpacing) + 10;
        this.boardHeight = (numOfRows * buttonHeight) + (numOfRows * buttonSpacing) + 150;
        buttons[0] = new ControllButton("tone 1");
        buttons[1] = new ControllButton("tone 2");
        buttons[2] = new ControllButton("tone 3");
        buttons[3] = new ControllButton("Save");
        buttons[4] = new ControllButton("Load");
        buttons[5] = new ControllButton("Pause");
        buttons[6] = new ControllButton("Clear");
        this.setLayout(null);

        for (int i = 0; i < numOfRows; i++) {
            for (int o = 0; o < numOfColumns; o++) {
                button[i][o] = new SoundButton("", this.buttonWidth, this.buttonHeight);
                button[i][o].setTinySound("sound" + (i + 1) + ".wav");
                button[i][o].addActionListener(this);
                this.add(button[i][o]);
                button[i][o].setLocation(xvalue, yvalue);
                xvalue += this.buttonWidth + this.buttonSpacing;
            }
            xvalue = this.buttonSpacing;
            yvalue += this.buttonHeight + this.buttonSpacing;
        }
        int nothaY = 24;
        for (int i = 0; i < 7; i++) {
            this.add(buttons[i], i);
            buttons[i].addActionListener(this);
            buttons[i].setLocation(nothaY, 20);
            nothaY += this.buttonSpacing+90;
        }
        this.setBackground(Color.black);
        this.setSize(this.boardWidth, this.boardHeight);
        this.setVisible(true);
    }

    public void setTempo(int delay) {
        delay /= 2;
        if (delay < 75) {
            delay = 1000;
        }
        tempo = delay;
    }

    public int getTempo() {
        return tempo;
    }
//Tell this method the column number we want all the buttons from
//and it will return an array with all the SoundButtons from that column

    public SoundButton[] getButtonsInColumn(int columnNumber) {
        SoundButton columnSoundButtons[] = new SoundButton[10];
        for (int i = 0; i < numOfRows; i++) {

            columnSoundButtons[i] = button[i][columnNumber];
        }

        return columnSoundButtons;
    }

    public int getWidth() {
        return this.boardWidth;
    }

    public int getHeight() {
        return this.boardHeight;
    }
    
    public int getNumOfColumns() {
        return this.numOfColumns;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean pauseWasChanged = false;
        boolean tempoWasChanged = false;
        for (int i = 0; i < numOfRows; i++) {

            for (int j = 0; j < numOfColumns; j++) {
                if (e.getSource() == button[i][j]) {
                    button[i][j].setActive();
                }
                if (e.getSource() == buttons[4] && tempoWasChanged == false) {
                    this.setTempo(tempo);
                    tempoWasChanged = true;
                }
                if (e.getSource() == buttons[5] && pauseWasChanged == false) {
                    setPaused(this.paused);
                    pauseWasChanged = true;
                }

                if (e.getSource() == buttons[6]) {
                    button[i][j].setActive(false);
                }

            }
        }
    }

    public void setPaused(boolean currentState) {
        if (currentState) {
            paused = false;
            buttons[5].setText("Pause");
        }
        if (currentState == false) {
            paused = true;
            buttons[5].setText("Play");
        }
    }

    public void unpaused() {
        paused = false;
    }

    public boolean getPaused() {
        return paused;

    }
}
