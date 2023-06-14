import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class DataMobil extends JFrame {
    private JTextField textFieldMerk, textFieldNomorPlat, textFieldTahun, textFieldHarga;
    private JLabel labelMerk, labelNomorPlat, labelTahun, labelHarga;
    private JButton buttonSubmit, buttonDelete, buttonBack;
    private JTable table;
    private DefaultTableModel model;

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

        // fungsi untuk tombol masukkan data
        buttonSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String merk = textFieldMerk.getText();
                String nomorPlat = textFieldNomorPlat.getText();
                String tahun = textFieldTahun.getText();
                String harga = textFieldHarga.getText();

                // Menambahkan data ke tabel data
                model.addRow(new Object[]{merk, nomorPlat, tahun, harga});

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
                    // fungsi untuk baris yang akan dihapus
                    model.removeRow(row);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DataMobil().setVisible(true);
            }
        });
    }
}
