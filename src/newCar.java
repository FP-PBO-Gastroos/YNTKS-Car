import java.util.Random;

public class newCar extends Elements {

    Random random = new Random();
    
    public newCar(int origin, int vel)
    {
        this.setXRandom(5,340);
        this.yvel=vel;
        this.y=origin;
        this.height=80;
        this.width=55;
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
