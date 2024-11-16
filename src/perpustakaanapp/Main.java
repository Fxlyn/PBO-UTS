package perpustakaanapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Perpustakaan perpustakaan = new Perpustakaan();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n===== Menu Perpustakaan =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Kembalikan Buku");
            System.out.println("5. Daftar Buku Tersedia");
            System.out.println("6. Daftar Anggota dan Buku yang Dipinjam");
            System.out.println("7. Keluar");
            System.out.print("Pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    System.out.println("===== Tambah Buku =====");
                    System.out.print("Judul: ");
                    String judul = scanner.nextLine();
                    System.out.print("Pengarang: ");
                    String pengarang = scanner.nextLine();
                    System.out.print("Tahun Terbit: ");
                    int tahun = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan buffer
                    System.out.print("ISBN: ");
                    String ISBN = scanner.nextLine();
                    perpustakaan.tambahBuku(new Buku(judul, pengarang, tahun, ISBN));
                    break;

                case 2:
                    System.out.println("===== Tambah Anggota =====");
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Nomor Anggota: ");
                    String nomor = scanner.nextLine();
                    System.out.print("Alamat: ");
                    String alamat = scanner.nextLine();
                    perpustakaan.tambahAnggota(new Anggota(nama, nomor, alamat));
                    break;

                case 3:
                    System.out.println("===== Pinjam Buku =====");
                    System.out.print("Nama Anggota: ");
                    nama = scanner.nextLine();
                    System.out.print("ISBN Buku: ");
                    ISBN = scanner.nextLine();
                    perpustakaan.pinjamBuku(nama, ISBN);
                    break;

                case 4:
                    System.out.println("===== Kembalikan Buku =====");
                    System.out.print("Nama Anggota: ");
                    nama = scanner.nextLine();
                    System.out.print("ISBN Buku: ");
                    ISBN = scanner.nextLine();
                    perpustakaan.kembalikanBuku(nama, ISBN);
                    break;

                case 5:
                    System.out.println("===== Daftar Buku Tersedia =====");
                    perpustakaan.daftarBukuTersedia();
                    break;

                case 6:
                    System.out.println("===== Daftar Anggota dan Buku yang Dipinjam =====");
                    perpustakaan.daftarAnggotaDanPinjaman();
                    break;

                case 7:
                    System.out.println("Terima kasih telah menggunakan aplikasi!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 7);
    }
}
