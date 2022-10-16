package com.neustar.droolsdemo.repository;


import com.neustar.droolsdemo.domain.UserDataType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataTypeRepository extends CrudRepository<UserDataType, Long> {

}
