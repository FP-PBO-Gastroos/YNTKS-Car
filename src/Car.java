import java.awt.*;

/**
 * Kelas ini mewakili mobil dalam sebuah game
 */
public class Car extends Elements {
    // Sebuah variabel statis yang menyimpan nilai spesifik mobil.
    private static int carVar = 0;

    /**
     * Constructs Membuat objek mobil baru.
     */
    public Car() {
        // Menginisialisasi koordinat y dari posisi mobil.
        this.y = 530;
        // Menginisialisasi koordinat x dari posisi mobil.
        this.x = 176;
        // Menginisialisasi kecepatan x mobil.
        this.xVel = 0;
        // Menginisialisasi kecepatan y mobil.
        this.yvel = 0;
        // Menginisialisasi lebar mobil.
        this.width = 55;
        // Menginisialisasi tinggi mobil.
        this.height = 80;
    }

    /**
     * Memeriksa apakah mobil berada dalam batasan tertentu dan menyesuaikan posisinya jika diperlukan.
     */
    public void checkBound() {
        // Jika koordinat x mobil kurang dari atau sama dengan 0, set ke 0.
        if (this.x <= 0) {
            this.x = 0;
        }
        // Jika tidak, jika koordinat x lebih besar atau sama dengan 345, set ke 345.
        else if (this.x >= 345) {
            this.x = 345;
        }
    }
}
