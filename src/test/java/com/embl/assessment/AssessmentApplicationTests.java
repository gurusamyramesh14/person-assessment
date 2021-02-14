package com.embl.assessment;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.embl.assessment.bean.PersonInfoBean;
import com.embl.assessment.service.IPersonManagementService;

/**
 * JUnit Test class implementation
 */
@SpringBootTest class AssessmentApplicationTests {
    
    /**
     * Person Management Service
     */
    @Autowired IPersonManagementService personManagementService;
    
    /**
     * Method for loading the context
     * @throws Exception
     */
    @Test public void contextLoads() throws Exception {
        assertThat(personManagementService).isNotNull();
    }
    
    /**
     * Test method for adding the person entity
     * @throws Exception
     */
    @Test public void addPerson() throws Exception {
        PersonInfoBean person = new PersonInfoBean();
        person.setFirst_name("Test");
        person.setLast_name("Test");
        person.setAge(24);
        person.setFavourite_colour("Blue");
        assertThat(personManagementService.add(person)).isNotNull();
    }
    
    /**
     * Test method for fetching all the person entity from the application
     * @throws Exception
     */
    @Test public void getAllPerson() throws Exception {
        assertThat(personManagementService.getAll()).isNotNull();
    }

    /**
     * Test method for updating the person information
     * @throws Exception
     */
    @Test public void updatePerson() throws Exception {
        
        PersonInfoBean person = new PersonInfoBean();
        person.setFirst_name("Test");
        person.setLast_name("Test");
        person.setAge(24);
        person.setFavourite_colour("Blue");
        person = personManagementService.add(person);
        person.setFirst_name("Test-new");
        person.setLast_name("Test-new");
        assertThat(personManagementService.update(person.getId(), person)).isNotNull();
    }
}
