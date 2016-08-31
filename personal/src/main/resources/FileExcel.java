/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.resources;

import java.io.FileNotFoundException;
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
        //row.setHeightInPoints(10); //alto de celda
        
        Cell cell = row.createCell((short) 1);
        Cell cell1 = row.createCell((short) 1);
        cell.setCellValue("Asistencia fecha xxxxxx");
        CellStyle cellStyle = libroTrabajo.createCellStyle();
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        //cellStyle.setFillBackgroundColor(IndexedColors.BLUE_GREY.getIndex());
        //cellStyle.setFillPattern(CellStyle.BIG_SPOTS);
        cellStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBottomBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setLeftBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setRightBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setTopBorderColor(IndexedColors.AUTOMATIC.getIndex());
        
        
        
        hoja1.addMergedRegion(new CellRangeAddress(
                1, // first row (0-based) primera fila
                1, //lasto row (0-based) ultima fila
                1, //first column (0-based) numero de columna inicial
                5 //last column (0-based) numero de columna final
        ));
        cell.setCellStyle(cellStyle);
        cell1.setCellStyle(cellStyle);
 
        //escribir este libro en un OutputStream.
        try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo)) {
            //escribir este libro en un OutputStream.
            libroTrabajo.write(fileOut);
            fileOut.flush();
        }
    }
   
    public void  excelDia() throws FileNotFoundException, IOException{
        String nombreFile = "quincena.xlsx";
        String nombreHoja = "dia x mes x año x";
        
        Workbook libro = new XSSFWorkbook();
        Sheet hoja = libro.createSheet(nombreHoja);
        
        Row row = hoja.createRow(1);
        Cell celda = row.createCell(1);
        combinarceldas(hoja, 1, 1, 1, 5);
        celda.setCellValue("Asistencia del dia de hoy fecha");
        //Row row1 = hoja.createRow(2);
        Row row2 = hoja.createRow(3);
        Cell cell = row2.createCell(1);
        cell.setCellValue("Nficha");
        Cell cell1 = row2.createCell(2);
        cell1.setCellValue("1er Apellido");
        Cell cell2 = row2.createCell(3);
        cell2.setCellValue("2do Apellido");
        Cell cell3 = row2.createCell(4);
        cell3.setCellValue("!er Nombre");
        Cell cell4 = row2.createCell(5);
        cell4.setCellValue("2do Nombre");
        Cell cell5 = row2.createCell(6);
        cell5.setCellValue("Identificacion");
        Cell cell6 = row2.createCell(7);
        cell6.setCellValue("Día");
        Cell cell7 = row2.createCell(8);
        cell7.setCellValue("Cargo");
        Cell cell8 = row2.createCell(9);
        cell8.setCellValue("Grupo");
        
        //Row row3 = hoja.createRow(1);
        Row row4 = hoja.createRow(5);
        Cell celda9 = row4.createCell(1);
        combinarceldas(hoja, 5, 5, 1, 3);
        celda9.setCellValue("Maestro Grupo:");
        Cell celda10 = row4.createCell(2);
        Cell celda11 = row4.createCell(3);
        Cell celda12 = row4.createCell(4);
        
        try (FileOutputStream fileOut = new FileOutputStream(nombreFile)) {
            //escribir este libro en un OutputStream.
            libro.write(fileOut);
            fileOut.flush();
        }
        
        
    }
    private void combinarceldas(Sheet hoja, int pFila, int uFila, int nColumna, int nColumnaFinal){
        hoja.addMergedRegion(new CellRangeAddress(pFila,uFila,nColumna,nColumnaFinal));
    }
        
}
