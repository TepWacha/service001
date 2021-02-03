package com.myproject.serviceservice1.controller;

import com.myproject.serviceservice1.entity.Output;
import com.myproject.serviceservice1.entity.Records;
import com.myproject.serviceservice1.service.MyService;
import com.myproject.serviceservice1.service.WriteFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class MyController {
    @Autowired
    private MyService myService;
    @Autowired
    private WriteFileService writeFileService;

    @PostMapping("/service1")
    public Output postRecord(@RequestBody Records records) {
        return myService.report(records);
    }

    @PostMapping("/writeFileToPC")
    public void writeFileToPC(@RequestBody Records records, String path) throws Exception {
        System.out.println(path);
        writeFileService.writeFileToPC(path, records);
    }

    @PostMapping(value = "/writeFileToDownload", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] writeFileToDownLoad(@RequestBody Records records) throws IOException {
        return writeFileService.writeFileToDownload(records);
    }
}