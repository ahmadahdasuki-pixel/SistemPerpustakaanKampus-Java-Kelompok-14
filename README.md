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

<img width="238" height="275" alt="image" src="https://github.com/user-attachments/assets/6e4bd76e-84f0-4f0f-b5fe-b60793e9525a" />

Ini adalah Tampilan Pertama atau menu utama saat pertama kali menjalankan program

**Lihat Kategori Buku**

<img width="233" height="127" alt="image" src="https://github.com/user-attachments/assets/5c03d30b-73e8-49db-a2f3-cc0cc7c56f06" />

Pada menu 1 yaitu melihat kategori buku yang ada apa saja dan dapat di lihat pada gambar kita memiliki 4 kategori buku yaitu Pemograman, Matematika, Jaringan Komputer , dan Basis Data.

**Tambah Buku**

<img width="302" height="187" alt="image" src="https://github.com/user-attachments/assets/d1164e97-469f-4a9a-98ca-8dcbe0ec8a60" />

Pada menu 2 kita melakukan proses penambahan buku baru ke dalam sistem perpustakaan. Pengguna memulai dengan memasukkan ID buku 75, judul Belajar Fundamental Python, dan penulis Suki Skom. Setelah itu, sistem menampilkan daftar kategori buku dan pengguna memilih kategori Pemrograman dengan memasukkan angka 1. Program kemudian menampilkan pesan “Buku berhasil ditambahkan.”, yang menandakan bahwa data buku berhasil dimasukkan ke dalam koleksi ArrayList.

**Tampilkan Buku**

<img width="310" height="405" alt="image" src="https://github.com/user-attachments/assets/9815182e-e4df-4ec9-a139-9555950f167d" />

Menu 3 kita akan melihat daftar buku yang sudah terdaftar apa saja dalam perpustakaan.

**Hapus Buku**

<img width="272" height="338" alt="image" src="https://github.com/user-attachments/assets/f981e61d-5fa3-4ab8-8a12-60df28501e2b" />

Pada menu 4, pengguna memasukkan ID buku 75 yang ingin dihapus. Sistem menampilkan pesan “Buku berhasil dihapus.” yang menandakan bahwa buku dengan ID tersebut berhasil dihapus dari koleksi ArrayList. Setelah proses selesai, program kembali menampilkan menu utama agar pengguna dapat memilih fitur lainnya.

**Catat Peminjaman**

<img width="284" height="289" alt="image" src="https://github.com/user-attachments/assets/8bdb690c-a406-4d9e-8567-d5ab88e7c9cb" />

Pada menu 5, pengguna kemudian memilih kategori buku Pemrograman dengan memasukkan angka 1 dan memilih hari Kamis dengan memasukkan angka 4. Sistem menampilkan pesan “Peminjaman berhasil dicatat.”, yang berarti jumlah peminjaman pada kategori Pemrograman untuk hari Kamis berhasil bertambah satu pada data Array 2D.

**Lihat Statistik Peminjaman**

<img width="663" height="174" alt="image" src="https://github.com/user-attachments/assets/e0f0df99-477b-47d5-b5ec-8d688120b989" />

Menu 6 ialah untuk melihat data peminjaman buku yang sudah terdaftar pada perpustakaan berapa dan hari apa serta kategori buku yang di pinjam apa saja dan berapa jumlahnya.

**Atur Lokasi Buku**

<img width="250" height="107" alt="image" src="https://github.com/user-attachments/assets/eaa404e7-8c61-4443-9cbd-59df5f91165e" />

Saat Pengguna memilih menu 7, kemudian memasukkan ID buku 103, lantai 2, rak 2, dan posisi 4. Sistem menampilkan pesan “Lokasi buku berhasil diatur.”, yang menandakan bahwa lokasi penyimpanan buku berhasil ditetapkan menggunakan Array 3D berdasarkan lantai, rak, dan posisi.

**Lihat Lokasi Buku**

<img width="227" height="604" alt="image" src="https://github.com/user-attachments/assets/464356be-7801-48b8-ba33-5d36b13b7116" />

Output gambar di atas yaitu menu 8 menunjukkan daftar lokasi penyimpanan buku berdasarkan lantai, rak, dan posisi. Sistem menampilkan ID buku yang menempati lokasi tertentu, seperti buku ID 101 di lantai 1 rak 1 posisi 1, ID 102 di lantai 1 rak 2 posisi 3, dan ID 103 di lantai 2 rak 2 posisi 4. Sementara itu, posisi yang belum ditempati ditampilkan sebagai “Kosong”. Data lokasi ini dikelola menggunakan Array 3D.

**Tambah Antrian Mahasiswa**

<img width="212" height="72" alt="image" src="https://github.com/user-attachments/assets/33d34762-311a-4bc7-975d-c2ba5c685709" />

Pengguna memilih menu 9, kemudian memasukkan nama mahasiswa, yaitu Abdul. Sistem menampilkan pesan “Mahasiswa masuk antrean.” yang menandakan bahwa Abdul berhasil ditambahkan ke dalam antrean menggunakan struktur data Queue (FIFO), sehingga mahasiswa dilayani berdasarkan urutan kedatangan.

**Lihat Antrian Mahasiswa**

<img width="227" height="117" alt="image" src="https://github.com/user-attachments/assets/0dd7f9fd-bc20-4ec7-8da9-298e4db255f6" />

Menu 10 ialah untuk melihat daftar anntrian nama mahasiswa yang ingin meminjam buku di perpustakaan siapa saja.

**Layani Antrian**

<img width="260" height="305" alt="image" src="https://github.com/user-attachments/assets/0015dc43-c186-49e5-aef0-7311c3b3ee37" />

Output gambar di atas menunjukkan proses pelayanan antrean mahasiswa, saat memilih menu 11 Sistem menampilkan “Melayani mahasiswa: Ahmad”, yang berarti Ahmad dilayani terlebih dahulu karena masuk paling awal dalam antrean. Proses ini menerapkan prinsip Queue (FIFO), yaitu mahasiswa yang masuk lebih dahulu akan dilayani lebih dahulu.

**Lihat Riwayat Transaksi**

<img width="296" height="128" alt="image" src="https://github.com/user-attachments/assets/22eea592-356d-4d17-831b-2a86995dcc67" />

Output pada gambar di atas  menunjukkan riwayat transaksi perpustakaan yang ditampilkan ketika pengguna memilih menu 12. Riwayat mencatat aktivitas penambahan dan penghapusan buku, seperti buku Belajar Fundamental Python, Matematika Diskrit, dan Belajar Java. Transaksi ditampilkan dari yang terbaru hingga yang paling lama. Fitur ini menerapkan struktur data Stack (LIFO), yaitu transaksi terakhir yang masuk akan ditampilkan terlebih dahulu.

**Batalkan Transaksi Terakhir**

<img width="348" height="295" alt="image" src="https://github.com/user-attachments/assets/62f39c8b-3d91-4fe7-9aec-9c924c754e6c" />

Output tersebut menunjukkan bahwa pengguna memilih menu 13, yaitu fitur untuk mengembalikan buku yang telah dihapus. Program berhasil menjalankan proses pengembalian buku, ditandai dengan pesan “Buku yang dihapus berhasil dikembalikan.”

**Keluar**

<img width="507" height="400" alt="image" src="https://github.com/user-attachments/assets/3a599cd0-352f-4b3f-a136-6ec625b9c286" />

Pengguna memilih menu 0 maka program selesai.


## Kesimpulan Program
Sistem Manajemen Perpustakaan Kampus merupakan program pembelajaran Java yang menggabungkan konsep OOP, arsitektur MVC, input menggunakan Scanner, serta enam jenis struktur data. Setiap struktur data digunakan untuk kebutuhan yang berbeda, mulai dari penyimpanan kategori dan statistik peminjaman hingga pengelolaan koleksi buku, lokasi penyimpanan, riwayat transaksi, dan antrean mahasiswa.

Melalui program ini, penerapan struktur data dapat dipahami melalui contoh sederhana yang dapat dijalankan dan diuji secara langsung. Pemisahan class berdasarkan MVC juga membantu meningkatkan keteraturan kode serta mempermudah proses pemeliharaan dan pengembangan program selanjutnya.
