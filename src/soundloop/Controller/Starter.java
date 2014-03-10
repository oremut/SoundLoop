package soundloop.Controller;

import javax.swing.*;
import soundloop.Models.SoundButton;
import soundloop.View.Board;

public class Starter {

    public static void main(String args[]) {

        JFrame frame = new JFrame();
        Board board = new Board();                
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(board.getWidth(), board.getHeight());
        frame.setLayout(null);

        frame.getContentPane().add(board);
        frame.setVisible(true);

        SoundButton buttons[] = new SoundButton[10];
        buttons = board.getButtonsInColumn(1);

        SoundController sc = new SoundController(board);

        while (true) {

            sc.playActiveSounds();

        }

    }    
}
