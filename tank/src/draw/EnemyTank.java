package draw;

/**
 * @Author mkbk
 * @Description
 * @Create 2021-10-10 13:40
 */
public class EnemyTank extends Tank implements Runnable {
    private TankType tankType;//坦克等级
    private int step = initStep();//坦克步长
    private int currStep = 0;//用于记录当前坦克走了多少步
    private int fireInterval = step * 3;//坦克射击间隔

    //用于初始化坦克的步长，在不碰到墙壁的前提下，走一个步长的距离地方坦克会调整方向
    private int initStep() {
        int i = (int) (Math.random() * 11 + INTERVAL);//范围10-40
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
                    ++currStep;
                    --fireInterval;
                }
                case DOWN -> {
                    moveDown();
                    ++currStep;
                    --fireInterval;
                }
                case RIGHT -> {
                    moveRight();
                    ++currStep;
                    --fireInterval;
                }
                case LEFT -> {
                    moveLeft();
                    ++currStep;
                    --fireInterval;
                }
                default -> {
                    System.out.println("敌方坦克自动掉头的地方出错");
                }
            }
            if (currStep == step) {//达到步长就调整方向
                this.changeRandomDirection();//得到随机方向
                currStep = 0;
            }
            if (fireInterval == 0) {//开火
                fireInterval = 3 * step;
                this.fire(this.getxIndex(), this.getyIndex(), this.getDirection());
            }
        }

    }
}
