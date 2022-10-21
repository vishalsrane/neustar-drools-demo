package com.neustar.droolsdemo.dto;

import com.neustar.droolsdemo.domain.DirectoryNumber;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class DirectoryNumberDto {

    private Long id;
    private String dn;
    private String resourceState;
    private Integer currentOcn;
    Set<UserDataDto> userData = new HashSet<>();
    private String action;

    public DirectoryNumberDto() {
    }

    public DirectoryNumberDto(Long id, String dn, String resourceState, Integer currentOcn, Set<UserDataDto> userData, String action) {
        this.id = id;
        this.dn = dn;
        this.resourceState = resourceState;
        this.currentOcn = currentOcn;
        this.userData = userData;
        this.action = action;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public String getResourceState() {
        return resourceState;
    }

    public void setResourceState(String resourceState) {
        this.resourceState = resourceState;
    }

    public Integer getCurrentOcn() {
        return currentOcn;
    }

    public void setCurrentOcn(Integer currentOcn) {
        this.currentOcn = currentOcn;
    }

    public Set<UserDataDto> getUserData() {
        return userData;
    }

    public void setUserData(Set<UserDataDto> userData) {
        this.userData = userData;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public static DirectoryNumber dtoToDomain(DirectoryNumberDto directoryNumberDto){
        DirectoryNumber directoryNumber = new DirectoryNumber();
        BeanUtils.copyProperties(directoryNumberDto, directoryNumber);
        return directoryNumber;
    }


    public static DirectoryNumberDto domainToDto(DirectoryNumber directoryNumber){
        DirectoryNumberDto directoryNumberDto = new DirectoryNumberDto();
        BeanUtils.copyProperties(directoryNumber, directoryNumberDto, "userDataSet" );
        Set<UserDataDto> userDataDtoSet = directoryNumber.getUserData().stream().map(userData -> {
            UserDataDto userDataDto = new UserDataDto();
            BeanUtils.copyProperties(userData, userDataDto, "userDataType");
            UserDataTypeDto userDataTypeDto = new UserDataTypeDto();
            BeanUtils.copyProperties(userData.getUserDataType(), userDataTypeDto);
            userDataDto.setUserDataType(userDataTypeDto);
            return userDataDto;
        }).collect(Collectors.toSet());


        directoryNumberDto.setUserData(userDataDtoSet);
        return directoryNumberDto;
    }


}
