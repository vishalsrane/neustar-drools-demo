package com.neustar.droolsdemo.service;

import com.neustar.droolsdemo.domain.DirectoryNumber;
import com.neustar.droolsdemo.dto.DirectoryNumberDto;
import com.neustar.droolsdemo.repository.DirectoryNumberRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DirectoryNumberService {

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private DirectoryNumberRepository directoryNumberRepository;

    Map<String, String> actionMapping = new HashMap<String, String>() {{
        put("CANCEL-RESERVE", "AVAILABLE");
    }};

    public DirectoryNumberDto saveDirectoryNumber(DirectoryNumberDto directoryNumberDto){
        DirectoryNumber directoryNumber = DirectoryNumberDto.dtoToDomain(directoryNumberDto);
        directoryNumber = directoryNumberRepository.save(directoryNumber);
        directoryNumberDto = DirectoryNumberDto.domainToDto(directoryNumber);
        return directoryNumberDto;
    }

    public List<DirectoryNumberDto> findAll(){
        List<DirectoryNumber> myList = directoryNumberRepository.findAllByOrderById();
        List<DirectoryNumberDto> set =  myList.stream()
                .map( directoryNumber -> DirectoryNumberDto.domainToDto(directoryNumber)).collect(Collectors.toList());
        return set;
    }

    public DirectoryNumberDto processDN(DirectoryNumberDto directoryNumberDto) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(directoryNumberDto);
        kieSession.fireAllRules();
        kieSession.dispose();
        return directoryNumberDto;
    }

    public String updateState(Long id, String action){
        DirectoryNumber directoryNumber = directoryNumberRepository.findById(id).get();
        String newState = this.actionMapping.get(action);
        directoryNumber.setResourceState(newState);
        directoryNumberRepository.save(directoryNumber);
        DirectoryNumberDto directoryNumberDto = DirectoryNumberDto.domainToDto(directoryNumber);
        directoryNumberDto = applyStr(directoryNumberDto);
        String stateAfterApplyingStr = directoryNumberDto.getResourceState();
        directoryNumberDto.setAction(action);
        if(!newState.equalsIgnoreCase(stateAfterApplyingStr)){
            directoryNumber.setResourceState(stateAfterApplyingStr);
            directoryNumberRepository.save(directoryNumber);
        }
        return "Updated to State -- > " + stateAfterApplyingStr;
    }

    public DirectoryNumberDto applyStr(DirectoryNumberDto directoryNumberDto){
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(directoryNumberDto);
        kieSession.fireAllRules();
        kieSession.dispose();
        return directoryNumberDto;
    }
}
