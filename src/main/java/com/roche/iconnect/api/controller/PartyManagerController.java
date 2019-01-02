package com.roche.iconnect.api.controller;

import com.roche.iconnect.api.domain.entity.PartyManager;
import com.roche.iconnect.api.domain.repository.PartyManagerRepository;
import com.roche.iconnect.api.service.intf.PartyManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PartyManagerController {

    @Autowired
    private PartyManagerService service;

    @Autowired
    private PartyManagerRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<PartyManager> partymanager(@PathVariable String id){
        Optional<PartyManager> partyManager = repository.findById(id);
        return ResponseEntity.ok(partyManager.get());
    }

    @PostMapping
    public ResponseEntity.BodyBuilder partymanager(@RequestBody PartyManager pm){
        PartyManager partyManager = repository.save(pm);
        return ResponseEntity.ok();
    }
}
