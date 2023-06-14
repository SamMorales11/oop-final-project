import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class DataPengembalian extends JFrame {
    private JTextField textFieldNama, textFieldNomorPlat, textFieldLamaPeminjaman, textFieldTanggalPeminjaman, textFieldTanggalPengembalian, textFieldHarga;
    private JLabel labelNama, labelNomorPlat, labelLamaPeminjaman, labelTanggalPeminjaman, labelTanggalPengembalian, labelHarga;
    private JButton buttonSubmit, buttonDelete, buttonBack;
    private JTable table;
    private DefaultTableModel model;

    public DataPengembalian() {
        setTitle("Data Pengembalian");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // membuat judul untuk kolom input
        labelNama = new JLabel("Nama Peminjam");
        labelNomorPlat = new JLabel("Nomor Plat");
        labelLamaPeminjaman = new JLabel("Lama Peminjaman (hari)");
        labelTanggalPeminjaman = new JLabel("Tanggal Peminjaman");
        labelTanggalPengembalian = new JLabel("Tanggal Pengembalian");
        labelHarga = new JLabel("Harga");

        // membuat textfield
        textFieldNama = new JTextField(10);
        textFieldNomorPlat = new JTextField(10);
        textFieldLamaPeminjaman = new JTextField(10);
        textFieldTanggalPeminjaman = new JTextField(10);
        textFieldTanggalPengembalian = new JTextField(10);
        textFieldHarga = new JTextField(10);

        // membuat button
        buttonSubmit = new JButton("Masukkan Data");
        buttonDelete = new JButton("Hapus");
        buttonBack = new JButton("Kembali");

        // membuat tabel data
        model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("Nama Peminjam");
        model.addColumn("Nomor Plat");
        model.addColumn("Lama Peminjaman");
        model.addColumn("Tanggal Peminjaman");
        model.addColumn("Tanggal Pengembalian");
        model.addColumn("Harga");

        
        add(labelNama);
        add(textFieldNama);
        add(labelNomorPlat);
        add(textFieldNomorPlat);
        add(labelLamaPeminjaman);
        add(textFieldLamaPeminjaman);
        add(labelTanggalPeminjaman);
        add(textFieldTanggalPeminjaman);
        add(labelTanggalPengembalian);
        add(textFieldTanggalPengembalian);
        add(labelHarga);
        add(textFieldHarga);
        add(buttonSubmit);
        add(buttonDelete);
        add(buttonBack);
        add(new JScrollPane(table));

        // fungsi tombol masukkan data
        buttonSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String nomorPlat = textFieldNomorPlat.getText();
                String lamaPeminjaman = textFieldLamaPeminjaman.getText();
                String tanggalPeminjaman = textFieldTanggalPeminjaman.getText();
                String tanggalPengembalian = textFieldTanggalPengembalian.getText();
                String harga = textFieldHarga.getText();

                // menambahkan data ke tabel data
                model.addRow(new Object[]{nama, nomorPlat, lamaPeminjaman, tanggalPeminjaman, tanggalPengembalian, harga});

                // membersihkan kolom input data setelah data ditambahkan
                textFieldNama.setText("");
                textFieldNomorPlat.setText("");
                textFieldLamaPeminjaman.setText("");
                textFieldTanggalPeminjaman.setText("");
                textFieldTanggalPengembalian.setText("");
                textFieldHarga.setText("");
            }
        });

        // fungis tombol hapus
        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    // hapus baris yang dipilih
                    model.removeRow(row);
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus.");
                }
            }
        });

        // fungsi tobol kembali
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // tutup window DataPengembalian lalu kembali ke MainMenu
                dispose();
                new MainMenu().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DataPengembalian().setVisible(true);
            }
        });
    }
}
