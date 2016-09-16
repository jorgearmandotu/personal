/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.resources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.xmlbeans.StringEnumAbstractBase.Table;

/**
 *
 * @author armando
 */
public class FileWord {
    
    public void crearWord() throws FileNotFoundException, IOException{
        String nombreArchivo = "fichas.docx";
        XWPFDocument doc = new XWPFDocument();
    
        XWPFTable table = doc.createTable(9, 1);
        table.getRow(0).getCell(0).setText("celda 1");
        
        table.setWidth(0);
        
        XWPFParagraph p1 = table.getRow(0).getCell(0).getParagraphs().get(0);
        
        XWPFRun r1 = p1.createRun();
        
        r1.setBold(true);
        r1.setText("The quick brown fox");
        r1.setItalic(true);
        r1.setFontFamily("Courier");
        r1.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
        r1.setTextPosition(100);

        //table.getRow(2).getCell(2).setText("only text");

        OutputStream out = new FileOutputStream(nombreArchivo);
        try {
             doc.write(out);
        } finally {
             out.close();
        }
        
        doc.close();

    }
    
    
    
}
