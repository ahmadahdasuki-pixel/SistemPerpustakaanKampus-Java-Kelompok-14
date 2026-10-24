
package sistemperpustakaan.model;


public class DataPeminjaman {

    // Array 1D: kategori buku
    private String[] kategori = {
        "Pemrograman",
        "Matematika",
        "Jaringan Komputer",
        "Basis Data"
    };

    // Array 2D: kategori dan hari
    // Data dummy: jumlah peminjaman selama satu minggu
    private int[][] peminjaman = {
        {5, 3, 4, 6, 2, 7, 3},
        {2, 4, 3, 2, 5, 1, 2},
        {4, 3, 5, 2, 3, 4, 1},
        {3, 5, 2, 4, 6, 2, 3}
    };

    private String[] hari = {
        "Senin", "Selasa", "Rabu", "Kamis",
        "Jumat", "Sabtu", "Minggu"
    };

    public void tampilkanKategori() {
        System.out.println("\n=== KATEGORI BUKU ===");

        for (int i = 0; i < kategori.length; i++) {
            System.out.println((i + 1) + ". " + kategori[i]);
        }
    }

    public void catatPeminjaman(int nomorKategori, int nomorHari) {
        peminjaman[nomorKategori][nomorHari]++;
    }

    public void tampilkanPeminjaman() {
        System.out.println("\n=== STATISTIK PEMINJAMAN ===");

        System.out.printf("%-22s", "Kategori");

        for (String namaHari : hari) {
            System.out.printf("%-10s", namaHari);
        }

        System.out.println();

        for (int i = 0; i < kategori.length; i++) {
            System.out.printf("%-22s", kategori[i]);

            for (int j = 0; j < hari.length; j++) {
                System.out.printf("%-10d", peminjaman[i][j]);
            }

            System.out.println();
        }
    }

    public int jumlahKategori() {
        return kategori.length;
    }

    public int jumlahHari() {
        return hari.length;
    }

    public String getKategori(int indeks) {
        return kategori[indeks];
    }

    public String getHari(int indeks) {
        return hari[indeks];
    }
}
