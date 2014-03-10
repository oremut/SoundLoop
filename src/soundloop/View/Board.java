package soundloop.View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import soundloop.Models.ControllButton;
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
    private int currentTone = 0;
    private boolean paused = false;
    private String soundName;
    ActionListener e;
    private SoundButton[][] button = new SoundButton[numOfRows][numOfColumns];
    private JButton buttons[] = new JButton[7];

    public Board() {
        this.boardWidth = (numOfColumns * buttonWidth) + (numOfColumns * buttonSpacing) + 10;
        this.boardHeight = (numOfRows * buttonHeight) + (numOfRows * buttonSpacing) + 150;
        this.soundName = "sound";
        buttons[0] = new ControllButton("tone 1");
        buttons[1] = new ControllButton("tone 2");
        buttons[2] = new ControllButton("tone 3");
        buttons[3] = new ControllButton("--");
        buttons[4] = new ControllButton("+");
        buttons[5] = new ControllButton("Pause");
        buttons[6] = new ControllButton("Clear");
        this.setLayout(null);

        for (int i = 0; i < numOfRows; i++) {
            for (int o = 0; o < numOfColumns; o++) {
                button[i][o] = new SoundButton("", this.buttonWidth, this.buttonHeight);
                button[i][o].setTinySound(this.soundName + (i + 1) + ".wav");
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
            nothaY += this.buttonSpacing + 90;
        }
        this.setBackground(Color.black);
        this.setSize(this.boardWidth, this.boardHeight);
        this.setVisible(true);
    }

    public void setTempoDown() {
        if (tempo < 1000 && tempo >= 125) {
            tempo += 125;
        } else if (tempo < 125) {
            tempo += 25;
        }
    }

    public void setTempoUp() {
        if (tempo > 125) {
            tempo -= 125;
        } else if (tempo <= 125 && tempo > 100) {
            tempo -= 25;
        }
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

        //Button listener to set the sound buttons' active state
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfColumns; j++) {
                if (e.getSource() == button[i][j]) {
                    button[i][j].setActive();
                }
                if (e.getSource() == buttons[6]) {
                    button[i][j].setActive(false);
                }
            }
        }

        //Button listeners to change tempo (buttons[3] and buttons[4]
        if (e.getSource() == buttons[3] && tempoWasChanged == false) {
            this.setTempoDown();
            tempoWasChanged = true;
        }
        if (e.getSource() == buttons[4] && tempoWasChanged == false) {
            this.setTempoUp();
            tempoWasChanged = true;
        }

        //Button listener for the pause button
        if (e.getSource() == buttons[5] && pauseWasChanged == false) {
            setPaused(this.paused);
            pauseWasChanged = true;
        }

        //Button listener to set the tone pack back to default (tone button 1)
        if (e.getSource() == buttons[0]) {
            if (this.currentTone != 0) {
                soundName = "sound";
                xvalue = buttonSpacing;
                for (int p = 0; p < numOfRows; p++) {
                    for (int o = 0; o < numOfColumns; o++) {
                        this.button[p][o].setNewTinySound("sound" + (p + 1) + ".wav");

                    }
                }
                this.currentTone = 0;
            }
        }

        //Button listener to set the tone pack to "beeps" (tone button 2

        if (e.getSource() == buttons[1]) {
            if (this.currentTone != 1) {
                soundName = "beep";
                for (int p = 0; p < numOfRows; p++) {
                    for (int o = 0; o < numOfColumns; o++) {
                        System.out.println("this is p: " + p + "\t this is o: " + o);
                        this.button[p][o].setNewTinySound(soundName + (p + 1) + ".wav");
                    }
                }
                this.currentTone = 1;
            }
        }

        //Button listener to set the tone pack to "beats" (tone button 3

        if (e.getSource() == buttons[2]) {
            if (this.currentTone != 2) {
                soundName = "beat";
                for (int p = 0; p < numOfRows; p++) {
                    for (int o = 0; o < numOfColumns; o++) {
                        System.out.println("this is p: " + p + "\t this is o: " + o);
                        this.button[p][o].setNewTinySound(soundName + (p + 1) + ".wav");
                    }
                }
            }
            this.currentTone = 2;
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
