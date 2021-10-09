package draw;

import javax.swing.*;
import java.awt.*;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-09 21:38
 */
public class Window extends JFrame {
    private MyPanel mp = null;

    public static void main(String[] args) {
        Window window = new Window();
    }

    public Window() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}



