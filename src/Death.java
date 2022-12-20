import java.awt.*; // import kelas awt
import java.util.Random; // import kelas random

// kelas Death merupakan turunan dari kelas Elements
public class Death extends Elements {

  // membuat objek random
  Random random = new Random();

  // constructor kelas Death dengan parameter origin dan vel
  public Death(int origin, int vel) {
    // mengatur posisi x secara acak antara 5 sampai 340
    this.setXRandom(5, 340);
    // mengatur posisi y sesuai dengan parameter origin
    this.y = origin;
    // mengatur kecepatan y sesuai dengan parameter vel
    this.yvel = 5;
    // mengatur lebar objek
    this.width = 44;
    // mengatur tinggi objek
    this.height = 46;
  }

  // method untuk mengecek batas objek
  public void checkBound() {
    // jika posisi y melebihi batas 800
    if (this.y > 800) {
      // mengubah objek menjadi tidak terlihat
      this.hidden = false;
      // mengatur posisi y menjadi -400
      this.y = -400;
      // mengatur posisi x secara acak antara 5 sampai 340
      this.setXRandom(5, 340);
    }
  }
}
