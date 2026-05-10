package com.tpv.tugas.gymme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Menu Utama - Form utama setelah Login berhasil
 * Materi: Pemrograman Visual - Event actionListener
 *
 * Menu Bar:
 * - MASTER : Form Pasien, Form Dokter, Form Obat, Form Perawat
 * - TRANSAKSI : Pemeriksaan, Rawat Inap, Pembayaran
 * - REPORT  : (sub-menu laporan)
 * - KELUAR  : Keluar aplikasi
 */
public class Menu_Utama extends JFrame implements ActionListener {

    // session user login
    private String namaLogin;

    // ===== Komponen Menu Bar =====
    private JMenuBar menuBar;

    // Menu 1: MASTER
    private JMenu menuMaster;
    private JMenuItem miPasien;
    private JMenuItem miDokter;
    private JMenuItem miObat;
    private JMenuItem miPerawat;

    // Menu 2: TRANSAKSI
    private JMenu menuTransaksi;
    private JMenuItem miPemeriksaan;
    private JMenuItem miRawatInap;
    private JMenuItem miPembayaran;

    // Menu 3: REPORT
    private JMenu menuReport;
    private JMenuItem miRepPasien;
    private JMenuItem miRepDokter;
    private JMenuItem miRepPemeriksaan;
    private JMenuItem miRepPembayaran;

    // Menu 4: KELUAR
    private JMenu menuKeluar;
    private JMenuItem miKeluar;

    // Panel konten utama
    private JPanel panelKonten;
    private JLabel lblWelcome;

    public Menu_Utama() {
        this("Admin");
    }

    public Menu_Utama(String namaLogin) {
        this.namaLogin = namaLogin;
        initComponents();
    }

    private void initComponents() {

        // ===== Inisialisasi Menu Bar =====
        menuBar = new JMenuBar();

        // --- Menu MASTER ---
        menuMaster = new JMenu("MASTER");
        menuMaster.setMnemonic(KeyEvent.VK_M);

        miPasien      = new JMenuItem("Form Pasien");
        miDokter      = new JMenuItem("Form Dokter");
        miObat        = new JMenuItem("Form Obat");
        miPerawat     = new JMenuItem("Form Perawat");

        miPasien.addActionListener(this);
        miDokter.addActionListener(this);
        miObat.addActionListener(this);
        miPerawat.addActionListener(this);

        menuMaster.add(miPasien);
        menuMaster.add(miDokter);
        menuMaster.add(miObat);
        menuMaster.add(miPerawat);

        // --- Menu TRANSAKSI ---
        menuTransaksi = new JMenu("TRANSAKSI");
        menuTransaksi.setMnemonic(KeyEvent.VK_T);

        miPemeriksaan = new JMenuItem("Pemeriksaan");
        miRawatInap   = new JMenuItem("Rawat Inap");
        miPembayaran  = new JMenuItem("Pembayaran");

        miPemeriksaan.addActionListener(this);
        miRawatInap.addActionListener(this);
        miPembayaran.addActionListener(this);

        menuTransaksi.add(miPemeriksaan);
        menuTransaksi.add(miRawatInap);
        menuTransaksi.add(miPembayaran);

        // --- Menu REPORT ---
        menuReport = new JMenu("REPORT");
        menuReport.setMnemonic(KeyEvent.VK_R);

        miRepPasien       = new JMenuItem("Laporan Pasien");
        miRepDokter       = new JMenuItem("Laporan Dokter");
        miRepPemeriksaan  = new JMenuItem("Laporan Pemeriksaan");
        miRepPembayaran   = new JMenuItem("Laporan Pembayaran");

        miRepPasien.addActionListener(this);
        miRepDokter.addActionListener(this);
        miRepPemeriksaan.addActionListener(this);
        miRepPembayaran.addActionListener(this);

        menuReport.add(miRepPasien);
        menuReport.add(miRepDokter);
        menuReport.add(miRepPemeriksaan);
        menuReport.add(miRepPembayaran);

        // --- Menu KELUAR ---
        menuKeluar = new JMenu("KELUAR");
        menuKeluar.setMnemonic(KeyEvent.VK_K);

        miKeluar = new JMenuItem("Keluar Aplikasi");
        miKeluar.addActionListener(this);
        menuKeluar.add(miKeluar);

        // Tambahkan semua menu ke menu bar
        menuBar.add(menuMaster);
        menuBar.add(menuTransaksi);
        menuBar.add(menuReport);
        menuBar.add(menuKeluar);

        setJMenuBar(menuBar);

        // ===== Panel Konten =====
        panelKonten = new JPanel(new BorderLayout());
        panelKonten.setBackground(new Color(230, 240, 255));

        lblWelcome = new JLabel("Selamat Datang di Sistem Informasi Klinik - " + namaLogin,
                SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 18));
        lblWelcome.setForeground(new Color(30, 80, 150));

        panelKonten.add(lblWelcome, BorderLayout.CENTER);
        add(panelKonten, BorderLayout.CENTER);

        // ===== Pengaturan JFrame =====
        setTitle("Menu Utama - Sistem Informasi Klinik");
        setSize(800, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
    }

    /**
     * Event actionPerformed untuk semua menu item
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        Object src = e.getSource();

        // === MENU MASTER ===
        if (src == miPasien) {
            new Data_Pasien().setVisible(true);
        } else if (src == miDokter) {
            new Data_Dokter().setVisible(true);
        } else if (src == miObat) {
            JOptionPane.showMessageDialog(this, "Membuka Form Obat...",
                    "Form Obat", JOptionPane.INFORMATION_MESSAGE);
            // TODO: new Form_Obat().setVisible(true);
        } else if (src == miPerawat) {
            JOptionPane.showMessageDialog(this, "Membuka Form Perawat...",
                    "Form Perawat", JOptionPane.INFORMATION_MESSAGE);
            // TODO: new Form_Perawat().setVisible(true);

        // === MENU TRANSAKSI ===
        } else if (src == miPemeriksaan) {
            new Rekam_Medis().setVisible(true);
        } else if (src == miRawatInap) {
            JOptionPane.showMessageDialog(this, "Membuka Form Rawat Inap...",
                    "Rawat Inap", JOptionPane.INFORMATION_MESSAGE);
            // TODO: new Form_RawatInap().setVisible(true);
        } else if (src == miPembayaran) {
            JOptionPane.showMessageDialog(this, "Membuka Form Pembayaran...",
                    "Pembayaran", JOptionPane.INFORMATION_MESSAGE);
            // TODO: new Form_Pembayaran().setVisible(true);

        // === MENU REPORT ===
        } else if (src == miRepPasien) {
            JOptionPane.showMessageDialog(this, "Membuka Laporan Pasien...",
                    "Report Pasien", JOptionPane.INFORMATION_MESSAGE);
        } else if (src == miRepDokter) {
            JOptionPane.showMessageDialog(this, "Membuka Laporan Dokter...",
                    "Report Dokter", JOptionPane.INFORMATION_MESSAGE);
        } else if (src == miRepPemeriksaan) {
            JOptionPane.showMessageDialog(this, "Membuka Laporan Pemeriksaan...",
                    "Report Pemeriksaan", JOptionPane.INFORMATION_MESSAGE);
        } else if (src == miRepPembayaran) {
            JOptionPane.showMessageDialog(this, "Membuka Laporan Pembayaran...",
                    "Report Pembayaran", JOptionPane.INFORMATION_MESSAGE);

        // === MENU KELUAR ===
        } else if (src == miKeluar) {
            int konfirmasi = JOptionPane.showConfirmDialog(this,
                    "Apakah Anda yakin ingin logout?",
                    "Konfirmasi Logout",
                    JOptionPane.YES_NO_OPTION);
            if (konfirmasi == JOptionPane.YES_OPTION) {
                this.dispose();
                new Login().setVisible(true);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Menu_Utama().setVisible(true);
        });
    }
}
