package soundloop.Models;

import java.awt.Color;
import javax.swing.JButton;

public class ControllButton extends JButton {

    /**
     * Sets the size of the menu buttons to 124X30 and sets the text.
     *
     * @param label
     */
    public ControllButton(String label) {
        super(label);
        super.setSize(124, 30);
        super.setForeground(Color.white);
        super.setBackground(Color.DARK_GRAY);
    }
}
