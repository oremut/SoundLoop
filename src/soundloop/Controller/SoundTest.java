/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundloop.Controller;

import javax.swing.JFrame;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;
import soundloop.Models.Board;
import soundloop.Models.SoundButton;

public class SoundTest {

    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(945, 1030);
        frame.setLayout(null);
        Board board = new Board();
        frame.getContentPane().add(board);
        frame.setVisible(true);
        
//        SoundButton buttons[] = new SoundButton[10];
//        buttons = board.getButtonsInColumn(1);
//        
//        buttons[1].setActive();
//        buttons[5].setActive();
//        
//        SoundController sc = new SoundController();
//        
//        sc.playActiveSounds(buttons);
        
        TinySound.init();
        SoundButton sb = new SoundButton("title");
        
        Sound buttonSound = sb.getTinySound();
        buttonSound.play();
        
        
    }
}