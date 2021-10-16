package draw;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-09 22:49
 */
public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public static Direction getRandomDirection() {
        int i = (int) (Math.random() * 4 + 1);//得到1,2,3,4其中的一个数据
        switch (i) {
            case 1:
                return UP;
            case 2:
                return DOWN;
            case 3:
                return RIGHT;
            case 4:
                return LEFT;
            default:
                System.out.println("Direction类中出现异常");
                return null;
        }
    }
}
