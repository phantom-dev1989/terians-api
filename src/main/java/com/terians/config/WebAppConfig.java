package com.terians.config;

import com.terians.neo4j.repository.*;
import com.terians.neo4j.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


@Configuration
public class WebAppConfig {

    /**
     * inclusion The PropertySourcesPlaceholderConfigurer automatically lets the
     * annotation included property files to be scanned. setting it static to
     * spawn on startup.
     *
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer ph = new PropertySourcesPlaceholderConfigurer();

        ph.setIgnoreUnresolvablePlaceholders(true);

        return ph;
    }

    @Bean
    public ClazzService clazzService() {

        return new ClazzServiceImpl();
    }

    @Bean
    public IssueService issueService() {

        return new IssueServiceImpl();
    }

    @Bean
    public MethodService methodService() {

        return new MethodServiceImpl();
    }

    @Bean
    public PackageService packageService() {

        return new PackageServiceImpl();
    }

    @Bean
    public VulnerabilityService vulnerabilityService() {

        return new VulnerabilityServiceImpl();
    }

    @Bean
    public ScanService scanService() {

        return new ScanServiceImpl();
    }

    @Bean
    public DependencyService dependencyService() {

        return new DependencyServiceImpl();
    }

    @Bean
    public ProjectService projectService() {

        return new ProjectServiceImpl();
    }

}
