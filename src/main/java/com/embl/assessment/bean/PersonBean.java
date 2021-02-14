package com.embl.assessment.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Bean definition for the Person Information
 */
public class PersonBean implements Serializable {
    
    /**
     * Default Serial ID
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Person Information
     */
    private List<PersonInfoBean> person;
    
    /**
     * Method for getting Person Information
     * @return
     */
    public List<PersonInfoBean> getPerson() {
        return person;
    }
    
    /**
     * Method for setting the Person Information
     * @param person
     */
    public void setPerson(List<PersonInfoBean> person) {
        this.person = person;
    }
}
