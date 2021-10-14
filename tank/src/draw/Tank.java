package draw;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-09 22:13
 */
public class Tank {
    private int xIndex;
    private int yIndex;
    private Direction direction = Direction.UP;//坦克初始方向
    private int speed = 4;

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveUP() {
        yIndex -= speed;
    }

    public void moveDown() {
        yIndex += speed;
    }

    public void moveRight() {
        xIndex += speed;
    }

    public void moveLeft() {
        xIndex -= speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Tank(int xIndex, int yIndex) {
        this.xIndex = xIndex;
        this.yIndex = yIndex;
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
