package com.myproject.serviceservice1.service;

import com.myproject.serviceservice1.entity.InputKeyAndValue;
import com.myproject.serviceservice1.entity.Records;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import com.google.common.io.ByteStreams;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class WriteFileService {

    public void writeFileToPC(String pathString, Records records) throws Exception {
        String sourceString = "";
        for (InputKeyAndValue inputKeyAndValue : records.getRecords()) {
            sourceString += inputKeyAndValue.getKey() + " is " + inputKeyAndValue.getValue() + "\n";
        }
        byte[] source = sourceString.getBytes(StandardCharsets.UTF_8);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(source);
        byteArrayOutputStream.close();
        ByteArrayInputStream reportInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        byte[] bytesData = ByteStreams.toByteArray(reportInputStream);
        Path path = Paths.get(pathString);
        Files.write(path, bytesData);
    }

    public byte[] writeFileToDownload(Records records) throws IOException {
        String sourceString = "";
        for (InputKeyAndValue inputKeyAndValue : records.getRecords()) {
            sourceString += inputKeyAndValue.getKey() + " is " + inputKeyAndValue.getValue() + "\n";
        }
        byte[] source = sourceString.getBytes(StandardCharsets.UTF_8);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(source);
        byteArrayOutputStream.close();
        ByteArrayInputStream reportInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        byte[] bytesData = ByteStreams.toByteArray(reportInputStream);
        Path path = Paths.get("C:/Users/tep.wacharotayangoon/Desktop/testFile.txt");
        Files.write(path, bytesData);
        String name = "record.txt";
        String originalFileName = "record.txt";
        String contentType = "text/plain";
        byte[] content = Files.readAllBytes(path);
        Files.deleteIfExists(path);
        MultipartFile result = new MockMultipartFile(name, originalFileName, contentType, content);
        return result.getBytes();
    }
}