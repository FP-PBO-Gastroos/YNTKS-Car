import java.util.Random;

public class enemy1 extends Elements{

    Random random = new Random();

    public enemy1(int origin,int vel)
    {
        this.setXRandom(5,340);
        this.y=origin;
        this.yvel=vel;
        this.width=55;
        this.height=80;
    }


    public void checkBound()
    {
        if(this.y>800) {
            this.hidden=false;
            this.y = -400;
            this.setXRandom(5,340);
        }

    }
}
