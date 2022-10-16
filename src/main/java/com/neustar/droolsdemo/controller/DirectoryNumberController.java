package com.neustar.droolsdemo.controller;

import com.neustar.droolsdemo.dto.DirectoryNumberDto;
import com.neustar.droolsdemo.service.DirectoryNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/directory-number")
public class DirectoryNumberController {

    private DirectoryNumberService directoryNumberService;

    @Autowired
    public DirectoryNumberController(DirectoryNumberService directoryNumberService){
        this.directoryNumberService = directoryNumberService;
    }


    @PostMapping
    public DirectoryNumberDto saveDN(@RequestBody DirectoryNumberDto directoryNumberDto){
        return directoryNumberService.saveDirectoryNumber(directoryNumberDto);
    }

    @GetMapping
    public Set<DirectoryNumberDto> findAll(){
        return this.directoryNumberService.findAll();
    }
}
