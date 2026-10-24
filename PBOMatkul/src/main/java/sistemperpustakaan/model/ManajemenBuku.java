
package sistemperpustakaan.model;

import java.util.ArrayList;

public class ManajemenBuku {
    private ArrayList<Buku> daftarBuku = new ArrayList<>();

    public ManajemenBuku() {
        daftarBuku.add(new Buku(
            101, "Belajar Java", "Budi Santoso", "Pemrograman"
        ));
        daftarBuku.add(new Buku(
            102, "Matematika Diskrit", "Andi Wijaya", "Matematika"
        ));
        daftarBuku.add(new Buku(
            103, "Jaringan Komputer", "Rina Putri", "Jaringan Komputer"
        ));
        daftarBuku.add(new Buku(
            104, "Dasar Basis Data", "Dewi Lestari", "Basis Data"
        ));
    }

    public boolean tambahBuku(Buku buku) {
        if (cariBuku(buku.getId()) != null) {
            return false;
        }

        daftarBuku.add(buku);
        return true;
    }

    public Buku cariBuku(int id) {
        for (Buku buku : daftarBuku) {
            if (buku.getId() == id) {
                return buku;
            }
        }

        return null;
    }

    public boolean hapusBuku(int id) {
        Buku buku = cariBuku(id);

        if (buku == null) {
            return false;
        }

        daftarBuku.remove(buku);
        return true;
    }

    public void tampilkanBuku() {
        if (daftarBuku.isEmpty()) {
            System.out.println("Belum ada buku.");
            return;
        }

        System.out.println("\n=== DAFTAR BUKU ===");

        for (Buku buku : daftarBuku) {
            buku.tampilkan();
            System.out.println("--------------------");
        }
    }
}
