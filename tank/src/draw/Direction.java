package draw;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-09 22:49
 */
public enum Direction {
    UP(1, "UP"),
    DOWN(2, "DOWN"),
    LEFT(3, "LEFT"),
    RIGHT(4, "RIGHT");

    private int value;
    private String direction;

    Direction(int value, String direction) {
        this.value = value;
        this.direction = direction;
    }

    public int getValue() {
        return value;
    }

    public String getDirection() {
        return direction;
    }

}
