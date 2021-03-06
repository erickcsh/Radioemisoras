/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.ShowController;
import data.Broadcaster;
import data.Show;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;

/**
 *
 * @author erick
 */
public class ShowForm extends javax.swing.JFrame {
    
    private ShowController controller;
    private ShowsFrame parentFrame;

    /**
     * Creates new form ShowForm
     */    
    public ShowForm(ShowController controller, ShowsFrame parentFrame) {
        initComponents();
        this.controller = controller;
        createComboBoxBroadcasters();
        this.parentFrame = parentFrame;
        if(this.controller.getSelectedShow() != null) {
            this.setShowInfo();
        }
    }
    
    private void newAction() {
        if(broadcasterCombo.getSelectedItem() != null && this.controller.newShow(nameInput.getText(),
                durationInput.getText(), scheduleInput.getText(), musicalGenreInput.getText(), broadcasterCombo.getSelectedItem())) {
            this.successSaveReturnToParent();
        } else {
            this.showInvalidSaveError();
        }
    }
    
    private void editAction() {
        if(this.controller.editShow(nameInput.getText(), durationInput.getText(), scheduleInput.getText(),
                musicalGenreInput.getText(), broadcasterCombo.getSelectedItem())) {
            this.successSaveReturnToParent();
        } else {
            this.showInvalidSaveError();
        }
    }
    
    private void successSaveReturnToParent() {
        this.controller.cleanSelectedShow();
        this.parentFrame.setVisible(true);
        this.parentFrame.refreshList();
        this.dispose();
    }
    
    private void showInvalidSaveError() {
        JOptionPane.showMessageDialog(this, 
                "Todos los campos son requeridos. Digite la duración en minutos",
                "Formato Inválido.",
                JOptionPane.ERROR_MESSAGE);
    }
    
    private void setShowInfo() {
        Show show = this.controller.getSelectedShow();
        this.nameInput.setText(show.getName());
        this.durationInput.setText(String.valueOf(show.getDurationInMinutes()));
        this.scheduleInput.setText(show.getSchedule());
        this.musicalGenreInput.setText(show.getMusicalGenre());
        this.broadcasterCombo.setSelectedItem(show.getBroadcaster());
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        nameInput = new javax.swing.JTextField();
        durationInput = new javax.swing.JTextField();
        scheduleInput = new javax.swing.JTextField();
        musicalGenreInput = new javax.swing.JTextField();
        comboBoxPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Programa");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Duración en minutos:");

        jLabel4.setText("Horario:");

        jLabel5.setText("Género:");

        jLabel6.setText("Locutor:");

        saveButton.setText("Guardar");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        backButton.setText("Volver");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout comboBoxPanelLayout = new javax.swing.GroupLayout(comboBoxPanel);
        comboBoxPanel.setLayout(comboBoxPanelLayout);
        comboBoxPanelLayout.setHorizontalGroup(
            comboBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        comboBoxPanelLayout.setVerticalGroup(
            comboBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

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
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameInput, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                            .addComponent(durationInput)
                            .addComponent(scheduleInput)
                            .addComponent(musicalGenreInput)
                            .addComponent(comboBoxPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(211, 211, 211)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(saveButton)
                                .addGap(86, 86, 86)
                                .addComponent(backButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(durationInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(scheduleInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(musicalGenreInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(comboBoxPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(backButton))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if(this.controller.getSelectedShow() == null) {
            this.newAction();
        } else {
            this.editAction();
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.controller.cleanSelectedShow();
        this.parentFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void createComboBoxBroadcasters() {
        Vector<Broadcaster> vector = new Vector<>(this.controller.broadcastersOptions());
        ComboBoxModel<Broadcaster> model = new DefaultComboBoxModel<Broadcaster>(vector);
        this.broadcasterCombo = new JComboBox<>(model);
        ComboBoxRenderer renderer = new ComboBoxRenderer();
        this.broadcasterCombo.setRenderer(renderer);
        broadcasterCombo.setEditable(false);
        broadcasterCombo.setEnabled(true);
        comboBoxPanel.removeAll();
        comboBoxPanel.setLayout(new BorderLayout()); 
        comboBoxPanel.add(broadcasterCombo, BorderLayout.CENTER);
        comboBoxPanel.revalidate(); 
        comboBoxPanel.repaint();
    }
    
    class ComboBoxRenderer extends DefaultListCellRenderer {
        /*
         * This method finds the image and text corresponding
         * to the selected value and returns the label, set up
         * to display the text and image.
         */
        public Component getListCellRendererComponent(
                                           JList list,
                                           Object value,
                                           int index,
                                           boolean isSelected,
                                           boolean cellHasFocus) {

            if(value instanceof Broadcaster) {
               value = ((Broadcaster)value).getName();
               setText((String) value);
            }  

            return this;
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel comboBoxPanel;
    private javax.swing.JTextField durationInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField musicalGenreInput;
    private javax.swing.JTextField nameInput;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField scheduleInput;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JComboBox<Broadcaster> broadcasterCombo;
}
