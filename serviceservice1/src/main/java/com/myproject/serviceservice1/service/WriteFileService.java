package com.myproject.serviceservice1.service;

import com.myproject.serviceservice1.entity.MyInput;
import com.myproject.serviceservice1.entity.Records;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.io.ByteStreams;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class WriteFileService {

    public void writeFileToPC(String pathString, Records records) throws Exception {
        String sourceString = "";
        for (MyInput m : records.getRecords()) {
            sourceString += m.getKey() + " is " + m.getValue() + "\n";
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
}