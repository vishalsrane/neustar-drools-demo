package com.neustar.droolsdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectoryNumber {

    private String id;

    private String dn;
    private String sim;
    private int customerNumber;
    private String customerName;



}
