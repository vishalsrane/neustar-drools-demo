package com.neustar.droolsdemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_data_type")
public class UserDataType {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    private String userDataKey;

    @JsonIgnore
    @OneToMany(mappedBy = "userDataType")
    private Set<UserData> userDataSet;
}
