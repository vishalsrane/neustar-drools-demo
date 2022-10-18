package com.neustar.droolsdemo.controller;

import com.neustar.droolsdemo.dto.DirectoryNumberDto;
import com.neustar.droolsdemo.dto.MyObj;
import com.neustar.droolsdemo.service.DirectoryNumberService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/my-obj")
public class MyObjController {

    private DirectoryNumberService directoryNumberService;

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    public MyObjController(DirectoryNumberService directoryNumberService){
        this.directoryNumberService = directoryNumberService;
    }


    @GetMapping
    public MyObj test(){
        MyObj obj = new MyObj();
        obj.setId(456l);
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(obj);
        kieSession.fireAllRules();
        kieSession.dispose();
        return obj;
    }


}
