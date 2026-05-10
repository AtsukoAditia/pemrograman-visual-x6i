# 🏥 Pemrograman Visual — Sistem Informasi Klinik

> Proyek latihan mata kuliah **Pemrograman Visual** menggunakan Java Swing (NetBeans IDE) yang terkoneksi dengan database MySQL melalui XAMPP.

---

## 📋 Deskripsi

Repositori ini berisi kumpulan program latihan dari materi-materi perkuliahan Pemrograman Visual. Program berbasis **Java Swing** dengan tampilan GUI yang dibangun menggunakan **NetBeans IDE**, serta terkoneksi ke database **MySQL (XAMPP)**.

Aplikasi ini mensimulasikan **Sistem Informasi Klinik** dengan fitur:
- Login user dengan validasi database
- Menu utama dengan navigation bar
- CRUD Data Pasien (Create, Read, Update, Delete)
- Pencarian data
- Dan form-form lainnya (Dokter, Obat, Perawat, Pemeriksaan, Rawat Inap, Pembayaran)

---

## 🛠️ Tools yang Digunakan

| Tools | Versi | Link Download |
|-------|-------|---------------|
| **Apache NetBeans IDE** | 29 | [⬇️ Download NetBeans](https://netbeans.apache.org/front/main/download/nb29/) |
| **XAMPP (Apache + MySQL)** | Latest | [⬇️ Download XAMPP](https://www.apachefriends.org/download.html) |
| **Java JDK** | 11+ | Termasuk dalam instalasi NetBeans |
| **MySQL Connector/J** | 8.x | Tersedia di folder `lib` project |

---

## 📁 Struktur Proyek

```
pemrograman-visual-x6i/
├── database/                          # File SQL database
│   └── klinik.sql                     # Script pembuatan tabel & data awal
│
├── src/main/java/
│   ├── com/tpv/tugas/gymme/           # Package utama aplikasi
│   │   ├── Login.java / .form         # Form Login
│   │   ├── Menu_Utama.java / .form    # Menu Utama (Menu Bar)
│   │   ├── data_pasien.java / .form   # CRUD Data Pasien
│   │   ├── Data_Dokter.java / .form   # CRUD Data Dokter
│   │   ├── Rekam_Medis.java / .form   # Rekam Medis
│   │   ├── bg2.java                   # Custom Panel Background
│   │   └── Gymme.java                 # Main entry point
│   │
│   └── koneksi/
│       └── koneksi.java               # Kelas koneksi database MySQL
│
├── pom.xml                            # Maven configuration
└── README.md
```

---

## 🗄️ Struktur Database

Database: `klinik`

```sql
-- Tabel pasien
CREATE TABLE pasien (
  id      VARCHAR(20) PRIMARY KEY,
  nama    VARCHAR(100),
  jk      VARCHAR(15),
  alamat  TEXT,
  goldar  VARCHAR(5)
);

-- Tabel admin (untuk login)
CREATE TABLE admin (
  username VARCHAR(50) PRIMARY KEY,
  password VARCHAR(100)
);
```

> File SQL lengkap tersedia di folder `database/`.

---

## 🚀 Cara Menjalankan

### 1. Persiapan Database
1. Install dan jalankan **XAMPP**, aktifkan **Apache** dan **MySQL**
2. Buka **phpMyAdmin** → `http://localhost/phpmyadmin`
3. Buat database baru dengan nama `klinik`
4. Import file `database/klinik.sql`

### 2. Buka Project di NetBeans
1. Buka **NetBeans IDE**
2. Pilih `File` → `Open Project`
3. Arahkan ke folder `pemrograman-visual-x6i`
4. Pastikan **MySQL Connector/J** sudah ada di Libraries project

### 3. Konfigurasi Koneksi
Sesuaikan file `koneksi/koneksi.java` jika diperlukan:
```java
String url  = "jdbc:mysql://localhost:3306/klinik";
String user = "root";
String pass = ""; // sesuaikan password MySQL Anda
```

### 4. Jalankan Aplikasi
- Klik kanan file `Login.java` → **Run File**
- Login dengan: **Username:** `admin` | **Password:** `1234`

---

## 📚 Materi yang Dipelajari

| No | Materi | Keterangan |
|----|--------|------------|
| 1 | Event `actionPerformed` | Tombol Login, Save, Edit, Delete, Clear, Exit |
| 2 | Event `mouseClicked` | Klik baris tabel → auto-fill form |
| 3 | Koneksi Database (JDBC) | Class `koneksi.java` dengan MySQL |
| 4 | CRUD dengan PreparedStatement | Insert, Update, Delete data pasien |
| 5 | `JTable` & `DefaultTableModel` | Menampilkan & refresh data dari DB |
| 6 | `JMenuBar` | Navigasi antar form di Menu Utama |
| 7 | Custom Background (`bg2.java`) | Override `paintComponent()` |

---

## 🖥️ Tampilan Aplikasi

```
[Form Login]
  Username: ________
  Password: ________
  [Login]  [Cancel]

[Menu Utama]
  MASTER | TRANSAKSI | REPORT | KELUAR

[Data Pasien]
  No. Identitas : ________
  Nama Pasien   : ________
  Jenis Kelamin : ○ Laki-laki  ○ Perempuan
  Alamat        : ________
  Golongan Darah: [Dropdown]
  [SAVE] [EDIT] [DELETE] [CLEAR] [EXIT]
  Kata Kunci: ________ [CARI]
  ┌─────────────────────────────────┐
  │  Tabel Data Pasien              │
  └─────────────────────────────────┘
```

---

## 👤 Author

**Aditia Nugraha (AtsukoAditia)**

- Mata Kuliah: Pemrograman Visual
- Program Studi: Teknik Informatika
- GitHub: [@AtsukoAditia](https://github.com/AtsukoAditia)

---

## 📝 Catatan

- File `.form` adalah file desain GUI NetBeans (jangan diedit manual)
- Pastikan XAMPP berjalan sebelum menjalankan aplikasi
- Gunakan NetBeans versi 17 ke atas untuk kompatibilitas optimal
- MySQL Connector JAR harus ditambahkan ke Libraries project secara manual jika belum ada
