package draw;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-10 13:40
 */
public class EnemyTank extends Tank implements Runnable {
    private TankType tankType;//默认坦克等级是一级
    private int step = initStep();//坦克步长
    private int currStep = 0;//用于记录当前坦克走了多少步

    //用于初始化坦克的步长
    private int initStep() {
        int i = (int) (Math.random() * 10 + 30);//范围100-130
        return i;
    }

    public EnemyTank(int xIndex, int yIndex, Direction direction, TankType tankType) {
        super(xIndex, yIndex, direction);
        this.tankType = tankType;//赋值坦克类型
    }

    //敌方坦克的行为
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //坦克朝相应的方向运动
            switch (getDirection()) {
                case UP -> {
                    moveUP();
                    currStep++;
                }
                case DOWN -> {
                    moveDown();
                    currStep++;
                }
                case RIGHT -> {
                    moveRight();
                    currStep++;
                }
                case LEFT -> {
                    moveLeft();
                    currStep++;
                }
                default -> {
                    System.out.println("敌方坦克自动掉头的地方出错");
                }
            }
            //如果坦克是上下方向
//            if (getDirection() == Direction.UP || getDirection() == Direction.DOWN) {
//                if (getxIndex() <= 0 || getxIndex() >= 760 || getyIndex() <= 0 || getyIndex() >= 540) {
//                    this.changeDirection();
//                    currStep = 0;//坦克当前步长设置为0
//                    continue;
//                }
//            }
//            //如果坦克是左右方向
//            if (getDirection() == Direction.RIGHT || getDirection() == Direction.LEFT) {
//                if (getxIndex() <= 0 || getxIndex() >= 740 || getyIndex() <= 0 || getyIndex() >= 560) {
//                    this.changeDirection();
//                    currStep = 0;//坦克当前步长设置为0
//                    continue;
//                }
//            }
            if (currStep == step) {
                this.changeRandomDirection();//得到随机方向
                currStep = 0;
            }
        }

    }
}
