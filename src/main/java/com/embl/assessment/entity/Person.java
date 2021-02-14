package com.embl.assessment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity definition for the Person details
 */
@Entity @Table(name = "PERSON") public class Person {
    
    /**
     * Primary key for Person details
     */
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
    
    /**
     * First Name
     */
    @Column(name = "FIRST_NAME", length = 50, nullable = false, unique = false) private String first_name;
    
    /**
     * Last Name
     */
    @Column(name = "LAST_NAME", length = 50, nullable = false, unique = false) private String last_name;
    
    /**
     * Age
     */
    @Column(name = "AGE", nullable = false, unique = false) private long age;
    
    /**
     * Favourite Colour
     */
    @Column(name = "FAVOURITE_COLOUR", length = 200, nullable = false, unique = false) private String favourite_colour;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFirst_name() {
        return first_name;
    }
    
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    
    public String getLast_name() {
        return last_name;
    }
    
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    
    public long getAge() {
        return age;
    }
    
    public void setAge(long age) {
        this.age = age;
    }
    
    public String getFavourite_colour() {
        return favourite_colour;
    }
    
    public void setFavourite_colour(String favourite_colour) {
        this.favourite_colour = favourite_colour;
    }
}
