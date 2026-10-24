
package sistemperpustakaan.model;

public class Buku {
    private int id;
    private String judul;
    private String penulis;
    private String kategori;

    public Buku(int id, String judul, String penulis, String kategori) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
    }

    public int getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public String getKategori() {
        return kategori;
    }

    public void tampilkan() {
        System.out.println("ID       : " + id);
        System.out.println("Judul    : " + judul);
        System.out.println("Penulis  : " + penulis);
        System.out.println("Kategori : " + kategori);
    }
}