package com.embl.assessment.controller.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.embl.assessment.bean.PersonBean;
import com.embl.assessment.bean.PersonInfoBean;
import com.embl.assessment.exception.PersonException;
import com.embl.assessment.service.IPersonManagementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Rest definition for the Person Management Operation
 */
@Api(value = "Person Management Service") @RestController @RequestMapping(
    value = "/person") public class PersonManagementRestService {
    
    /** Logger Object */
    Logger logger = LoggerFactory.getLogger(getClass().getName());
    
    /** Person Management Service */
    @Autowired IPersonManagementService personService;
    
    @ApiOperation(httpMethod = "POST", value = "API Endpoint for bulk adding the Person details",
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) @PostMapping(
            value = "/add/bulk", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.ALL_VALUE) public
        ResponseEntity<String> addBulk(@RequestBody PersonBean personBean) throws PersonException {
        
        try {
            
            // Invoke the Person Service for adding the Person.
            personService.add(personBean);
            
            // Return the Person Information in the Response.
            return ResponseEntity.status(HttpStatus.CREATED).build();
            
        } catch (Exception e) {
            
            // Log the exception
            logger.error("Error occurred while bulk adding the Person - {}", e, e);
            
            // Return the Exception Status
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }
    
    /**
     * API end-point definition for adding Person
     * @param personBean
     * @return
     * @throws Exception
     */
    @ApiOperation(httpMethod = "POST", value = "API Endpoint for adding the Person Information",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE) @PostMapping(value = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) public
        ResponseEntity<PersonInfoBean> add(@RequestBody PersonInfoBean personBean) throws PersonException {
        
        // Person Object
        PersonInfoBean person = null;
        
        try {
            
            // Invoke the Person Service for adding the Person.
            person = personService.add(personBean);
            
            // Return the Person Information in the Response.
            return ResponseEntity.status(HttpStatus.CREATED).body(person);
            
        } catch (Exception e) {
            
            // Log the exception
            logger.error("Error occurred while adding the Person - {}", e, e);
            
            // Return the Exception Status
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }
    
    /**
     * API end-point definition for adding Person
     * @param personBean
     * @return
     * @throws Exception
     */
    @ApiOperation(httpMethod = "PUT", value = "API Endpoint for updating the Person Information",
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) @PutMapping(
            value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE) public
        ResponseEntity<PersonInfoBean> update(@PathVariable("id") long personId, @RequestBody PersonInfoBean personBean)
            throws Exception {
        
        // Person Object
        PersonInfoBean person = null;
        
        try {
            
            // Invoke the Person Service for adding the Person.
            person = personService.update(personId, personBean);
            
            // Return the Person Information in the Response.
            return ResponseEntity.status(HttpStatus.OK).body(person);
            
        } catch (Exception e) {
            
            // Log the exception
            logger.error("Error occurred while adding the Person - {}", e, e);
            
            // Return the Exception Status
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }
    
    /**
     * API end-point definition for adding Person
     * @param personBean
     * @return
     * @throws Exception
     */
    @ApiOperation(httpMethod = "DELETE", value = "API Endpoint for deleting the Person Information",
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) @DeleteMapping(
            value = "/delete/{id}", produces = MediaType.ALL_VALUE) public
        ResponseEntity<PersonInfoBean> delete(@PathVariable("id") long personId) throws Exception {
        
        try {
            
            // Invoke the Person Service for adding the Person.
            personService.delete(personId);
            
            // Return the Person Information in the Response.
            return ResponseEntity.status(HttpStatus.OK).build();
            
        } catch (Exception e) {
            
            // Log the exception
            logger.error("Error occurred while adding the Person - {}", e, e);
            
            // Return the Exception Status
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }
    
    /**
     * API end-point definition for adding Person
     * @param personBean
     * @return
     * @throws Exception
     */
    @ApiOperation(httpMethod = "GET", value = "API Endpoint for getting all the Person Information",
        produces = MediaType.APPLICATION_JSON_VALUE) @GetMapping(value = "/get",
            produces = MediaType.APPLICATION_JSON_VALUE) public
        ResponseEntity<List<PersonInfoBean>> getAll() throws Exception {
        
        // Person Object
        List<PersonInfoBean> personList = null;
        
        try {
            
            // Invoke the Person Service for adding the Person.
            personList = personService.getAll();
            
            // Return the Person Information in the Response.
            return ResponseEntity.status(HttpStatus.OK).body(personList);
            
        } catch (Exception e) {
            
            // Log the exception
            logger.error("Error occurred while adding the Person - {}", e, e);
            
            // Return the Exception Status
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }
    
    /**
     * API end-point definition for adding Person
     * @param personBean
     * @return
     * @throws Exception
     */
    @ApiOperation(httpMethod = "GET", value = "API Endpoint for getting the Person Information by specific ID",
        produces = MediaType.APPLICATION_JSON_VALUE) @GetMapping(value = "/get/id/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE) public
        ResponseEntity<PersonInfoBean> getById(@PathVariable("id") long personId) throws Exception {
        
        // Person Object
        PersonInfoBean person = null;
        
        try {
            
            // Invoke the Person Service for adding the Person.
            person = personService.getById(personId);
            
            // Return the Person Information in the Response.
            return ResponseEntity.status(HttpStatus.OK).body(person);
            
        } catch (Exception e) {
            
            // Log the exception
            logger.error("Error occurred while adding the Person - {}", e, e);
            
            // Return the Exception Status
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }
}
