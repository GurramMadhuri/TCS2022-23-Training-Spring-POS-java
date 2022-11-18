/**
 * 
 */
package com.tcs.constant;

/**
 * @author Administrator
 *
 */
  public class SQLConstants {

     /* AdminDaoImp1 SQL Queries starts here*/	
	  
    public static final String APPROVE_REGISTRATION="select * from registration where status=0";
    
    public static final String ADD_STUDENT_STUDENT_TABLE="insert into student values(?,?,?,?)";

    public static final String ADD_STUDENT_LOGIN_TABLE="insert into login values(?,?,?,?)";

    public static final String GET_COURSEID_CATALOGUE="select courseId from catalogue";
    
    public static final String ADD_COURSE_CATALOGUE="insert into catalogue values(?,?,?,?,?)";
    
    public static final String GET_PROFESSORID_PROFESSOR="select professorId from professor";
    
    public static final String ADD_PROFESSOR_PROFESSOR_TABLE="insert into professor values(?,?,?,?)";
    
    public static final String ADD_PROFESSOR_LOGIN_TABLE="insert into login values(?,?,?,?)";
    
    public static final String COUNT_PROFESSOR="select count(*) from professor";
    
    public static final String GET_PROFESSOR="select * from professor";

    public static final String COUNT_CATALOGUE="select count(*) from catalogue";
    
    public static final String GET_CATALOGUE="select * from catalogue";

    public static final String GET_COURSE_ID_NAME_CATALOGUE="select courseId,courseName from catalogue";

    public static final String GET_STUDENTID_GRADE="select studentId from grade";

    public static final String GET_GRADE_TABLE="select * from grade";

    public static final String ADD_RESULT_GRADECARD="insert into gradecard values(?,?,?)";
    
    /* AdminDaoImp1 SQL Queries ends here*/	




    /* ProfessorDaoImp1 SQL Queries starts here*/	

	public static final String COURSE_REGISTRATION_DETAILS ="select * from courseregistration";
	
	public static final String ADD_GRADE="insert into grade(studentId,studentName,courseId,grade) values(?,?,?,?)";

    /* ProfessorDaoImp1 SQL Queries ends here*/	

	
	
	
    /* StudentDaoImp1 SQL Queries starts here*/	

	public static final String ADD_STUDENT_COURSE_REGISTRATION="insert into courseregistration values(?,?,?,?,?,?)";

	public static final String GET_STUDENTID_PAYMENT="select studentId from payment";

    /* StudentDaoImp1 SQL Queries ends here*/
	
	
	

    /* UserDaoImp1 SQL Queries starts here*/	

	
	public static final String GET_STUDENTID_STUDENT="select studentId from student";
	
	public static final String ADD_STUDENT_REGISTRATION="insert into registration values(?,?,?,?,?)"; 
	
	public static final String GET_LOGIN_DETAILS="select username,password,roleId from login";
	
	public static final String GET_LOGIN_DETAILS1="select  loginId,roleId,password from login";

    /* UserDaoImp1 SQL Queries ends here*/	

	
	
  }
