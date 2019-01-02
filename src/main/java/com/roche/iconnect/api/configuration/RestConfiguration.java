package com.roche.iconnect.api.configuration;

import org.apache.catalina.valves.ExtendedAccessLogValve;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;

@Configuration
public class RestConfiguration implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    @Value("${rest.config.max-page-size}")
    private int maxPageSize;

    @Value("${rest.config.default-page-size}")
    private int defaultPageSize;

    @NotNull
    @Value("${accessLogValve.directory}")
    private String accessLogDirectory;

    @NotNull
    @Value("${accessLogValve.pattern}")
    private String accessLogPattern;

    @NotNull
    @Value("${accessLogValve.suffix}")
    private String accessLogSuffix;

    @NotNull
    @Value("${accessLogValve.prefix}")
    private String accessLogPrefix;

    @NotNull
    @Value("${accessLogValve.rotatable}")
    private Boolean accessLogRotatable;

    @NotNull
    @Value("${accessLogValve.fileDateFormat}")
    private String accessLogFileDateFormat;

    @Override
    public void customize(TomcatServletWebServerFactory container) {
        ExtendedAccessLogValve accessLogValve = new ExtendedAccessLogValve();
        accessLogValve.setDirectory(accessLogDirectory);
        accessLogValve.setPattern(accessLogPattern);
        accessLogValve.setSuffix(accessLogSuffix);
        accessLogValve.setPrefix(accessLogPrefix);
        accessLogValve.setRotatable(accessLogRotatable);
        accessLogValve.setFileDateFormat(accessLogFileDateFormat);
        container.addContextValves(accessLogValve);
    }

    public void setMaxPageSize(int maxPageSize) {
        this.maxPageSize = maxPageSize;
    }

    public void setDefaultPageSize(int defaultPageSize) {
        this.defaultPageSize = defaultPageSize;
    }

    public void setAccessLogDirectory(String accessLogDirectory) {
        this.accessLogDirectory = accessLogDirectory;
    }

    public void setAccessLogPattern(String accessLogPattern) {
        this.accessLogPattern = accessLogPattern;
    }

    public void setAccessLogSuffix(String accessLogSuffix) {
        this.accessLogSuffix = accessLogSuffix;
    }

    public void setAccessLogPrefix(String accessLogPrefix) {
        this.accessLogPrefix = accessLogPrefix;
    }

    public void setAccessLogRotatable(Boolean accessLogRotatable) {
        this.accessLogRotatable = accessLogRotatable;
    }

    public void setAccessLogFileDateFormat(String accessLogFileDateFormat) {
        this.accessLogFileDateFormat = accessLogFileDateFormat;
    }
}
