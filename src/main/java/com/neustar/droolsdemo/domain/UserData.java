package com.neustar.droolsdemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_data")
public class UserData {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_data_type_id")
    private UserDataType userDataType;

    private String userData;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "directory_number_id")
    private DirectoryNumber directoryNumber;
}
