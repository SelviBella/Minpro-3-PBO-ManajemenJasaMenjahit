# Sistem Manajemen Jasa Menjahit

**Nama**: Selvi Bella Dwi Anita

**NIM**:2509116053

**Kelas**: B

---

## Deskripsi Singkat Program

Program aplikasi jasa menjahit ini dikembangkan untuk mengoptimalkan manajemen antrean pesanan jahit secara otomatis. Program ini menggunakan pola struktur *MVC (Model View Controller)* agar penyusunan kode lebih rapi. Selain itu, program ini menerapkan konsep Encapsulation, Inheritance, Abstraction (Abstract Class & Method) serta Polymorphism (Overriding & Overloading). Terdapat juga implementasi Interface untuk mengkalkulasi potongan harga (diskon) secara otomatis bagi pelanggan.

---

## Struktur Package

Program ini dibagi ke dalam beberapa package terpisah agar kodenya bisa terorganisir dengan baik:

1. *model*: Package ini berisi data objek atau entitas dan logika hitungan program, yaitu Pelanggan.java, Layanan.java (Abstract Class), LayananJahitBaru.java, LayananPermak.java, Pesanan.java, dan DiskonKhusus.java (Interface).
2. *view*: Package ini berisi file View.java yang bertugas untuk menampilkan menu di layar dan membaca inputan keyboard dari user memakai Scanner.
3. *controller*: Package ini Berisi file Controller.java yang bertugas sebagai otak untuk mengatur data pesanan (tambah, tampilkan, ubah, dan hapus) di dalam ArrayList.
4. *main*: Package ini berisi file Main.java yang bertugas sebagai gerbang utama untuk menjalankan program saat pertama kali dibuka.

---

## Alur Program

**1. Menu Utama**

Aplikasi memunculkan 5 pilihan menu awal yaitu tambah, tampilkan, ubah status, hapus pesanan dan keluar dari program. Menu utama ini ditampilkan menggunakan perulangan do-while dan switch-case.

<img width="202" height="100" alt="image" src="https://github.com/user-attachments/assets/93f0ef6d-aef6-4db0-aa9b-a262985020dc" />

---
**2. Menu 1 (Tambah Pesanan Baru)**

User/Penjahit bisa memasukkan data pelanggan, memilih jenis layanan (Jahit Baru atau Permak), memasukkan detail bahan atau tingkat kesulitan, jenis pakaian, ukuran, dan jumlahnya. Total harganya nanti akan langsung dihitung otomatis oleh sistem.

<img width="256" height="241" alt="image" src="https://github.com/user-attachments/assets/afd5ff30-a9eb-4eef-85b1-876dfec57576" />

---
**3. Menu 2 (Tampilkan Semua Pesanan)**

Aplikasi menampilkan semua daftar antrean pesanan yang ada dan bisa memilih format cetak nota yaitu format yang Lengkap (Invoice) atau tampilan format yang Ringkas (Hanya satu baris)*.

* Tampilan Nota Lengkap

<img width="432" height="705" alt="image" src="https://github.com/user-attachments/assets/db249232-6296-4ad3-b27f-88e55fa15b88" />

---
* Tampilan Nota Ringkas

<img width="338" height="257" alt="image" src="https://github.com/user-attachments/assets/aca64eb6-ecec-4168-bca2-65cdafd895b5" />

---
**4. Menu 3 (Ubah Status Pesanan)**

Digunakan untuk mencari ID pesanan tertentu lalu mengubah status pengerjaannya ("Selesai" atau "Diambil") dan otomatis akan terubah saat ditampilkan.

<img width="320" height="567" alt="image" src="https://github.com/user-attachments/assets/0cda5254-b062-44fb-b3c8-57b39679d27d" />

---
**5. Menu 4 (Batalkan/Hapus Pesanan)**

Digunakan untuk menghapus atau membatalkan pesanan dari daftar antrian berdasarkan ID pesanan yang dipilih. Contohnya jika ingin menghapus pesanan yang statusnya "Diambil".

<img width="320" height="480" alt="image" src="https://github.com/user-attachments/assets/9fea0ccc-9621-4b20-a759-5f65d28c2238" />

---
**6. Menu 5 (Keluar)**

Untuk menghentikan perulangan menu utama dan menutup program aplikasi.

<img width="245" height="116" alt="image" src="https://github.com/user-attachments/assets/7f6d99f3-428c-4850-9ab2-ac60d2c2537e" />

---
**7. Validasi Input**

Program menggunakan fungsi input.hasNextInt() untuk mengecek inputan user. Jika user salah memasukkan huruf atau input yang tidak valid seperti pada pilihan menu, tambah pesanan, memilih ID saat update status, maupun ID saat hapus pesanan, program tidak akan eror atau keluar sendiri, melainkan memunculkan pesan peringatan dan kembali ke menu utama dengan aman.

* Validasi Pilih Menu Awal

<img width="276" height="233" alt="image" src="https://github.com/user-attachments/assets/e3dc4b6e-8668-43a7-abbb-02de08a5d1f1" />

---
* Validasi Nama Pelanggan

<img width="540" height="127" alt="image" src="https://github.com/user-attachments/assets/ea4d9752-7bc9-4546-b121-40fc01720fda" />

---
* Validasi Nomor Telepon

<img width="472" height="148" alt="image" src="https://github.com/user-attachments/assets/3cb7df4c-fd4a-464d-8fa4-256fe96d7f7a" />

---
* Validasi Alamat

<img width="487" height="155" alt="image" src="https://github.com/user-attachments/assets/ccaf95c1-9993-4759-9825-db990833cbe3" />

---
* Validasi Pilihan Layanan

<img width="253" height="182" alt="image" src="https://github.com/user-attachments/assets/33fd310b-8cac-494a-b31b-8ce612f66b0a" />

---
* Validasi Jenis Bahan Kain

<img width="397" height="198" alt="image" src="https://github.com/user-attachments/assets/2ccdd373-13bd-4254-85b8-e99d665c5364" />

---
* Validasi Jenis Pakaian

<img width="586" height="207" alt="image" src="https://github.com/user-attachments/assets/9428be51-d764-4223-90d3-53d199e55223" />

---
* Validasi Tingkat Kesulitan

<img width="411" height="198" alt="image" src="https://github.com/user-attachments/assets/843dbd46-0508-4b0e-b07c-3ed78ddca1b8" />

---
* Validasi Ukuran

<img width="382" height="225" alt="image" src="https://github.com/user-attachments/assets/d45fbbe9-cf2f-4141-badb-cb942c58442e" />

---
* Validasi Jumlah (pcs)

<img width="323" height="240" alt="image" src="https://github.com/user-attachments/assets/31ff79c6-3d2f-4e6e-95d0-e869bffb9331" />

---
* Validasi ID untuk Ubah Status Pesanan

<img width="303" height="143" alt="image" src="https://github.com/user-attachments/assets/0b1ed73e-9aa9-4131-a1f6-4000c72be449" />

---
* Validasi Status Baru

<img width="485" height="145" alt="image" src="https://github.com/user-attachments/assets/bf91228a-bab2-49e7-a8e6-973857f8210b" />

---
* Validasi ID untuk Batalkan Pesanan

<img width="267" height="128" alt="image" src="https://github.com/user-attachments/assets/89d3386f-8c1e-4373-8da7-51d58d91fe3d" />

---
## Penerapan Encapsulation & Inheritance

Semua atribut penting di dalam kelas model (seperti nama, nomor telepon, dan alamat) dikunci menggunakan hak akses private. Variabel *idPesanan* di dalam file Pesanan.java juga sudah diubah menjadi *private* agar datanya lebih aman, dan akses pembacaannya dari luar kelas harus lewat fungsi *Getter.





















