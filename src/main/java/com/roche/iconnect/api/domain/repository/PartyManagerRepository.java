package com.roche.iconnect.api.domain.repository;

import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;
import com.roche.iconnect.api.domain.entity.PartyManager;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(collectionResourceRel = "partymanager", path = "partymanager")
public interface PartyManagerRepository extends DocumentDbRepository<PartyManager, String> {
    List<PartyManager> findByFirstname(String firstname);
}