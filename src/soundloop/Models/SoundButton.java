package soundloop.Models;

import java.awt.Color;
import javax.swing.JButton;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

public class SoundButton extends JButton {

    private Color notActive = Color.DARK_GRAY;
    private Color isActive = Color.WHITE;
    private Color notActiveInActiveColumn = Color.WHITE;
    private Color isActiveInActiveColumn = Color.LIGHT_GRAY;
    private boolean isActivated;
    private Sound buttonSound;
    private boolean[][] buttonPressed = new boolean[10][10];

    /**
     * Set the buttons that play sound to the correct attributes
     *
     * @param text current text the buttons will be set to.
     * @param width how wide the button will be
     * @param height how tall the button will be
     */
    public SoundButton(String text, int width, int height) {
        super.setText(text);
        super.setSize(width, height);
        super.setForeground(Color.white);
        super.setBackground(Color.DARK_GRAY);

        this.isActivated = false;
        TinySound.init();
    }

    /**
     * This plays the sound that was located on the button
     */
    public void playSound() {
        this.buttonSound.play();
    }

    /**
     * Sets the Sound object for the SoundButton
     *
     * @param soundName The url of the sound file to be used
     */
    public void setTinySound(String soundName) {

        Sound bs = TinySound.loadSound(soundName);
        this.buttonSound = bs;
    }

    /**
     * this sets the soundName to the url of a sound in tinySound
     *
     * @param soundName The string that will turn into a location for a sound
     */
    public void setNewTinySound(String soundName) {
        this.buttonSound = null;
        Sound bs = TinySound.loadSound(soundName);
        this.buttonSound = bs;
    }

    //returns the sound object of the button.
    public Sound getTinySound() {
        return this.buttonSound;
    }

    /**
     * @return whether the button is active or not
     */
    public boolean isActivated() {
        return this.isActivated;
    }

    /**
     * Sets the button to white or dark_gray whether it is active or not.
     */
    public void setActive() {
        this.isActivated = this.isActivated ? false : true;


        if (this.isActivated == true) {
            this.setBackground(isActive);
            //this.buttonSound.play();
        } else {
            this.setBackground(notActive);
        }
    }

    /**
     * This method is an alternate method to change the background back to
     * dark_gray from the clearing button.
     *
     * @param active Boolean - Set the button to active or not active
     */
    public void setActive(boolean active) {
        this.isActivated = false;
        if (this.isActivated == true) {
            this.setBackground(isActive);
        } else {
            this.setBackground(notActive);
        }
    }

    /**
     * Determines whether the button is active and whether to keep the color
     * when the time bar passes by it.
     *
     * @param isInActiveColumn Buttons that are active in the column
     */
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
}
