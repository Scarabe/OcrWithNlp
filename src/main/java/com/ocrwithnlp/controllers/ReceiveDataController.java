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
    public ResponseEntity<String> insertNewBankSlip(@RequestParam final String teste) throws TesseractException {
        String file = "c:/RG.jpg";

        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("c:/");
        tesseract.setLanguage("por");
        String text = tesseract.doOCR(new File(file));

        return ResponseEntity.status(HttpStatus.OK).body(text);
    }
}