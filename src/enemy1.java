import java.util.Random;
	/**
		Kelas untuk mengendalikan enemy1.
	*/
public class enemy1 extends Elements{
	// Atribut untuk menggenerate angka random
    Random random = new Random();
    /**
    Konstruktor untuk membuat objek enemy1 baru.
     origin Titik awal y enemy1.
     vel Kecepatan enemy1.
    */
    public enemy1(int origin,int vel)
    {
        this.setXRandom(5,340);
        this.y=origin;
        this.yvel=vel;
        this.width=55;
        this.height=80;
    }

    /**
    Method untuk mengecek apakah enemy1 sudah melewati batas layar.
    Jika ya, maka posisi enemy1 akan direset ke atas layar dan nilai hidden akan dikembalikan ke false.
    */
    public void checkBound()
    {
        if(this.y>800) {
            this.hidden=false;
            this.y = -400;
            this.setXRandom(5,340);
        }

    }
}
