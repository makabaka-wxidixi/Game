package draw;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-09 22:14
 */
public class Hero extends Tank {
    public static List<Bullet> bullets = new ArrayList<>();//存放子弹
    private Bullet bullet = null;

    public Hero(int xIndex, int yIndex) {
        super(xIndex, yIndex);
    }

    /**
     * 调用fire的时候会开启子弹线程
     *
     * @param x         坦克的坐标
     * @param y
     * @param direction 坦克的方向
     */
    public void fire(int x, int y, Direction direction) {
        //根据传入的方向不同，来开启不同的线程
        switch (direction) {
            case UP:
                Bullet bullet1 = new Bullet(x + 18, y - 10, direction);
                bullets.add(bullet1);
                bullet1.start();
                break;
            case DOWN:
                Bullet bullet2 = new Bullet(x + 18, y + 60, direction);
                bullets.add(bullet2);
                bullet2.start();
                break;
            case RIGHT:
                Bullet bullet3 = new Bullet(x + 50, y + 28, direction);
                bullets.add(bullet3);
                bullet3.start();
                break;
            case LEFT:
                Bullet bullet4 = new Bullet(x - 20, y + 28, direction);
                bullets.add(bullet4);
                bullet4.start();
                break;
            default:
                System.out.println("子弹方向错误");
                break;
        }
    }

}
