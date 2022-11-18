/**
 * 
 */
package com.tcs.exception;

/**
 * @author Administrator
 *
 */
public class StudentAlreadyExists extends Exception {
private static final long serialVersionUID = 1L;
	
	
	private int studentId;
	   public StudentAlreadyExists(int studentId)
	   {
	      this.studentId = studentId;
	   } 
	   public int getStudentId()
	   {
	      return studentId;
	   }


}
