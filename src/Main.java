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
    }

    public static void main(String[] args) {
        System.out.println("Program ITK-Mart dimulai");
    }
}