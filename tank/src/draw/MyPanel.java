package draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-09 22:13
 */
class MyPanel extends JPanel implements KeyListener, Runnable {

    private Hero hero = null;
    private Vector<EnemyTank> enemyTankes = new Vector<>();//用来存放敌方坦克
    private int initNumOfEnemy = 3;//初始化敌方坦克数量

    public MyPanel() {
        //初始化英雄坦克
        hero = new Hero(300, 300);
        hero.setSpeed(5);
        //初始化敌方坦克，将其放入集合中去
        for (int i = 0; i < initNumOfEnemy; i++) {
            EnemyTank enemyTank = new EnemyTank(150 * (i + 1), 50);
            enemyTankes.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {//在画板上画一些东西
        super.paint(g);
        g.fillRect(0, 0, 800, 600);
        drawTank(hero.getxIndex(), hero.getyIndex(), g, hero.getDirection(), Army.HERO);

        if (!hero.bullets.isEmpty()) {
            for (Bullet bullet : Hero.bullets) {
                drawBullet(bullet.getX(), bullet.getY(), g, bullet.getDirection());
            }
        }

        for (int i = 0; i < enemyTankes.size(); i++) {//循环画出敌方坦克
            drawTank(enemyTankes.get(i).getxIndex(), enemyTankes.get(i).getyIndex(), g,
                    enemyTankes.get(i).getDirection(), Army.ENEMY);
        }
    }

    public void drawBullet(int x, int y, Graphics g, Direction direction) {
        switch (direction) {
            case UP:
                g.setColor(Color.green);
                g.fillOval(x, y, 4, 10);
                g.fillRect(x, y + 5, 4, 5);
                break;
            case DOWN:
                g.setColor(Color.green);
                g.fillRect(x, y, 4, 5);
                g.fillOval(x, y, 4, 10);
                break;
            case RIGHT:
                g.setColor(Color.green);
                g.fillRect(x, y, 5, 4);
                g.fillOval(x, y, 10, 4);
                break;
            case LEFT:
                g.setColor(Color.green);
                g.fillOval(x, y, 10, 4);
                g.fillRect(x + 5, y, 5, 4);
                break;
            default:
                System.out.println("子弹方向错误");
                break;
        }
    }

    /**
     * 画坦克
     *
     * @param x         坦克坐标
     * @param y         坦克坐标
     * @param g         画笔
     * @param direction 坦克的方向
     * @param army      坦克的军团（敌人还是英雄）
     */
    public void drawTank(int x, int y, Graphics g, Direction direction, Army army) {
        //根据坦克的军团来确定坦克颜色
        switch (army) {
            case ENEMY:
                g.setColor(Color.yellow);
                break;
            case HERO:
                g.setColor(Color.cyan);
                break;
            default:
                System.out.println("坦克党派错误");
                break;
        }
        //根据传入的坦克方向来绘制坦克
        switch (direction) {
            case UP:
                g.drawRect(x, y, 10, 60);
                g.drawRect(x + 30, y, 10, 60);
                g.drawRect(x + 10, y + 10, 20, 40);
                g.drawOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y, x + 20, y + 20);
                break;
            case DOWN:
                g.drawRect(x, y, 10, 60);
                g.drawRect(x + 30, y, 10, 60);
                g.drawRect(x + 10, y + 10, 20, 40);
                g.drawOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 40, x + 20, y + 60);
                break;
            case LEFT:
                g.drawRect(x - 10, y + 10, 60, 10);
                g.drawRect(x - 10, y + 40, 60, 10);
                g.drawRect(x, y + 20, 40, 20);
                g.drawOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 10, y + 30, x - 10, y + 30);
                break;
            case RIGHT:
                g.drawRect(x - 10, y + 10, 60, 10);
                g.drawRect(x - 10, y + 40, 60, 10);
                g.drawRect(x, y + 20, 40, 20);
                g.drawOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 30, y + 30, x + 50, y + 30);
                break;
            default:
                System.out.println("方向错误");
                break;
        }

    }

    //当从键盘上输入的是Ascii中的符号时调用该方法
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //当按压按键时调用该方法
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirection(Direction.UP);
            hero.moveUP();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirection(Direction.DOWN);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirection(Direction.RIGHT);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirection(Direction.LEFT);
            hero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            //坦克射击
            hero.fire(hero.getxIndex(), hero.getyIndex(), hero.getDirection());
        }
        this.repaint();
    }

    //释放按键时调用该方法
    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}
