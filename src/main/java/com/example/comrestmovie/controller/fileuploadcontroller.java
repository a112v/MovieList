package com.example.comrestmovie.controller;

import com.example.comrestmovie.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class fileuploadcontroller
{
    @Autowired
    private FileUploadHelper fileuploadhelper;

    @PostMapping("/upload_file")
    public ResponseEntity<String> UploadFile(@RequestParam("file") MultipartFile multipfile)
    {
        try{
            System.out.println(multipfile.getOriginalFilename());
            System.out.println(multipfile.getContentType());
            System.out.println(multipfile.getSize());
            System.out.println(multipfile.getName());
            if(multipfile.isEmpty())
            {
                ResponseEntity.status(HttpStatus.NO_CONTENT).body("Please send a file");
            }
            if(!multipfile.getContentType().equals("image/jpeg"))
            {
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only jpeg format accepted");
            }
            boolean f=fileuploadhelper.uploadFile(multipfile);
            if(f) {
               // return ResponseEntity.ok("upload is done");
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(multipfile.getOriginalFilename()).toUriString());
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problem Problem");
    }
}
