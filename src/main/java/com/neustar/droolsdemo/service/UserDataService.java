package com.neustar.droolsdemo.service;


import com.neustar.droolsdemo.domain.UserDataType;
import com.neustar.droolsdemo.dto.UserDataDto;
import com.neustar.droolsdemo.repository.UserDataTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataService {

    UserDataTypeRepository userDataTypeRepository;

    @Autowired
    public UserDataService(UserDataTypeRepository userDataTypeRepository){
        this.userDataTypeRepository = userDataTypeRepository;
    }

//     public UserDataType addUserDataType(UserDataDto userDataDto){
//        UserDataType userDataType = new UserDataType();
//        userDataType = UserDataDto.dtoToDomain(userDataDto);
//        return userDataTypeRepository.save(userDataType);
//    }

}
