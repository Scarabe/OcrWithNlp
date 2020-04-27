package com.ocrwithnlp.controllers;

import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;

/**
 * @author gscarabelo
 * @since 10/30/18 10:46 PM
 */
@RestController
@Slf4j
@RequestMapping("/rest")
public class ReceiveDataController {

    @RequestMapping(value = "/ocrfile", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> insertNewBankSlip(@RequestParam final String language) throws TesseractException {
        String file = "/teste.png";

        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("/");
        tesseract.setLanguage(language);
        tesseract.setTessVariable("user_defined_dpi", "300");

        String text = tesseract.doOCR(new File(file));

        return ResponseEntity.status(HttpStatus.OK).body(text);
    }
}