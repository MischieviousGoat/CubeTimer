import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    public final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    TimerDisplay timer;

    public Window() {
        setTitle("Cube Timer");
        setSize(WIDTH, HEIGHT);
        setLayout(null);
        getContentPane().setBackground(new Color(17, 18, 33));

        timer = new TimerDisplay();
        add(timer);

        setVisible(true);
        setResizable(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
