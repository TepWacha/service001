package com.myproject.serviceservice1.service;

import com.myproject.serviceservice1.entity.MyInput;
import com.myproject.serviceservice1.entity.Output;
import com.myproject.serviceservice1.entity.Records;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyService {
    public Output report(Records records){
        Output outputt = new Output();
        List<String> output = new ArrayList<>();
        for(MyInput m : records.getRecords()){
            output.add(m.getKey()+" is "+m.getValue());
        }
        outputt.setOutput(output);
        return outputt;
    }
}