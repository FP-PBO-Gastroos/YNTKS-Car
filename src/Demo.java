import javax.swing.*; // import kelas swing

// kelas Demo
public class Demo {
  // deklarasi frame sebagai objek JFrame
  public static JFrame frame;

  public static void main(String[] args) {
    // membuat objek frame dengan judul "YNTKS Car"
    frame = new JFrame("YNTKS Car");
    // mengatur agar program berhenti saat frame ditutup
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // membuat objek panel sebagai GamePanel
    GamePanel panel = new GamePanel();
    // mengatur panel sebagai content pane dari frame
    frame.setContentPane(panel);
    // mengatur agar frame tidak bisa diubah ukurannya
    frame.setResizable(false);
    // menyesuaikan ukuran frame sesuai dengan komponen di dalamnya
    frame.pack();
    // menampilkan frame
    frame.setVisible(true);
  }
}
