public class Truck extends Elements {

    public Truck(int origin,int vel)
    {
        this.setXRandom(0,300);
        this.y=origin;
        this.yvel=vel;
        this.width=90;
        this.height=150;
        this.hidden=false;
    }

    public void checkBound()
    {
        if (this.y>800)
        {
            this.setXRandom(0,300);
            this.y=-400;
            this.hidden=false;
        }
    }
}
