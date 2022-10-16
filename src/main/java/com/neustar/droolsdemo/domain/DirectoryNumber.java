package com.neustar.droolsdemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DIRECTORY_NUMBER")
public class DirectoryNumber {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    String dn;
    String resourceState;
    int currentOcn;

    @OneToMany(mappedBy = "directoryNumber")
    Set<UserData> userData = new HashSet<>();

}
