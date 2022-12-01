
import java.awt.*;

/**
 * Created by Ram on 7/6/2016.
 */
public class Car extends Elements{
    private static int carVar=0;
	public int yVel;


    public Car()
    {
        this.y=550;
        this.x=100;
        this.xVel=0;
        this.yvel=0;
        this.width=55;
        this.height=80;
    }

    public void checkBound()
    { if(this.x<=0)
        this.x=0;
    else if(x>=345)
        this.x=345;
    if(this.y<=0)
        this.y=0;
    else if(y>=345)
        this.y=345;
    }
}

