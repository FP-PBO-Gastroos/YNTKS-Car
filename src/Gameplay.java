import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Kelas yang menangani logika dan tampilan saat game sedang dimainkan.
 */
public class Gameplay extends State {
    // Variabel yang menyimpan hitungan
    private int count=0;

    @Override
    public void update(Graphics graphics) {
        // Menampilkan gambar gameplay
        graphics.drawImage(Resources.Gameplay, 0, 0, 400, 700, null);
        // Menetapkan warna hitam dan font untuk tulisan
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,24));

        // Jika hitungan bernilai 0, maka musik main menu dihentikan dan musik welcome dimulai
        if (count==0) {
            Resources.mainMenuTone.stop();
            Resources.welcomeTone.loop();
            // Menaikkan hitungan menjadi 1
            count++;
        }

        // Menampilkan tulisan "KEMBALI"
        graphics.drawString("KEMBALI", 300, 660);
    }

    @Override
    public void onMousepressed(MouseEvent e) {
        // Membuat objek Rectangle dengan posisi dan ukuran sesuai dengan posisi dan ukuran tombol "KEMBALI"
        Rectangle r = new Rectangle(290,650,130,40);
        // Jika posisi mouse terletak di dalam area tombol "KEMBALI", maka kembali ke menu utama
        if (r.contains(e.getX(),e.getY()))
        {
            GamePanel.currentState= new MenuState();
        }
    }

    @Override
    public void onKeyPresses(KeyEvent e) {
        // Method kosong
    }
}
