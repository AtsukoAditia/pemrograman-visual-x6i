package com.tpv.tugas.gymme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Form Login Sederhana
 * Materi: Pemrograman Visual - Event actionListener
 * 
 * Komponen:
 * - JLabel     : label Username dan Password
 * - JTextField : input Username (tuser)
 * - JPasswordField : input Password (tpass)
 * - JButton    : tombol Login (blog) dan Cancel (bcan)
 */
public class Login extends JFrame implements ActionListener {

    // Deklarasi komponen
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField tuser;        // variabel textfield username
    private JPasswordField tpass;    // variabel passwordfield
    private JButton blog;            // variabel button login
    private JButton bcan;            // variabel button cancel

    public Login() {
        initComponents();
    }

    private void initComponents() {
        // Inisialisasi komponen
        lblUsername = new JLabel("Username");
        lblPassword = new JLabel("Password");
        tuser = new JTextField(15);
        tpass = new JPasswordField(15);
        blog  = new JButton("Login");
        bcan  = new JButton("Cancel");

        // Tambahkan ActionListener pada tombol
        blog.addActionListener(this);
        bcan.addActionListener(this);

        // Layout form menggunakan GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);

        // Baris 1: Label Username
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        add(lblUsername, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        add(tuser, gbc);

        // Baris 2: Label Password
        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.EAST;
        add(lblPassword, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        add(tpass, gbc);

        // Baris 3: Tombol Login dan Cancel
        JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelBtn.add(blog);
        panelBtn.add(bcan);
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(panelBtn, gbc);

        // Pengaturan JFrame
        setTitle("Form Login");
        setSize(320, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // tampil di tengah layar
        setResizable(false);
    }

    /**
     * Event actionPerformed - dipanggil saat tombol diklik
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // Event tombol LOGIN
        if (e.getSource() == blog) {
            String username = tuser.getText();
            String password = new String(tpass.getPassword());

            // Validasi login sederhana
            if (username.equals("admin") && password.equals("1234")) {
                JOptionPane.showMessageDialog(this,
                    "Login Berhasil!",
                    "Informasi",
                    JOptionPane.INFORMATION_MESSAGE);
                // TODO: buka form utama setelah login berhasil
            } else {
                JOptionPane.showMessageDialog(this,
                    "Username atau Password salah!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                tuser.setText("");
                tpass.setText("");
                tuser.requestFocus();
            }
        }

        // Event tombol CANCEL
        if (e.getSource() == bcan) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}
