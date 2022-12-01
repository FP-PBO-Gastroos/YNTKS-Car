import java.awt.*;

public class Car extends Elements{
    private static int carVar=0;


    public Car()
    {
    	//Koordinat letak mobil
        this.y=530;
        this.x=176;
        this.xVel=0;
        this.width=55;
        this.height=80;
    }

    public void checkBound()
    { if(this.x<=0)
        this.x=0;
    else if(x>=345)
        this.x=345;
    }
}

