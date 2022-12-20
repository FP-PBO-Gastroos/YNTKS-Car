import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

/**
 * Kelas yang menangani menu utama dari permainan.
 */
public class MenuState extends State {
	  private  int count=0;
	
	  @Override
	  public void update(Graphics graphics) {
	    // Jika ini adalah pertama kali update dipanggil, maka mainkan suara menu utama dan berhentikan suara lainnya
	    if (count==0) {
	      Resources.mainMenuTone.loop();
	      Resources.gameOverTone.stop();
	      Resources.welcomeTone.stop();
	      count++;
	    }
	
	    // Tampilkan gambar latar belakang dan teks
	    graphics.drawImage(Resources.welcomeToGameImage, 0, 0, 400, 700, null);
	    graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
	    graphics.setColor(Color.BLACK);
	    graphics.drawString("ALUR GAME", 120, 325);
	    graphics.drawString("MULAI GAME", 110, 375);
	    graphics.drawString("KELUAR", 145, 425);
	    graphics.drawString("KONTROL", 137, 475);
	  }
	
	  @Override
	  public void onMousepressed(MouseEvent e) {
	    // Buat objek rectangle untuk masing-masing menu
	    Rectangle r1 = new Rectangle(110, 350, 195, 25); // MULAI
	    Rectangle r2 = new Rectangle(145, 400, 65, 25); // KELUAR
	    Rectangle r3 = new Rectangle(137, 450, 325, 25); // KONTROL
	    Rectangle r4 = new Rectangle(120, 300, 325, 25); // ALUR GAME
	
	    // Cek apakah mouse diklik di salah satu rectangle
	    if(r2.contains(e.getX(), e.getY())) {
	      // Tutup aplikasi jika tombol KELUAR diklik
	      Demo.frame.dispatchEvent(new WindowEvent(Demo.frame, WindowEvent.WINDOW_CLOSING));
	    } else if (r1.contains(e.getX(), e.getY())) {
	      // Pindah ke WelcomeToStage1 jika tombol MULAI diklik
	      GamePanel.currentState = new WelcomeToStage1();
	    } else if (r3.contains(e.getX(), e.getY())) {
	      // Pindah ke Kontrol jika tombol KONTROL diklik
	      GamePanel.currentState = new Kontrol();
	    } else if (r4.contains(e.getX(), e.getY())) {
	      // Pindah ke Gameplay jika tombol ALUR GAME diklik
	      GamePanel.currentState = new Gameplay();
	    }
	  }

 


    @Override
    public void onKeyPresses(KeyEvent e) {

    }
}
