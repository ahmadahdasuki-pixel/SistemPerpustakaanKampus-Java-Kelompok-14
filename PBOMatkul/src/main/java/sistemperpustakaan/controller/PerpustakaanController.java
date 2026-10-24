
package sistemperpustakaan.controller;

import sistemperpustakaan.model.Buku;
import sistemperpustakaan.model.ManajemenBuku;
import sistemperpustakaan.model.DataPeminjaman;
import sistemperpustakaan.model.LokasiBuku;
import sistemperpustakaan.model.LayananPerpustakaan;
import sistemperpustakaan.view.PerpustakaanView;

public class PerpustakaanController {

    private ManajemenBuku buku = new ManajemenBuku();
    private DataPeminjaman dataPeminjaman = new DataPeminjaman();
    private LokasiBuku lokasiBuku = new LokasiBuku();
    private LayananPerpustakaan layanan =
            new LayananPerpustakaan();

    private PerpustakaanView view;

    public PerpustakaanController(PerpustakaanView view) {
        this.view = view;

        // Data dummy riwayat transaksi Stack
        layanan.catatTransaksi("TAMBAH", buku.cariBuku(101));
        layanan.catatTransaksi("TAMBAH", buku.cariBuku(102));
    }

    public void jalankan() {
        int pilihan;

        do {
            view.tampilkanMenu();
            pilihan = view.inputInt("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    dataPeminjaman.tampilkanKategori();
                    break;
                case 2:
                    tambahBuku();
                    break;
                case 3:
                    buku.tampilkanBuku();
                    break;
                case 4:
                    hapusBuku();
                    break;
                case 5:
                    catatPeminjaman();
                    break;
                case 6:
                    dataPeminjaman.tampilkanPeminjaman();
                    break;
                case 7:
                    aturLokasi();
                    break;
                case 8:
                    lokasiBuku.tampilkanLokasi();
                    break;
                case 9:
                    tambahAntrean();
                    break;
                case 10:
                    layanan.tampilkanAntrean();
                    break;
                case 11:
                    layaniAntrean();
                    break;
                case 12:
                    layanan.tampilkanRiwayat();
                    break;
                case 13:
                    batalkanTransaksi();
                    break;
                case 0:
                    view.pesan("Program selesai.");
                    break;
                default:
                    view.pesan("Pilihan tidak tersedia.");
            }

        } while (pilihan != 0);
    }

    private void tambahBuku() {
        int id = view.inputInt("ID buku: ");
        String judul = view.inputString("Judul buku: ");
        String penulis = view.inputString("Penulis: ");

        dataPeminjaman.tampilkanKategori();

        int pilihan = view.inputInt("Pilih kategori (1-4): ");

        if (pilihan < 1 || pilihan > dataPeminjaman.jumlahKategori()) {
            view.pesan("Kategori tidak valid.");
            return;
        }

        Buku data = new Buku(
            id, judul, penulis,
            dataPeminjaman.getKategori(pilihan - 1)
        );

        if (buku.tambahBuku(data)) {
            layanan.catatTransaksi("TAMBAH", data);
            view.pesan("Buku berhasil ditambahkan.");
        } else {
            view.pesan("ID buku sudah digunakan.");
        }
    }

    private void hapusBuku() {
        int id = view.inputInt("ID buku yang dihapus: ");
        Buku data = buku.cariBuku(id);

        if (data == null) {
            view.pesan("Buku tidak ditemukan.");
            return;
        }

        buku.hapusBuku(id);
        lokasiBuku.hapusLokasi(id);
        layanan.catatTransaksi("HAPUS", data);

        view.pesan("Buku berhasil dihapus.");
    }

    private void catatPeminjaman() {
        dataPeminjaman.tampilkanKategori();

        int kategori = view.inputInt("Pilih kategori (1-4): ");

        if (kategori < 1 || kategori > dataPeminjaman.jumlahKategori()) {
            view.pesan("Kategori tidak valid.");
            return;
        }

        System.out.println("\n=== PILIH HARI ===");

        for (int i = 0; i < dataPeminjaman.jumlahHari(); i++) {
            System.out.println(
                (i + 1) + ". " + dataPeminjaman.getHari(i)
            );
        }

        int hari = view.inputInt("Pilih hari (1-7): ");

        if (hari < 1 || hari > dataPeminjaman.jumlahHari()) {
            view.pesan("Hari tidak valid.");
            return;
        }

        dataPeminjaman.catatPeminjaman(kategori - 1, hari - 1);
        view.pesan("Peminjaman berhasil dicatat.");
    }

    private void aturLokasi() {
        int id = view.inputInt("ID buku: ");

        if (buku.cariBuku(id) == null) {
            view.pesan("Buku tidak ditemukan.");
            return;
        }

        int lantai = view.inputInt("Lantai (1-2): ");
        int rak = view.inputInt("Rak (1-3): ");
        int posisi = view.inputInt("Posisi (1-5): ");

        if (lokasiBuku.aturLokasi(id, lantai, rak, posisi)) {
            view.pesan("Lokasi buku berhasil diatur.");
        } else {
            view.pesan("Lokasi tidak valid atau sudah terisi.");
        }
    }

    private void tambahAntrean() {
        String nama = view.inputString("Nama mahasiswa: ");

        if (nama.trim().isEmpty()) {
            view.pesan("Nama tidak boleh kosong.");
            return;
        }

        layanan.tambahAntrean(nama);
        view.pesan("Mahasiswa masuk antrean.");
    }

    private void layaniAntrean() {
        String nama = layanan.layaniAntrean();

        if (nama == null) {
            view.pesan("Antrean masih kosong.");
        } else {
            view.pesan("Melayani mahasiswa: " + nama);
        }
    }

    private void batalkanTransaksi() {
        LayananPerpustakaan.Transaksi transaksi =
                layanan.batalkanTransaksi();

        if (transaksi == null) {
            view.pesan("Tidak ada transaksi untuk dibatalkan.");
            return;
        }

        Buku data = transaksi.getBuku();

        if (transaksi.getJenis().equals("TAMBAH")) {
            buku.hapusBuku(data.getId());
            lokasiBuku.hapusLokasi(data.getId());
            view.pesan("Penambahan buku terakhir dibatalkan.");
        } else if (transaksi.getJenis().equals("HAPUS")) {
            buku.tambahBuku(data);
            view.pesan("Buku yang dihapus berhasil dikembalikan.");
        }
    }
}