# Tugas-PBO-Pertemuan-Keempatbelas
Membuat Halaman Login, Register, Lupa Password Koneksi IReport, Jasper, Download dan Upload File CSV dan JFrame Form Netbeans dengan JPA (Java Persistence API) dan Dihubungkan dengan Foreign Key di Kontainer Netbeans. 
# HALAMAN LOGIN
Halaman login merupakan halaman awal yang digunakan pengguna untuk mengakses sistem dengan memasukkan username dan password. Pada aplikasi ini, proses autentikasi dilakukan dengan menghubungkan halaman login ke database menggunakan JPA (Java Persistence API). JPA berfungsi sebagai penghubung antara program Java dan database, sehingga data pengguna dapat diakses atau diverifikasi secara langsung melalui entitas (entity class).
Pada implementasinya di NetBeans, dibuat kelas entitas bernama Login yang berisi atribut seperti id, username, dan password. Kelas ini diberi anotasi @Entity agar dikenali sebagai representasi tabel pada database. JPA akan secara otomatis memetakan kelas tersebut ke tabel yang ada di database, misalnya tabel login.
Saat pengguna menekan tombol Login, sistem akan menjalankan query menggunakan EntityManager untuk memeriksa apakah kombinasi username dan password yang dimasukkan sesuai dengan data yang tersimpan di database.
Jika data valid, pengguna akan diarahkan ke halaman utama aplikasi. Namun, jika data tidak ditemukan atau salah, maka sistem akan menampilkan pesan kesalahan.
Dengan pendekatan ini, proses login menjadi lebih aman dan efisien karena seluruh interaksi data dikelola oleh JPA tanpa perlu menulis query SQL secara manual. Selain itu, penggunaan JPA memudahkan pengembangan aplikasi karena mendukung konsep Object Relational Mapping (ORM), yang memungkinkan objek Java langsung terhubung dengan tabel database.
 # PRIMARY KEY DAN FOREIGN KEY
       Primary Key adalah atribut atau kombinasi atribut pada sebuah tabel yang berfungsi untuk membedakan setiap baris data agar bersifat unik dan tidak boleh kosong. Primary key digunakan sebagai identitas utama suatu record, sehingga tidak ada dua data yang memiliki nilai primary key yang sama.
Foreign Key adalah atribut pada suatu tabel yang digunakan untuk menghubungkan data dengan tabel lain melalui referensi ke primary key tabel tersebut. Foreign key berfungsi untuk menjaga hubungan antar-tabel dan memastikan konsistensi serta integritas data di dalam basis data.
# KONTAINER GUI 
Kontainer dua tab pada NetBeans GUI menggunakan komponen JTabbedPane yang berfungsi untuk menampilkan beberapa panel dalam satu jendela aplikasi. Melalui komponen ini, pengguna dapat berpindah antar-tab dengan mudah tanpa membuka form baru. Setiap tab berisi tampilan atau fungsi yang berbeda, misalnya tab pertama menampilkan data pemilik, sedangkan tab kedua menampilkan data hewan. Dengan penggunaan JTabbedPane, tampilan aplikasi menjadi lebih rapi, terstruktur, dan efisien karena semua fitur dapat diakses dalam satu frame utama. Selain itu, komponen ini juga memudahkan pengelompokan data atau fitur yang saling berhubungan, sehingga meningkatkan kenyamanan dan kemudahan bagi pengguna dalam mengoperasikan aplikasi.
LANGKAH-LANGKAH PRAKTIKUM
1. Membuat Entity Classes From Database Buka NetBeans → Klik New → Entity Classes From Database. Pilih Data Source sesuai koneksi PostgreSQL. Pindahkan semua tabel dari Available Tables ke Selected Tables. Centang Generate Named Query Annotation for Persistent Fields → Next. Centang Use Column Names in Relationship → Finish.
2. Membuat Persistence Unit Klik kanan pada project → New → Persistence Unit. Pilih koneksi database PostgreSQL. Simpan hingga file persistence.xml terbentuk.
3. Membuat Database di PostgreSQL Buka pgAdmin → klik kanan Database → Create Database. Beri nama database → Save. Buat tabel sesuai kebutuhan (tabel login, pemilik, hewan, dsb.).
4. Menghubungkan NetBeans ke PostgreSQL Pada tab Services, buka Database → Drivers. Klik kanan PostgreSQL → Connect Using. Masukkan database name dan password. Klik Test Connection untuk memastikan koneksi berhasil. Salin JDBC URL bila diperlukan.
5. Menambah Library Klik kanan Libraries → Add Library untuk menambahkan PostgreSQL JDBC Driver. Klik kanan Libraries → Add JAR/Folder untuk menambahkan library JasperReport.
6. Membuat Report Jasper (Report Wizard) Klik kanan package → New → Report Wizard. Pilih ukuran kertas → Next. Tentukan nama file report (jasper/jrxml). Pilih koneksi database. Pindahkan semua field ke kanan → Next → Finish.
7. Membuat Package Kontainer Buat satu package berisi: JFrame Form JDialog (Insert, Update, Delete) Entity Classes File Jasper & Jrxml Persistence Unit
8. Membuat JFrame Form Utama Rancang tampilan tabel dan tombol (Insert, Update, Delete, Upload, Download, Cetak). Tambahkan method:koneksi()bersih()loadDataPetville() Tampilkan data dari database ke dalam JTable.
9. Membuat JDialog Insert Tambahkan form untuk input data baru. Hubungkan tombol Save ke kode em.persist() untuk menambah data.
10. Membuat JDialog Update Form untuk mengedit data. Ambil data baris yang dipilih dari JTable. Update data menggunakan em.merge().
11. Membuat JDialog Delete Menampilkan data yang siap dihapus. Hapus satu baris menggunakan em.remove().
12. Membuat Tombol Upload CSV Gunakan JFileChooser untuk memilih file CSV. Baca file menggunakan BufferedReader. Lakukan validasi: Format angka Nama pemilik Simpan data ke database dengan em.persist(). Tampilkan notifikasi “Upload selesai”.
13. Membuat Tombol Download CSV Loop data tabel → tulis ke file CSV menggunakan FileWriter. Simpan ke direktori yang dipilih user.
14. Membuat Tombol Delete All Jalankan query DELETE FROM NamaTabel. Refresh JTable.
15. Membuat Fitur Login Buat entity Login. Cek username & password menggunakan JPA. Jika benar → masuk Dashboard. Jika salah → tampilkan pesan kesalahan.
16. Membuat Halaman Register Form untuk membuat akun baru. Cek apakah username sudah ada. Simpan akun baru ke database.
17. Membuat Halaman Lupa Password Masukkan username. Jika ditemukan → arahkan ke form Reset Password.
18. Membuat Halaman Reset Password Masukkan password baru. Update data password di database.
19. Mencetak Data dengan Jasper Klik tombol Cetak. JasperReport akan membaca data dari database. Cetak seluruh isi tabel dalam bentuk laporan.
