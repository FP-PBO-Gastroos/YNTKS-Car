import java.util.Random;

public class Road extends Elements{
    public Road(int vel)
    {
        this.x=0;
        this.y=-9000;
        this.yvel=vel;

    }

    public void checkBound()
    {
        if (this.y>-10)
            this.y=-9300;

    }

}
