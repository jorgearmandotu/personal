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
import static org.apache.poi.ss.formula.WorkbookEvaluator.getSupportedFunctionNames;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author home
 */
public class FileExcel {
    
    
 
    public static void generaXlsx() throws IOException{
         
        //nombre del archivo de Excel
        String nombreArchivo = "quincena.xlsx";
 
        
 
        Workbook libroTrabajo = new XSSFWorkbook();
        
        String nombreHoja1 = "fecha";//nombre de la hoja1
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
        String nomObra = "SANTA MARIA DE FATIMA";
        
        Workbook libro = new XSSFWorkbook();
        
        Appi app = new Appi();
        Date Fecha = new Date();
        DateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        String fechaActual = formato.format(Fecha);
        String[] quincena = app.definirQuincena(fechaActual);
        
        String nombreHoja = fechaActual;
                        
        Sheet hojaMadre = libro.createSheet("periodo "+quincena[0]+" a "+quincena[1]);
        
        Row row1 = hojaMadre.createRow(1);
        Sheet hoja = libro.createSheet(nombreHoja);

        paginaDiaria(libro, hoja, fechaActual);
        
//        estlilos pagMadre
        //estilo convecciones
        Font negrita = libro.createFont();
        negrita.setBoldweight(Font.BOLDWEIGHT_BOLD);
        
        
        
        Font negritaGrande = libro.createFont();
        negritaGrande .setBoldweight(Font.BOLDWEIGHT_BOLD);
        negritaGrande.setFontHeightInPoints((short)14);
        
        Font normal = libro.createFont();
        normal.setFontHeightInPoints((short)12);
        
        DataFormat numeric = libro.createDataFormat();
        
        
        CellStyle convecciones = libro.createCellStyle();
        convecciones.setAlignment(CellStyle.ALIGN_CENTER);
        convecciones.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        convecciones.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
        convecciones.setFillPattern(CellStyle.SOLID_FOREGROUND);
        convecciones.setBorderBottom(CellStyle.BORDER_THIN);
        convecciones.setBottomBorderColor(IndexedColors.AUTOMATIC.getIndex());
        convecciones.setBorderTop(CellStyle.BORDER_THIN);
        convecciones.setTopBorderColor(IndexedColors.AUTOMATIC.getIndex());
        convecciones.setBorderLeft(CellStyle.BORDER_THIN);
        convecciones.setLeftBorderColor(IndexedColors.AUTOMATIC.getIndex());
        convecciones.setBorderRight(CellStyle.BORDER_THIN);
        convecciones.setRightBorderColor(IndexedColors.AUTOMATIC.getIndex());
        convecciones.setFont(negrita);
        
        
        //estilos conecciones celdas
        CellStyle cellRoja = libro.createCellStyle();
        cellRoja.setFillForegroundColor(IndexedColors.RED.getIndex());
        cellRoja.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cellRoja.setFillBackgroundColor(IndexedColors.RED.getIndex());
        cellRoja.setFillBackgroundColor(CellStyle.SOLID_FOREGROUND);
        cellRoja.setBorderBottom(CellStyle.BORDER_THIN);
        cellRoja.setBottomBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellRoja.setBorderTop(CellStyle.BORDER_THIN);
        cellRoja.setTopBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellRoja.setBorderLeft(CellStyle.BORDER_THIN);
        cellRoja.setLeftBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellRoja.setBorderRight(CellStyle.BORDER_THIN);
        cellRoja.setRightBorderColor(IndexedColors.AUTOMATIC.getIndex());
        
        CellStyle cellAmarilla = libro.createCellStyle();
        cellAmarilla.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        cellAmarilla.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cellAmarilla.setBorderBottom(CellStyle.BORDER_THIN);
        cellAmarilla.setBottomBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellAmarilla.setBorderTop(CellStyle.BORDER_THIN);
        cellAmarilla.setTopBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellAmarilla.setBorderLeft(CellStyle.BORDER_THIN);
        cellAmarilla.setLeftBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellAmarilla.setBorderRight(CellStyle.BORDER_THIN);
        cellAmarilla.setRightBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellAmarilla.setFont(normal);
        
        CellStyle cellAzul = libro.createCellStyle();
        cellAzul.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cellAzul.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        cellAzul.setBorderBottom(CellStyle.BORDER_THIN);
        cellAzul.setBottomBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellAzul.setBorderTop(CellStyle.BORDER_THIN);
        cellAzul.setTopBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellAzul.setBorderLeft(CellStyle.BORDER_THIN);
        cellAzul.setLeftBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellAzul.setBorderRight(CellStyle.BORDER_THIN);
        cellAzul.setRightBorderColor(IndexedColors.AUTOMATIC.getIndex());
        
        CellStyle cellAzul2 = libro.createCellStyle();
        cellAzul2.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cellAzul2.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        cellAzul2.setBorderBottom(CellStyle.BORDER_THIN);
        cellAzul2.setBottomBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellAzul2.setBorderTop(CellStyle.BORDER_THIN);
        cellAzul2.setTopBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellAzul2.setBorderLeft(CellStyle.BORDER_THIN);
        cellAzul2.setLeftBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellAzul2.setBorderRight(CellStyle.BORDER_THIN);
        cellAzul2.setRightBorderColor(IndexedColors.AUTOMATIC.getIndex());
        
        CellStyle cellBordes = libro.createCellStyle();
        cellBordes.setBorderBottom(CellStyle.BORDER_THIN);
        cellBordes.setBorderTop(CellStyle.BORDER_THIN);
        cellBordes.setBorderLeft(CellStyle.BORDER_THIN);
        cellBordes.setBorderRight(CellStyle.BORDER_THIN);
        cellBordes.setBottomBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellBordes.setTopBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellBordes.setLeftBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellBordes.setRightBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellBordes.setFont(normal);
        //cellBordes.setDataFormat(numeric.getFormat("_(* #.##0_);_(* (#.##0);_(* -??_);_(@_)"));
        
        CellStyle cellBordesNeg = libro.createCellStyle();
        cellBordesNeg.setBorderBottom(CellStyle.BORDER_THIN);
        cellBordesNeg.setBorderTop(CellStyle.BORDER_THIN);
        cellBordesNeg.setBorderLeft(CellStyle.BORDER_THIN);
        cellBordesNeg.setBorderRight(CellStyle.BORDER_THIN);
        cellBordesNeg.setBottomBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellBordesNeg.setTopBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellBordesNeg.setLeftBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellBordesNeg.setRightBorderColor(IndexedColors.AUTOMATIC.getIndex());
        cellBordesNeg.setFont(negrita);
        
        CellStyle cellTitulo = libro.createCellStyle();
        cellTitulo.setAlignment(CellStyle.ALIGN_CENTER);
        cellTitulo.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        cellTitulo.setFont(negritaGrande);
        
        
        Cell cellConvec = row1.createCell(7);
        cellConvec.setCellStyle(convecciones);
        cellConvec.setCellValue("Convecciones");
        combinarceldas(hojaMadre, 1, 4, 7, 7);
        
        Cell cellR = row1.createCell(9);
        cellR.setCellStyle(cellRoja);
        
        Row row2 = hojaMadre.createRow(2);
        Row row3 = hojaMadre.createRow(3);
        Row row4 = hojaMadre.createRow(4);
        
        Cell cellA = row2.createCell(9);
        cellA.setCellStyle(cellAmarilla);
        
        Cell cellAz = row3.createCell(9);
        cellAz.setCellStyle(cellAzul);
        
        Cell cellAz2 = row4.createCell(9);
        cellAz2.setCellStyle(cellAzul2);
        
        Cell cellConvA = row1.createCell(10);
        cellConvA.setCellStyle(cellBordes);
        cellConvA.setCellValue("Faltas");
        combinarceldas(hojaMadre, 2, 2, 10, 14);
        Cell cellConvb = row2.createCell(10);
        cellConvb.setCellStyle(cellBordes);
        cellConvb.setCellValue("ContraMaestros");
        combinarceldas(hojaMadre, 3, 3, 10, 14);
        Cell cellConvc = row3.createCell(10);
        cellConvc.setCellStyle(cellBordes);
        cellConvc.setCellValue("Incapacidades");
        combinarceldas(hojaMadre, 4, 4, 10, 14);
        Cell cellConvd = row4.createCell(10);
        cellConvd.setCellStyle(cellBordes);
        cellConvd.setCellValue("Permisos");
        combinarceldas(hojaMadre, 1, 1, 10, 14);
        
        Cell cellObra = row2.createCell(1);
        cellObra.setCellStyle(cellTitulo);
        cellObra.setCellValue(nomObra);
        combinarceldas(hojaMadre, 2, 2, 1, 4);
        
        Cell cellQuincena = row3.createCell(1);
        cellQuincena.setCellStyle(cellTitulo);
        cellQuincena.setCellValue("quincena N° #");
        combinarceldas(hojaMadre, 3, 3, 1, 4);
        
        Cell cellQuinrango = row4.createCell(1);
        cellQuinrango.setCellStyle(cellTitulo);
        cellQuinrango.setCellValue("día1 a día2 de mes");
        combinarceldas(hojaMadre, 4, 4, 1, 4);
        
        Row row6 = hojaMadre.createRow(6);
        Cell cellP = row6.createCell(2);
        cellP.setCellValue("grupo 1");
                
        //int dianum = 1;
        for(int i = 0; i<15;i++) {
            Cell celldia1 = row6.createCell(i+9);
            celldia1.setCellStyle(cellBordes);
            celldia1.setCellValue(i+1);
        }
        
        Row row7 = hojaMadre.createRow(7);
        
        String[] titles = {"N°", "Ficha", "1ER.Apellido", "2DO.Apellido", "1ER.Nombre", "2DO.Nombre", "concatenar", "IDENTIFICACION",
        "#Cuenta", "S", "D", "L", "M", "M", "J", "V", "S", "D", "L", "M", "M", "J", "V", "S", "D/W", "V/ DIARIO", "SALARIO", "AUX. TRANS",
        "BONIFICACION", "ISS", "TOTAL A PAGAR", "REDONDEAR", "CES-%CES -P-V", "Total Costo Empresa", "CARGO", "MAESTRO/CUADRILLA"};
        for(int i=0; i<titles.length; i++){
            Cell cellT0 = row7.createCell(i);
            cellT0.setCellValue(titles[i]);
            cellT0.setCellStyle(cellBordesNeg);
        }
        //array de empleados ordenados porgrupo, supervisor, ficha
        //SELECT * FROM empleado ORDER BY grupo, supervisor DESC, nficha
        
        ArrayList empleados = app.empleadosTotales();
        AportesBonificaciones ent = app.entidad("SALARIO MINIMO");
        float minimo = ent.getValor();
        for(int i=0; i<empleados.size(); i++){
            Row rowD = hojaMadre.createRow(i+8);
            
            Cell cellD = rowD.createCell(0);
            cellD.setCellValue(i+1);
            cellD.setCellStyle(cellBordes);
            
            Empleado emp = (Empleado) empleados.get(i);
            Cell cellD1 = rowD.createCell(1);
            cellD1.setCellValue(emp.getnFicha());
            cellD1.setCellStyle(cellBordes);
            if(emp.getSupervisor() == 1) cellD1.setCellStyle(cellAmarilla);
            
            Cell cellD2 = rowD.createCell(2);
            cellD2.setCellValue(emp.getpApellido());
            cellD2.setCellStyle(cellBordes);
            if(emp.getSupervisor() == 1) cellD2.setCellStyle(cellAmarilla);
            
            Cell cellD3 = rowD.createCell(3);
            cellD3.setCellValue(emp.getsApellido());
            cellD3.setCellStyle(cellBordes);
            if(emp.getSupervisor() == 1) cellD3.setCellStyle(cellAmarilla);
            
            Cell cellD4 = rowD.createCell(4);
            cellD4.setCellValue(emp.getpNombre());
            cellD4.setCellStyle(cellBordes);
            if(emp.getSupervisor() == 1) cellD4.setCellStyle(cellAmarilla);
            
            Cell cellD5 = rowD.createCell(5);
            cellD5.setCellValue(emp.getsNombre());
            cellD5.setCellStyle(cellBordes);
            if(emp.getSupervisor() == 1) cellD5.setCellStyle(cellAmarilla);
            
            Cell cellD6 = rowD.createCell(6);
            cellD6.setCellFormula("concatenate(c"+(i+9)+",d"+(i+9)+",e"+(i+9)+",f"+(i+9)+")");
            cellD6.setCellStyle(cellBordes);
            if(emp.getSupervisor() == 1) cellD6.setCellStyle(cellAmarilla);
            
            Cell cellD7 = rowD.createCell(7);
            cellD7.setCellValue(emp.getCedula());
            cellD7.setCellStyle(cellBordes);
            if(emp.getSupervisor() == 1) cellD7.setCellStyle(cellAmarilla);
            
            Cell cellD8 = rowD.createCell(8);
            cellD8.setCellValue(emp.getnCuenta());
            cellD8.setCellStyle(cellBordes);
            if(emp.getSupervisor() == 1) cellD7.setCellStyle(cellAmarilla);
            
            //celdas con asistencia
            ArrayList<String> dias = app.diasAsistencia(emp.getCedula());
            float diasW = 0;
            for(int j=0; j<dias.size();j++){
                Cell cellDias = rowD.createCell(j+9);
                cellDias.setCellValue(dias.get(j));
                if(dias.get(j).equals("N")){
                    cellDias.setCellStyle(cellRoja);
                }else if(dias.get(j).equals("I")){
                    cellDias.setCellStyle(cellAzul);
                }else if(dias.get(j).equals("P")){
                    cellDias.setCellStyle(cellAzul2);
                    diasW++;
                }else if(dias.get(j).equals("%")){
                    cellDias.setCellStyle(cellAzul2);
                    diasW = (float) (diasW+0.5);
                }
                else {
                    cellDias.setCellStyle(cellBordes);
                    diasW++;
                }
            }
            Cell cellDW = rowD.createCell(24);
            cellDW.setCellValue(diasW);
            cellDW.setCellStyle(cellBordes);
            
            Cell cellVD = rowD.createCell(25);
            cellVD.setCellFormula("("+minimo+"/30)");
            cellVD.setCellStyle(cellBordes);
            
            Cell cellsal = rowD.createCell(26);
            cellsal.setCellFormula("(z"+(i+9)+" * y"+(i+9)+")");
            cellsal.setCellStyle(cellBordes);
            
            Cell cellAuxTrans = rowD.createCell(27);
            cellAuxTrans.setCellFormula("(77700/30*y"+(i+9)+")");
            cellAuxTrans.setCellStyle(cellBordes);
            
            Cell cellBon = rowD.createCell(28);
            cellBon.setCellValue("bonificacion");
            cellBon.setCellStyle(cellBordes);
            
            Cell cellIss = rowD.createCell(29);
            cellIss.setCellFormula("("+minimo+"*0.08)/30*15");
            cellIss.setCellStyle(cellBordes);
        }
        //System.out.println(getSupportedFunctionNames ());
        for(int column=0; column<36; column++){
            hojaMadre.autoSizeColumn(column, true);
        }
        
        try (FileOutputStream fileOut = new FileOutputStream(nombreFile)) {
            //escribir este libro en un OutputStream.
            libro.write(fileOut);
            fileOut.flush();
        }
    }
    private void combinarceldas(Sheet hoja, int pFila, int uFila, int nColumna, int nColumnaFinal){
        hoja.addMergedRegion(new CellRangeAddress(pFila,uFila,nColumna,nColumnaFinal));
    }
    
    private void paginaDiaria(Workbook libro, Sheet hoja, String fechaActual){
        
        //estilos
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
        
        //escribiendo hoja
        Appi app = new Appi();
        
        ArrayList<Empleado> faltas = app.faltas(fechaActual);//obtengo listado de empleados
        String grupoBandera = "";
        String maestro = "";
        int pRow = 3;
        if(!faltas.isEmpty()){
            Row row = hoja.createRow(1);
            Cell celda = row.createCell(3);
            Cell celda2 = row.createCell(4);
            Cell celda3 = row.createCell(5);
            Cell celda4 = row.createCell(6);
            Cell celda5 = row.createCell(7);
            combinarceldas(hoja, 1, 1, 3, 7);
            celda.setCellValue("Asistencia "+fechaActual);
            celda.setCellStyle(estilo);
            celda2.setCellStyle(estilo);
            celda3.setCellStyle(estilo);
            celda4.setCellStyle(estilo);
            celda5.setCellStyle(estilo);
            grupoBandera = faltas.get(0).getGrupo();
            
            //encabezados
            Row row2 = hoja.createRow(pRow);
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
        }
        Empleado emp = null;
        for (Empleado falta : faltas) {
            //datos
            emp = (Empleado) falta;
            Grupo grupo = app.grupo(emp.getGrupo());
            if(!grupoBandera.equals(emp.getGrupo())){
                grupoBandera = emp.getGrupo();
                pRow = pRow+2;
                //frima maestro
                Row row4 = hoja.createRow(pRow);
                Cell celda9 = row4.createCell(1);
                combinarceldas(hoja, pRow, pRow, 1, 3);
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
                Cell celda15 = row4.createCell(7);
                celda15.setCellStyle(borderBot);
                Cell celda16 = row4.createCell(8);
                celda16.setCellStyle(borderBot);
                
                pRow++;
        
                Row row6 = hoja.createRow(pRow);
                Cell celda64 = row6.createCell(4);
                combinarceldas(hoja, pRow, pRow, 4, 8);
                celda64.setCellValue(maestro);
                
                pRow = pRow+2;
                //encabexzados
                Row row2 = hoja.createRow(pRow);
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
            }
            Row row5 = hoja.createRow(pRow+1);
            Cell celda51 = row5.createCell(1);
            celda51.setCellStyle(bordes);
            celda51.setCellValue(emp.getnFicha());
            Cell celda52 = row5.createCell(2);
            celda52.setCellStyle(bordes);
            celda52.setCellValue(emp.getpApellido());
            Cell celda53 = row5.createCell(3);
            celda53.setCellStyle(bordes);
            celda53.setCellValue(emp.getsApellido());
            Cell celda54 = row5.createCell(4);
            celda54.setCellStyle(bordes);
            celda54.setCellValue(emp.getpNombre());
            Cell celda55 = row5.createCell(5);
            celda55.setCellStyle(bordes);
            celda55.setCellValue(emp.getsNombre());
            Cell celda56 = row5.createCell(6);
            celda56.setCellStyle(bordes);
            celda56.setCellValue(emp.getCedula());
            Cell celda57 = row5.createCell(7);
            celda57.setCellStyle(bordes);
            celda57.setCellValue(fechaActual);
            Cell celda58 = row5.createCell(8);
            celda58.setCellStyle(bordes);
            celda58.setCellValue(emp.getCargo());
            Cell celda59 = row5.createCell(9);
            celda59.setCellStyle(bordes);
            celda59.setCellValue(grupo.getNombre());
            pRow++;
            Empleado supervisor = app.empleado(grupo.getSupervisor());
            if(supervisor != null){
                maestro = supervisor.getpNombre()+" "+supervisor.getsNombre()+" "+supervisor.getpApellido()+" "+supervisor.getsApellido();
            }else{
                maestro = String.valueOf(grupo.getSupervisor());
            }
           
            //
            //String cedula = (String) e;
            //Empleado emp = app.empleado(cedula);
            System.out.println(emp.getCedula());
        }
        if(emp != null){
            pRow = pRow+2;
                //frima maestro
            Row row4 = hoja.createRow(pRow);
            Cell celda9 = row4.createCell(1);
            combinarceldas(hoja, pRow, pRow, 1, 3);
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
            Cell celda15 = row4.createCell(7);
            celda15.setCellStyle(borderBot);
            Cell celda16 = row4.createCell(8);
            celda16.setCellStyle(borderBot);
                
            pRow++;
        
            Row row6 = hoja.createRow(pRow);
            Cell celda64 = row6.createCell(4);
            combinarceldas(hoja, pRow, pRow, 4, 8);
            celda64.setCellValue(maestro);
        }  
    }
        
}
