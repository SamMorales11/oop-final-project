import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private JButton buttonDataMobil;
    private JButton buttonDataPeminjaman;
    private JButton buttonDataPengembalian;
    private JButton buttonKeluar;

    public MainMenu() {
        setTitle("Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        buttonDataMobil = new JButton("Data Mobil");
        buttonDataPeminjaman = new JButton("Pendataan Peminjaman");
        buttonDataPengembalian = new JButton("Pendataan Pengembalian Mobil");
        buttonKeluar = new JButton("Keluar");

        panel.add(buttonDataMobil);
        panel.add(buttonDataPeminjaman);
        panel.add(buttonDataPengembalian);
        panel.add(buttonKeluar);

        buttonDataMobil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataMobil dataMobil = new DataMobil();
                dataMobil.setVisible(true);
            }
        });

        buttonDataPeminjaman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataPeminjaman dataPeminjaman = new DataPeminjaman();
                dataPeminjaman.setVisible(true);
            }
        });

        buttonDataPengembalian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataPengembalian dataPengembalian = new DataPengembalian();
                dataPengembalian.setVisible(true);
            }
        });

        // Button Keluar
        buttonKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logika untuk aksi saat tombol "Keluar" ditekan
                // Misalnya, tampilkan dialog konfirmasi dan tutup program jika dikonfirmasi
                dispose();
            }
        });

        add(panel);
    }
}

