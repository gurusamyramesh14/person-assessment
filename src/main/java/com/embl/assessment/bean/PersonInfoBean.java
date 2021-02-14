package com.embl.assessment.bean;

import java.io.Serializable;

/**
 * Bean definition for the Person Information
 */
public class PersonInfoBean implements Serializable {
    
    /**
     * Default Serial ID
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Unique Identifier
     */
    private Long id;
    
    /**
     * First Name
     */
    private String first_name;
    
    /**
     * Last Name
     */
    private String last_name;
    
    /**
     * Age
     */
    private int age;
    
    /**
     * Favorite Color
     */
    private String favourite_colour;
    
    /**
     * Method for getting the Unique ID
     * @return
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Method for setting the Unique ID
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Method for getting the First Name
     * @return
     */
    public String getFirst_name() {
        return first_name;
    }
    
    /**
     * Method for setting the First Name
     * @param first_name
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    
    /**
     * Method for getting the Last Name
     * @return
     */
    public String getLast_name() {
        return last_name;
    }
    
    /**
     * Method for setting the Last Name
     * @param last_name
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    
    /**
     * Method for getting the Age
     * @return
     */
    public int getAge() {
        return age;
    }
    
    /**
     * Method for setting the Age
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    /**
     * Method for getting the Favorite Color
     * @return
     */
    public String getFavourite_colour() {
        return favourite_colour;
    }
    
    /**
     * Method for setting the Favorite Color
     * @param favourite_colour
     */
    public void setFavourite_colour(String favourite_colour) {
        this.favourite_colour = favourite_colour;
    }
}
