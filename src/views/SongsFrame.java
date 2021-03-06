/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import business.FileSelector;
import controller.SongController;
import data.SongFile;
import business.SongsList;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author erick
 */
public class SongsFrame extends javax.swing.JFrame {

    private SongController controller;
    private JFrame parentFrame;
    
    /**
     * Creates new form SongsFrame
     */
    public SongsFrame(SongsList songsList, JFrame parentFrame) {
        initComponents();
        this.controller = new SongController(songsList);
        this.parentFrame = parentFrame;
        this.refreshList();
    }
    
    public void refreshList() {
        this.songsList.setText(controller.displayList());
    }
    
    private void refreshSearchResults(String results) {
        this.resultsArea.setText(results);
    }
    
    private void showSongFileForm() {
        SongFileForm frame = new SongFileForm(controller, this);
        frame.setVisible(true);
        this.setVisible(false);
    }
    
    private void showCDForm() {
        CDForm frame = new CDForm(controller, this);
        frame.setVisible(true);
        this.setVisible(false);
    }
    
    private void showInvalidIdError() {
        JOptionPane.showMessageDialog(this, 
                "Revisar que el id esté presente y que corresponda al id de un archivo o disco ",
                "Elemento no encontrado.",
                JOptionPane.ERROR_MESSAGE);
    }
    
    private void showInvalidSearchError() {
        JOptionPane.showMessageDialog(this, 
                "El parámetro de búsqueda no puede estar vacío ",
                "No se puede efectuar búsqueda.",
                JOptionPane.ERROR_MESSAGE);
    }
    
    private void showInvalidExportError() {
        JOptionPane.showMessageDialog(this, 
                "No se pudieron exportar las canciones, intente nuevamente.",
                "No se pudo efectuar la exportación.",
                JOptionPane.ERROR_MESSAGE);
    }
    
    private void showSuccessExportMessage() {
        JOptionPane.showMessageDialog(this, 
                "Las canciones se han exportado de manera exitosa.",
                "Se ha creado el archivo.",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        addSongButton = new javax.swing.JButton();
        addCDButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        songIdInput = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        songsList = new javax.swing.JTextArea();
        exportSongsButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultsArea = new javax.swing.JTextArea();
        searchSingerInput = new javax.swing.JTextField();
        searchSingerButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        searchGenreInput = new javax.swing.JTextField();
        searchGenreButton = new javax.swing.JButton();
        importSongsFiles = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Canciones");

        backButton.setText("Volver");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        addSongButton.setText("Agregar Canción");
        addSongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSongButtonActionPerformed(evt);
            }
        });

        addCDButton.setText("Agregar CD");
        addCDButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCDButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Editar por id:");

        editButton.setText("Editar");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        songsList.setEditable(false);
        songsList.setColumns(20);
        songsList.setRows(5);
        songsList.setEnabled(false);
        jScrollPane1.setViewportView(songsList);

        exportSongsButton.setText("Exportar Canciones");
        exportSongsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportSongsButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Buscar por Cantante:");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        resultsArea.setEditable(false);
        resultsArea.setColumns(20);
        resultsArea.setRows(5);
        resultsArea.setEnabled(false);
        jScrollPane2.setViewportView(resultsArea);

        searchSingerButton.setText("Buscar");
        searchSingerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSingerButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Buscar por Género:");

        searchGenreButton.setText("Buscar");
        searchGenreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchGenreButtonActionPerformed(evt);
            }
        });

        importSongsFiles.setText("Importar Canciones");
        importSongsFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importSongsFilesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(songIdInput, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(editButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(addCDButton))
                            .addComponent(exportSongsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(addSongButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(backButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(importSongsFiles)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchGenreInput, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(searchSingerInput, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(searchSingerButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(searchGenreButton)))
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(396, 396, 396))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jSeparator2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchSingerInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchSingerButton)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchGenreInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchGenreButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(songIdInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addCDButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addSongButton)
                                .addGap(15, 15, 15)
                                .addComponent(importSongsFiles)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(exportSongsButton)
                                .addGap(18, 18, 18)
                                .addComponent(backButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.parentFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        String id = this.songIdInput.getText();
        if(!id.isEmpty() && this.controller.selectSongContainer(id)) {
            if(this.controller.getSelectedSongContainer() instanceof SongFile) {
                this.showSongFileForm();
            } else {
                this.showCDForm();
            }
        } else {
            this.showInvalidIdError();
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void addCDButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCDButtonActionPerformed
        showCDForm();
    }//GEN-LAST:event_addCDButtonActionPerformed

    private void addSongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSongButtonActionPerformed
        showSongFileForm();
    }//GEN-LAST:event_addSongButtonActionPerformed

    private void searchSingerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSingerButtonActionPerformed
        String singer = this.searchSingerInput.getText();
        if(!singer.isEmpty()) {
            String results = controller.searchSongsBySinger(singer);
            refreshSearchResults(results);
        } else {
            showInvalidSearchError();
        }
    }//GEN-LAST:event_searchSingerButtonActionPerformed

    private void searchGenreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchGenreButtonActionPerformed
        String genre = this.searchGenreInput.getText();
        if(!genre.isEmpty()) {
            String results = controller.searchSongsByGenre(genre);
            refreshSearchResults(results);
        } else {
            showInvalidSearchError();
        }
    }//GEN-LAST:event_searchGenreButtonActionPerformed

    private void importSongsFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importSongsFilesActionPerformed
        FileSelector selector = new FileSelector();
        File fileSelected = selector.showOpenDialog(SongsFrame.this);
        this.controller.importSongFiles(fileSelected);
        this.refreshList();
    }//GEN-LAST:event_importSongsFilesActionPerformed

    private void exportSongsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportSongsButtonActionPerformed
        FileSelector selector = new FileSelector();
        File fileSelected = selector.showSaveDialog(SongsFrame.this);
        if(this.controller.exportSongs(fileSelected)) {
            this.showSuccessExportMessage();;
        } else {
            this.showInvalidExportError();
        }
    }//GEN-LAST:event_exportSongsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCDButton;
    private javax.swing.JButton addSongButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton exportSongsButton;
    private javax.swing.JButton importSongsFiles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea resultsArea;
    private javax.swing.JButton searchGenreButton;
    private javax.swing.JTextField searchGenreInput;
    private javax.swing.JButton searchSingerButton;
    private javax.swing.JTextField searchSingerInput;
    private javax.swing.JTextField songIdInput;
    private javax.swing.JTextArea songsList;
    // End of variables declaration//GEN-END:variables
}
