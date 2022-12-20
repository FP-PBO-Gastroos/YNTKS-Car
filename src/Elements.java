import java.awt.*; // import kelas awt
import java.awt.event.KeyEvent; // import kelas event untuk keyboard
import java.awt.event.MouseEvent; // import kelas event untuk mouse
import java.util.Random; // import kelas random

	// kelas Elements merupakan kelas abstrak
	abstract public class Elements {
	  // deklarasi variabel x, y, xVel, yvel, height, width, dan hidden
	  public int x = 0;
	  public int y = 0;
	  public int xVel = 0;
	  public int yvel = 0;
	  public int height = 0;
	  public int width = 0;
	  public boolean hidden = false;
	  // deklarasi objek random
	  private Random random = new Random();
	
	  // method untuk mengupdate posisi objek
	  public void updatePos() {
	    // mengubah posisi x sesuai dengan kecepatan x
	    this.x += this.xVel;
	    // mengubah posisi y sesuai dengan kecepatan y
	    this.y += this.yvel;
	    // memanggil method checkBound
	    this.checkBound();
	  }
	
	  // method abstrak untuk mengecek batas objek
	  abstract public void checkBound();
	
	  // method untuk mengecek apakah objek bersinggungan dengan objek lain
	  public boolean checkIntersection(Elements e) {
	    // membuat objek r1 sebagai persegi dengan posisi x, y, lebar, dan tinggi sesuai dengan objek ini
	    Rectangle r1 = new Rectangle(this.x, this.y, this.width, this.height);
	    // membuat objek r2 sebagai persegi dengan posisi x, y, lebar, dan tinggi sesuai dengan objek e
	    Rectangle r2 = new Rectangle(e.x, e.y, e.width, e.height);
	
	    // jika objek r1 bersinggungan dengan objek r2
	    if (r1.intersects(r2))
	      // mengembalikan nilai true
	      return true;
	    else
	      // mengembalikan nilai false
	      return false;
	  }
	
	  // method untuk mengatur posisi x secara acak antara low dan high
	  public void setXRandom(int low, int high) {
	    this.x = random.nextInt(high - low) + low;
	  }
	
	  // method untuk mengatur posisi y secara acak antara low dan high
	  public void setYRandom(int low, int high) {
	    this.y = -random.nextInt(-high - low) - low;
	  }
	
	  // method statik untuk menangani event saat mouse ditekan
	  public static void pause(MouseEvent e) {
	    // membuat objek r sebagai persegi dengan posisi x, y, lebar, dan tinggi sesuai dengan objek
        Rectangle r = new Rectangle(355, 20, 40, 35);
        if (r.contains(e.getX(), e.getY())) {
            GamePanel.pause = !GamePanel.pause;
        }
        if (GamePanel.pause) {
            Resources.carMoving.stop();
            Resources.welcomeTone.loop();
        } else {
            Resources.carMoving.loop();
            Resources.welcomeTone.stop();
        }
    }
    
	  //method statik untuk menangani event saat mouse ditekan
	  public static void muteUnmute(MouseEvent e) {
        Rectangle r = new Rectangle(355, 60, 40, 35);
        if (r.contains(e.getX(), e.getY())) {
            GamePanel.muteUnmute = !GamePanel.muteUnmute;
        }
        if (GamePanel.muteUnmute) {
            // Stop all audio except when the game is paused
            if (!GamePanel.pause) {
                Resources.carMoving.stop();
                Resources.welcomeTone.stop();
            }
            else {
            	Resources.carMoving.stop();
                Resources.welcomeTone.stop();
            }
        } else {
            // Restart audio only if the game is not paused
            if (!GamePanel.pause) {
                Resources.carMoving.loop();
                Resources.welcomeTone.stop();
            }
        }
    }

   
	  public static void carHandling(KeyEvent e , Car car) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            car.xVel = 7;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            car.xVel = -7;
        }  else if (e.getKeyCode() == KeyEvent.VK_UP) {
            car.yvel = -3;
        }  else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            car.yvel = 3;
        }  else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            car.xVel = 0;
        }  else if (e.getKeyCode() == KeyEvent.VK_SHIFT)
        	car.yvel = 0;
    }


}


