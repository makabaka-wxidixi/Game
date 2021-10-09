package draw;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-09 22:13
 */
public class Tank {
    private int xIndex;
    private int yIndex;

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
