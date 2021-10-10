package draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

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
        this.addKeyListener(mp);//给窗口添加监听器，使其拥有监听功能
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}



