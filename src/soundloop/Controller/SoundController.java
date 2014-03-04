/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundloop.Controller;

import kuusisto.tinysound.Sound;
import soundloop.Models.SoundButton;
import java.util.ArrayList;

public class SoundController {

//This method takes in an array of SoundButtons, it loops through them and 
//checks to see if any of them are "activated". If they are, it calls
//SoundButton.getTinySound() and stores the sound file in an array.
//Then it loops through the array of TinySounds and plays them all.
    public void playActiveSounds(SoundButton[] soundButtons) {

//The array of TinySounds. Initialized to 10 because it will never be more
//than that for a single column.
        ArrayList<Sound> buttonSounds = new ArrayList();

        for (int i = 0; i < soundButtons.length; i++) //Loop through the parameter "soundButtons" and call ".isActivated()" on 
        //all of them. If they are activated, call "getTinySound(), and add it to
        //the buttonSounds[] array.
        {
            if (soundButtons[i].isActivated()) {
                buttonSounds.add(soundButtons[i].getTinySound());
            }
        }
        for (int i = 0; i < buttonSounds.size(); i++) {
            buttonSounds.get(i).play();
        }
    }
}