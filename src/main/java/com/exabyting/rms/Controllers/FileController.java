package com.exabyting.rms.Controllers;

import com.exabyting.rms.Services.CloudinaryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/files")
public class FileController {

    @Autowired
    private CloudinaryServices cloudinaryServices;


    @PostMapping("/upload/")
    public ResponseEntity<Map> uploadImage(@RequestParam("image") MultipartFile file){
        Map data = cloudinaryServices.upload(file);
        return  new ResponseEntity<>(data, HttpStatus.OK);

    }
}
