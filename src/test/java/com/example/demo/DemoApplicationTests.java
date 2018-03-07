package com.example.demo;

import com.example.demo.controller.FileUploadController;
import com.example.demo.services.storage.StorageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(value = FileUploadController.class, secure = false)
public class DemoApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private StorageService storageService;

    @Test
    public void testControllerAndReturnCreatedStatus() throws Exception {
        String fileName = "test.txt";

        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", fileName,
                "text/plain", "test data".getBytes());

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/")
                        .file(mockMultipartFile);
        this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    public void testControllerAndReturnCreatedStatus1() throws Exception {
        String fileName = "test.txt";

        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", fileName,
                "text/plain", "test data".getBytes());

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/")
                        .file(mockMultipartFile);
        this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isCreated());

    }

}

