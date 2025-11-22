/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Kontainer;

/**
 *
 * @author Alif
 */
import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class KontainerMain extends javax.swing.JFrame {

    private EntityManagerFactory emf;
    private EntityManager em;
    private JTabbedPane tabbedPane;
    private JTable tabelPetville;
    private JTable tabelPemilik;

    // Variabel data
    String id_hewan, nama_hewan, jenis_hewan;
    int harga;
    String id_pemilik, nama_pemilik, alamat, no_telepon;

    // Konfigurasi PostgreSQL (khusus untuk laporan Jasper)
    String DB_URL = "jdbc:postgresql://localhost:5432/PBO12Rill";
    String USER = "postgres";
    String PASS = "090406";
    String DRIVER = "org.postgresql.Driver";

    public KontainerMain() {

        initComponents();
        initJPA();

        tabelPetville = jTable1;
        tabelPemilik = jTable2;

        loadDataPetville();
        loadDataPemilik();
    }

    private void initJPA() {
        try {
            emf = Persistence.createEntityManagerFactory("DBPertamaPU");
            em = emf.createEntityManager();
            System.out.println("Koneksi ke PostgreSQL berhasil!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Koneksi ke database gagal: " + e.getMessage());
        }
    }

    private void loadDataPetville() {
        EntityManager em = emf.createEntityManager();
        try {
            List<Petville> listPet = em.createQuery(
                    "SELECT p FROM Petville p ORDER BY p.idHewan", Petville.class
            ).getResultList();

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // hapus semua baris lama

            for (Petville p : listPet) {
                model.addRow(new Object[]{
                    p.getIdHewan(),
                    p.getNamaHewan(),
                    p.getJenisHewan(),
                    p.getHarga(),
                    p.getIdPemilik().getNamaPemilik()
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    private void loadDataPemilik() {

        EntityManager em = emf.createEntityManager();
        try {
            List<Pemilik> list = em.createQuery("SELECT p FROM Pemilik p ORDER BY p.idPemilik", Pemilik.class).getResultList();

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0); // hapus semua baris lama

            for (Pemilik p : list) {

                model.addRow(new Object[]{
                    p.getIdPemilik(),
                    p.getNamaPemilik(),
                    p.getAlamat(),
                    p.getNoTelepon(),});
            }

            jTable2.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal menampilkan data Pemilik: " + e.getMessage());
        } finally {
            em.close();
        }

    }

    public void exportTableToCSV(JTable table, String fileName) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File(fileName));

        int option = fileChooser.showSaveDialog(null);

        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

                TableModel model = table.getModel();
                int colCount = model.getColumnCount();

                // Tulis header
                for (int i = 0; i < colCount; i++) {
                    bw.write(model.getColumnName(i));
                    if (i < colCount - 1) {
                        bw.write(";");
                    }
                }
                bw.newLine();

                // Tulis isi baris
                for (int row = 0; row < model.getRowCount(); row++) {
                    for (int col = 0; col < colCount; col++) {
                        Object value = model.getValueAt(row, col);
                        bw.write(value == null ? "" : value.toString());
                        if (col < colCount - 1) {
                            bw.write(";");
                        }
                    }
                    bw.newLine();
                }

                JOptionPane.showMessageDialog(null,
                        "File CSV berhasil disimpan:\n" + file.getAbsolutePath());

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Gagal menyimpan CSV: " + e.getMessage());
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        InsertButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        UpdateButton1 = new javax.swing.JButton();
        DeleteButton1 = new javax.swing.JButton();
        CetakButton1 = new javax.swing.JButton();
        UploadButton1 = new javax.swing.JButton();
        DownloadButton1 = new javax.swing.JButton();
        DeleteAllButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        InsertButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        DeleteButton2 = new javax.swing.JButton();
        UpdateButton2 = new javax.swing.JButton();
        CetakButton2 = new javax.swing.JButton();
        UploadButton2 = new javax.swing.JButton();
        DownloadButton2 = new javax.swing.JButton();
        DeleteAllButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        InsertButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        InsertButton1.setText("INSERT");
        InsertButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID HEWAN", "NAMA HEWAN", "JENIS HEWAN", "HARGA", "NAMA PEMILIK"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        UpdateButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        UpdateButton1.setText("UPDATE");
        UpdateButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButton1ActionPerformed(evt);
            }
        });

        DeleteButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteButton1.setText("DELETE");
        DeleteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButton1ActionPerformed(evt);
            }
        });

        CetakButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CetakButton1.setText("CETAK");
        CetakButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CetakButton1ActionPerformed(evt);
            }
        });

        UploadButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        UploadButton1.setText("UPLOAD");
        UploadButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadButton1ActionPerformed(evt);
            }
        });

        DownloadButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DownloadButton1.setText("DOWNLOAD");
        DownloadButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DownloadButton1ActionPerformed(evt);
            }
        });

        DeleteAllButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteAllButton.setText("DELETE ALL");
        DeleteAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteAllButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(InsertButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(UpdateButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(DeleteButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(CetakButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(DownloadButton1)
                .addGap(31, 31, 31)
                .addComponent(DeleteAllButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UploadButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CetakButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(InsertButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(UpdateButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DeleteButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DownloadButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UploadButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("DATA HEWAN", jPanel1);

        InsertButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        InsertButton2.setText("INSERT");
        InsertButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertButton2ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID PEMILIK", "NAMA PEMILIK", "ALAMAT", "NO TELEPON"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        DeleteButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteButton2.setText("DELETE");
        DeleteButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButton2ActionPerformed(evt);
            }
        });

        UpdateButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        UpdateButton2.setText("UPDATE");
        UpdateButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButton2ActionPerformed(evt);
            }
        });

        CetakButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CetakButton2.setText("CETAK");
        CetakButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CetakButton2ActionPerformed(evt);
            }
        });

        UploadButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        UploadButton2.setText("UPLOAD");
        UploadButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadButton2ActionPerformed(evt);
            }
        });

        DownloadButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DownloadButton2.setText("DOWNLOAD");
        DownloadButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DownloadButton2ActionPerformed(evt);
            }
        });

        DeleteAllButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteAllButton2.setText("DELETE ALL");
        DeleteAllButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteAllButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(InsertButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(UpdateButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148)
                        .addComponent(DeleteButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(CetakButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(DownloadButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(DeleteAllButton2)
                        .addGap(18, 18, 18)
                        .addComponent(UploadButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InsertButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CetakButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UploadButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DownloadButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteAllButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(156, 156, 156))
        );

        jTabbedPane2.addTab("DATA PEMILIK", jPanel2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PETVILLE");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PERAWATAN DAN PENITIPAN HEWAN");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Jl. Durian, Ds. Keboan Anom, Gedangan, Sidoarjo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(247, 247, 247))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(222, 222, 222))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InsertButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertButton1ActionPerformed
        InsertDialog1 dialog = new InsertDialog1(this, true); // true = modal
        dialog.setLocationRelativeTo(this); // supaya muncul di tengah
        dialog.setVisible(true);

        loadDataPetville();
    }//GEN-LAST:event_InsertButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();

        if (row != -1) { // pastikan baris dipilih
            id_hewan = jTable1.getValueAt(row, 0).toString();
            nama_hewan = jTable1.getValueAt(row, 1).toString();
            jenis_hewan = jTable1.getValueAt(row, 2).toString();

            // Konversi harga ke integer dengan aman
            Object hargaObj = jTable1.getValueAt(row, 3);
            if (hargaObj != null) {
                try {
                    harga = Integer.parseInt(hargaObj.toString());
                } catch (NumberFormatException e) {
                    harga = 0; // fallback
                }
            }

            id_pemilik = jTable1.getValueAt(row, 4).toString();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void UpdateButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButton1ActionPerformed
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            String idHewan = jTable1.getValueAt(row, 0).toString();
            String namaHewan = jTable1.getValueAt(row, 1).toString();
            String jenisHewan = jTable1.getValueAt(row, 2).toString();
            int harga = Integer.parseInt(jTable1.getValueAt(row, 3).toString());
            String idPemilik = jTable1.getValueAt(row, 4).toString();

            UpdateDialog1 dialog = new UpdateDialog1(this, true, idHewan, namaHewan, jenisHewan, harga, idPemilik);
            dialog.setVisible(true);

            loadDataPetville();
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus terlebih dahulu!");
        }
    }//GEN-LAST:event_UpdateButton1ActionPerformed

    private void DeleteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButton1ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            // Ambil data dari JTable
            String id_hewan = jTable1.getValueAt(selectedRow, 0).toString();
            String nama_hewan = jTable1.getValueAt(selectedRow, 1).toString();
            String jenis_hewan = jTable1.getValueAt(selectedRow, 2).toString();
            int harga = Integer.parseInt(jTable1.getValueAt(selectedRow, 3).toString());
            String id_pemilik = jTable1.getValueAt(selectedRow, 4).toString(); // kolom FK id_pemilik

            // Kirim data ke DeleteDialog1 (yang sudah kamu modifikasi)
            DeleteDialog1 dialog = new DeleteDialog1(this, true, id_hewan, nama_hewan, jenis_hewan, harga, id_pemilik);
            dialog.setLocationRelativeTo(this); // supaya muncul di tengah layar
            dialog.setVisible(true);

            // Refresh data tabel setelah hapus
            loadDataPetville();
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diupdate terlebih dahulu!");
        }
    }//GEN-LAST:event_DeleteButton1ActionPerformed

    private void CetakButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CetakButton1ActionPerformed
        JasperReport reports;
        String path = ".\\src\\Kontainer\\petville.jasper";
        try {
            Class.forName(DRIVER);
            java.sql.Connection conn = java.sql.DriverManager.getConnection(DB_URL, USER, PASS);
            reports = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reports, null, conn);
            JasperViewer viewer = new JasperViewer(jprint, false);
            viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            viewer.setVisible(true);
        } catch (ClassNotFoundException | java.sql.SQLException | JRException ex) {
            Logger.getLogger(Petville.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Gagal mencetak laporan: " + ex.getMessage());
        }
    }//GEN-LAST:event_CetakButton1ActionPerformed

    private void InsertButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertButton2ActionPerformed
        InsertDialog2 dialog = new InsertDialog2(this, true); // true = modal
        dialog.setLocationRelativeTo(this); // supaya muncul di tengah
        dialog.setVisible(true);

        loadDataPemilik();
    }//GEN-LAST:event_InsertButton2ActionPerformed

    private void UploadButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadButton1ActionPerformed
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File filePilihan = jfc.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(filePilihan))) {
                String baris;
                String pemisah = ";";

                em.getTransaction().begin();

                while ((baris = br.readLine()) != null) {
                    baris = baris.replace("\uFEFF", "").trim();
                    String[] data = baris.split(pemisah);

                    // Skip header atau baris tidak lengkap
                    if (data.length < 5 || data[0].equalsIgnoreCase("id_hewan")) {
                        continue;
                    }

                    String idHewan = data[0].trim();
                    String namaHewan = data[1].trim();
                    String jenisHewan = data[2].trim();

                    // Cek harga apakah angka
                    int harga;
                    try {
                        harga = Integer.parseInt(data[3].trim());
                    } catch (Exception e) {
                        System.out.println("? Harga bukan angka, baris dilewati: " + data[3]);
                        continue;
                    }

                    String idPemilikStr = data[4].trim();

                    // ===============================
                    //  Auto resolve Pemilik
                    // ===============================
                    Pemilik pemilik = null;

                    // 🔍 Cari berdasarkan ID pemilik (primary key)
                    pemilik = em.find(Pemilik.class, idPemilikStr);

                    // Jika tidak ketemu → coba cari berdasarkan nama (case-insensitive & trim)
                    if (pemilik == null) {
                        try {
                            pemilik = em.createQuery(
                                    "SELECT p FROM Pemilik p "
                                    + "WHERE LOWER(TRIM(p.namaPemilik)) = :nama",
                                    Pemilik.class
                            )
                                    .setParameter("nama", idPemilikStr.toLowerCase().trim())
                                    .getSingleResult();
                        } catch (Exception e) {
                            // Tetap null kalau tidak ditemukan
                        }
                    }

                    // Jika tetap null → skip
                    if (pemilik == null) {
                        System.out.println("? Pemilik tidak ditemukan, dilewati: " + idPemilikStr);
                        continue;
                    }

                    // ===============================
                    //  Buat entitas Petville
                    // ===============================
                    Petville p = new Petville(idHewan);
                    p.setNamaHewan(namaHewan);
                    p.setJenisHewan(jenisHewan);
                    p.setHarga(harga);
                    p.setIdPemilik(pemilik);

                    em.persist(p);
                }

                em.getTransaction().commit();
                JOptionPane.showMessageDialog(this, "Upload selesai!");
                loadDataPetville();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Gagal upload: " + ex.getMessage());
                ex.printStackTrace();
            }
        }


    }//GEN-LAST:event_UploadButton1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int row = jTable2.getSelectedRow();
        if (row != -1) { // pastikan baris dipilih
            // Ambil nilai tiap kolom berdasarkan urutan kolom di JTable
            String id_pemilik = jTable2.getValueAt(row, 0).toString();
            String nama_pemilik = jTable2.getValueAt(row, 1).toString();
            String alamat = "";
            String no_telepon = "";

            // Cek jika alamat tidak null
            Object alamatObj = jTable2.getValueAt(row, 2);
            if (alamatObj != null) {
                alamat = alamatObj.toString();
            }

            // Cek jika no telepon tidak null
            Object telpObj = jTable2.getValueAt(row, 3);
            if (telpObj != null) {
                no_telepon = telpObj.toString();
            }
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void DeleteButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButton2ActionPerformed
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow != -1) {
            // Ambil data dari JTable
            String id_pemilik = jTable2.getValueAt(selectedRow, 0).toString();
            String nama_pemilik = jTable2.getValueAt(selectedRow, 1).toString();
            String alamat = jTable2.getValueAt(selectedRow, 2).toString();
            String no_telepon = jTable2.getValueAt(selectedRow, 3).toString();

            // Kirim data ke DeleteDialog2 (yang sudah kamu modifikasi)
            DeleteDialog2 dialog = new DeleteDialog2(this, true, id_pemilik, nama_pemilik, alamat, no_telepon);
            dialog.setLocationRelativeTo(this); // supaya muncul di tengah layar
            dialog.setVisible(true);

            // Refresh data tabel setelah hapus
            loadDataPemilik();
            loadDataPetville();
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus terlebih dahulu!");
        }
    }//GEN-LAST:event_DeleteButton2ActionPerformed

    private void UpdateButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButton2ActionPerformed
        int row = jTable2.getSelectedRow();
        if (row != -1) {
            String idPemilik = jTable2.getValueAt(row, 0).toString();
            String namaPemilik = jTable2.getValueAt(row, 1).toString();
            String alamat = jTable2.getValueAt(row, 2).toString();
            String noTelepon = jTable2.getValueAt(row, 3).toString();

            UpdateDialog2 dialog = new UpdateDialog2(this, true, idPemilik, namaPemilik, alamat, noTelepon);
            dialog.setVisible(true);

            loadDataPemilik();
            loadDataPetville();
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diupdate terlebih dahulu!");
        }


    }//GEN-LAST:event_UpdateButton2ActionPerformed

    private void CetakButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CetakButton2ActionPerformed
        JasperReport reports;
        String path = ".\\src\\Kontainer\\pemilik.jasper";
        try {
            Class.forName(DRIVER);
            java.sql.Connection conn = java.sql.DriverManager.getConnection(DB_URL, USER, PASS);
            reports = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reports, null, conn);
            JasperViewer viewer = new JasperViewer(jprint, false);
            viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            viewer.setVisible(true);
        } catch (ClassNotFoundException | java.sql.SQLException | JRException ex) {
            Logger.getLogger(Petville.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Gagal mencetak laporan: " + ex.getMessage());
        }
    }//GEN-LAST:event_CetakButton2ActionPerformed

    private void UploadButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadButton2ActionPerformed
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File filePilihan = jfc.getSelectedFile();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBPertamaPU");
            EntityManager em = emf.createEntityManager();

            try (BufferedReader br = new BufferedReader(new FileReader(filePilihan))) {
                String baris;
                String pemisah = ";";

                em.getTransaction().begin();

                while ((baris = br.readLine()) != null) {
                    // Hilangkan karakter BOM dan spasi
                    baris = baris.replace("\uFEFF", "").trim();
                    String[] data = baris.split(pemisah);

                    // Lewati header dan baris tidak lengkap
                    if (data.length < 4 || data[0].equalsIgnoreCase("id_pemilik")) {
                        continue;
                    }

                    // Ambil data dari CSV
                    String idPemilik = data[0].trim();
                    String namaPemilik = data[1].trim();
                    String alamat = data[2].trim();
                    String noTelepon = data[3].trim();

                    // Cek apakah data dengan ID ini sudah ada
                    Pemilik existing = em.find(Pemilik.class, idPemilik);
                    if (existing == null) {
                        // Buat objek baru
                        Pemilik p = new Pemilik(idPemilik);
                        p.setNamaPemilik(namaPemilik);
                        p.setAlamat(alamat);
                        p.setNoTelepon(noTelepon);

                        em.persist(p);
                    } else {
                        // Jika sudah ada, update data-nya
                        existing.setNamaPemilik(namaPemilik);
                        existing.setAlamat(alamat);
                        existing.setNoTelepon(noTelepon);
                        em.merge(existing);
                    }
                }

                em.getTransaction().commit();
                JOptionPane.showMessageDialog(this, "Upload data Pemilik selesai!");

                // Refresh tabel setelah upload
                loadDataPemilik(); // pastikan kamu punya method ini untuk refresh JTable

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Gagal upload: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                em.close();
                emf.close();
            }
        }
    }//GEN-LAST:event_UploadButton2ActionPerformed

    private void DownloadButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DownloadButton1ActionPerformed
        exportTableToCSV(jTable1, "data_hewan.csv");
    }//GEN-LAST:event_DownloadButton1ActionPerformed

    private void DeleteAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteAllButtonActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this,
                "Yakin ingin menghapus SEMUA data akun (tabel Hewan)?",
                "Konfirmasi Hapus Semua",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBPertamaPU");
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            // Ambil semua data dari Entity Pw
            List<Petville> data = em.createQuery("SELECT p FROM Petville p", Petville.class).getResultList();

            // Hapus satu per satu
            for (Petville item : data) {
                em.remove(em.contains(item) ? item : em.merge(item));
            }

            em.getTransaction().commit();

            // Jika kamu punya fungsi refresh tabel, panggil di sini:
            // showTable();
            JOptionPane.showMessageDialog(this, "Semua data tabel Petville berhasil dihapus!");

            loadDataPetville();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal menghapus data PW!");

        } finally {
            em.close();
            emf.close();
        }

    }//GEN-LAST:event_DeleteAllButtonActionPerformed

    private void DownloadButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DownloadButton2ActionPerformed
        exportTableToCSV(jTable2, "data_pemilik.csv");
    }//GEN-LAST:event_DownloadButton2ActionPerformed

    private void DeleteAllButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteAllButton2ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this,
                "Yakin ingin menghapus SEMUA data akun (tabel Pemilik)?",
                "Konfirmasi Hapus Semua",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBPertamaPU");
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            // Ambil semua data dari Entity Pw
            List<Pemilik> data = em.createQuery("SELECT p FROM Pemilik p", Pemilik.class).getResultList();

            // Hapus satu per satu
            for (Pemilik item : data) {
                em.remove(em.contains(item) ? item : em.merge(item));
            }

            em.getTransaction().commit();

            // Jika kamu punya fungsi refresh tabel, panggil di sini:
            // showTable();
            JOptionPane.showMessageDialog(this, "Semua data tabel Pemilik berhasil dihapus!");

            loadDataPemilik();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal menghapus data PW!");

        } finally {
            em.close();
            emf.close();
        }
    }//GEN-LAST:event_DeleteAllButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KontainerMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KontainerMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KontainerMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KontainerMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KontainerMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CetakButton1;
    private javax.swing.JButton CetakButton2;
    private javax.swing.JButton DeleteAllButton;
    private javax.swing.JButton DeleteAllButton2;
    private javax.swing.JButton DeleteButton1;
    private javax.swing.JButton DeleteButton2;
    private javax.swing.JButton DownloadButton1;
    private javax.swing.JButton DownloadButton2;
    private javax.swing.JButton InsertButton1;
    private javax.swing.JButton InsertButton2;
    private javax.swing.JButton UpdateButton1;
    private javax.swing.JButton UpdateButton2;
    private javax.swing.JButton UploadButton1;
    private javax.swing.JButton UploadButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
