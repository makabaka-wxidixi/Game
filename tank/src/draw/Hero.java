package draw;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-09 22:14
 */
public class Hero extends Tank {
    private Bullet bullet = null;

    public Bullet getBullet() {
        return bullet;
    }

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
        switch (direction) {
            case UP:
                bullet = new Bullet(x + 18, y - 10, direction);
                break;
            case DOWN:
                bullet = new Bullet(x + 18, y + 60, direction);
                break;
            case RIGHT:
                bullet = new Bullet(x + 50, y + 28, direction);
                break;
            case LEFT:
                bullet = new Bullet(x - 20, y + 28, direction);
                break;
            default:
                System.out.println("子弹方向错误");
                break;
        }
        //线程开启
        bullet.start();
    }

}
