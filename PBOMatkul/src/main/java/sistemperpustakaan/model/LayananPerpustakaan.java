
package sistemperpustakaan.model;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class LayananPerpustakaan {

    // Stack: riwayat transaksi
    private Stack<Transaksi> riwayat = new Stack<>();

    // Queue: antrean mahasiswa
    private Queue<String> antrean = new LinkedList<>();
    public static class Transaksi {
        private String jenis;
        private Buku buku;

        public Transaksi(String jenis, Buku buku) {
            this.jenis = jenis;
            this.buku = buku;
        }

        public String getJenis() {
            return jenis;
        }

        public Buku getBuku() {
            return buku;
        }
    }

    public LayananPerpustakaan() {
        // Data dummy antrean
        antrean.offer("Ahmad");
        antrean.offer("Budi");
    }

    public void catatTransaksi(String jenis, Buku buku) {
        riwayat.push(new Transaksi(jenis, buku));
    }

    public void tampilkanRiwayat() {
        if (riwayat.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }

        System.out.println("\n=== RIWAYAT TRANSAKSI ===");

        for (int i = riwayat.size() - 1; i >= 0; i--) {
            Transaksi transaksi = riwayat.get(i);

            System.out.println(
                transaksi.getJenis() + " buku: "
                + transaksi.getBuku().getJudul()
            );
        }
    }

    public Transaksi batalkanTransaksi() {
        if (riwayat.isEmpty()) {
            return null;
        }

        return riwayat.pop();
    }

    public void tambahAntrean(String nama) {
        antrean.offer(nama);
    }

    public String layaniAntrean() {
        return antrean.poll();
    }

    public void tampilkanAntrean() {
        if (antrean.isEmpty()) {
            System.out.println("Antrean masih kosong.");
            return;
        }

        System.out.println("\n=== ANTREAN MAHASISWA ===");

        int nomor = 1;

        for (String nama : antrean) {
            System.out.println(nomor + ". " + nama);
            nomor++;
        }
    }
}