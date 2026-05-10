package com.tpv.tugas.gymme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import koneksi.koneksi;

/**
 * Form Login terhubung database tabel admin
 */
public class Login extends JFrame implements ActionListener {

    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField tuser;
    private JPasswordField tpass;
    private JButton blog;
    private JButton bcan;
    private Connection conn;

    public Login() {
        initComponents();
        conn = new koneksi().connect();
        if (conn == null) {
            JOptionPane.showMessageDialog(this,
                "Koneksi ke database gagal.\nPeriksa XAMPP/MySQL dan konfigurasi koneksi.",
                "Error Database",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        lblUsername = new JLabel("Username");
        lblPassword = new JLabel("Password");
        tuser = new JTextField(15);
        tpass = new JPasswordField(15);
        blog  = new JButton("Login");
        bcan  = new JButton("Cancel");

        blog.addActionListener(this);
        bcan.addActionListener(this);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);

        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        add(lblUsername, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        add(tuser, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.EAST;
        add(lblPassword, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        add(tpass, gbc);

        JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelBtn.add(blog);
        panelBtn.add(bcan);
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(panelBtn, gbc);

        setTitle("Form Login - Sistem Informasi Klinik");
        setSize(320, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == blog) {
            String username = tuser.getText().trim();
            String password = new String(tpass.getPassword()).trim();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Username dan Password harus diisi!",
                    "Validasi Login",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (conn == null) {
                JOptionPane.showMessageDialog(this,
                    "Koneksi database belum tersedia.",
                    "Error Database",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql = "select * from admin where username=? and password=?";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, username);
                stat.setString(2, password);
                ResultSet hasil = stat.executeQuery();

                if (hasil.next()) {
                    String nama = hasil.getString("nama_lengkap");
                    JOptionPane.showMessageDialog(this,
                        "Login Berhasil! Selamat Datang, " + nama + "!",
                        "Informasi",
                        JOptionPane.INFORMATION_MESSAGE);

                    this.dispose();
                    Menu_Utama menuUtama = new Menu_Utama(nama);
                    menuUtama.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this,
                        "Username atau Password salah!",
                        "Error Login",
                        JOptionPane.ERROR_MESSAGE);
                    tuser.setText("");
                    tpass.setText("");
                    tuser.requestFocus();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,
                    "Login gagal: " + ex.getMessage(),
                    "Error Database",
                    JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == bcan) {
            tuser.setText("");
            tpass.setText("");
            tuser.requestFocus();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}
