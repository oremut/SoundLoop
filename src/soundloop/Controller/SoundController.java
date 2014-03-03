/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package soundloop.Controller;

import kuusisto.tinysound.TinySound;
import soundloop.Models.SoundButton;

public class SoundController {
    
    //This method takes in an array of SoundButtons, it loops through them and 
    //checks to see if any of them are "activated". If they are, it calls
    //SoundButton.getTinySound() and stores the sound file in an array.
    //Then it loops through the array of TinySounds and plays them all.
    public void playActiveSounds(SoundButton[] soundButtons){
        
        //The array of TinySounds. Initialized to 10 because it will never be more
        //than that for a single column.
        TinySound buttonSounds[] = new TinySound[10];
        
        //Loop through the parameter "soundButtons" and call ".isActivated()" on 
        //all of them. If they are activated, call "getTinySound(), and add it to
        //the buttonSounds[] array.
        
    }
}
