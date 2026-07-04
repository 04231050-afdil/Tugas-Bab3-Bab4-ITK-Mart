class Barang {
    private String nama;
    private int harga;
    private int stok;

    public Barang(String nama, int harga, int stok) {
        this.nama = nama;
        setHarga(harga);
        setStok(stok);
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

    private void setHarga(int harga) {
        if (harga > 0) {
            this.harga = harga;
        } else {
            System.out.println("Harga harus lebih dari 0");
            this.harga = 0;
        }
    }

    private void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        } else {
            System.out.println("Stok tidak boleh negatif");
            this.stok = 0;
        }
    }

    public void kurangiStok() {
        if (stok > 0) {
            stok--;
        }
    }
}

class Pembeli {
    private String nama;
    private int saldo;
    private int poin;

    public Pembeli(String nama, int saldo) {
        this.nama = nama;
        setSaldo(saldo);
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

    private void setSaldo(int saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("Saldo tidak boleh negatif");
            this.saldo = 0;
        }
    }

    public void kurangiSaldo(int jumlah) {
        if (jumlah > 0 && saldo >= jumlah) {
            saldo -= jumlah;
        }
    }

    public void tambahPoin() {
        poin += 10;
    }
}

class Transaksi {
    public static void proses(Pembeli pembeli, Barang barang) {

        System.out.println("\n" + pembeli.getNama() +
                " mencoba membeli " + barang.getNama());

        if (pembeli.getSaldo() < barang.getHarga()) {
            System.out.println("[GAGAL] Transaksi gagal: saldo tidak cukup");
        } else if (barang.getStok() <= 0) {
            System.out.println("[GAGAL] Transaksi gagal: stok habis");
        } else {
            pembeli.kurangiSaldo(barang.getHarga());
            barang.kurangiStok();
            pembeli.tambahPoin();

            System.out.println("[BERHASIL] Transaksi berhasil!");
            System.out.println("Sisa saldo: " + pembeli.getSaldo());
            System.out.println("Sisa stok: " + barang.getStok());
            System.out.println("Poin pembeli: " + pembeli.getPoin());
        }
    }
}