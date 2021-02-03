package com.myproject.serviceservice1.controller;

import com.myproject.serviceservice1.entity.OutputDTO;
import com.myproject.serviceservice1.entity.Records;
import com.myproject.serviceservice1.service.JsonService;
import com.myproject.serviceservice1.service.WriteFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Service001Controller {
    @Autowired
    private JsonService jsonService;
    @Autowired
    private WriteFileService writeFileService;

    @PostMapping("/writeJson")
    public OutputDTO writeJson(@RequestBody Records records) {
        return jsonService.writeJson(records);
    }

    @PostMapping("/writeFileToPC")
    public void writeFileToPC(@RequestBody Records records, String path) throws Exception {
        writeFileService.writeFileToPC(path, records);
    }

    @PostMapping(value = "/writeFileToDownload", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] writeFileToDownLoad(@RequestBody Records records) throws IOException {
        return writeFileService.writeFileToDownload(records);
    }
}