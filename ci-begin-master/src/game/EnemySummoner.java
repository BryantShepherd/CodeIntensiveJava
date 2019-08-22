package game;

public class EnemySummoner extends GameObject {
    //Definition
    public int frameCount = 0;
    public int delaySummon = 120; //2 seconds
    public EnemySummoner() {

    }

    @Override
    public void run() {
        frameCount++;
        if (frameCount > delaySummon) {
            new Enemy(); //TODO: What the heck is new Enemy()
            frameCount = 0;
        }
    }
}
