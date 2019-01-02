package com.roche.iconnect.api.service.impl;

import com.roche.iconnect.api.service.intf.PartyManagerService;
import org.springframework.stereotype.Service;

@Service
public class PartyManagerServiceImpl implements PartyManagerService {
    @Override
    public void save() {
        System.out.println("saving to DB....");
    }
}
