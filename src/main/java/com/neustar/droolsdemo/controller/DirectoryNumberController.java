package com.neustar.droolsdemo.controller;

import com.neustar.droolsdemo.dto.DirectoryNumber;
import com.neustar.droolsdemo.service.DirectoryNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectoryNumberController {

    private DirectoryNumberService directoryNumberService;

    @Autowired
    public DirectoryNumberController(DirectoryNumberService directoryNumberService){
        this.directoryNumberService = directoryNumberService;
    }

    @PostMapping("/directory-number")
    private DirectoryNumber getDiscountPercent(@RequestBody DirectoryNumber directoryNumber) {
        return this.directoryNumberService.processDN(directoryNumber);
//        return directoryNumber;
    }
}
