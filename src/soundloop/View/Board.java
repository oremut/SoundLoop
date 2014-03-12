package soundloop.View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import soundloop.Models.ControllButton;
import soundloop.Models.SoundButton;

public class Board extends JPanel implements ActionListener {

    private final int NUM_OF_ROWS = 10;
    private final int NUM_OF_COLUMNS = 20;
    private final int BUTTON_WIDTH = 40;
    private final int BUTTON_HEIGHT = 40;
    private final int CONTROL_BUTTON_WIDTH = 124;
    private final int BUTTON_SPACING = 5;
    private int yValue = 40;
    private int boardWidth;
    private int boardHeight;
    private int curX;
    private int curY;
    private int a = 0;
    private int b = 0;
    private int xvalue = BUTTON_SPACING;
    private int tempo = 250;
    private int currentTone = 0;
    private boolean paused = false;
    private String soundName;
    ActionListener e;
    private SoundButton[][] button = new SoundButton[NUM_OF_ROWS][NUM_OF_COLUMNS];
    private JButton buttons[] = new JButton[7];

    /**
     * Adds the buttons in an alignment that fits the number of sounds.
     */
    public Board() {
        this.boardWidth = (NUM_OF_COLUMNS * BUTTON_WIDTH) + (NUM_OF_COLUMNS * BUTTON_SPACING) + 10;
        this.boardHeight = (NUM_OF_ROWS * BUTTON_HEIGHT) + (NUM_OF_ROWS * BUTTON_SPACING) + 68;
        this.soundName = "sound";
        buttons[0] = new ControllButton("Sounds 1");
        buttons[1] = new ControllButton("Sounds 2");
        buttons[2] = new ControllButton("Sounds 3");
        buttons[3] = new ControllButton("Tempo -");
        buttons[4] = new ControllButton("Tempo +");
        buttons[5] = new ControllButton("Pause");
        buttons[6] = new ControllButton("Clear");
        this.setLayout(null);

        for (int i = 0; i < NUM_OF_ROWS; i++) {
            for (int o = 0; o < NUM_OF_COLUMNS; o++) {
                button[i][o] = new SoundButton("", this.BUTTON_WIDTH, this.BUTTON_HEIGHT);
                button[i][o].setTinySound(this.soundName + (i + 1) + ".wav");
                button[i][o].addActionListener(this);
                this.add(button[i][o]);
                button[i][o].setLocation(xvalue, yValue);
                xvalue += this.BUTTON_WIDTH + this.BUTTON_SPACING;
            }
            xvalue = this.BUTTON_SPACING;
            yValue += this.BUTTON_HEIGHT + this.BUTTON_SPACING;
        }
        int xButtonSpacing = 3;
        for (int i = 0; i < 7; i++) {
            this.add(buttons[i], i);
            buttons[i].addActionListener(this);
            buttons[i].setLocation(xButtonSpacing, 5);
            xButtonSpacing += this.BUTTON_SPACING + this.CONTROL_BUTTON_WIDTH;
        }
        this.setBackground(Color.black);
        this.setSize(this.boardWidth, this.boardHeight);
        this.setVisible(true);
    }

    /**
     * Reduces the speed or tempo.
     */
    public void setTempoDown() {
        if (tempo < 1000 && tempo >= 125) {
            tempo += 125;
        } else if (tempo < 125) {
            tempo += 25;
        }
    }

    /**
     * Increases the tempo.
     */
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

    /**
     *
     * @param columnNumber The current column that the iterator is on.
     * @return The buttons that are in the column.
     */
    public SoundButton[] getButtonsInColumn(int columnNumber) {
        SoundButton columnSoundButtons[] = new SoundButton[10];
        for (int i = 0; i < NUM_OF_ROWS; i++) {

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
        return this.NUM_OF_COLUMNS;
    }

    /**
     * Find which button is pressed, and what to do after.
     *
     * @param e The ActionEvent object
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean pauseWasChanged = false;
        boolean tempoWasChanged = false;

        //Button listener to set the sound buttons' active state
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            for (int j = 0; j < NUM_OF_COLUMNS; j++) {
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
                xvalue = BUTTON_SPACING;
                for (int p = 0; p < NUM_OF_ROWS; p++) {
                    for (int o = 0; o < NUM_OF_COLUMNS; o++) {
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
                for (int p = 0; p < NUM_OF_ROWS; p++) {
                    for (int o = 0; o < NUM_OF_COLUMNS; o++) {
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
                for (int p = 0; p < NUM_OF_ROWS; p++) {
                    for (int o = 0; o < NUM_OF_COLUMNS; o++) {
                        this.button[p][o].setNewTinySound(soundName + (p + 1) + ".wav");
                    }
                }
            }
            this.currentTone = 2;
        }
    }

    /**
     * Pauses or unpauses the iterator
     *
     * @param currentState Whether the pause button is pressed or not.
     */
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

    /**
     * Sets the boolean paused to false
     */
    public void unpaused() {
        paused = false;
    }

    /**
     * Determine the current pause state of the iterator
     *
     * @return True or false depending on if the board is paused or not.
     */
    public boolean getPaused() {
        return paused;

    }
}
