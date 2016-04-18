/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.Song;
import data.SongContainer;
import data.SongFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Parse songs to excel or excel to songs
 * @author erick
 */
public class SongExcelParser {

    /*
     * Parse excel file to song containers
     * @params File the File to parse
     * @return the list of parsed SongsContainer
    */
    public ArrayList<SongContainer> fileToSongFiles(File fileSelected) {
        if(fileSelected instanceof File ) {
            try {
                Workbook wb = WorkbookFactory.create(fileSelected);
                Sheet sheet = wb.getSheetAt(0);
                return sheetToSongFiles(sheet);
            } catch(Exception e) {
                return new ArrayList<>();
            }
        } else {
            return new ArrayList<>();
        }
    }
    
    /*
     * Parse excel file to songs
     * @params File the File to parse
     * @return the list of parsed Songs
    */
    public ArrayList<Song> fileToCDSongs(File fileSelected) {
        if(fileSelected instanceof File ) {
            try {
                Workbook wb = WorkbookFactory.create(fileSelected);
                Sheet sheet = wb.getSheetAt(0);
                return sheetToCDSongs(sheet);
            } catch(Exception e) {
                return new ArrayList<>();
            }
        } else {
            return new ArrayList<>();
        }
    }
    
    /*
     * Parse song containers to excel
     * @params File the File to save
     * @params songContainerList the list of song container to parse
     * @return the list of parsed SongsContainer
    */
    public boolean songsToFile(File fileSelected, ArrayList<SongContainer> songContainerList) {
        if(fileSelected instanceof File ) {
            try {
                if(!fileSelected.exists()) {
                    writeEmptyFile(fileSelected);
                }
                Workbook wb = new XSSFWorkbook();
                songsToWorkbook(wb, songContainerList);
                return writeWorkbookToFile(wb, fileSelected);
            } catch(Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    private ArrayList<SongContainer> sheetToSongFiles(Sheet sheet) {
        SongFile songFile;
        Row row;
        ArrayList<SongContainer> songFiles = new ArrayList<>();
        Iterator<Row> rows = sheet.rowIterator();
        while(rows.hasNext()) {
            row = rows.next();
            if(row.getRowNum() != 0) {
                songFile = getSongFileFromRow(row);
                if(songFile != null && songFile.isValid()) {
                    songFiles.add(songFile);
                }
            }
        }
        return songFiles;
    }

    private SongFile getSongFileFromRow(Row row) {
        try {
            String albumName = row.getCell(0).getRichStringCellValue().getString();
            String songName = row.getCell(1).getRichStringCellValue().getString();
            String singer = row.getCell(2).getRichStringCellValue().getString();
            Double duration = row.getCell(3).getNumericCellValue();
            String musicalGenre = row.getCell(4).getRichStringCellValue().getString();
            String location = row.getCell(5).getRichStringCellValue().getString();
            return new SongFile(albumName, singer, musicalGenre, location, songName, duration.intValue());
        } catch(Exception e) {
            return null;
        }
    }

    private ArrayList<Song> sheetToCDSongs(Sheet sheet) {
        Song song;
        Row row;
        ArrayList<Song> songs = new ArrayList<>();
        Iterator<Row> rows = sheet.rowIterator();
        while(rows.hasNext()) {
            row = rows.next();
            if(row.getRowNum() != 0) {
                song = getSongFromRow(row);
                if(song != null && song.isValid()) {
                    songs.add(song);
                }
            }
        }
        return songs;
    }

    private Song getSongFromRow(Row row) {
        try {
            String songName = row.getCell(0).getRichStringCellValue().getString();
            String singer = row.getCell(1).getRichStringCellValue().getString();
            Double duration = row.getCell(2).getNumericCellValue();
            String musicalGenre = row.getCell(3).getRichStringCellValue().getString();
            return new Song(songName, musicalGenre, singer, duration.intValue());
        } catch(Exception e) {
            return null;
        }   
    }

    private void songsToWorkbook(Workbook wb, ArrayList<SongContainer> songContainerList) {
        Row row;
        int rowNumber = 1;
        Sheet sheet = wb.createSheet();
        row = setRowHeader(sheet);
        for(SongContainer container : songContainerList) {
            for(Song song : container.getSongs()) {
                row = sheet.createRow(rowNumber);
                setRowInfo(row, song, container);
                rowNumber++;
            }
        }
        for (int x = 0; x < sheet.getRow(0).getPhysicalNumberOfCells(); x++) {
            sheet.autoSizeColumn(x);
        }
    }

    private void writeEmptyFile(File fileSelected) throws IOException {
        fileSelected.getParentFile().mkdirs();
        fileSelected.createNewFile();
    }

    private boolean writeWorkbookToFile(Workbook wb, File fileSelected) {
        try {
            FileOutputStream fos = new FileOutputStream(fileSelected);
            wb.write(fos);
            fos.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private void setRowInfo(Row row, Song song, SongContainer container) {
        Cell cell = row.createCell(0);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue(container.getAlbumName());
        cell = row.createCell(1);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue(song.getName());
        cell = row.createCell(2);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue(song.getSinger());
        cell = row.createCell(3);
        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
        cell.setCellValue((double)song.getDurationInMinutes());
        cell = row.createCell(4);
        cell.setCellType(Cell.CELL_TYPE_STRING);        
        cell.setCellValue(song.getMusicalGenre());
        cell = row.createCell(5);
        cell.setCellType(Cell.CELL_TYPE_STRING);        
        cell.setCellValue(container.getLocation());
    }

    private Row setRowHeader(Sheet sheet) {
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellType(Cell.CELL_TYPE_STRING);        
        cell.setCellValue("Álbum");
        cell = row.createCell(1);        
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue("Nombre de la canción");
        cell = row.createCell(2);        
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue("Cantante");
        cell = row.createCell(3);        
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue("Duración");
        cell = row.createCell(4);        
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue("Género musical");
        cell = row.createCell(5);        
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue("Path o ubicación");
        return row;
    }
    
}
