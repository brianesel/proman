package com.proman.pdfconversion.converter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class pdfConverter {

    private static final String PDF = "src/main/resources/pdf.pdf";
    private static final String HTML = "src/main/resources/html.html";

    public static void generatePDFFromHTML() throws ParserConfigurationException, IOException, DocumentException {
        String filename = "/home/bacramo/Documents/web/javaspring/proman3/proman/src/main/java/com/proman/pdfconversion/converter/temporary/upload.html";
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(
                "/home/bacramo/Documents/web/javaspring/proman3/proman/src/main/java/com/proman/pdfconversion/converter/temporary/product.pdf"));
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(filename));
        document.close();
    }
}