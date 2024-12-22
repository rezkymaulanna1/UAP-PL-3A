import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManajemenKeuangan {
    public static void main(String[] args) {
        // Frame Utama
        JFrame frame = new JFrame("Manajemen Keuangan Pribadi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Panel untuk Input Data
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 5, 5));

        // Komponen Input
        JLabel labelNama = new JLabel("Nama Transaksi:");
        JTextField fieldNama = new JTextField();

        JLabel labelJenis = new JLabel("Jenis (Pemasukan/Pengeluaran):");
        JTextField fieldJenis = new JTextField();

        JLabel labelJumlah = new JLabel("Jumlah:");
        JTextField fieldJumlah = new JTextField();

        JButton buttonTambah = new JButton("Tambah Data");

        inputPanel.add(labelNama);
        inputPanel.add(fieldNama);
        inputPanel.add(labelJenis);
        inputPanel.add(fieldJenis);
        inputPanel.add(labelJumlah);
        inputPanel.add(fieldJumlah);
        inputPanel.add(new JLabel());
        inputPanel.add(buttonTambah);

        // Tabel untuk Menampilkan Data
        String[] columnNames = {"Nama Transaksi", "Jenis", "Jumlah"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Event Listener untuk Tombol Tambah
        buttonTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = fieldNama.getText().trim();
                String jenis = fieldJenis.getText().trim();
                String jumlah = fieldJumlah.getText().trim();

                if (nama.isEmpty() || jenis.isEmpty() || jumlah.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Semua field harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        double jumlahParsed = Double.parseDouble(jumlah);
                        tableModel.addRow(new Object[]{nama, jenis, jumlahParsed});
                        fieldNama.setText("");
                        fieldJenis.setText("");
                        fieldJumlah.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Jumlah harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Menambahkan Komponen ke Frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Menampilkan Frame
        frame.setVisible(true);
    }
}
