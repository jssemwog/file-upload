package com.example.demo.controller;

import com.example.demo.entities.FileMetaData;
import com.example.demo.exception.StorageFileNotFoundException;
import com.example.demo.services.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity handleFileUpload(@RequestParam("file") MultipartFile file,
                                           @ModelAttribute FileMetaData fileMetaData) {
        storageService.store(file, fileMetaData);
        String message = "You successfully uploaded " + file.getOriginalFilename() + "!";
        return new ResponseEntity(message, HttpStatus.CREATED);
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}