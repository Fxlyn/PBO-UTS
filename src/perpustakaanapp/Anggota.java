package perpustakaanapp;

import java.util.ArrayList;

public class Anggota {
    private String nama;
    private String nomorAnggota;
    private String alamat;
    private ArrayList<Buku> daftarPinjaman;

    public Anggota(String nama, String nomorAnggota, String alamat) {
        this.nama = nama;
        this.nomorAnggota = nomorAnggota;
        this.alamat = alamat;
        this.daftarPinjaman = new ArrayList<>();
    }

    public void tampilkanInfoAnggota() {
        System.out.println("Nama: " + nama);
        System.out.println("Nomor Anggota: " + nomorAnggota);
        System.out.println("Alamat: " + alamat);
        System.out.println("Buku yang Dipinjam:");
        if (daftarPinjaman.isEmpty()) {
            System.out.println("Tidak ada buku yang dipinjam.");
        } else {
            for (Buku buku : daftarPinjaman) {
                System.out.println("- " + buku.getISBN());
            }
        }
        System.out.println("-----------------------------------");
    }

    public void pinjamBuku(Buku buku) {
        daftarPinjaman.add(buku);
        System.out.println("Buku '" + buku.getISBN() + "' berhasil dipinjam oleh " + nama + ".");
    }

    public void kembalikanBuku(Buku buku) {
        daftarPinjaman.remove(buku);
        System.out.println("Buku '" + buku.getISBN() + "' berhasil dikembalikan oleh " + nama + ".");
    }

    public String getNama() {
        return nama;
    }
}
