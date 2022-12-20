import java.util.Random;
	/**
	Kelas untuk mengendalikan enemy4.
	*/

public class enemy4 extends Elements {
	// Atribut untuk menggenerate angka random
	Random random = new Random();
	/**
    Konstruktor untuk membuat objek enemy4 baru.
     origin Titik awal y enemy4.
     vel Kecepatan enemy4.
    */
	public enemy4(int origin, int vel)
    {
        this.setXRandom(5,340);
        this.yvel=vel;
        this.y=origin;
        this.height=80;
        this.width=55;
    }
    /**
    Method untuk mengecek apakah enemy4 sudah melewati batas layar.
    Jika ya, maka posisi enemy4 akan direset ke atas layar dan nilai hidden akan dikembalikan ke false.
    */
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
