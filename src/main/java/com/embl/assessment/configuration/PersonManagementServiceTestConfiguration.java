package com.embl.assessment.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.embl.assessment.service.IPersonManagementService;

/**
 * Configuration class for the JUnit test classes
 */
@Profile("test") @Configuration public class PersonManagementServiceTestConfiguration {
    
    /**
     * Bean definition for the Person Management Service
     * @return
     */
    @Bean @Primary public IPersonManagementService personManagementService() {
        return Mockito.mock(IPersonManagementService.class);
    }
}
