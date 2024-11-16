package perpustakaanapp;

import java.util.ArrayList;

public class Perpustakaan {
    private ArrayList<Buku> daftarBuku;
    private ArrayList<Anggota> daftarAnggota;

    public Perpustakaan() {
        daftarBuku = new ArrayList<>();
        daftarAnggota = new ArrayList<>();
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
        System.out.println("Buku '" + buku.getISBN() + "' berhasil ditambahkan ke perpustakaan!");
    }

    public void tambahAnggota(Anggota anggota) {
        daftarAnggota.add(anggota);
        System.out.println("Anggota '" + anggota.getNama() + "' berhasil didaftarkan!");
    }

    public void daftarBukuTersedia() {
        if (daftarBuku.isEmpty()) {
            System.out.println("Tidak ada buku di perpustakaan.");
            return;
        }
        boolean adaBukuTersedia = false;
        for (Buku buku : daftarBuku) {
            if (buku.isTersedia()) {
                adaBukuTersedia = true;
                buku.tampilkanInfoBuku();
            }
        }
        if (!adaBukuTersedia) {
            System.out.println("Semua buku sedang dipinjam.");
        }
    }

    public void daftarAnggotaDanPinjaman() {
        if (daftarAnggota.isEmpty()) {
            System.out.println("Tidak ada anggota yang terdaftar.");
            return;
        }

        for (Anggota anggota : daftarAnggota) {
            anggota.tampilkanInfoAnggota();
        }
    }

    public void pinjamBuku(String namaAnggota, String ISBN) {
        Anggota anggota = cariAnggota(namaAnggota);
        Buku buku = cariBuku(ISBN);

        if (anggota != null && buku != null && buku.isTersedia()) {
            buku.pinjam();
            anggota.pinjamBuku(buku);
            System.out.println("Buku berhasil dipinjam.");
        } else {
            System.out.println("Gagal meminjam buku. Pastikan data valid.");
        }
    }

    public void kembalikanBuku(String namaAnggota, String ISBN) {
        Anggota anggota = cariAnggota(namaAnggota);
        Buku buku = cariBuku(ISBN);

        if (anggota != null && buku != null) {
            buku.kembalikan();
            anggota.kembalikanBuku(buku);
        } else {
            System.out.println("Gagal mengembalikan buku. Pastikan data valid.");
        }
    }

    private Anggota cariAnggota(String nama) {
        for (Anggota anggota : daftarAnggota) {
            if (anggota.getNama().equalsIgnoreCase(nama)) {
                return anggota;
            }
        }
        return null;
    }

    private Buku cariBuku(String ISBN) {
        for (Buku buku : daftarBuku) {
            if (buku.getISBN().equalsIgnoreCase(ISBN)) {
                return buku;
            }
        }
        return null;
    }
}
