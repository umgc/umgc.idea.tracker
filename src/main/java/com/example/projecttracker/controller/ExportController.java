package com.example.projecttracker.controller;


import java.io.FileNotFoundException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

/**
 *
 * @author Kathryn
 */
public class ExportController {
    
    public static void exportWord() throws FileNotFoundException{
        XWPFDocument document = new XWPFDocument();
        
        //College Name at top of the document bold in big text with line above
        XWPFParagraph school = document.createParagraph();
        XWPFRun schoolrun = school.createRun();
        schoolrun.setText("University of Maryland Global College");
        school.setAlignment(ParagraphAlignment.CENTER);
        school.setBorderTop(Borders.BASIC_THIN_LINES);
        schoolrun.setFontSize(24);
        schoolrun.setBold(true);
        
        //Department & Course details in medium text with line below
        XWPFParagraph department = document.createParagraph();
        XWPFRun deptrun = department.createRun();
        deptrun.setText("Department of Information & Technology Systems");
        deptrun.addBreak();
        deptrun.setText("SWEN 670 – Software Engineering Project");
        deptrun.setFontSize(16);
        department.setAlignment(ParagraphAlignment.CENTER);
        department.setBorderBottom(Borders.BASIC_THIN_LINES);
        
        //Project Title
        XWPFParagraph title = document.createParagraph();
        XWPFRun titlerun = title.createRun();
        titlerun.setText("Project Title: " + "Variable name");
        titlerun.addBreak();
        titlerun.setFontSize(12);
        title.setAlignment(ParagraphAlignment.LEFT);
        title.setSpacingAfter(100);
        
        
       //Project Sponsor
        XWPFParagraph sponsor = document.createParagraph();
        XWPFRun sponsorrun = sponsor.createRun();
        sponsorrun.setText("Project Sponsor: " + "Variable name");
        sponsorrun.addBreak();
        sponsorrun.setFontSize(12);
        sponsor.setAlignment(ParagraphAlignment.LEFT);

        
        
        //Project Liaison
        XWPFParagraph liaison = document.createParagraph();
        XWPFRun liaisonrun = liaison.createRun();
        liaisonrun.setText("Project Liaison: " + "Variable name");
        liaisonrun.addBreak();
        liaisonrun.setFontSize(12);
        liaison.setAlignment(ParagraphAlignment.LEFT);

        
        //Project Description
        XWPFParagraph description = document.createParagraph();
        XWPFRun descrun = description.createRun();
        descrun.setText("Project Description: " + "Variable name");
        descrun.addBreak();
        descrun.setFontSize(12);
        description.setAlignment(ParagraphAlignment.LEFT);
        description.getSpacingAfter();
        
        
        try (FileOutputStream output = new FileOutputStream("SWEN 670 Project" + ".docx")) {
        	System.out.println("File exporting");
            document.write(output);
            document.close();
        } catch (IOException ex) {
            Logger.getLogger(ExportController.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        
        
    }
}
