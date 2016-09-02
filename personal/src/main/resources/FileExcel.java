/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.resources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import main.Appi;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
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
        
        Font negrita = libro.createFont();
        negrita.setBoldweight(Font.BOLDWEIGHT_BOLD);
        
        
        
        CellStyle estilo = libro.createCellStyle();
        estilo.setAlignment(CellStyle.ALIGN_CENTER);
        estilo.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        estilo.setFillPattern(CellStyle.SOLID_FOREGROUND);
        estilo.setBorderBottom(CellStyle.BORDER_THIN);
        estilo.setBottomBorderColor(IndexedColors.AUTOMATIC.getIndex());
        estilo.setBorderLeft(CellStyle.BORDER_THIN);
        estilo.setLeftBorderColor(IndexedColors.AUTOMATIC.getIndex());
        estilo.setBorderRight(CellStyle.BORDER_THIN);
        estilo.setRightBorderColor(IndexedColors.AUTOMATIC.getIndex());
        estilo.setBorderTop(CellStyle.BORDER_THIN);
        estilo.setTopBorderColor(IndexedColors.AUTOMATIC.getIndex());
        estilo.setFont(negrita);
        
        CellStyle bordes = libro.createCellStyle();
        bordes.setAlignment(CellStyle.ALIGN_LEFT);
        bordes.setBorderBottom(CellStyle.BORDER_THIN);
        bordes.setBottomBorderColor(IndexedColors.AUTOMATIC.getIndex());
        bordes.setBorderLeft(CellStyle.BORDER_THIN);
        bordes.setLeftBorderColor(IndexedColors.AUTOMATIC.getIndex());
        bordes.setBorderRight(CellStyle.BORDER_THIN);
        bordes.setRightBorderColor(IndexedColors.AUTOMATIC.getIndex());
        bordes.setBorderTop(CellStyle.BORDER_THIN);
        bordes.setTopBorderColor(IndexedColors.AUTOMATIC.getIndex());
        
        CellStyle estilo2 = libro.createCellStyle();
        estilo2.setAlignment(CellStyle.ALIGN_CENTER);
        estilo2.setBorderBottom(CellStyle.BORDER_THIN);
        estilo2.setBottomBorderColor(IndexedColors.AUTOMATIC.getIndex());
        estilo2.setBorderLeft(CellStyle.BORDER_THIN);
        estilo2.setLeftBorderColor(IndexedColors.AUTOMATIC.getIndex());
        estilo2.setBorderRight(CellStyle.BORDER_THIN);
        estilo2.setRightBorderColor(IndexedColors.AUTOMATIC.getIndex());
        estilo2.setBorderTop(CellStyle.BORDER_THIN);
        estilo2.setTopBorderColor(IndexedColors.AUTOMATIC.getIndex());
        estilo2.setAlignment(CellStyle.ALIGN_CENTER);
        estilo2.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        estilo2.setFillPattern(CellStyle.SOLID_FOREGROUND);
        estilo2.setFont(negrita);
        
        
        CellStyle borderBot = libro.createCellStyle();
        borderBot.setBorderBottom(CellStyle.BORDER_THIN);
        borderBot.setBottomBorderColor(IndexedColors.AUTOMATIC.getIndex());
        
        
        Row row = hoja.createRow(1);
        Cell celda = row.createCell(1);
        Cell celda2 = row.createCell(2);
        Cell celda3 = row.createCell(3);
        Cell celda4 = row.createCell(4);
        Cell celda5 = row.createCell(5);
        
        combinarceldas(hoja, 1, 1, 1, 5);
        celda.setCellValue("Asistencia del dia de hoy fecha");
        celda.setCellStyle(estilo);
        celda2.setCellStyle(estilo);
        celda3.setCellStyle(estilo);
        celda4.setCellStyle(estilo);
        celda5.setCellStyle(estilo);
        //Row row1 = hoja.createRow(2);
        
        //empleados faltas
        Appi app = new Appi();
        Date Fecha = new Date();
        DateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        String fechaActual = formato.format(Fecha);
        ArrayList<String> faltas = app.faltas(fechaActual);//obtengo listado de cedulas
        for(Object e : faltas){
            String cedula = (String) e;
            Empleado emp = app.empleado(cedula);
            Grupo grupo = app.grupo(emp.getGrupo());
        }
        
        //enmcabezados
        Row row2 = hoja.createRow(3);
        Cell cell = row2.createCell(1);
        cell.setCellValue("Nficha");
        cell.setCellStyle(estilo2);
        
        Cell cell1 = row2.createCell(2);
        cell1.setCellValue("1er Apellido");
        cell1.setCellStyle(estilo2);
        
        Cell cell2 = row2.createCell(3);
        cell2.setCellValue("2do Apellido");
        cell2.setCellStyle(estilo2);
        
        Cell cell3 = row2.createCell(4);
        cell3.setCellValue("1er Nombre");
        cell3.setCellStyle(estilo2);
        
        Cell cell4 = row2.createCell(5);
        cell4.setCellValue("2do Nombre");
        cell4.setCellStyle(estilo2);
        
        Cell cell5 = row2.createCell(6);
        cell5.setCellValue("Identificacion");
        cell5.setCellStyle(estilo2);
        
        Cell cell6 = row2.createCell(7);
        cell6.setCellValue("Día");
        cell6.setCellStyle(estilo2);
        
        Cell cell7 = row2.createCell(8);
        cell7.setCellValue("Cargo");
        cell7.setCellStyle(estilo2);
        
        Cell cell8 = row2.createCell(9);
        cell8.setCellValue("Grupo");
        cell8.setCellStyle(estilo2);
        
        //Row row3 = hoja.createRow(1);
        // debe ejcutarse un loop de acuerdoa consaulta
        //datos
        Row row5 = hoja.createRow(4);
        Cell celda51 = row5.createCell(1);
        celda51.setCellStyle(bordes);
        celda51.setCellValue("#ficha");
        Cell celda52 = row5.createCell(2);
        celda52.setCellStyle(bordes);
        celda52.setCellValue("apellido");
        Cell celda53 = row5.createCell(3);
        celda53.setCellStyle(bordes);
        celda53.setCellValue("#apellido");
        Cell celda54 = row5.createCell(4);
        celda54.setCellStyle(bordes);
        celda54.setCellValue("#nombre");
        Cell celda55 = row5.createCell(5);
        celda55.setCellStyle(bordes);
        celda55.setCellValue("#nombre");
        Cell celda56 = row5.createCell(6);
        celda56.setCellStyle(bordes);
        celda56.setCellValue("#identificacion");
        Cell celda57 = row5.createCell(7);
        celda57.setCellStyle(bordes);
        celda57.setCellValue("#dia");
        Cell celda58 = row5.createCell(8);
        celda58.setCellStyle(bordes);
        celda58.setCellValue("#cargo");
        Cell celda59 = row5.createCell(9);
        celda59.setCellStyle(bordes);
        celda59.setCellValue("#grupo");
        
        //datos responsable firma
        Row row4 = hoja.createRow(6);
        Cell celda9 = row4.createCell(1);
        combinarceldas(hoja, 6, 6, 1, 3);
        celda9.setCellValue("Maestro Grupo:");
        celda9.setCellStyle(estilo);
        Cell celda10 = row4.createCell(2);
        celda10.setCellStyle(bordes);
        Cell celda11 = row4.createCell(3);
        celda11.setCellStyle(bordes);
        Cell celda12 = row4.createCell(4);
        celda12.setCellStyle(borderBot);
        Cell celda13 = row4.createCell(5);
        celda13.setCellStyle(borderBot);
        Cell celda14 = row4.createCell(6);
        celda14.setCellStyle(borderBot);
        
        Row row6 = hoja.createRow(7);
        Cell celda64 = row6.createCell(4);
        combinarceldas(hoja, 7, 7, 4, 6);
        celda64.setCellValue("maestro XXXX");
        
        //CellS
        //celda64.setCellStyle();
        
        
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
