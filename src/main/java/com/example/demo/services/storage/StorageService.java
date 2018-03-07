package com.example.demo.services.storage;

import com.example.demo.entities.FileMetaData;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    void store(MultipartFile file, FileMetaData fileMetaData);

}