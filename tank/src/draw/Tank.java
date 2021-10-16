package draw;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-09 22:13
 */
public class Tank {
    private int xIndex;
    private int yIndex;
    private Direction direction;//坦克初始方向
    private int speed = 4;

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveUP() {
        if (yIndex > 0)//当还没有到达边界的时候才移动
            yIndex -= speed;
        else if(this instanceof EnemyTank){//如果是敌方坦克
            this.changeDirection();
        }else{
            ;
        }
    }

    public void moveDown() {
        if (yIndex < 540)
            yIndex += speed;
        else if(this instanceof EnemyTank){//如果是敌方坦克
            this.changeDirection();
        }else{
            ;
        }
    }

    public void moveRight() {
        if (xIndex < 740)
            xIndex += speed;
        else if(this instanceof EnemyTank){//如果是敌方坦克
            this.changeDirection();
        }else{
            ;
        }
    }

    public void moveLeft() {
        if (xIndex > 0)
            xIndex -= speed;
        else if(this instanceof EnemyTank){//如果是敌方坦克
            this.changeDirection();
        }else{
            ;
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
