package com.proman.pdfconversion.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.ParserConfigurationException;

import com.itextpdf.text.DocumentException;
import com.proman.pdfconversion.converter.pdfConverter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/pdf/converter")
public class pdfConverterController {

    private static String UPLOADED_FOLDER = "../converter/temporary/";

    @RequestMapping(value = "/file", headers = "content-type=multipart/*", method = RequestMethod.POST)
    public ResponseEntity handleFileUpload(@RequestParam("file") MultipartFile file)
            throws ParserConfigurationException, DocumentException {
        try {
            System.out.printf("File name=%s, size=%s\n", file.getOriginalFilename(), file.getSize());
            byte[] bytes = file.getBytes();
            System.out.print(bytes);
            Path path = Paths.get(
                    "/home/bacramo/Documents/web/javaspring/proman3/proman/src/main/java/com/proman/pdfconversion/converter/temporary/upload.html");
            Files.write(path, bytes);
            pdfConverter.generatePDFFromHTML();
        } catch (IOException ioe) {
            // if something went bad, we need to inform client about it
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        // everything was OK, return HTTP OK status (200) to the client
        return ResponseEntity.ok().build();
    }

}
