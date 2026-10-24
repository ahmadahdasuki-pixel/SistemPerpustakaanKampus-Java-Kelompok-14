
package sistemperpustakaan.model;


public class LokasiBuku {
    // Lantai x Rak x Posisi
    private String[][][] lokasi = new String[2][3][5];
    public LokasiBuku() {
        // Data dummy lokasi buku
        lokasi[0][0][0] = "101";
        lokasi[0][1][2] = "102";
        lokasi[1][0][1] = "103";
        lokasi[1][2][4] = "104";
    }
    public boolean aturLokasi(int id, int lantai,
                              int rak, int posisi) {

        if (lantai < 1 || lantai > 2
                || rak < 1 || rak > 3
                || posisi < 1 || posisi > 5) {
            return false;
        }

        String idBuku = String.valueOf(id);
        int l = lantai - 1;
        int r = rak - 1;
        int p = posisi - 1;

        String tujuan = lokasi[l][r][p];

        if (tujuan != null && !tujuan.equals(idBuku)) {
            return false;
        }

        // Cari dan hapus lokasi lama buku yang sama
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 5; k++) {
                    if (idBuku.equals(lokasi[i][j][k])) {
                        lokasi[i][j][k] = null;
                    }
                }
            }
        }

        lokasi[l][r][p] = idBuku;
        return true;
    }

    public void hapusLokasi(int id) {
        String idBuku = String.valueOf(id);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 5; k++) {
                    if (idBuku.equals(lokasi[i][j][k])) {
                        lokasi[i][j][k] = null;
                    }
                }
            }
        }
    }

    public void tampilkanLokasi() {
        System.out.println("\n=== LOKASI PENYIMPANAN ===");

        for (int i = 0; i < 2; i++) {
            System.out.println("\nLantai " + (i + 1));

            for (int j = 0; j < 3; j++) {
                System.out.println("  Rak " + (j + 1));

                for (int k = 0; k < 5; k++) {
                    String id = lokasi[i][j][k];

                    System.out.println(
                        "    Posisi " + (k + 1) + " : "
                        + (id == null ? "Kosong" : "ID " + id)
                    );
                }
            }
        }
    }
}
