package com.neustar.droolsdemo.dto;

import com.neustar.droolsdemo.domain.DirectoryNumber;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DirectoryNumberDto {

    private Long id;

    private String dn;
    private String resourceState;
    private Integer currentOcn;

    Set<UserDataDto> userData = new HashSet<>();

    private String action;

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
