package com.neustar.droolsdemo.dto;

import com.neustar.droolsdemo.domain.UserDataType;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDataDto {

    private Long id;

    private String userData;

    private UserDataType userDataType;

}

