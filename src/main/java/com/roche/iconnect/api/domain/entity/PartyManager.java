package com.roche.iconnect.api.domain.entity;


import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Document(collection = "partymanager")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartyManager {

    @Id
    private String emailid;
    private String firstname;
    private String lastname;
    private String address;
}
