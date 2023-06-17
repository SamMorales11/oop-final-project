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

public class DataMobil extends JFrame {
    private JTextField textFieldMerk, textFieldNomorPlat, textFieldTahun, textFieldHarga;
    private JLabel labelMerk, labelNomorPlat, labelTahun, labelHarga;
    private JButton buttonSubmit, buttonDelete, buttonBack;
    private JTable table;
    private DefaultTableModel model;
    private String dataFilePath;

    public DataMobil() {
        setTitle("Data Mobil");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Membuat judul untuk kolom input
        labelMerk = new JLabel("Merk Mobil");
        labelNomorPlat = new JLabel("Nomor Plat");
        labelTahun = new JLabel("Tahun");
        labelHarga = new JLabel("Harga");

        // Membuat textfield
        textFieldMerk = new JTextField(10);
        textFieldNomorPlat = new JTextField(10);
        textFieldTahun = new JTextField(10);
        textFieldHarga = new JTextField(10);

        // Membuat button
        buttonSubmit = new JButton("Masukkan Data");
        buttonDelete = new JButton("Hapus");
        buttonBack = new JButton("Kembali");

        // Membuat tabel data
        model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("Merk Mobil");
        model.addColumn("Nomor Plat Mobil");
        model.addColumn("Tahun");
        model.addColumn("Harga");

        add(labelMerk);
        add(textFieldMerk);
        add(labelNomorPlat);
        add(textFieldNomorPlat);
        add(labelTahun);
        add(textFieldTahun);
        add(labelHarga);
        add(textFieldHarga);
        add(buttonSubmit);
        add(buttonDelete);
        add(buttonBack);
        add(new JScrollPane(table));

        // Path data file
        dataFilePath = "data_mobil.txt";

        // Memuat ulang data yg tersimpan
        loadSavedData();

        // fungsi untuk tombol masukkan data
        buttonSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String merk = textFieldMerk.getText();
                String nomorPlat = textFieldNomorPlat.getText();
                String tahun = textFieldTahun.getText();
                String harga = textFieldHarga.getText();

                // Menambahkan data ke tabel data
                model.addRow(new Object[]{merk, nomorPlat, tahun, harga});

                saveDataToFile(merk, nomorPlat, tahun, harga);

                // Membersihkan kolom teks setelah data ditambahkan
                textFieldMerk.setText("");
                textFieldNomorPlat.setText("");
                textFieldTahun.setText("");
                textFieldHarga.setText("");
            }
        });

        // fungsi untuk tombol hapus
        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    // Menghapus data dari tabel
                    model.removeRow(row);

                    saveDataToTextFile();
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih baris data yang ingin dihapus.");
                }
            }
        });

        // fungsi untuk tombol kembali
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // tutup window DataMobil lalu kembali ke MainMenu
                dispose();
                new MainMenu().setVisible(true);
            }
        });
    }

    // simpan data
    private void saveDataToFile(String merk, String nomorPlat, String tahun, String harga) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFilePath, true))) {
            String data = merk + "," + nomorPlat + "," + tahun + "," + harga;
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
                String merk = model.getValueAt(i, 0).toString();
                String nomorPlat = model.getValueAt(i, 1).toString();
                String tahun = model.getValueAt(i, 2).toString();
                String harga = model.getValueAt(i, 3).toString();

                String data = merk + "," + nomorPlat + "," + tahun + "," + harga;
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
                model.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DataMobil().setVisible(true);
            }
        });
    }
}
