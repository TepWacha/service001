package com.myproject.serviceservice1.service;

import com.myproject.serviceservice1.entity.InputKeyAndValue;
import com.myproject.serviceservice1.entity.OutputDTO;
import com.myproject.serviceservice1.entity.Records;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JsonService {
    public OutputDTO writeJson(Records records) {
        OutputDTO output = new OutputDTO();
        List<String> outputString = new ArrayList<>();
        for (InputKeyAndValue inputKeyAndValue : records.getRecords()) {
            outputString.add(inputKeyAndValue.getKey() + " is " + inputKeyAndValue.getValue());
        }
        output.setOutput(outputString);
        return output;
    }
}