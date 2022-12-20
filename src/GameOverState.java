import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Kelas yang menangani logika dan tampilan saat game over.
 */
public class GameOverState extends State {
    // Array yang berisi pilihan yang ditampilkan saat game over
    private Object[] options = {"MAIN LAGI",
            "KELUAR",};
    // Variabel yang menyimpan pilihan yang dipilih oleh user
    private int n;
    @Override
    public void update(Graphics graphics)
    {
        // Menstop musik yang sedang diputar saat game over
        Resources.carMoving.stop();
        // Memulai pemutaran musik game over
        Resources.gameOverTone.loop();

        // Menampilkan dialog box yang menanyakan apakah user ingin main lagi atau keluar
        n = JOptionPane.showOptionDialog(Demo.frame,
                "YO NDAK TAU KOK TANYA SAYA..",
                "KOK KALAH SIH??!!",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,null,
                options,
                options[1]);

        // Jika user memilih "MAIN LAGI", maka kembali ke menu utama
        if (n==0)
            GamePanel.currentState= new MenuState();
        // Jika user memilih "KELUAR", maka program akan keluar
        else
            System.exit(0);
    }

    @Override
    public void onMousepressed(MouseEvent e) {
        // Method kosong
    }

    @Override
    public void onKeyPresses(KeyEvent e) {
        // Method kosong
    }
}
