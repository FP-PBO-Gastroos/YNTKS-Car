import java.util.Random;

/**
 * Kelas ExtraTime merupakan kelas yang merepresentasikan elemen tambahan waktu
 * yang terdapat dalam sebuah permainan.
 */
public class ExtraTime extends Elements {
    // Objek random yang akan digunakan untuk menentukan posisi elemen tambahan waktu secara acak.
    Random random = new Random();

    /**
     * Constructor untuk menciptakan elemen tambahan waktu baru.
     * @parameter origin Koordinat y dari titik asal elemen.
     * @parameter vel Kecepatan elemen tambahan waktu.
     */
    public ExtraTime(int origin, int vel)
    {
        // Menentukan posisi x secara acak antara 5 dan 340.
        this.setXRandom(5,340);
        // Menentukan posisi y sesuai dengan parameter origin.
        this.y=origin;
        // Menentukan kecepatan y sesuai dengan parameter vel.
        this.yvel=5;
        // Menentukan tinggi elemen tambahan waktu.
        this.height=44;
        // Menentukan lebar elemen tambahan waktu.
        this.width=51;
    }

    /**
     * Method untuk memeriksa apakah elemen tambahan waktu sudah melewati batas layar.
     * Jika sudah, maka elemen tambahan waktu akan direset ke posisi awal dan ditampilkan kembali.
     */
    public void checkBound()
    {
        // Jika posisi y elemen tambahan waktu lebih besar dari 800, maka elemen tersebut akan direset ke posisi awal.
        if (this.y>800)
        {
            // Menentukan posisi x secara acak antara 5 dan 340.
            this.setXRandom(5,340);
            // Menentukan posisi y sebesar -400.
            this.y=-400;
            // Menampilkan elemen tambahan waktu kembali.
            this.hidden=false;
        }
    }
}
