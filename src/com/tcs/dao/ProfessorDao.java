/**
 * 
 */
package com.tcs.dao;

/**
 * @author Administrator
 *
 */
/*
 * @interface: AdminDao
 * @method: viewEnrolledStudent -professor can see the students who registered for a particular course
 * @method: addGrades- professor can add grades.
 * 
 */

import com.tcs.exception.StudentNotFound;
public interface ProfessorDao {
	public void viewEnrolledStudent(int cid) throws StudentNotFound;
	public void addGrades(int sid) throws StudentNotFound;	
}
