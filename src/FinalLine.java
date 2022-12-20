public class FinalLine extends Elements {
    /**
     * Konstruktor untuk membuat objek FinalLine.
     *
     * @parameter vel Kecepatan vertikal dari garis akhir.
     * @parameter origin Titik awal posisi vertikal dari garis akhir.
     */
    public FinalLine(int vel,int origin)
    {
        // Menetapkan nilai x sebagai 0 (posisi horizontal tetap)
        this.x=0;
        // Menetapkan nilai y sesuai dengan titik awal yang ditentukan
        this.y=origin;
        // Menetapkan lebar garis akhir sebesar 400 piksel
        this.width=400;
        // Menetapkan tinggi garis akhir sebesar 30 piksel
        this.height=30;
        // Menetapkan kecepatan vertikal garis akhir sesuai dengan yang ditentukan
        this.yvel=vel;
    }

    /**
     * Method yang tidak melakukan apa-apa, hanya digunakan untuk mengimplementasikan
     * method abstrak yang ada di kelas Elements.
     */
    @Override
    public void checkBound() {
        // Method kosong
    }
}
