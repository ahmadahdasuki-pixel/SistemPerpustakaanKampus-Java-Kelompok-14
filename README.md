# Sistem Manajemen Perpustakaan Kampus
Sistem Manajemen Perpustakaan Kampus merupakan program berbasis Java yang dibuat untuk membantu pengelolaan data buku dan aktivitas sederhana di perpustakaan kampus melalui menu interaktif berbasis console. Program ini menerapkan konsep Object-Oriented Programming (OOP) serta beberapa struktur data, yaitu Array 1D, Array 2D, Array 3D, ArrayList, Stack, dan Queue.

Fitur yang tersedia meliputi pengelolaan data buku, pencatatan statistik peminjaman berdasarkan kategori dan hari, pengaturan lokasi penyimpanan buku, pengelolaan antrean mahasiswa, serta pencatatan dan pembatalan transaksi terakhir. Program disusun menggunakan pola arsitektur MVC (Model-View-Controller) agar kode lebih terstruktur, mudah dipahami, dan mudah dikembangkan.

## Tugas Pemrograman Java
- **Mata Kuliah:** Pemrograman Berorientasi Objek
- **Dosen Pengampu:** M. Ibadurrahman Arrasyid Supriyanto M.Kom.
- **Program Studi:** Sistem Informasi
- **Angkatan:** 2025
- **Kelompok:** 14

## Anggota Kelompok 14
1. *Ahmad Ahdasuki* - 2509116021 - Kelas A
2. *Rivalio Chendra* - 2509116039 - Kelas A
3. *Muhammad Aqia Yudha Yulian Putra* - 2509116105 - Kelas C
4. *Meilanie* - 2509116109 - Kelas C

## Struktur File Proyek
Struktur file proyek dipisahkan berdasarkan fungsi setiap class. Pembagian ini bertujuan agar kode tidak menumpuk dalam satu file dan setiap class memiliki tanggung jawab yang jelas.

Gambaran struktur folder proyek:

<img width="543" height="377" alt="image" src="https://github.com/user-attachments/assets/67644ccb-3a8d-43b7-8617-30febbf66101" />

## Penerapan MVC
Program menggunakan pola arsitektur MVC (Model-View-Controller), yaitu metode pemisahan kode menjadi tiga bagian utama berdasarkan tanggung jawabnya.
- Model: Mengelola data dan proses pengolahan data. Contohnya Buku.java, ManajemenBuku.java, DataPeminjaman.java, LokasiBuku.java, dan LayananPerpustakaan.java.
- View: Mengatur tampilan menu, menerima masukan pengguna, serta menampilkan hasil proses. Bagian ini terdapat pada PerpustakaanView.java.
- Controller: Mengatur jalannya program berdasarkan pilihan pengguna dan menghubungkan View dengan Model. Bagian ini terdapat pada PerpustakaanController.java.
Sementara itu, PBOMatkul.java berfungsi sebagai class utama untuk membuat objek View dan Controller, kemudian menjalankan program melalui method jalankan().

Penerapan MVC membuat kode lebih rapi karena tampilan, pengolahan data, dan alur program tidak dicampur dalam satu class.

## Penerapan Scanner 
Scanner merupakan class Java yang digunakan untuk menerima input dari pengguna melalui keyboard. Pada program ini, Scanner diterapkan di class PerpustakaanView.java untuk menerima pilihan menu dan data yang dimasukkan pengguna.

Contoh kode penerapan dari PerpustakaanView.java:
```java
private Scanner input = new Scanner(System.in);

public int inputInt(String pesan) {
    while (true) {
        System.out.print(pesan);

        if (input.hasNextInt()) {
            int angka = input.nextInt();
            input.nextLine();
            return angka;
        } else {
            System.out.println("Input harus berupa angka!");
            input.nextLine();
        }
    }
}

public String inputString(String pesan) {
    System.out.print(pesan);
    return input.nextLine();
}
```
Penjelasan kode:
- new Scanner(System.in) digunakan untuk membaca input dari keyboard.
- inputInt() digunakan untuk menerima input berupa bilangan bulat, seperti pilihan menu dan ID buku.
- hasNextInt() memeriksa apakah input yang diberikan berupa bilangan bulat.
- input.nextLine() setelah nextInt() digunakan untuk menghabiskan karakter baris baru yang tersisa.
- inputString() digunakan untuk menerima teks, seperti judul buku, nama penulis, dan nama mahasiswa.
- while (true) membuat input terus diminta kembali apabila pengguna memasukkan nilai yang tidak sesuai.
Dengan Scanner, pengguna dapat berinteraksi dengan program secara langsung melalui console.

## Penerapan Array 1D
Array 1D (One-Dimensional Array) adalah struktur data yang menyimpan sekumpulan elemen dalam satu dimensi. Dalam program ini, Array 1D digunakan pada DataPeminjaman.java untuk menyimpan daftar kategori buku dan nama hari.

Contoh data kategori:
```java
String[] kategori = {
    "Pemrograman",
    "Matematika",
    "Jaringan Komputer",
    "Basis Data"
};
```
Array tersebut menyimpan empat kategori buku yang dapat dipilih pengguna ketika mencatat peminjaman. Selain itu, array hari menyimpan nama hari dari Senin sampai Minggu.

Array 1D memudahkan program menyimpan dan mengakses daftar kategori maupun hari berdasarkan indeks.

## Penerapan Array 2D
Array 2D (Two-Dimensional Array) merupakan struktur data berbentuk tabel yang memiliki baris dan kolom. Dalam program ini, Array 2D digunakan pada DataPeminjaman.java untuk menyimpan jumlah peminjaman buku berdasarkan kategori dan hari.

Contoh deklarasi:
```java
int[][] peminjaman = {
    {5, 3, 4, 6, 2, 7, 3},
    {2, 4, 3, 2, 5, 1, 2},
    {4, 3, 5, 2, 3, 4, 1},
    {3, 5, 2, 4, 6, 2, 3}
};
```
Setiap baris mewakili satu kategori buku, sedangkan setiap kolom mewakili satu hari dalam seminggu. Sebagai contoh, nilai peminjaman[0][0] adalah 5, yang berarti terdapat lima peminjaman pada kategori Pemrograman di hari Senin.

Ketika pengguna mencatat peminjaman, nilai pada baris kategori dan kolom hari yang dipilih akan bertambah. Data tersebut kemudian dapat ditampilkan dalam bentuk tabel statistik peminjaman.

## Penerapan Array 3D
Array 3D (Three-Dimensional Array) adalah struktur data yang memiliki tiga dimensi. Dalam program ini, Array 3D diterapkan pada LokasiBuku.java untuk merepresentasikan lokasi penyimpanan buku berdasarkan lantai, rak, dan posisi buku pada rak.

Contoh deklarasi:
```java
String[][][] lokasi = new String[2][3][5];
```
Array tersebut memiliki kapasitas dua lantai, tiga rak pada setiap lantai, dan lima posisi pada setiap rak. Setiap elemen menyimpan ID buku yang menempati lokasi tersebut. Posisi yang belum digunakan bernilai null.

Contohnya, lokasi[0][0][0] menyimpan ID buku 101, yang menunjukkan lantai 1, rak 1, posisi 1 apabila indeks array diterjemahkan menjadi nomor lokasi yang dimulai dari 1.

Dengan struktur ini, pengguna dapat mengatur lokasi buku, melihat seluruh lokasi penyimpanan, dan menghindari penempatan dua buku berbeda pada posisi yang sama.

## Penerapan ArrayList
ArrayList merupakan struktur data Java yang dapat menampung kumpulan data dengan ukuran yang dinamis. Pada program ini, ArrayList digunakan di class ManajemenBuku.java untuk menyimpan dan mengelola objek buku.

Contoh kode penerapan dari ManajemenBuku.java:
```java
private ArrayList<Buku> daftarBuku = new ArrayList<>();

public ManajemenBuku() {
    daftarBuku.add(new Buku(
        101, "Belajar Java", "Budi Santoso", "Pemrograman"
    ));

    daftarBuku.add(new Buku(
        102, "Matematika Diskrit", "Andi Wijaya", "Matematika"
    ));
}

public void tambahBuku(Buku buku) {
    if (cariBuku(buku.getId()) != null) {
        System.out.println("ID buku sudah digunakan!");
        return;
    }

    daftarBuku.add(buku);
    System.out.println("Buku berhasil ditambahkan.");
}

public void tampilkanBuku() {
    for (Buku buku : daftarBuku) {
        buku.tampilkan();
        System.out.println("-------------------");
    }
}
```

## Penerapan Stack LIFO
Stack adalah struktur data yang menerapkan prinsip LIFO (Last In, First Out), yaitu data yang terakhir dimasukkan akan menjadi data pertama yang dikeluarkan.

Pada program ini, Stack digunakan di class LayananPerpustakaan.java untuk menyimpan riwayat transaksi penambahan dan penghapusan buku. Fitur ini juga digunakan untuk mendukung pembatalan transaksi terakhir.

Contoh kode penerapan dari LayananPerpustakaan.java:
```java
private Stack<Transaksi> riwayat = new Stack<>();

public void catatTransaksi(String jenis, Buku buku) {
    riwayat.push(new Transaksi(jenis, buku));
}

public void tampilkanRiwayat() {
    if (riwayat.isEmpty()) {
        System.out.println("Belum ada riwayat transaksi.");
        return;
    }

    for (int i = riwayat.size() - 1; i >= 0; i--) {
        Transaksi transaksi = riwayat.get(i);

        System.out.println(
            transaksi.getJenis() + " - "
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
```
Penjelasan kode:
- Stack<Transaksi> digunakan untuk menyimpan riwayat transaksi.
- push() menambahkan transaksi baru ke bagian atas Stack.
- isEmpty() memeriksa apakah Stack kosong.
- Perulangan dimulai dari indeks terakhir agar riwayat ditampilkan dari transaksi terbaru.
- pop() mengambil sekaligus menghapus transaksi paling baru dari Stack.
Sebagai contoh, jika pengguna menambahkan buku A, kemudian menambahkan buku B, transaksi buku B berada di posisi teratas Stack. Ketika pengguna memilih pembatalan transaksi, transaksi buku B akan diproses terlebih dahulu.

Pada implementasi program saat ini, pembatalan transaksi penambahan buku akan menghapus buku tersebut, sedangkan pembatalan penghapusan buku akan menambahkan kembali data bukunya. Pemulihan lokasi buku yang sebelumnya dihapus belum didukung.

## Penerapan Queue FIFO
Queue merupakan struktur data yang menerapkan prinsip FIFO (First In, First Out), yaitu data yang masuk lebih dahulu akan dilayani lebih dahulu.

Pada program ini, Queue digunakan di class LayananPerpustakaan.java untuk mengelola antrean mahasiswa yang akan dilayani oleh petugas perpustakaan.

Contoh kode penerapan dari LayananPerpustakaan.java:
```java
private Queue<String> antrean = new LinkedList<>();

public LayananPerpustakaan() {
    antrean.offer("Ahmad");
    antrean.offer("Budi");
}

public void tambahAntrean(String nama) {
    antrean.offer(nama);
    System.out.println(nama + " masuk antrean.");
}

public void layaniAntrean() {
    if (antrean.isEmpty()) {
        System.out.println("Antrean masih kosong.");
        return;
    }

    String nama = antrean.poll();
    System.out.println(nama + " telah dilayani.");
}

public void tampilkanAntrean() {
    if (antrean.isEmpty()) {
        System.out.println("Antrean masih kosong.");
        return;
    }

    for (String nama : antrean) {
        System.out.println(nama);
    }
}
```
Penjelasan kode:
- Queue<String> digunakan untuk menyimpan nama mahasiswa dalam antrean.
- LinkedList digunakan sebagai implementasi dari interface Queue.
- offer() menambahkan mahasiswa ke bagian belakang antrean.
- poll() mengambil sekaligus menghapus mahasiswa yang berada di bagian depan antrean.
- isEmpty() memeriksa apakah antrean masih memiliki mahasiswa.
- tampilkanAntrean() menampilkan mahasiswa sesuai urutan antrean.
Pada constructor, terdapat dua data dummy, yaitu Ahmad dan Budi. Ahmad masuk lebih dahulu sehingga akan dilayani lebih dahulu. Setelah Ahmad dilayani, Budi menjadi mahasiswa berikutnya yang berada di depan antrean.

Dengan penerapan Queue, program dapat menyimulasikan sistem pelayanan mahasiswa yang teratur berdasarkan urutan kedatangan.

## Alur Program

**Tampilan Menu Utama**
**Lihat Kategori Buku**
**Tambah Buku**
**Tampilkan Buku**
**Hapus Buku**
**Catat Peminjaman**
**Lihat Statistik Peminjaman**
**Atur Lokasi Buku**
**Lihat Lokasi Buku**
**Tambah Antrian Mahasiswa**
**Lihat Antrian Mahasiswa**
**Layani Antrian**
**Lihat Riwayat Transaksi**
**Batalkan Transaksi Terakhir**
**Keluar**

## Kesimpulan Program
Sistem Manajemen Perpustakaan Kampus merupakan program pembelajaran Java yang menggabungkan konsep OOP, arsitektur MVC, input menggunakan Scanner, serta enam jenis struktur data. Setiap struktur data digunakan untuk kebutuhan yang berbeda, mulai dari penyimpanan kategori dan statistik peminjaman hingga pengelolaan koleksi buku, lokasi penyimpanan, riwayat transaksi, dan antrean mahasiswa.

Melalui program ini, penerapan struktur data dapat dipahami melalui contoh sederhana yang dapat dijalankan dan diuji secara langsung. Pemisahan class berdasarkan MVC juga membantu meningkatkan keteraturan kode serta mempermudah proses pemeliharaan dan pengembangan program selanjutnya.
