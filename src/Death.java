import java.awt.*;
import java.util.Random;

public class Death extends Elements{

    Random random = new Random();

    public Death(int origin,int vel)
    {
        this.setXRandom(5,340);
        this.y=origin;
        this.yvel=5;
        this.width=44;
        this.height=46;
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

//    private void setX()
//    {
//        int r= random.nextInt(2);
//        if (r==0)
//            this.x=0;
//        else
//        	//letak x salah satu death
//            this.x=325;
//    }



