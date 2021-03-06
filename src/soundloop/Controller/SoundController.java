package soundloop.Controller;

import kuusisto.tinysound.Sound;
import soundloop.Models.SoundButton;
import java.util.ArrayList;
import soundloop.View.Board;

public class SoundController {

    private Board board;
    private int currentColumnNumber = 0;

    public SoundController(Board board) {
        this.board = board;

    }

//This method takes in an array of SoundButtons, it loops through them and 
//checks to see if any of them are "activated". If they are, it calls
//SoundButton.getTinySound() and stores the sound file in an array.
//Then it loops through the array of TinySounds and plays them all.
    public void playActiveSounds() {

//The array of TinySounds. Initialized to 10 because it will never be more
//than that for a single column.

        if (board.getPaused() == true) {
        } else if (board.getPaused() == false) {
            ArrayList<Sound> buttonSounds = new ArrayList();
            SoundButton[] sb = this.board.getButtonsInColumn(this.currentColumnNumber);

            for (int i = 0; i < sb.length; i++) //Loop through the parameter "soundButtons" and call ".isActivated()" on 
            //all of them. If they are activated, call "getTinySound(), and add it to
            //the buttonSounds[] array.
            {
                if (sb[i].isActivated()) {
                    buttonSounds.add(sb[i].getTinySound());
                }
            }
            for (int i = 0; i < buttonSounds.size(); i++) {
                buttonSounds.get(i).play();
            }

            setColumnButtonColors(sb, true);

            try {
                Thread.sleep(board.getTempo());
                setColumnButtonColors(sb, false);
            } catch (InterruptedException e) {
                e.printStackTrace();
// handle the exception... 
// For example consider calling Thread.currentThread().interrupt(); here.
            }

            this.currentColumnNumber++;
            if (this.currentColumnNumber > this.board.getNumOfColumns() - 1) {
                this.currentColumnNumber = 0;
            }
        }
    }

    /**
     *
     * @param sb The SoundButton array.
     * @param isActive Are the SoundButtons currently active
     */
    private void setColumnButtonColors(SoundButton[] sb, boolean isActive) {
        for (int i = 0; i < sb.length; i++) {
            sb[i].buttonIsInActiveColumn(isActive);

        }
    }
}