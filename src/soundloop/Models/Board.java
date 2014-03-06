package soundloop.Models;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener {

private int curX;
private int curY;
private int numOfButtons = 10;
private int a = 0;
private int b = 0;
private int xvalue = 40;
private int yvalue = 120;
private int tempo = 250;

private boolean paused = false;
ToneButton t;
ActionListener e;
private SoundButton[][] button = new SoundButton[numOfButtons][numOfButtons];
private JButton buttons[] = new JButton[7];

public Board() {
buttons[0] = new ToneButton("tone 1");
buttons[1] = new ToneButton("tone 2");
buttons[2] = new ToneButton("tone 3");
buttons[3] = new SaveButton("Save");
buttons[4] = new LoadButton("Load");
buttons[5] = new PlayButton("Pause");
buttons[6] = new PlayButton("Clear");
this.setLayout(null);

for (int i = 0; i < numOfButtons; i++) {
for (int o = 0; o < numOfButtons; o++) {
button[i][o] = new SoundButton("");
button[i][o].setTinySound("sound"+(i+1)+".wav");
button[i][o].addActionListener(this);
this.add(button[i][o]);
button[i][o].setLocation(xvalue, yvalue);
xvalue += 88;
}
xvalue = 40;
yvalue += 88;
}
int nothaY = 24;
for (int i = 0; i < 7; i++) {
this.add(buttons[i], i);
buttons[i].addActionListener(this);
buttons[i].setLocation(nothaY, 20);
nothaY += 136;
}
this.setBackground(Color.black);
this.setSize(945, 1025);
this.setVisible(true);
}
public void setTempo(int delay){
delay /=2;
if(delay < 75){
delay = 1000;
}
tempo = delay;
}

public int getTempo(){
return tempo;
}
//Tell this method the column number we want all the buttons from
//and it will return an array with all the SoundButtons from that column
public SoundButton[] getButtonsInColumn(int columnNumber) {
SoundButton columnSoundButtons[] = new SoundButton[10];
for (int i = 0; i < numOfButtons; i++) {

columnSoundButtons[i] = button[i][columnNumber];
}

return columnSoundButtons;
}

@Override
public void actionPerformed(ActionEvent e) {
boolean pauseWasChanged = false;
boolean tempoWasChanged = false;
for (int i = 0; i < numOfButtons; i++) {

for (int j = 0; j < numOfButtons; j++) {
if (e.getSource() == button[i][j]) {
button[i][j].setActive();
}
if (e.getSource() == buttons[4] && tempoWasChanged == false) {
this.setTempo(tempo);
tempoWasChanged = true;
}
if (e.getSource() == buttons[5] && pauseWasChanged == false) {
setPaused(this.paused);
pauseWasChanged = true;
}


if (e.getSource() == buttons[6]) {
button[i][j].setActive(false);
}

}
}
}

public void setPaused(boolean currentState){
if(currentState){
paused = false;
buttons[5].setText("Pause");
}
if(currentState == false){
paused = true;
buttons[5].setText("Play");
}
}

public void unpaused(){
paused = false;
}
public boolean getPaused(){
return paused;

}
}