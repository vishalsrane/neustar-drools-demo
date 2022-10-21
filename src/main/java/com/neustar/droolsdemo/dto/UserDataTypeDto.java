package com.neustar.droolsdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neustar.droolsdemo.domain.UserData;
import com.neustar.droolsdemo.domain.UserDataType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Set;

public class UserDataTypeDto {
    private Long id;
    private String userDataKey;

    public UserDataTypeDto(Long id, String userDataKey) {
        this.id = id;
        this.userDataKey = userDataKey;
    }

    public UserDataTypeDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserDataKey() {
        return userDataKey;
    }

    public void setUserDataKey(String userDataKey) {
        this.userDataKey = userDataKey;
    }

    public static UserDataType dtoToDomain(UserDataTypeDto userDataTypeDto){
        UserDataType userDataType = new UserDataType();
        BeanUtils.copyProperties(userDataTypeDto, userDataType, "userDataSet");
        return  userDataType;
    }

    public static  UserDataTypeDto domainToDto(UserDataType userDataType){
        UserDataTypeDto userDataTypeDto = new UserDataTypeDto();
        BeanUtils.copyProperties(userDataType, userDataTypeDto, "userDataSet");
        return userDataTypeDto;
    }
}
