# TP2DPBO2023
Soal :
- Program bebas, kecuali program Mahasiswa dan Book Author
- Terdapat proses Create, Read, Update, dan Delete data
- Terdapat proses Autentikasi (Login, Register) *
- Menggunakan minimal 2 tabel pada database
- Harus terdapat minimal 1 properti gambar pada class yang dibuat (gambar
akan ditampilkan pada UI)
- Terdapat pergantian screen pada UI
- Terdapat button navigasi untuk beralih screen
- List data ditampilkan menggunakan card (JPanel)

# FORMAT JANJI
Saya Villeneuve Andhira Suwandhi NIM 2108067 mengerjakan Tugas Praktikum 2 DPBO<br/>
dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan.<br/>
Aamiin.<br/>

# DESAIN
![Menu](https://user-images.githubusercontent.com/101118033/232077229-8dca7bd4-5b71-405b-82e0-71cf92a9f16d.png)

# DOKUMENTASI
- Add<br />
![Add](https://user-images.githubusercontent.com/101118033/232077336-16ad023f-7640-4f46-a665-b0ee988bff1b.png)
- Update<br />
![Update](https://user-images.githubusercontent.com/101118033/232077379-fb0badd4-4eea-41f6-94d9-20d9cace80dd.png)
- Delete<br />
![Delete-confirmation](https://user-images.githubusercontent.com/101118033/232077466-2f3340ed-b4a7-4239-beda-f80902806c31.png)
![Delete](https://user-images.githubusercontent.com/101118033/232077419-a7601750-94a7-40aa-ae06-53e8eb81c34b.png)
- Login & Register
![Login](https://user-images.githubusercontent.com/101118033/232077512-4b081982-47ff-4c11-a338-af15866b7f90.png)
![Register](https://user-images.githubusercontent.com/101118033/232077525-cdc4d00c-b919-4e8f-bc58-df13183a7aae.png)

# ALUR
1. Insert:
- Menekan tombol 'add',
- Akan muncul tab baru untuk mengisi data,
- Mengisi data dengan atau tidak dengan gambar,
- Jika sudah selesai, menekan tombol 'add' di bawah untuk menambahkan data,
- Query data INSERT INTO,
- Data berhasil ditambahkan dengan output dialog.

2. Update:
- Pilih salah satu data dan tekan tombol 'update',
- Data akan dipilih dengan id yang dipunyai dalam database,
- Mengubah isi data,
- Setelah itu, akan query update from table 'obat' where 'id',
- Output informasi update berhasil.

3. Delete:
- Pilih salah satu data dan tekan tombol 'delete',
- Data akan dipilih dengan id yang dipunyai dalam database,
- Menghapus semua isi data,
- Setelah itu, akan query Delete from table 'obat' where 'id',
- Sebelum dihapus, ada konfirmasi YES/NO terlebih dahulu,
- Output informasi delete berhasil.
