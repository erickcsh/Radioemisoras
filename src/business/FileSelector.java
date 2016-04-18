/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import views.SongsFrame;

/**
 *
 * @author erick
 */
public class FileSelector {
    
    JFileChooser fileselector;
        
    public FileSelector() {    
        fileselector = new JFileChooser();
    }
    
    /*
     * Shows a open file dialog
     * @params parentFrame the frame from where the chooser is opened
     * @return the selected File
    */
    public File showOpenDialog(JFrame parentFrame) {
        setFileExtensionFiler();
        int returnVal = fileselector.showOpenDialog(parentFrame);
        return selectFile(returnVal);
    }
    
    /*
     * Shows a save file dialog
     * @params parentFrame the frame from where the chooser is opened
     * @return the selected File
    */
    public File showSaveDialog(JFrame parentFrame) {
        setFileExtensionFiler();
        int returnVal = fileselector.showSaveDialog(parentFrame);
        return selectFile(returnVal);
    }

    private void setFileExtensionFiler() {
        FileFilter filter = new FileNameExtensionFilter("Excel file", "xls", "xlsx");
        fileselector.addChoosableFileFilter(filter);
    }

    private File selectFile(int returnVal) {
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileselector.getSelectedFile();
            return file;
        }
        return null;
    }
    
}
