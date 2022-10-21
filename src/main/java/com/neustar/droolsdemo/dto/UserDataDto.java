package com.neustar.droolsdemo.dto;

import com.neustar.droolsdemo.domain.UserDataType;
//import lombok.*;
import org.springframework.beans.BeanUtils;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class UserDataDto {

    private Long id;

    private String userData;

    private UserDataTypeDto userDataType;


    public UserDataDto() {
    }
    public UserDataDto(Long id, String userData, UserDataTypeDto userDataType) {
        this.id = id;
        this.userData = userData;
        this.userDataType = userDataType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }

    public UserDataTypeDto getUserDataType() {
        return userDataType;
    }

    public void setUserDataType(UserDataTypeDto userDataType) {
        this.userDataType = userDataType;
    }

}

