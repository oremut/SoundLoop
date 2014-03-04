/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package soundloop.Models;

import java.awt.Color;
import javax.swing.JButton;

public class ToneButton extends JButton {
public ToneButton(String label) {
    super(label);
    super.setSize(80, 80);
    super.setForeground(Color.white);
    super.setBackground(Color.DARK_GRAY);
}

public void changeColor(){
    super.setBackground(Color.YELLOW);
}
}
