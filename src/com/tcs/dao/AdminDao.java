/**
 * 
 */
package com.tcs.dao;

import com.tcs.exception.CourseAlreadyExists;
import com.tcs.exception.ProfessorAlreadyExists;
import com.tcs.exception.CourseNotFound;
import com.tcs.exception.StudentGradesNotFound;
import com.tcs.exception.ProfessorNotFound;



/**
 * @author Administrator
 *
 */

/*
 * @interface: AdminDao
 * @method: approveRegistration to approve the student by admin.
 * @method: addcourse- admin can add course into catalogue.
 * @method: addprofessor - admin can add new professor .
 * @method: listprofessor -admin can see all the professors.
 * @method: listcourses -admin can see all the courses.
 * @method: removecourse - admin can remove the course from catalogue.
 * @method: gradecard - admin can generate the gradecard for a particular student.
 * 
 */

public interface AdminDao {
	
	public void approveRegistration();
	public void addCourse(int cid,String cname,String pname,String dept,String pre) throws CourseAlreadyExists;
	public void addProfessor(int pid,String pname,String ppswd,String dept) throws ProfessorAlreadyExists;
	public void listProfessor() throws ProfessorNotFound;
	public void listCourses() throws CourseNotFound;
	public void removeCourse(int inp) throws CourseNotFound;
	public void gradeCard(int sid,String sname) throws StudentGradesNotFound;
	
}
