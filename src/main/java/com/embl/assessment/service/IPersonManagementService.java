package com.embl.assessment.service;

import java.util.List;

import com.embl.assessment.bean.PersonBean;
import com.embl.assessment.bean.PersonInfoBean;
import com.embl.assessment.exception.PersonException;

/**
 * Interface definition for Person Management
 */
public interface IPersonManagementService {

	/**
	 * Method for adding the Person Information.
	 * 
	 * @param personBean
	 * @return
	 * @throws Exception
	 */
	PersonInfoBean add(PersonInfoBean personBean) throws PersonException;
	
	   /**
     * Method for adding the Person Information.
     * 
     * @param personBean
     * @return
     * @throws Exception
     */
    void add(PersonBean personBean) throws PersonException;

	/**
	 * Method for updating the Person Information
	 * 
	 * @param personId
	 * @param personBean
	 * @return
	 * @throws Exception
	 */
	PersonInfoBean update(long personId, PersonInfoBean personBean) throws PersonException;

	/**
	 * Method for deleting the Person Information
	 * 
	 * @param personId
	 * @throws Exception
	 */
	void delete(long personId) throws PersonException;

	/**
	 * Method for fetching all the Person Information
	 * 
	 * @return
	 * @throws Exception
	 */
	List<PersonInfoBean> getAll() throws PersonException;

	/**
	 * Method for fetching the Person Information by ID
	 * 
	 * @param personId
	 * @return
	 * @throws Exception
	 */
	PersonInfoBean getById(long personId) throws PersonException;
}