import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.io.*;

public class DataPengembalian {
    private User user;
    private JTextField textFieldNama, textFieldNomorPlat, textFieldLamaPeminjaman, textFieldTanggalPeminjaman, textFieldTanggalPengembalian, textFieldHarga;
    private JLabel labelNama, labelNomorPlat, labelLamaPeminjaman, labelTanggalPeminjaman, labelTanggalPengembalian, labelHarga;
    private JButton buttonSubmit, buttonDelete, buttonBack;
    private JTable table;
    private DefaultTableModel model;

    public DataPengembalian(User user) {
        this.user = user;
        JFrame frame = new JFrame();
        frame.setTitle("Data Pengembalian");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Membuat judul untuk kolom input
        labelNama = new JLabel("Nama Peminjam");
        labelNomorPlat = new JLabel("Nomor Plat");
        labelLamaPeminjaman = new JLabel("Lama Peminjaman (hari)");
        labelTanggalPeminjaman = new JLabel("Tanggal Peminjaman");
        labelTanggalPengembalian = new JLabel("Tanggal Pengembalian");
        labelHarga = new JLabel("Harga");

        // Membuat textfield
        textFieldNama = new JTextField(10);
        textFieldNomorPlat = new JTextField(10);
        textFieldLamaPeminjaman = new JTextField(10);
        textFieldTanggalPeminjaman = new JTextField(10);
        textFieldTanggalPengembalian = new JTextField(10);
        textFieldHarga = new JTextField(10);

        // Membuat button
        buttonSubmit = new JButton("Masukkan Data");
        buttonDelete = new JButton("Hapus");
        buttonBack = new JButton("Kembali");

        // Membuat tabel
        model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("Nama Peminjam");
        model.addColumn("Nomor Plat");
        model.addColumn("Lama Peminjaman");
        model.addColumn("Tanggal Peminjaman");
        model.addColumn("Tanggal Pengembalian");
        model.addColumn("Harga");

       
        frame.add(labelNama);
        frame.add(textFieldNama);
        frame.add(labelNomorPlat);
        frame.add(textFieldNomorPlat);
        frame.add(labelLamaPeminjaman);
        frame.add(textFieldLamaPeminjaman);
        frame.add(labelTanggalPeminjaman);
        frame.add(textFieldTanggalPeminjaman);
        frame.add(labelTanggalPengembalian);
        frame.add(textFieldTanggalPengembalian);
        frame.add(labelHarga);
        frame.add(textFieldHarga);
        frame.add(buttonSubmit);
        frame.add(buttonDelete);
        frame.add(buttonBack);
        frame.add(new JScrollPane(table));

        // fungsi tombol masukkan data
        buttonSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String nomorPlat = textFieldNomorPlat.getText();
                String lamaPeminjaman = textFieldLamaPeminjaman.getText();
                String tanggalPeminjaman = textFieldTanggalPeminjaman.getText();
                String tanggalPengembalian = textFieldTanggalPengembalian.getText();
                String harga = textFieldHarga.getText();

                // masukkan data ke tabel
                model.addRow(new Object[]{nama, nomorPlat, lamaPeminjaman, tanggalPeminjaman, tanggalPengembalian, harga});

                
                simpanDataKeFile(nama, nomorPlat, lamaPeminjaman, tanggalPeminjaman, tanggalPengembalian, harga);

                // kosongkan kolom input setelah data masuk tabel
                textFieldNama.setText("");
                textFieldNomorPlat.setText("");
                textFieldLamaPeminjaman.setText("");
                textFieldTanggalPeminjaman.setText("");
                textFieldTanggalPengembalian.setText("");
                textFieldHarga.setText("");
            }
        });

        // fungsi tombol hapus
        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    // Menghapus baris yang dipilih dari tabel
                    model.removeRow(row);
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus.");
                }
            }
        });

        // fungsi tombol kembali
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Menutup jendela DataPengembalian dan kembali ke MainMenu
                frame.dispose();
                new MainMenu().setVisible(true);
            }
        });

        frame.setVisible(true);
    }

    private void simpanDataKeFile(String nama, String nomorPlat, String lamaPeminjaman, String tanggalPeminjaman, String tanggalPengembalian, String harga) {
        try {
            FileWriter writer = new FileWriter("data_pengembalian.txt", true); // Menulis ke file dengan mode append (menambahkan ke data yang sudah ada)
            writer.write(nama + "," + nomorPlat + "," + lamaPeminjaman + "," + tanggalPeminjaman + "," + tanggalPengembalian + "," + harga + "\n");
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void bacaDataDariFile() {
        try {
            File file = new File("data_pengembalian.txt");
            if (file.exists()) {
                FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] data = line.split(",");
                    model.addRow(data);
                }

                bufferedReader.close();
                reader.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DataPengembalian dataPengembalian = new DataPengembalian(null);
                dataPengembalian.bacaDataDariFile();
                dataPengembalian.setVisible(true);
            }
        });
    }

    protected void setVisible(boolean b) {
    }
}
