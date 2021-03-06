package com.cvworld.controllers;

import com.cvworld.dao.CvRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class ProfileController {
@GetMapping("/download/")
    public ResponseEntity<InputStreamResource> download( @RequestParam(value = "parameter1", required = false) String  filename)throws IOException{
    System.out.println(filename);
   File file = new File(filename);
    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

    return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment;filename=" + file.getName())
            .contentType(MediaType.APPLICATION_PDF).contentLength(file.length())
            .body(resource);

}

}
