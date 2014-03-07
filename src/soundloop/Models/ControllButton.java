package soundloop.Models;

import java.awt.Color;
import javax.swing.JButton;

public class ControllButton extends JButton {
public ControllButton(String label) {
    super(label);
    super.setSize(80, 80);
    super.setForeground(Color.white);
    super.setBackground(Color.DARK_GRAY);
}
}
