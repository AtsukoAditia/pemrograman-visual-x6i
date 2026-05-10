package com.tpv.tugas.gymme;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Class bg2 - Custom JPanel dengan Background Gambar
 * Materi: Pemrograman Visual - Event actionListener
 * 
 * Cara penggunaan:
 * 1. Letakkan file gambar (misal: images.jpg) di dalam folder src/gambar/
 * 2. Tarik class bg2 ke dalam form Login di NetBeans Designer
 * 3. Atur ukuran panel bg2 sesuai ukuran form
 */
public class bg2 extends JPanel {

    private Image image;

    public bg2() {
        // Muat gambar dari folder gambar di dalam src
        image = new ImageIcon(getClass().getResource("/gambar/images.jpg")).getImage();
    }

    /**
     * Override paintComponent untuk menggambar background gambar
     * @param grphcs objek Graphics dari JPanel
     */
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D gd = (Graphics2D) grphcs.create();
        // Gambar image memenuhi seluruh luas panel
        gd.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        gd.dispose();
    }
}
