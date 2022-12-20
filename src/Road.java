import java.util.Random;

/**
 * Kelas yang menangani jalan yang akan ditampilkan dalam permainan.
 */
public class Road extends Elements {
	  public Road(int vel) {
	    this.x = 0;
	    this.y = -9000;
	    this.yvel = vel;
	  }
	
	  /**
	   * Metode untuk memeriksa apakah jalan sudah melewati batas layar.
	   * Jika sudah melewati batas, maka jalan akan dipindah kembali ke atas layar.
	   */
	  public void checkBound() {
	    if (this.y > -10) {
	      this.y = -9300;
	    }
	  }
}
