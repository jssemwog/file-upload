package com.example.demo;

import com.example.demo.entities.FileMetaData;
import com.example.demo.repository.FileMetaDataRepository;
import com.example.demo.services.storage.StorageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationIT {

    @Autowired
    private StorageService storageService;

    @Autowired
    FileMetaDataRepository fileMetaDataRepository;

    @Test
    public void testUpload() {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "world.txt",
                "text/plain", "test data".getBytes());

        FileMetaData fileMetaData = new FileMetaData(mockMultipartFile.getName(), mockMultipartFile.getSize());

        storageService.store(mockMultipartFile, fileMetaData);

        List<FileMetaData> allFiles = fileMetaDataRepository.findAll();

        assertThat(allFiles, notNullValue());
        assertThat(allFiles.get(0).getId(), is(1L));
    }
}
