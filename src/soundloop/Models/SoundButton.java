
package soundloop.Models;
import java.awt.Color;
import javax.swing.JButton;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

public class SoundButton extends JButton {
    private boolean isActivated;
    private Sound buttonSound;
    private boolean[][] buttonPressed = new boolean[10][10];
    
    public SoundButton(String text) {
        
    super.setText(text);
    super.setSize(70, 70);
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
        TinySound.init();
        Sound bs = TinySound.loadSound(soundName);
        this.buttonSound = bs;        
    }
    
  
    
    //returns the sound object of the button.
    public Sound getTinySound() {
        return this.buttonSound;
    }
    
    public boolean isActivated(){
        return this.isActivated;
    }
    
    public void setActive() {
        this.isActivated = this.isActivated ? false : true;
            
        
        if (this.isActivated == true) {
        this.setBackground(Color.LIGHT_GRAY);
        //this.buttonSound.play();
        } else {
            this.setBackground(Color.DARK_GRAY);
        }
    }
    
//    public boolean getPressed() {
//        return Starter.sendPressed();
//    }
    
}
    
