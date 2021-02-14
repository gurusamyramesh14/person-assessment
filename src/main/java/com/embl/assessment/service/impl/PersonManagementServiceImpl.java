package com.embl.assessment.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.embl.assessment.bean.PersonBean;
import com.embl.assessment.bean.PersonInfoBean;
import com.embl.assessment.entity.Person;
import com.embl.assessment.exception.PersonException;
import com.embl.assessment.repository.PersonRepository;
import com.embl.assessment.service.IPersonManagementService;

/**
 * Service Implementation for Person Management Operations
 */
@Service public class PersonManagementServiceImpl implements IPersonManagementService {
    
    /**
     * Logger Object Definition
     */
    Logger logger = LoggerFactory.getLogger(getClass().getName());
    
    /**
     * Person Repository Object
     */
    @Autowired PersonRepository personRepository;
    
    /**
     * Method for adding the Person Information.
     * @param personBean
     * @return
     * @throws Exception
     */
    @Override public void add(PersonBean personBean) throws PersonException {
        
        try {
            
            // Check whether the Person Information is available or not
            if (null != personBean && null != personBean.getPerson() && !personBean.getPerson().isEmpty()) {
                
                // Iterate the Person Information
                for (PersonInfoBean personInfo: personBean.getPerson()) {
                    
                    // Define the Person Entity Object
                    Person person = new Person();
                    
                    // Populate the details from the request bean into Entity
                    person.setFirst_name(personInfo.getFirst_name());
                    person.setLast_name(personInfo.getLast_name());
                    person.setAge(personInfo.getAge());
                    person.setFavourite_colour(personInfo.getFavourite_colour());
                    
                    // Invoke the Save Operation
                    personRepository.save(person);
                    
                }
                
            } else {
                
                // Throw the exception for empty input.,
                throw new PersonException("");
            }
            
        } catch (Exception e) {
            
            // Check whether the caught exception is User Defined.,
            if (e.getClass().isAssignableFrom(PersonException.class)) {
                
                // Throw the exception.
                throw e;
            }
            
            // Log the Exception and re-throw the Exception
            logger.error("Excetion while adding the Person List - {}", e);
            throw new PersonException("Excetion while adding the Person List: ", e);
        }
    }
    
    /**
     * Method for adding the Person Information.
     * @param personBean
     * @return
     * @throws Exception
     */
    @Override public PersonInfoBean add(PersonInfoBean personBean) throws PersonException {
        
        try {
            
            // Define the Person Entity Object
            Person person = new Person();
            
            // Populate the details from the request bean into Entity
            person.setFirst_name(personBean.getFirst_name());
            person.setLast_name(personBean.getLast_name());
            person.setAge(personBean.getAge());
            person.setFavourite_colour(personBean.getFavourite_colour());
            
            // Invoke the Save Operation
            person = personRepository.save(person);
            
            // Return the final output.
            return convertEntityInToBean(person);
            
        } catch (Exception e) {
            
            // Check whether the caught exception is User Defined.,
            if (e.getClass().isAssignableFrom(PersonException.class)) {
                
                // Throw the exception.
                throw e;
            }
            
            // Log the Exception and re-throw the Exception
            logger.error("Excetion while adding the Person Information - {}", e);
            throw new PersonException("Excetion while adding the Person Information: ", e);
        }
    }
    
    /**
     * Method for updating the Person Information
     * @param personId
     * @param personBean
     * @return
     * @throws Exception
     */
    @Override public PersonInfoBean update(long personId, PersonInfoBean personBean) throws PersonException {
        
        try {
            
            // Define the Person Entity Object
            Optional<Person> personOpt = personRepository.findById(personId);
            
            // Check whether the Person Information is available or not
            if (!personOpt.isPresent()) {
                
                // Stop the Execution
                throw new PersonException("Person Information not found");
            }
            
            // Fetch the person information
            Person person = personOpt.get();
            
            // Populate the details from the request bean into Entity
            if (null != personBean.getFirst_name() && !personBean.getFirst_name().isEmpty())
                person.setFirst_name(personBean.getFirst_name());
            
            if (null != personBean.getLast_name() && !personBean.getLast_name().isEmpty())
                person.setLast_name(personBean.getLast_name());
            
            if (personBean.getAge() > 0)
                person.setAge(personBean.getAge());
            
            if (null != personBean.getFavourite_colour() && !personBean.getFavourite_colour().isEmpty())
                person.setFavourite_colour(personBean.getFavourite_colour());
            
            // Invoke the Save Operation
            person = personRepository.save(person);
            
            // Return the final output.
            return convertEntityInToBean(person);
            
        } catch (Exception e) {
            
            // Check whether the caught exception is User Defined.,
            if (e.getClass().isAssignableFrom(PersonException.class)) {
                
                // Throw the exception.
                throw e;
            }
            
            // Log the Exception and re-throw the Exception
            logger.error("Excetion while updating the Person Information - {}", e);
            throw new PersonException("", e);
        }
    }
    
    /**
     * Method for deleting the Person Information
     * @param personId
     * @throws Exception
     */
    @Override public void delete(long personId) throws PersonException {
        
        try {
            
            // Define the Person Entity Object
            Optional<Person> personOpt = personRepository.findById(personId);
            
            // Check whether the Person Information is available or not
            if (!personOpt.isPresent()) {
                
                // Stop the Execution
                throw new PersonException("Person Information not found");
            }
            
            // Fetch the person information
            Person person = personOpt.get();
            
            // Invoke the Delete Operation
            personRepository.delete(person);
            
        } catch (Exception e) {
            
            // Check whether the caught exception is User Defined.,
            if (e.getClass().isAssignableFrom(PersonException.class)) {
                
                // Throw the exception.
                throw e;
            }
            
            // Log the Exception and re-throw the Exception
            logger.error("Excetion while deleting the Person Information - {}", e);
            throw new PersonException("", e);
        }
    }
    
    /**
     * Method for fetching all the Person Information
     * @return
     * @throws Exception
     */
    @Override public List<PersonInfoBean> getAll() throws PersonException {
        
        try {
            
            // Person List Object
            List<Person> personList = new ArrayList<Person>();
            
            // Person Bean List Object
            List<PersonInfoBean> personBeanList = new ArrayList<PersonInfoBean>();
            
            // Fetch all the records and add to the list
            personRepository.findAll().forEach(personList::add);
            
            personList.forEach(person -> {
                personBeanList.add(convertEntityInToBean(person));
            });
            
            // Return the final output.
            return personBeanList;
            
        } catch (Exception e) {
            
            // Check whether the caught exception is User Defined.,
            if (e.getClass().isAssignableFrom(PersonException.class)) {
                
                // Throw the exception.
                throw e;
            }
            
            // Log the Exception and re-throw the Exception
            logger.error("Excetion while listing the Person Information - {}", e);
            throw new PersonException("", e);
        }
    }
    
    /**
     * Method for fetching the Person Information by ID
     * @param personId
     * @return
     * @throws Exception
     */
    @Override public PersonInfoBean getById(long personId) throws PersonException {
        
        try {
            
            // Define the Person Entity Object
            Optional<Person> personOpt = personRepository.findById(personId);
            
            
            // Check whether the Person Information is available or not
            if (!personOpt.isPresent()) {
                
                // Stop the Execution
                throw new PersonException("Person Information not found");
            }

            // Get the Person details
            Person person = personOpt.get();

            // Return the final output.
            return convertEntityInToBean(person);
            
        } catch (Exception e) {
            
            // Check whether the caught exception is User Defined.,
            if (e.getClass().isAssignableFrom(PersonException.class)) {
                
                // Throw the exception.
                throw e;
            }
            
            // Log the Exception and re-throw the Exception
            logger.error("Excetion while fetching the Person Information by ID - {}", e);
            throw new PersonException("", e);
        }
    }
    
    /**
     * Method for converting the Person Entity into Person Bean
     * @param person
     * @return
     * @throws Exception
     */
    private PersonInfoBean convertEntityInToBean(Person person) {
        
        // Define the bean
        PersonInfoBean bean = new PersonInfoBean();
        
        // Populate the basic information
        bean.setId(person.getId());
        bean.setFirst_name(person.getFirst_name());
        bean.setLast_name(person.getLast_name());
        bean.setFavourite_colour(person.getFavourite_colour());
        bean.setAge((int) person.getAge());
        
        // Populate the Person ID.
        bean.setId(person.getId());
        
        // Return the bean
        return bean;
    }
}
