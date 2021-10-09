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
        drawTank(hero.getxIndex(), hero.getyIndex(), g, Direction.UP, Army.ENEMY);
    }

    public void drawTank(int x, int y, Graphics g, Direction direction, Army army) {
        switch (army) {
            case ENEMY:
                g.setColor(Color.cyan);
                break;
            case HERO:
                g.setColor(Color.yellow);
                break;
            default:
                System.out.println("坦克党派错误");
                break;
        }
        switch (direction) {
            case UP:
                g.fillRect(x,y,10,60);
                break;
            case DOWN:
                System.out.println("向下");
                break;
            case LEFT:
                System.out.println("向左");
                break;
            case RIGHT:
                System.out.println("向右");
                break;
            default:
                System.out.println("方向错误");
                break;
        }

    }
}
