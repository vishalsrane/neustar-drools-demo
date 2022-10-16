package com.neustar.droolsdemo.controller;


import com.neustar.droolsdemo.domain.UserDataType;
import com.neustar.droolsdemo.dto.UserDataDto;
import com.neustar.droolsdemo.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-data")
public class UserDataController {

    @Autowired
    UserDataService userDataService;


//    @PostMapping
//    public UserDataType createUserData(@RequestBody UserDataDto userDataDto){
//        return userDataService.addUserDataType(userDataDto);
//    }


}
