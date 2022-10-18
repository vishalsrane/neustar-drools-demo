package com.neustar.droolsdemo.repository;

import com.neustar.droolsdemo.domain.DirectoryNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DirectoryNumberRepository extends CrudRepository<DirectoryNumber, Long> {
    List<DirectoryNumber> findAllByOrderById();


}
