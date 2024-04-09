import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TimerDisplay extends JLabel {
    Action toggleTimer;

    public ScrambleGenerator scrambleGenerator;

    float elapsedTime = 0;
    int miliseconds = 0;
    int seconds = 0;
    int minutes = 0;

    boolean isRunning = false;

    String milisecondString = String.format("%02d", miliseconds);

    Timer timer = new Timer(1, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            elapsedTime += 1.5415;
            minutes = (int)((elapsedTime/6000) % 60);
            seconds = (int)((elapsedTime/100) % 60);
            miliseconds = (int)(elapsedTime) % 100;

            milisecondString = String.format("%02d", miliseconds);

            if (minutes > 0) {
                setText(minutes + ":" + seconds + "." + milisecondString);
                if (seconds < 10) {
                    setText(minutes + ":0" + seconds + "." + milisecondString);
                }
            } else {
                setText(seconds + "." + milisecondString);
            }
        }
    });

    public TimerDisplay() {
        setText(seconds + "." + milisecondString);
        setBounds(0, 1080 / 3 - 150, 1920, 300);
        setFont(new Font("Verdana", Font.PLAIN, 100));
        setForeground(Color.WHITE);
        setHorizontalAlignment(JTextField.CENTER);

        scrambleGenerator = new ScrambleGenerator();
        add(scrambleGenerator);

        toggleTimer = new ToggleTimer();

        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), "toggleTimer");
        getActionMap().put("toggleTimer", toggleTimer);
    }

    public void run() {
        if (isRunning) {
            elapsedTime = 0;
            timer.start();
        } else {
            timer.stop();
            scrambleGenerator.generateScramble();
            scrambleGenerator.setText(scrambleGenerator.scramble);
            scrambleGenerator.scramble = "";
        }
    }

    public class ToggleTimer extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            isRunning = !isRunning;
            run();
        }
    }
}
