package com.roche.iconnect.api.configuration;

import com.microsoft.azure.spring.data.cosmosdb.config.AbstractDocumentDbConfiguration;
import com.microsoft.azure.spring.data.cosmosdb.config.DocumentDBConfig;
import com.microsoft.azure.spring.data.cosmosdb.repository.config.EnableDocumentDbRepositories;
import com.roche.iconnect.api.properties.DocumentDbProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDocumentDbRepositories
@EnableConfigurationProperties(DocumentDbProperties.class)
@PropertySource("application.yml")
public class PartyManagerRepositoryConfiguration extends AbstractDocumentDbConfiguration {

    @Autowired
    private DocumentDbProperties properties;

    @Override
    public DocumentDBConfig getConfig() {
        return DocumentDBConfig.builder(properties.getUri(), properties.getKey(), properties.getDatabase()).build();
    }
}