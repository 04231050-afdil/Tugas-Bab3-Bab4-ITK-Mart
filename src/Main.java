public class Main {

    static class Barang {
        private String nama;
        private int harga;
        private int stok;

        public Barang(String nama, int harga, int stok) {
            this.nama = nama;
            this.harga = harga;
            this.stok = stok;
        }

        public String getNama() {
            return nama;
        }

        public int getHarga() {
            return harga;
        }

        public int getStok() {
            return stok;
        }

        public void kurangiStok() {
            if (stok > 0) {
                stok--;
            }
        }
    }

    static class Pembeli {
        private String nama;
        private int saldo;
        private int poin;

        public Pembeli(String nama, int saldo) {
            this.nama = nama;
            this.saldo = saldo;
            this.poin = 0;
        }

        public String getNama() {
            return nama;
        }

        public int getSaldo() {
            return saldo;
        }

        public int getPoin() {
            return poin;
        }

        private void kurangiSaldo(int jumlah) {
            saldo -= jumlah;
        }

        private void tambahPoin() {
            poin += 10;
        }
    }

    static class Transaksi {
        public static void proses(Pembeli pembeli, Barang barang) {

            System.out.println("\n" + pembeli.getNama() +
                    " mencoba membeli " + barang.getNama());

            if (pembeli.getSaldo() < barang.getHarga()) {
                System.out.println("❌ Transaksi gagal: saldo tidak cukup");
            } else if (barang.getStok() <= 0) {
                System.out.println("❌ Transaksi gagal: stok habis");
            } else {
                pembeli.kurangiSaldo(barang.getHarga());
                barang.kurangiStok();
                pembeli.tambahPoin();

                System.out.println("✅ Transaksi berhasil!");
                System.out.println("Sisa saldo: " + pembeli.getSaldo());
                System.out.println("Sisa stok: " + barang.getStok());
                System.out.println("Poin pembeli: " + pembeli.getPoin());
            }
        }
    }

    public static void main(String[] args) {

        Barang indomie = new Barang("Indomie", 3000, 1);

        // gagal (saldo kurang)
        Pembeli p1 = new Pembeli("Afdil", 2000);
        Transaksi.proses(p1, indomie);

        // sukses
        Pembeli p2 = new Pembeli("Budi", 10000);
        Transaksi.proses(p2, indomie);

        // gagal (stok habis)
        Pembeli p3 = new Pembeli("Citra", 10000);
        Transaksi.proses(p3, indomie);
    }
}