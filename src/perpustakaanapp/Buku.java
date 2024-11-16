package perpustakaanapp;

public class Buku {
    private String judul;
    private String pengarang;
    private int tahunTerbit;
    private String ISBN;
    private boolean status; // true: tersedia, false: dipinjam

    public Buku(String judul, String pengarang, int tahunTerbit, String ISBN) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
        this.ISBN = ISBN;
        this.status = true;
    }

    public void tampilkanInfoBuku() {
        System.out.println("Judul: " + judul);
        System.out.println("Pengarang: " + pengarang);
        System.out.println("Tahun Terbit: " + tahunTerbit);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Status: " + (status ? "Tersedia" : "Dipinjam"));
        System.out.println("-----------------------------------");
    }

    public boolean isTersedia() {
        return status;
    }

    public void pinjam() {
        this.status = false;
    }

    public void kembalikan() {
        this.status = true;
    }

    public String getISBN() {
        return ISBN;
    }
}
