package soundloop.Models;

import java.awt.Color;
import javax.swing.JButton;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

public class SoundButton extends JButton{

    private Color notActive = Color.DARK_GRAY;
    private Color isActive = Color.WHITE;
    private Color notActiveInActiveColumn = Color.WHITE;
    private Color isActiveInActiveColumn = Color.LIGHT_GRAY;
    private boolean isActivated;
    private Sound buttonSound;
    private boolean[][] buttonPressed = new boolean[10][10];

    public SoundButton(String text, int width, int height) {

        super.setText(text);
        super.setSize(width, height);
        super.setForeground(Color.white);
        super.setBackground(Color.DARK_GRAY);

        this.isActivated = false;
        TinySound.init();

        //temporary loading of a sound file, this will be erased later  
        Sound bs = TinySound.loadSound("sound1.wav");
        this.buttonSound = bs;

    }

    public void playSound() {
        this.buttonSound.play();
    }

    private void setButton(boolean val, int a, int b) {
        buttonPressed[a][b] = val;
    }

    //pass in the file name of the sound for this button, and set it up
    //as a Sound object
    public void setTinySound(String soundName) {
        
        Sound bs = TinySound.loadSound(soundName);
        this.buttonSound = bs;
    }
    public void setNewTinySound(String soundName) {
        this.buttonSound = null;
        Sound bs = TinySound.loadSound(soundName);
        this.buttonSound = bs;
    }

    //returns the sound object of the button.
    public Sound getTinySound() {
        return this.buttonSound;
    }

    public boolean isActivated() {
        return this.isActivated;
    }

    public void setActive() {
        this.isActivated = this.isActivated ? false : true;


        if (this.isActivated == true) {
            this.setBackground(isActive);
            //this.buttonSound.play();
        } else {
            this.setBackground(notActive);
        }
    }
    
    public void setActive(boolean active) {
        this.isActivated = false;
        if (this.isActivated == true) {
            this.setBackground(isActive);
            //this.buttonSound.play();
        } else {
            this.setBackground(notActive);
        }
    }

    public void buttonIsInActiveColumn(boolean isInActiveColumn) {
        if (isInActiveColumn) {
            if (isActivated) {
                this.setBackground(isActiveInActiveColumn);
            } else {
                this.setBackground(notActiveInActiveColumn);
            }
        } else {
            if (isActivated) {
                this.setBackground(isActive);
            } else {
                this.setBackground(notActive);
            }
        }
    }
//    public boolean getPressed() {
//        return Starter.sendPressed();
//    }
}
