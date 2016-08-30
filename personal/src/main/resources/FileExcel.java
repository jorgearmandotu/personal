/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.resources;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author home
 */
public class FileExcel {
    
    
 
    public static void generaXlsx() throws IOException{
         
        //nombre del archivo de Excel
        String nombreArchivo = "quincena.xlsx";
 
        String nombreHoja1 = "fecha";//nombre de la hoja1
 
        Workbook libroTrabajo = new XSSFWorkbook();
        Sheet hoja1 = libroTrabajo.createSheet(nombreHoja1) ;
        
        Row row = hoja1.createRow((short)1);
        row.setHeightInPoints(30);
        
        Cell cell = row.createCell((short) 1);
        cell.setCellValue("Asistencia fecha xxxxxx");
        CellStyle cellStyle = libroTrabajo.createCellStyle();
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        //cellStyle.setFillBackgroundColor(IndexedColors.BLUE_GREY.getIndex());
        //cellStyle.setFillPattern(CellStyle.BIG_SPOTS);
        cellStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cell.setCellStyle(cellStyle);
        
        
        hoja1.addMergedRegion(new CellRangeAddress(
                1, // first row (0-based) primera fila
                1, //lasto row (0-based) ultima fila
                1, //first column (0-based) numero de columna inicial
                5 //last column (0-based) numero de columna final
        ));
        
        /*FileOutputStream fileout = new FileOutputStream(nombreArchivo);
        libroTrabajo.write(fileout);
        fileout.close();*/
        
        //iterando numero de filas (r)
        /*for (int r=0;r < 5; r++ ) {
            Row row = hoja1.createRow(r);
             
            //iterando numero de columnas (c)
            for (int c=0;c < 5; c++ ){
                Cell cell = row.createCell(c);
                Cell cell2 = row.createCell(c+1);
                Cell cell3 = row.createCell(c);
                
                cell.setCellValue("Cell "+r+" "+c);
                cell2.setCellValue("ajajaj");
                
            }*/
            
      //  }
 
        //escribir este libro en un OutputStream.
        try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo)) {
            //escribir este libro en un OutputStream.
            libroTrabajo.write(fileOut);
            fileOut.flush();
        }
    }
   
        
}
