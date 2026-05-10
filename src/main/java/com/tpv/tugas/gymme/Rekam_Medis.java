/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.tpv.tugas.gymme;

import com.toedter.calendar.JCalendar;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;

/**
 *
 * @author atsukoaditia
 */
public final class Rekam_Medis extends javax.swing.JFrame {
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    private DefaultTableModel tabDokter;
    private DefaultTableModel tabPasien;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Rekam_Medis.class.getName());

    public Rekam_Medis() {
        initComponents();
        conn = new koneksi().connect();
        if (conn == null) {
            JOptionPane.showMessageDialog(this,
                "Koneksi ke database gagal.\nPeriksa XAMPP/MySQL dan konfigurasi koneksi.",
                "Error Database",
                JOptionPane.ERROR_MESSAGE);
        } else {
            datatable();
            loadTableDokter();
            loadTablePasien();
        }
        aktif();
        kosong();
    }

    protected void aktif() {
        calTanggal.setEnabled(true);
        tid_dokter.setEnabled(true);
        tid_pasien.setEnabled(true);
        ttb.setEnabled(true);
        tbb.setEnabled(true);
        tdiagnosa.setEnabled(true);
        tcari.setEnabled(true);
        calTanggal.requestFocus();
    }

    protected void kosong() {
        calTanggal.setDate(new java.util.Date());
        tid_dokter.setText("");
        tnama_dokter.setText("");
        tid_pasien.setText("");
        tnama_pasien.setText("");
        tgd.setText("");
        ttb.setText("");
        tbb.setText("");
        tdiagnosa.setText("");
        tcari.setText("");
    }

    private String getTanggalPeriksa() {
        return sdf.format(calTanggal.getDate());
    }

    protected void datatable() {
        Object[] Baris = {"Tanggal Periksa", "ID Dokter", "ID Pasien", "Tinggi Badan", "Berat Badan", "Diagnosa"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelrekam.setModel(tabmode);
        String sql = "select * from rekam order by tgl asc";
        try {
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String[] data = {
                    hasil.getString("tgl"),
                    hasil.getString("id_dok"),
                    hasil.getString("id_pas"),
                    hasil.getString("tb"),
                    hasil.getString("bb"),
                    hasil.getString("diagnosa")
                };
                tabmode.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                "Gagal load data rekam medis: " + e.getMessage(),
                "Error Database",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadTableDokter() {
        Object[] Baris = {"ID Dokter", "Nama Dokter", "Jenis Kelamin", "Spesialis"};
        tabDokter = new DefaultTableModel(null, Baris);
        tabelDokter.setModel(tabDokter);
        String sql = "select * from dokter order by id asc";
        try {
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String[] data = {
                    hasil.getString("id"),
                    hasil.getString("nama"),
                    hasil.getString("jk"),
                    hasil.getString("spesialis")
                };
                tabDokter.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal load data dokter: " + e.getMessage());
        }
    }

    private void loadTablePasien() {
        Object[] Baris = {"ID Pasien", "Nama Pasien", "Jenis Kelamin", "Golongan Darah"};
        tabPasien = new DefaultTableModel(null, Baris);
        tabelPasien.setModel(tabPasien);
        String sql = "select * from pasien order by id asc";
        try {
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String[] data = {
                    hasil.getString("id"),
                    hasil.getString("nama"),
                    hasil.getString("jk"),
                    hasil.getString("goldar")
                };
                tabPasien.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal load data pasien: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogDokter = new javax.swing.JDialog(this, "Cari Data Dokter", true);
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelDokter = new javax.swing.JTable();
        dialogPasien = new javax.swing.JDialog(this, "Cari Data Pasien", true);
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelPasien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        calTanggal = new com.toedter.calendar.JCalendar();
        jLabel3 = new javax.swing.JLabel();
        tid_dokter = new javax.swing.JTextField();
        bcari_dokter = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tnama_dokter = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tid_pasien = new javax.swing.JTextField();
        bcari_pasien = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tnama_pasien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tgd = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ttb = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tbb = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tdiagnosa = new javax.swing.JTextArea();
        bsave = new javax.swing.JButton();
        bclear = new javax.swing.JButton();
        bexit = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        bcari = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelrekam = new javax.swing.JTable();

        tabelDokter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelDokter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDokterMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelDokter);

        javax.swing.GroupLayout dialogDokterLayout = new javax.swing.GroupLayout(dialogDokter.getContentPane());
        dialogDokter.getContentPane().setLayout(dialogDokterLayout);
        dialogDokterLayout.setHorizontalGroup(
            dialogDokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogDokterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );
        dialogDokterLayout.setVerticalGroup(
            dialogDokterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogDokterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabelPasien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelPasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPasienMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabelPasien);

        javax.swing.GroupLayout dialogPasienLayout = new javax.swing.GroupLayout(dialogPasien.getContentPane());
        dialogPasien.getContentPane().setLayout(dialogPasienLayout);
        dialogPasienLayout.setHorizontalGroup(
            dialogPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogPasienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );
        dialogPasienLayout.setVerticalGroup(
            dialogPasienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogPasienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rekam Medis");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setText("~ Rekam Medis ~");

        jLabel2.setText("Tanggal Pemeriksaan");

        jLabel3.setText("ID Dokter");

        bcari_dokter.setText("Cari");
        bcari_dokter.addActionListener(this::bcari_dokterActionPerformed);

        jLabel4.setText("Nama Dokter");

        tnama_dokter.setEditable(false);

        jLabel5.setText("No. Identitas Pasien");

        bcari_pasien.setText("Cari");
        bcari_pasien.addActionListener(this::bcari_pasienActionPerformed);

        jLabel6.setText("Nama Pasien");

        tnama_pasien.setEditable(false);

        jLabel7.setText("Golongan Darah");

        tgd.setEditable(false);

        jLabel8.setText("Tinggi Badan");

        jLabel9.setText("Berat Badan");

        jLabel10.setText("Diagnosa Dokter");

        tdiagnosa.setColumns(20);
        tdiagnosa.setRows(5);
        jScrollPane1.setViewportView(tdiagnosa);

        bsave.setText("SAVE");
        bsave.addActionListener(this::bsaveActionPerformed);

        bclear.setText("CLEAR");
        bclear.addActionListener(this::bclearActionPerformed);

        bexit.setText("EXIT");
        bexit.addActionListener(this::bexitActionPerformed);

        jLabel11.setText("Cari Data Riwayat Pasien");

        bcari.setText("Cari");
        bcari.addActionListener(this::bcariActionPerformed);

        tabelrekam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tabelrekam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelrekamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelrekam);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(18, 18, 18)
                            .addComponent(tcari)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bcari))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(calTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tid_dokter, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(bcari_dokter))
                                .addComponent(tnama_dokter)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tid_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(bcari_pasien))
                                .addComponent(tnama_pasien)
                                .addComponent(tgd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ttb, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tbb, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 130, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(bsave, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                .addComponent(bclear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bexit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(calTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tid_dokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcari_dokter)
                    .addComponent(bsave))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tnama_dokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bclear))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tid_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcari_pasien)
                    .addComponent(bexit))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tnama_pasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tgd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ttb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcari))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bcari_dokterActionPerformed(java.awt.event.ActionEvent evt) {
        loadTableDokter();
        dialogDokter.setSize(550, 320);
        dialogDokter.setLocationRelativeTo(this);
        dialogDokter.setVisible(true);
    }

    private void bcari_pasienActionPerformed(java.awt.event.ActionEvent evt) {
        loadTablePasien();
        dialogPasien.setSize(550, 320);
        dialogPasien.setLocationRelativeTo(this);
        dialogPasien.setVisible(true);
    }

    private void bsaveActionPerformed(java.awt.event.ActionEvent evt) {
        if (tid_dokter.getText().trim().isEmpty() || tid_pasien.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data dokter dan pasien harus dipilih terlebih dahulu");
            return;
        }

        String sql = "insert into rekam (tgl, id_dok, id_pas, tb, bb, diagnosa) values (?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, getTanggalPeriksa());
            stat.setString(2, tid_dokter.getText().trim());
            stat.setString(3, tid_pasien.getText().trim());
            stat.setInt(4, Integer.parseInt(ttb.getText().trim()));
            stat.setInt(5, Integer.parseInt(tbb.getText().trim()));
            stat.setString(6, tdiagnosa.getText().trim());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            kosong();
            tid_dokter.requestFocus();
            datatable();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tinggi dan berat badan harus berupa angka");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan " + e.getMessage());
        }
    }

    private void bclearActionPerformed(java.awt.event.ActionEvent evt) {
        kosong();
        datatable();
    }

    private void bexitActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {
        Object[] Baris = {"Tanggal Periksa", "ID Dokter", "ID Pasien", "Tinggi Badan", "Berat Badan", "Diagnosa"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelrekam.setModel(tabmode);
        String sql = "select * from rekam where id_pas like ? order by tgl asc";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, "%" + tcari.getText().trim() + "%");
            ResultSet hasil = stat.executeQuery();
            while (hasil.next()) {
                String[] data = {
                    hasil.getString("tgl"),
                    hasil.getString("id_dok"),
                    hasil.getString("id_pas"),
                    hasil.getString("tb"),
                    hasil.getString("bb"),
                    hasil.getString("diagnosa")
                };
                tabmode.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Pencarian data rekam gagal: " + e.getMessage());
        }
    }

    private void tabelrekamMouseClicked(java.awt.event.MouseEvent evt) {
        int bar = tabelrekam.getSelectedRow();
        if (bar < 0) {
            return;
        }

        try {
            java.util.Date tgl = sdf.parse(tabmode.getValueAt(bar, 0).toString());
            calTanggal.setDate(tgl);
        } catch (Exception e) {
        }
        tid_dokter.setText(tabmode.getValueAt(bar, 1).toString());
        tid_pasien.setText(tabmode.getValueAt(bar, 2).toString());
        ttb.setText(tabmode.getValueAt(bar, 3).toString());
        tbb.setText(tabmode.getValueAt(bar, 4).toString());
        tdiagnosa.setText(tabmode.getValueAt(bar, 5).toString());

        String sqlDok = "select * from dokter where id=?";
        String sqlPas = "select * from pasien where id=?";
        try {
            PreparedStatement statDok = conn.prepareStatement(sqlDok);
            statDok.setString(1, tid_dokter.getText().trim());
            ResultSet hasilDok = statDok.executeQuery();
            if (hasilDok.next()) {
                tnama_dokter.setText(hasilDok.getString("nama"));
            }

            PreparedStatement statPas = conn.prepareStatement(sqlPas);
            statPas.setString(1, tid_pasien.getText().trim());
            ResultSet hasilPas = statPas.executeQuery();
            if (hasilPas.next()) {
                tnama_pasien.setText(hasilPas.getString("nama"));
                tgd.setText(hasilPas.getString("goldar"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal membaca detail  " + e.getMessage());
        }
    }

    private void tabelDokterMouseClicked(java.awt.event.MouseEvent evt) {
        int bar = tabelDokter.getSelectedRow();
        if (bar >= 0) {
            tid_dokter.setText(tabDokter.getValueAt(bar, 0).toString());
            tnama_dokter.setText(tabDokter.getValueAt(bar, 1).toString());
            dialogDokter.dispose();
        }
    }

    private void tabelPasienMouseClicked(java.awt.event.MouseEvent evt) {
        int bar = tabelPasien.getSelectedRow();
        if (bar >= 0) {
            tid_pasien.setText(tabPasien.getValueAt(bar, 0).toString());
            tnama_pasien.setText(tabPasien.getValueAt(bar, 1).toString());
            tgd.setText(tabPasien.getValueAt(bar, 3).toString());
            dialogPasien.dispose();
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new Rekam_Medis().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcari;
    private javax.swing.JButton bcari_dokter;
    private javax.swing.JButton bcari_pasien;
    private javax.swing.JButton bclear;
    private javax.swing.JButton bexit;
    private javax.swing.JButton bsave;
    private com.toedter.calendar.JCalendar calTanggal;
    private javax.swing.JDialog dialogDokter;
    private javax.swing.JDialog dialogPasien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tabelDokter;
    private javax.swing.JTable tabelPasien;
    private javax.swing.JTable tabelrekam;
    private javax.swing.JTextArea tdiagnosa;
    private javax.swing.JTextField tbb;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tgd;
    private javax.swing.JTextField tid_dokter;
    private javax.swing.JTextField tid_pasien;
    private javax.swing.JTextField tnama_dokter;
    private javax.swing.JTextField tnama_pasien;
    private javax.swing.JTextField ttb;
    // End of variables declaration//GEN-END:variables
}
