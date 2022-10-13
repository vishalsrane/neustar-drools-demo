package com.neustar.droolsdemo.service;

import com.neustar.droolsdemo.dto.DirectoryNumber;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectoryNumberService {

    private final KieContainer kieContainer;

    @Autowired
    public DirectoryNumberService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public DirectoryNumber processDN(DirectoryNumber directoryNumber) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(directoryNumber);
        kieSession.fireAllRules();
        kieSession.dispose();
        return directoryNumber;
    }
}
