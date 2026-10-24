
package sistemperpustakaan.view;

import java.util.Scanner;

public class PerpustakaanView {
    private Scanner input = new Scanner(System.in);

    public int inputInt(String pesan) {
        while (true) {
            System.out.print(pesan);

            if (input.hasNextInt()) {
                int angka = input.nextInt();
                input.nextLine();
                return angka;
            }

            System.out.println("Masukkan angka yang valid.");
            input.nextLine();
        }
    }

    public String inputString(String pesan) {
        System.out.print(pesan);
        return input.nextLine();
    }

    public void tampilkanMenu() {
        System.out.println("\n==============================");
        System.out.println(" SISTEM MANAJEMEN PERPUSTAKAAN");
        System.out.println("==============================");
        System.out.println("1. Lihat kategori buku");
        System.out.println("2. Tambah buku");
        System.out.println("3. Tampilkan buku");
        System.out.println("4. Hapus buku");
        System.out.println("5. Catat peminjaman");
        System.out.println("6. Lihat statistik peminjaman");
        System.out.println("7. Atur lokasi buku");
        System.out.println("8. Lihat lokasi buku");
        System.out.println("9. Tambah antrean mahasiswa");
        System.out.println("10. Lihat antrean mahasiswa");
        System.out.println("11. Layani antrean");
        System.out.println("12. Lihat riwayat transaksi");
        System.out.println("13. Batalkan transaksi terakhir");
        System.out.println("0. Keluar");
        System.out.println("==============================");
    }

    public void pesan(String pesan) {
        System.out.println(pesan);
    }
}