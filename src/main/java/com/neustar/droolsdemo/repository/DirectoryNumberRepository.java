package com.neustar.droolsdemo.repository;

import com.neustar.droolsdemo.domain.DirectoryNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryNumberRepository extends CrudRepository<DirectoryNumber, Long> {

}
