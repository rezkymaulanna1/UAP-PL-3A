Penjelasan Program
Frame Utama:

JFrame frame = new JFrame("Manajemen Keuangan Pribadi"); Membuat jendela utama dengan judul "Manajemen Keuangan Pribadi."
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); Menutup aplikasi saat jendela ditutup.
Panel Input:

JPanel inputPanel = new JPanel(); Membuat panel untuk menampung komponen input seperti label dan text field.
inputPanel.setLayout(new GridLayout(4, 2, 5, 5)); Mengatur tata letak panel dalam bentuk grid 4 baris dan 2 kolom dengan jarak antar komponen sebesar 5 piksel.
Komponen Input:

JLabel digunakan untuk menampilkan label informasi di samping setiap input.
JTextField memungkinkan pengguna untuk memasukkan teks.
Tabel Data:

DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0); Membuat model tabel dengan kolom "Nama Transaksi," "Jenis," dan "Jumlah."
JTable table = new JTable(tableModel); Membuat tabel dengan model yang sudah didefinisikan.
Tombol Tambah Data:

buttonTambah.addActionListener(...) Menambahkan event listener untuk menangani klik tombol. Ketika tombol ditekan:
Validasi memastikan semua field terisi.
Nilai diambil dari JTextField dan ditambahkan ke tabel jika valid.
Jika Jumlah bukan angka, program menampilkan pesan error.
Misalkan Ada Perubahan Kode
Mengubah GridLayout menjadi FlowLayout:

java
Copy code
inputPanel.setLayout(new FlowLayout());
Perbedaan:

Dengan FlowLayout, semua komponen akan diatur secara horizontal sesuai lebar panel, dan baris baru akan dibuat jika tidak ada cukup ruang. Ini bisa membuat tata letak menjadi tidak terstruktur, terutama jika ada banyak komponen.
Menambahkan Validasi untuk Jenis Transaksi:

java
Copy code
if (!jenis.equalsIgnoreCase("Pemasukan") && !jenis.equalsIgnoreCase("Pengeluaran")) {
    JOptionPane.showMessageDialog(frame, "Jenis harus 'Pemasukan' atau 'Pengeluaran'!", "Peringatan", JOptionPane.WARNING_MESSAGE);
    return;
}
Perbedaan:

Program sekarang memastikan bahwa jenis transaksi hanya dapat berupa "Pemasukan" atau "Pengeluaran." Ini meningkatkan validitas data yang dimasukkan ke tabel.
Mengubah JTable menjadi tidak dapat diedit:

java
Copy code
JTable table = new JTable(tableModel) {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Semua sel tidak dapat diedit
    }
};
Perbedaan:

Data dalam tabel tidak dapat diedit langsung oleh pengguna. Semua perubahan harus dilakukan melalui input field, meningkatkan kontrol terhadap data.
Menambahkan Kolom Tanggal:

java
Copy code
String[] columnNames = {"Nama Transaksi", "Jenis", "Jumlah", "Tanggal"};
Perbedaan:

Menambah kolom "Tanggal" untuk menyimpan tanggal transaksi. Anda juga perlu menambahkan input untuk tanggal dan memasukkan data tersebut ke tabel.
