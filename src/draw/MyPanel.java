package draw;


import javax.swing.*;
import java.awt.*;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-09 22:13
 */
class MyPanel extends JPanel {

    Hero hero = null;

    public MyPanel() {
        hero = new Hero(100, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 800, 600);
    }
}
