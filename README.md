Program: Manajemen Keuangan Pribadi
Fungsi Utama:

Memasukkan data transaksi (nama, jenis, jumlah) melalui input field.
Menampilkan data dalam tabel.
Komponen Utama:

Input Panel:
Menggunakan JLabel dan JTextField untuk menerima input.
Tombol Tambah Data untuk memproses input.
Tabel:
JTable untuk menampilkan data transaksi.
Data diatur menggunakan DefaultTableModel.
Validasi:

Semua field harus diisi.
Jumlah harus berupa angka.
Event Tombol:

Menambahkan data ke tabel jika valid.
Menampilkan pesan error jika input tidak sesuai.
Perubahan Contoh:
Menambah Validasi Jenis Transaksi:

java
Copy code
if (!jenis.equalsIgnoreCase("Pemasukan") && !jenis.equalsIgnoreCase("Pengeluaran")) {
    JOptionPane.showMessageDialog(frame, "Jenis harus 'Pemasukan' atau 'Pengeluaran'!");
    return;
}
Efek: Memastikan jenis transaksi valid.

Tabel Tidak Dapat Diedit:

java
Copy code
JTable table = new JTable(tableModel) {
    public boolean isCellEditable(int row, int column) { return false; }
};
Efek: Data hanya bisa diubah melalui input, bukan tabel langsung.

