import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

public class DataPeminjaman extends JFrame {
    private JTextField textFieldNama, textFieldNoTelepon, textFieldEmail, textFieldAlamat, textFieldNomorPlat, textFieldLamaPeminjaman, textFieldTanggalPeminjaman, textFieldHarga;
    private JLabel labelNama, labelNoTelepon, labelEmail, labelAlamat, labelNomorPlat, labelLamaPeminjaman, labelTanggalPeminjaman, labelHarga;
    private JButton buttonSubmit, buttonDelete, buttonBack;
    private JTable table;
    private DefaultTableModel model;
    private String dataFilePath;

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

        // path data file
        dataFilePath = "data_peminjaman.txt";

        // Muat data
        loadSavedData();

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

                // simpan data ke file teks
                saveDataToFile(nama, noTelepon, email, alamat, nomorPlat, lamaPeminjaman, tanggalPeminjaman, harga);

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

                    // simpan data ulang ke file teks setelah data dihapus
                    saveDataToTextFile();
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih baris data yang ingin dihapus.");
                }
            }
        });

        // fungsi untuk tombol kembali
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // tutup window DataPeminjaman lalu kembali ke MainMenu
                dispose();
                new MainMenu().setVisible(true);
            }
        });
    }

    // simpan data
    private void saveDataToFile(String nama, String noTelepon, String email, String alamat, String nomorPlat, String lamaPeminjaman, String tanggalPeminjaman, String harga) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFilePath, true))) {
            String data = nama + "," + noTelepon + "," + email + "," + alamat + "," + nomorPlat + "," + lamaPeminjaman + "," + tanggalPeminjaman + "," + harga;
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveDataToTextFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFilePath))) {
            int rowCount = model.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                String nama = model.getValueAt(i, 0).toString();
                String noTelepon = model.getValueAt(i, 1).toString();
                String email = model.getValueAt(i, 2).toString();
                String alamat = model.getValueAt(i, 3).toString();
                String nomorPlat = model.getValueAt(i, 4).toString();
                String lamaPeminjaman = model.getValueAt(i, 5).toString();
                String tanggalPeminjaman = model.getValueAt(i, 6).toString();
                String harga = model.getValueAt(i, 7).toString();
                String data = nama + "," + noTelepon + "," + email + "," + alamat + "," + nomorPlat + "," + lamaPeminjaman + "," + tanggalPeminjaman + "," + harga;
                writer.write(data);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // muat data
    private void loadSavedData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 8) {
                    model.addRow(new Object[]{data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DataPeminjaman().setVisible(true);
            }
        });
    }
}
