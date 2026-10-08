/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import controller.Controller;
import model.*;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class View {
    private final Controller controller = new Controller();
    private final Scanner input = new Scanner(System.in);

    public void tampilkanMenu() {
        int pilihan = 0;
        do {
            System.out.println("\n === SISTEM JASA MENJAHIT ===");
            System.out.println("1. Tambah Pesanan Baru ");
            System.out.println("2. Tampilkan Semua Pesanan ");
            System.out.println("3. Ubah Status Pesanan ");
            System.out.println("4. Batalkan Pesanan ");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            
            if (input.hasNextInt()) {
                pilihan = input.nextInt();
                input.nextLine(); 
            } else {
                System.out.println("[Error] Input menu harus berupa angka bulat!");
                input.nextLine(); 
                continue;
            }

            switch (pilihan) {
                case 1 -> prosesTambah();
                case 2 -> prosesTampil();
                case 3 -> prosesUpdate();
                case 4 -> prosesHapus();
                case 5 -> System.out.println("Keluar dari program. Terima kasih!");
                default -> System.out.println("Pilihan tidak tersedia!");
            }
        } while (pilihan != 5);
    }

    private void prosesTambah() {
        System.out.print("Nama Pelanggan: ");
        String nama = input.nextLine();
        if (nama.trim().isEmpty() || nama.matches("[0-9]+")) {
            System.out.println("[Error] Gagal! Nama pelanggan tidak valid (tidak boleh kosong atau hanya berisi angka).");
            return;
        }
     
        System.out.print("Nomor Telepon : ");
        String telp = input.nextLine();
        if (!telp.matches("[0-9]+") || telp.length() < 10 || telp.length() > 13) {
            System.out.println("[Error] Gagal! Nomor telepon harus berupa angka dan berjumlah 10-13 digit.");
            return;
        }
        
        System.out.print("Alamat        : ");
        String alamat = input.nextLine();
        
        if (alamat.trim().isEmpty() || alamat.matches("[0-9]+")){
            System.out.println("[Error] Gagal! Alamat tidak valid (tidak boleh kosong atau hanya berisi angka).");
            return;
        }
        
        Pelanggan pelanggan = new Pelanggan(nama, telp, alamat);

        System.out.println("Pilih Layanan: 1. Jahit Baru | 2. Permak");
        System.out.print("Pilihan (1/2): ");
        int opsi = input.hasNextInt() ? input.nextInt() : 0; input.nextLine();

        Layanan layananTerpilih;
        if (opsi == 1) {
            System.out.print("Jenis Bahan Kain (Biasa/Sutra): ");
            String bahan = input.nextLine();
            if (!bahan.equalsIgnoreCase("Biasa") && !bahan.equalsIgnoreCase("Sutra")) {
                System.out.println("[Error] Gagal! Jenis bahan kain hanya boleh 'Biasa' atau 'Sutra'.");
                return;
            }
            layananTerpilih = new LayananJahitBaru(150000, bahan);
        } else if (opsi == 2) {
            System.out.print("Tingkat Kesulitan (Ringan/Berat): ");
            String sulit = input.nextLine();
            if (!sulit.equalsIgnoreCase("Ringan") && !sulit.equalsIgnoreCase("Berat")) {
                System.out.println("[Error] Gagal! Tingkat kesulitan hanya boleh 'Ringan' or 'Berat'.");
                return;
            }
            layananTerpilih = new LayananPermak(50000, sulit);
        } else {
            System.out.println("[Error] Opsi layanan tidak valid!"); 
            return;
        }

        System.out.print("Jenis Pakaian: ");
        String jenis = input.nextLine();
        if (jenis.trim().isEmpty() || !jenis.matches("[a-zA-Z\\s]+")) {
            System.out.println("[Error] Gagal! Jenis pakaian hanya boleh berisi huruf alfabet (contoh: Kemeja, Gaun, Celana).");
            return;
        }
        
        System.out.print("Ukuran (S/M/L/XL): ");
        String ukuran = input.nextLine();
        if (!ukuran.equalsIgnoreCase("S") && !ukuran.equalsIgnoreCase("M") && 
            !ukuran.equalsIgnoreCase("L") && !ukuran.equalsIgnoreCase("XL")) {
            System.out.println("[Error] Gagal! Ukuran pakaian hanya boleh S, M, L, atau XL.");
            return;
        }
        
        System.out.print("Jumlah (pcs): ");
        int jml;
        if (input.hasNextInt()) {
            jml = input.nextInt(); input.nextLine();
            if (jml <= 0) {
                System.out.println("[Error] Gagal! Jumlah pesanan minimal harus 1 pcs.");
                return;
            }
        } else {
            System.out.println("[Error] Gagal! Jumlah pcs harus berupa angka bulat.");
            input.nextLine(); 
            return;
        }

        controller.tambahPesanan(pelanggan, layananTerpilih, jenis, ukuran, jml);
        System.out.println("Pesanan Baru Berhasil Ditambahkan!");
    }

    private void prosesTampil() {
        System.out.println("\n--- FORMAT NOTA ---\n1. Lengkap | 2. Ringkas");
        System.out.print("Pilih format (1/2): ");
        int format = input.hasNextInt() ? input.nextInt() : 1; input.nextLine();

        System.out.println("\n--- DAFTAR ANTRIAN ---");
        for (Pesanan p : controller.getDaftarPesanan()) {
            if (format == 2) p.tampilkanInvoice(true); 
            else p.tampilkanInvoice();
        }
    }

    private void prosesUpdate() {
        System.out.print("Masukkan ID Pesanan: ");
        int id;
        if (input.hasNextInt()) {
            id = input.nextInt(); input.nextLine();
        } else {
            System.out.println("[Error] Input ID gagal! ID harus berupa angka bulat.");
            input.nextLine(); return;
        }
        
        System.out.print("Masukkan Status Baru (Selesai/Diambil): ");
        String status = input.nextLine();
        
        if (status.equalsIgnoreCase("Selesai") || status.equalsIgnoreCase("Diambil")) {

            if (controller.updateStatus(id, status)) {
                System.out.println("Status Berhasil Diperbarui!");
            } else {
                System.out.println("ID Pesanan tidak ditemukan!");
            }
        } else {
            System.out.println("[Error] Status tidak valid! Hanya boleh mengisi 'Selesai' atau 'Diambil'. ");
        }
    }

    private void prosesHapus() {
        System.out.print("Masukkan ID Pesanan yang ingin dihapus: ");
        int id;
        if (input.hasNextInt()) {
            id = input.nextInt(); input.nextLine();
        } else {
            System.out.println("[Error] Input ID gagal! ID harus berupa angka bulat.");
            input.nextLine(); return;
        }

        if (controller.sampleDelete(id)) System.out.println("Pesanan Berhasil Dihapus!");
        else System.out.println("ID Pesanan tidak ditemukan!");
    }
}
