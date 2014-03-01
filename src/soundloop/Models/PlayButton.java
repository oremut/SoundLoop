/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package soundloop.Models;

import java.awt.Color;
import javax.swing.JButton;

public class PlayButton extends JButton {
public PlayButton(String label) {
    super(label);
    super.setSize(80, 80);
    super.setForeground(Color.white);
    super.setBackground(Color.DARK_GRAY);
}
}
