package draw;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-09 22:59
 */
public enum Army {
    ENEMY(1, "ENEMY"),
    HERO(2, "HERO");

    private int value;
    private String typed;

    Army(int value, String typed) {
        this.value = value;
        this.typed = typed;
    }

    public int getValue() {
        return value;
    }

    public String getTyped() {
        return typed;
    }
}
