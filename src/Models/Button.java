
package Models;
import java.awt.Color;
import javax.swing.JButton;
import soundloop.Controller.Starter;

public class Button extends JButton {
    private boolean[][] buttonPressed = new boolean[10][10];
    
    public Button(String text) {
    super.setText(text);
    super.setSize(80, 80);
    super.setBackground(Color.DARK_GRAY);
    
}
    
    private void setButton(boolean val, int a, int b) {
        buttonPressed[a][b] = val;
    }
    
    public boolean getPressed() {
        return Starter.sendPressed();
    }
    
}
