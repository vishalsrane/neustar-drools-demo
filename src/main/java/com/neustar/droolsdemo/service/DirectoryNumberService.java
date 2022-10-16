package com.neustar.droolsdemo.service;

import com.neustar.droolsdemo.domain.DirectoryNumber;
import com.neustar.droolsdemo.dto.DirectoryNumberDto;
import com.neustar.droolsdemo.repository.DirectoryNumberRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DirectoryNumberService {

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private DirectoryNumberRepository directoryNumberRepository;

    public DirectoryNumberDto saveDirectoryNumber(DirectoryNumberDto directoryNumberDto){
        DirectoryNumber directoryNumber = DirectoryNumberDto.dtoToDomain(directoryNumberDto);
        directoryNumber = directoryNumberRepository.save(directoryNumber);
        directoryNumberDto = DirectoryNumberDto.domainToDto(directoryNumber);
        return directoryNumberDto;
    }

    public Set<DirectoryNumberDto> findAll(){
        Iterable<DirectoryNumber> iterable = directoryNumberRepository.findAll();
        Set<DirectoryNumberDto> set =  StreamSupport.stream(iterable.spliterator(), false)
                .map( directoryNumber -> DirectoryNumberDto.domainToDto(directoryNumber)).collect(Collectors.toSet());
        return set;
    }

    public DirectoryNumberDto processDN(DirectoryNumberDto directoryNumberDto) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(directoryNumberDto);
        kieSession.fireAllRules();
        kieSession.dispose();
        return directoryNumberDto;
    }
}
