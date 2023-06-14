import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class DataPeminjaman extends JFrame {
    private JTextField textFieldNama, textFieldNoTelepon, textFieldEmail, textFieldAlamat, textFieldNomorPlat, textFieldLamaPeminjaman, textFieldTanggalPeminjaman, textFieldHarga;
    private JLabel labelNama, labelNoTelepon, labelEmail, labelAlamat, labelNomorPlat, labelLamaPeminjaman, labelTanggalPeminjaman, labelHarga;
    private JButton buttonSubmit, buttonDelete, buttonBack;
    private JTable table;
    private DefaultTableModel model;

    public DataPeminjaman() {
        setTitle("Data Peminjaman");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // membuat judul untuk kolom input
        labelNama = new JLabel("Nama Peminjam");
        labelNoTelepon = new JLabel("No. Telepon");
        labelEmail = new JLabel("Email");
        labelAlamat = new JLabel("Alamat");
        labelNomorPlat = new JLabel("Nomor Plat");
        labelLamaPeminjaman = new JLabel("Lama Peminjaman (dalam hari)");
        labelTanggalPeminjaman = new JLabel("Tanggal Peminjaman");
        labelHarga = new JLabel("Harga");

        // membuat textfield
        textFieldNama = new JTextField(10);
        textFieldNoTelepon = new JTextField(10);
        textFieldEmail = new JTextField(10);
        textFieldAlamat = new JTextField(10);
        textFieldNomorPlat = new JTextField(10);
        textFieldLamaPeminjaman = new JTextField(10);
        textFieldTanggalPeminjaman = new JTextField(10);
        textFieldHarga = new JTextField(10);

        // membuat button
        buttonSubmit = new JButton("Masukkan Data");
        buttonDelete = new JButton("Hapus");
        buttonBack = new JButton("Kembali");

        // membuat tabel data
        model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("Nama Peminjam");
        model.addColumn("No. Telepon");
        model.addColumn("Email");
        model.addColumn("Alamat");
        model.addColumn("Nomor Plat");
        model.addColumn("Lama Peminjaman");
        model.addColumn("Tanggal Peminjaman");
        model.addColumn("Harga");

       
        add(labelNama);
        add(textFieldNama);
        add(labelNoTelepon);
        add(textFieldNoTelepon);
        add(labelEmail);
        add(textFieldEmail);
        add(labelAlamat);
        add(textFieldAlamat);
        add(labelNomorPlat);
        add(textFieldNomorPlat);
        add(labelLamaPeminjaman);
        add(textFieldLamaPeminjaman);
        add(labelTanggalPeminjaman);
        add(textFieldTanggalPeminjaman);
        add(labelHarga);
        add(textFieldHarga);
        add(buttonSubmit);
        add(buttonDelete);
        add(buttonBack);
        add(new JScrollPane(table));

        // fungsi untuk tombol masukkan data
        buttonSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String noTelepon = textFieldNoTelepon.getText();
                String email = textFieldEmail.getText();
                String alamat = textFieldAlamat.getText();
                String nomorPlat = textFieldNomorPlat.getText();
                String lamaPeminjaman = textFieldLamaPeminjaman.getText();
                String tanggalPeminjaman = textFieldTanggalPeminjaman.getText();
                String harga = textFieldHarga.getText();

                // tambah data ke tabel
                model.addRow(new Object[]{nama, noTelepon, email, alamat, nomorPlat, lamaPeminjaman, tanggalPeminjaman, harga});

                // membersihkan kolom teks setelah data ditambahkan
                textFieldNama.setText("");
                textFieldNoTelepon.setText("");
                textFieldEmail.setText("");
                textFieldAlamat.setText("");
                textFieldNomorPlat.setText("");
                textFieldLamaPeminjaman.setText("");
                textFieldTanggalPeminjaman.setText("");
                textFieldHarga.setText("");
            }
        });

        // fungsi untuk tombol hapus
        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    // hapus baris yang dipilih
                    model.removeRow(row);
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih baris data yang ingin dihapus.");
                }
            }
        });

        // fungsi untuk tombol kembali
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // tutup window  DataPeminjaman lalu kembali ke MainMenu
                dispose();
                new MainMenu().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DataPeminjaman().setVisible(true);
            }
        });
    }
}
