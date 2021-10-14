package draw;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-10 13:40
 */
public class EnemyTank extends Tank {
    private Direction direction = Direction.DOWN;

    public EnemyTank(int xIndex, int yIndex) {
        super(xIndex, yIndex);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
