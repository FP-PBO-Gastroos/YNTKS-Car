import java.awt.*;
import java.util.Random;

public class Death extends Elements {
    private Random random = new Random();

    public Death(int origin,int vel)
    {
        this.setX();
        this.y=origin;
        this.yvel=vel;
        this.width=44;
        this.height=46;
    }

    public void checkBound()
    {
        if (this.y>800)
        {
            this.y=-400;
            this.setX();
            this.hidden=false;
        }
    }

    private void setX()
    {
        int r= random.nextInt(2);
        if (r==0)
            this.x=0;
        else
            this.x=125;
    }


}
