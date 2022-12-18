import java.util.Random;


public class ExtraTime extends Elements {
	Random random = new Random();
    public ExtraTime(int origin, int vel)
    {
        this.setXRandom(5,340);
        this.y=origin;
        this.yvel=5;
        this.height=44;
        this.width=51;
    }

    public void checkBound()
    {
        if (this.y>800)
        {
            this.setXRandom(5,340);
            this.y=-400;
            this.hidden=false;
        }
    }
}
