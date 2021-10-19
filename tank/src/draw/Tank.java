package draw;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-09 22:13
 */
public class Tank {
    private int xIndex;
    private int yIndex;
    private Direction direction;//坦克初始方向
    private int speed = 4;//坦克的速度
    public static List<Bullet> bullets = new ArrayList<>();//存放打出来的子弹
    public static final int INTERVAL = 30;//间隔，用于敌方坦克开炮和转向

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * 调用fire的时候会根据方向的不同，会创建不同的子弹对象，然后放入集合中
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
                Bullet bullet3 = new Bullet(x + 60, y + 18, direction);
                bullets.add(bullet3);
                bullet3.start();
                break;
            case LEFT:
                Bullet bullet4 = new Bullet(x - 10, y + 18, direction);
                bullets.add(bullet4);
                bullet4.start();
                break;
            default:
                System.out.println("子弹方向错误");
                break;
        }
    }

    /**
     * 如果原来为纵向，那么将坦克改变为横向
     * 如果原来为横向，那么将坦克改变为纵向
     */
    public void setDirection() {
        int i = (int) (Math.random() * 2);//0或者1
        if (this.isYOrX() == 1) {
            if (i == 1) {
                this.direction = Direction.RIGHT;
            } else {
                this.direction = Direction.LEFT;
            }
        } else {
            if (i == 1) {
                this.direction = Direction.UP;
            } else {
                this.direction = Direction.DOWN;
            }
        }
    }

    /**
     * this为英雄坦克，判断时是否和敌方坦克碰到
     *
     * @return 如果碰到就返回true，反之false
     */
    private boolean heroTouch() {
        for (int i = 0; i < MyPanel.getEnemyTankes().size(); i++) {
            //如果碰到，敌方坦克就调整方向
            //判断左下角到右上角
            if (this.getFloorBorderY() <= MyPanel.getEnemyTankes().get(i).getBottomBorderY()//英雄坦克上边界小于等于敌方坦克
                    && this.getRightBorderX() >= MyPanel.getEnemyTankes().get(i).getLeftBorderX()//英雄坦克下边界大于等于敌方坦克
                    && this.getBottomBorderY() >= MyPanel.getEnemyTankes().get(i).getFloorBorderY()
                    && this.getLeftBorderX() <= MyPanel.getEnemyTankes().get(i).getRightBorderX()) {
                return true;
            }
            //判断左上角到右下角
            if (this.getBottomBorderY() >= MyPanel.getEnemyTankes().get(i).getFloorBorderY()//英雄坦克左边界小于等于敌方坦克
                    && this.getRightBorderX() >= MyPanel.getEnemyTankes().get(i).getLeftBorderX()//英雄坦克右边界大于等于敌方坦克
                    && this.getFloorBorderY() <= MyPanel.getEnemyTankes().get(i).getBottomBorderY()
                    && this.getLeftBorderX() <= MyPanel.getEnemyTankes().get(i).getRightBorderX()) {
                return true;
            }
        }
        return false;
    }

    /**
     * this 是敌方坦克
     *
     * @return 碰到就返回true，否则false；
     */
    public boolean enemyTouch() {
        for (int i = 0; i < MyPanel.getEnemyTankes().size(); i++) {
            if (MyPanel.getEnemyTankes().get(i) == this) {//防止自己和自己判断
                continue;
            }
            //如果碰到，敌方坦克就调整方向
            //判断上下边界
            if (this.getFloorBorderY() <= MyPanel.getEnemyTankes().get(i).getBottomBorderY()//英雄坦克上边界小于等于敌方坦克
                    && this.getRightBorderX() >= MyPanel.getEnemyTankes().get(i).getLeftBorderX()//英雄坦克下边界大于等于敌方坦克
                    && this.getBottomBorderY() >= MyPanel.getEnemyTankes().get(i).getFloorBorderY()
                    && this.getLeftBorderX() <= MyPanel.getEnemyTankes().get(i).getRightBorderX())//英雄坦克下边界大于等于敌方坦克
                return true;
            //判断左右边界
            if (this.getBottomBorderY() >= MyPanel.getEnemyTankes().get(i).getFloorBorderY()//英雄坦克左边界小于等于敌方坦克
                    && this.getRightBorderX() >= MyPanel.getEnemyTankes().get(i).getLeftBorderX()//英雄坦克右边界大于等于敌方坦克
                    && this.getFloorBorderY() <= MyPanel.getEnemyTankes().get(i).getBottomBorderY()
                    && this.getLeftBorderX() <= MyPanel.getEnemyTankes().get(i).getRightBorderX())//英雄坦克右边界大于等于敌方坦克
                return true;
        }
        //判断和英雄坦克之间是否碰到
        if (this.getFloorBorderY() <= MyPanel.getHero().getBottomBorderY()//英雄坦克上边界小于等于敌方坦克
                && this.getRightBorderX() >= MyPanel.getHero().getLeftBorderX()//英雄坦克下边界大于等于敌方坦克
                && this.getBottomBorderY() >= MyPanel.getHero().getFloorBorderY()
                && this.getLeftBorderX() <= MyPanel.getHero().getRightBorderX())//英雄坦克下边界大于等于敌方坦克
            return true;
        //判断左右边界
        if (this.getBottomBorderY() >= MyPanel.getHero().getFloorBorderY()//英雄坦克左边界小于等于敌方坦克
                && this.getRightBorderX() >= MyPanel.getHero().getLeftBorderX()//英雄坦克右边界大于等于敌方坦克
                && this.getFloorBorderY() <= MyPanel.getHero().getBottomBorderY()
                && this.getLeftBorderX() <= MyPanel.getHero().getRightBorderX())//英雄坦克右边界大于等于敌方坦克
            return true;
        return false;
    }

    //坦克向上移动
    public void moveUP() {
        if (this instanceof Hero) {//如果是英雄坦克
            if (yIndex > 0)
                yIndex -= speed;
        } else {//调用move的是敌方坦克
            if (yIndex > 0) {//先移动，然后再判断是否碰撞
                yIndex -= speed;
                if (enemyTouch()) {//如果发生碰撞退一步，然后转向
                    yIndex += speed;
                    this.changeDirection();
                }
            } else
                this.changeRandomDirection();
        }
    }

    public void moveDown() {
        if (this instanceof Hero) {//如果是英雄坦克
            if (yIndex < 540)
                yIndex += speed;
        } else {//调用move的是敌方坦克
            if (yIndex < 540) {
                yIndex += speed;
                if (enemyTouch()) {
                    yIndex -= speed;
                    this.changeDirection();
                }
            } else
                this.changeRandomDirection();
        }
    }

    public void moveRight() {
        if (this instanceof Hero) {//如果是英雄坦克
            if (xIndex < 740)
                xIndex += speed;
        } else {//调用move的是敌方坦克
            if (xIndex < 740) {//先移动，然后再判断是否碰撞
                xIndex += speed;
                if (enemyTouch()) {//如果发生碰撞退一步，然后转向
                    xIndex -= speed;
                    this.changeDirection();
                }
            } else
                this.changeRandomDirection();
        }
    }

    public void moveLeft() {
        if (this instanceof Hero) {//如果是英雄坦克
            if (xIndex > 0)
                xIndex -= speed;
        } else {//调用move的是敌方坦克
            if (xIndex > 0) {//先移动，然后再判断是否碰撞
                xIndex -= speed;
                if (enemyTouch()) {//如果发生碰撞退一步，然后转向
                    xIndex += speed;
                    this.changeDirection();
                }
            } else
                this.changeRandomDirection();
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        if (this.direction == Direction.UP || this.direction == Direction.DOWN) {
            if (direction == Direction.RIGHT || direction == Direction.LEFT) {
                this.xIndex -= 10;
                this.yIndex += 10;
            }
            this.direction = direction;
        } else {
            if (direction == Direction.DOWN || direction == Direction.UP) {
                this.xIndex += 10;
                this.yIndex -= 10;
            }
            this.direction = direction;
        }
    }

    /*
    初始化坦克的坐标、方向
     */
    public Tank(int xIndex, int yIndex, Direction direction) {
        this.xIndex = xIndex;
        this.yIndex = yIndex;
        this.direction = direction;
    }

    //坦克随机得到一个方向
    public void changeRandomDirection() {
//        for (int i = 0; i < MyPanel.getEnemyTankes().size(); i++) {
//            if (this.isYOrX() == MyPanel.getEnemyTankes().get(i).isYOrX()) {//如果是两个坦克的朝向是不是相同或者相反
//                if (isYOrX() == 1) {
//                    if (MyPanel.getEnemyTankes().get(i).getLeftBorderX() - this.getRightBorderX() <= 10
//                            && this.getBottomBorderY() >= MyPanel.getEnemyTankes().get(i).getFloorBorderY()
//                            && this.getBottomBorderY() <= MyPanel.getEnemyTankes().get(i).getBottomBorderY()
//                            || this.getFloorBorderY() >= MyPanel.getEnemyTankes().get(i).getFloorBorderY()
//                            && this.getFloorBorderY() <= MyPanel.getEnemyTankes().get(i).getBottomBorderY()) {//两个坦克距离小于等于10就想不同方向走
//                        MyPanel.getEnemyTankes().get(i).setDirection(Direction.UP);
//                        this.direction = Direction.DOWN;
//                        return;
//                    }
//                } else {
//                    if (MyPanel.getEnemyTankes().get(i).getFloorBorderY() - this.getBottomBorderY() <= 10
//                            && this.getLeftBorderX() >= MyPanel.getEnemyTankes().get(i).getLeftBorderX()
//                            && this.getLeftBorderX() <= MyPanel.getEnemyTankes().get(i).getRightBorderX()
//                            || this.getRightBorderX() >= MyPanel.getEnemyTankes().get(i).getLeftBorderX()
//                            && this.getRightBorderX() <= MyPanel.getEnemyTankes().get(i).getRightBorderX()) {
//                        MyPanel.getEnemyTankes().get(i).setDirection(Direction.LEFT);
//                        this.direction = Direction.RIGHT;
//                        return;
//                    }
//                }
//            }
//        }
        this.setDirection(Direction.getRandomDirection());
    }

    /**
     * 将坦克掉头180度
     */
    public void changeDirection() {
        switch (this.direction) {
            case UP:
                setDirection(Direction.DOWN);
                break;
            case DOWN:
                setDirection(Direction.UP);
                break;
            case RIGHT:
                setDirection(Direction.LEFT);
                break;
            case LEFT:
                setDirection(Direction.RIGHT);
                break;
            default:
                break;
        }
    }

    //得到右边界
    public int getRightBorderX() {
        if (direction == Direction.DOWN || direction == Direction.UP) {
            return xIndex + 40;
        } else {
            return xIndex + 60;
        }
    }


    //得到下边界
    public int getBottomBorderY() {
        if (direction == Direction.DOWN || direction == Direction.UP) {
            return yIndex + 60;
        } else {
            return yIndex + 40;
        }
    }

    /**
     * 判断坦克是横向还是纵向
     *
     * @return 如果是纵向的就返回1，横向的就返回0
     */
    public int isYOrX() {
        if (this.direction == Direction.DOWN || this.direction == Direction.UP)
            return 1;
        else
            return 0;
    }

    //得到上边界
    public int getFloorBorderY() {
        return yIndex;
    }

    //得到左边界
    public int getLeftBorderX() {
        return xIndex;
    }

    public int getxIndex() {
        return xIndex;
    }

    public void setxIndex(int xIndex) {
        this.xIndex = xIndex;
    }

    public int getyIndex() {
        return yIndex;
    }

    public void setyIndex(int yIndex) {
        this.yIndex = yIndex;
    }
}
