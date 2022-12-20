import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Kelas ini merepresentasikan sebuah game yang telah selesai dimainkan.
 */
public class CompleteGame extends State{
	// Variabel untuk menghitung jumlah kali method update dipanggil.
	private int count=0;

	/**
     * Method ini digunakan untuk memperbarui tampilan game setelah selesai dimainkan.
     * graphics objek Graphics yang digunakan untuk menggambar tampilan game
     */
    @Override
    public void update(Graphics graphics) {
        graphics.setFont(new Font("SansSerif",Font.PLAIN,40));
     // Jika method ini baru pertama kali dipanggil, stop suara selesai game dan putar suara menu utama.
        if (count==0) {
            Resources.finishTone.stop();
            Resources.mainMenuTone.loop();
            count++;
        }

     // Gambar latar belakang putih.
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 400, 700);
        // Gambar gambar selesai game.
        graphics.drawImage(Resources.completeGame, 0, 100, 400, 400, null);
        // Atur warna font menjadi hitam.
        graphics.setColor(Color.BLACK);
        // Atur font menjadi SansSerif, gaya plain, dan ukuran 35.
        graphics.setFont(new Font("SansSerif", Font.PLAIN, 35));
        // Tulis "MAIN LAGI?" di layar.
        graphics.drawString("MAIN LAGI?", 90, 550);
        // Atur font menjadi SansSerif, gaya plain, dan ukuran 30.
        graphics.setFont(new Font("SansSerif", Font.PLAIN, 30));
        // Tulis "YA" dan "TIDAK" di layar.
        graphics.drawString("YA", 105, 600);
        graphics.drawString("TIDAK", 180, 600);




    }
    /**
     * Method ini dipanggil ketika tombol mouse ditekan.
     * e objek MouseEvent yang menyimpan informasi tentang event mouse yang terjadi
     */
    @Override
    public void onMousepressed(MouseEvent e) {
    	// Buat objek Rectangle baru yang berisi area kotak "YA".
        Rectangle r = new Rectangle(105, 570, 60, 40);
        // Buat objek Rectangle baru yang berisi area kotak "TIDAK".
        Rectangle r1 = new Rectangle(180, 570, 50, 40);
        // Jika posisi mouse berada di dalam kotak "YA", pindah ke menu utama.
        if (r.contains(e.getX(),e.getY()))
        {
            GamePanel.currentState= new MenuState();
        }
     // Jika posisi mouse berada di dalam kotak "TIDAK", keluar dari program.
        if (r1.contains(e.getX(),e.getY()))
            System.exit(0);


    }
    
    /**
     * Method ini dipanggil ketika tombol keyboard ditekan.
     * e objek KeyEvent yang menyimpan informasi tentang event keyboard yang terjadi
     */

    @Override
    public void onKeyPresses(KeyEvent e) {

    }
}
