package com.neustar.droolsdemo.controller;

import com.neustar.droolsdemo.dto.DirectoryNumberDto;
import com.neustar.droolsdemo.dto.UserDataDto;
import com.neustar.droolsdemo.dto.UserDataTypeDto;
import com.neustar.droolsdemo.service.DirectoryNumberService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private KieContainer kieContainer;

    @GetMapping
    public UserDataTypeDto test(){
        UserDataTypeDto userDataTypeDto = new UserDataTypeDto();
        userDataTypeDto.setId(333l);
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(userDataTypeDto);
        kieSession.fireAllRules();
        kieSession.dispose();
        return userDataTypeDto;
    }
}
