package draw;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-14 19:30
 */
public class Bullet extends Thread {
    /*
    子弹的坐标、方向、速度
     */
    private int x;
    private int y;
    private Direction direction;
    private int speed = 5;
    public boolean isAlive = false;



    public Bullet() {
    }

    /**
     * @param x         子弹初始坐标
     * @param y
     * @param direction 子弹的方向
     */
    public Bullet(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {
        isAlive = true;
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (this.direction) {
                case UP:
                    y -= speed;
                    break;
                case DOWN:
                    y += speed;
                    break;
                case RIGHT:
                    x += speed;
                    break;
                case LEFT:
                    x -= speed;
                    break;
                default:
                    System.out.println("子弹方向错误");
                    break;
            }
            System.out.println("子弹发射");
            if (this.x >= 800 || this.x <= 0 || this.y >= 600 || this.y <= 0) {
                isAlive = false;
                break;
            }
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
