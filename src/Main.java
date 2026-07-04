public class Main {
    public static void main(String[] args) {

        Barang indomie = new Barang("Indomie", 3000, 1);

        // gagal karena saldo kurang
        Pembeli p1 = new Pembeli("Afdil", 2000);
        Transaksi.proses(p1, indomie);

        // berhasil
        Pembeli p2 = new Pembeli("Budi", 10000);
        Transaksi.proses(p2, indomie);

        // gagal karena stok habis
        Pembeli p3 = new Pembeli("Citra", 10000);
        Transaksi.proses(p3, indomie);
    }
}