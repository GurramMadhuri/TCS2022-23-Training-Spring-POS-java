/**
 * 
 */
package com.tcs.service;

import com.tcs.bean.Course;
import com.tcs.bean.GradeCard;
import com.tcs.bean.Catalogue;
import com.tcs.bean.Professor;
import com.tcs.bean.Student;
import com.tcs.dao.AdminDao;
import com.tcs.dao.AdminDaoImp1;
import com.tcs.dao.UserDao;
import com.tcs.dao.UserDaoImp1;
import com.tcs.exception.CourseAlreadyExists;
import com.tcs.exception.CourseNotFound;
import com.tcs.exception.ProfessorAlreadyExists;
import com.tcs.exception.ProfessorNotFound;
import com.tcs.exception.StudentGradesNotFound;

import java.util.*;
import com.tcs.service.UserServiceImp;
import com.tcs.service.UserServiceInterface;

/**
 * @author Administrator
 *
 */
public class AdminServiceImp implements AdminServiceInterface{
	UserServiceImp usimp=new UserServiceImp();
	static List<Catalogue> cclist=new ArrayList<Catalogue>();
	AdminDao adi = new AdminDaoImp1();
	
  static List<GradeCard> gcard=new ArrayList<GradeCard>();
	 Scanner sc=new Scanner(System.in);
	 
	 
	 /*
	  * @method: approveStudentRegistration
	  * Admin has to approve the student registration by using student ID
	  * 
	  * @param: sid  Student ID
	  * @param: status Admin set the status value to 1 to approve the student.
	  *
	  */
	 
	@Override
	public void approveStudentRegistration() {
		// TODO Auto-generated method stub
		
		
        adi.approveRegistration();
		
	}

	 /*
	  * @method: addCourse
	  * Admin can add course to course catalogue
	  * 
	  * @param: course id,course name,professor name,department,prerequisites
	  */
	
	@Override
	public void addCourse() {
		// TODO Auto-generated method stub
		try {
        //Catalogue course=new Catalogue();
		
		System.out.println("Enter Course ID");
	    int cid=sc.nextInt();
	    sc.nextLine();
	    System.out.println("Enter Course Name");
	    String cname=sc.nextLine();
	    System.out.println("Enter Professor Name");
	    String pname=sc.nextLine();
	    System.out.println("Enter Department");
	    String dept=sc.nextLine();
	    System.out.println("Enter Prerequisites");
	    String pre=sc.nextLine();
	  	//cclist.add(course);1
	    adi.addCourse(cid,cname,pname,dept,pre);
		}
		catch(CourseAlreadyExists e)
		{
			System.out.println("Course Id "+e.getCourseId()+" already exists");
		}
		
	}
	
	
	 /*
	  * @method: removeCourse
	  * Admin can remove course from course catalogue by using the course ID.
	  * 
	  * @param: Course ID The course Id is used to search whether the course exists or not.If exists then remove the course
	  *          else print course id not found.
	  */

	@Override
	public void removeCourse() {
		// TODO Auto-generated method stub
		try {
		
		System.out.println("Enter Course ID");
		int inp=sc.nextInt();
		adi.removeCourse(inp);
		
		
		
		}
		catch(CourseNotFound e)
		{
			System.out.println("Course ID"+e.getCourseId()+" not found");
		}
		
	}

	
	
	
	 /*
	  * @method: generateReportCard
	  * Admin can generate report card of a particular student using student Id.
	  * 
	  * @param: Student ID The student Id is used to search whether the student exists or not.
	  *         If exists the report card is generated and printed else prints student not found.
	  */
	
	@Override
	public void generateReportCard() {
		// TODO Auto-generated method stub
		try
		{
		//int count=0;
		System.out.println("Enter Student Id");
		int sid=sc.nextInt();sc.nextLine();
		System.out.println("Enter Student Name");
		String sname=sc.nextLine();
	

		adi.gradeCard(sid,sname);
		}
		catch(StudentGradesNotFound e)
		{
			System.out.println("Grades for Student Id"+e.getStudentId()+"Student Name"+e.getStudentName()+" not found");
			//e.printStackTrace();
		}
	}

	
	

	 /*
	  * @method: addProfessor
	  * Admin can add professor details
	  * 
	  * @param: Professor ID,professor Name,Department,Professor Password(default password- which can be updated by professor).
	  */
	
	
	@Override
	public void addProfessor() {
		// TODO Auto-generated method stub
		try {
		//Professor pro=new Professor();
		
		System.out.println("Enter Professor Id");
	    int pid=sc.nextInt();
	    sc.nextLine();
	    System.out.println("Enter Professor Name");
	    String pname=sc.nextLine();
	    System.out.println("Enter Department");
	    String dept=sc.nextLine();
	    
	    System.out.println("Enter Professor Password");
	    String ppswd=sc.nextLine();
	    //UserServiceImp.plist.add(pro);
	    adi.addProfessor(pid,pname,ppswd,dept);
		}
		catch(ProfessorAlreadyExists e)
		{
			System.out.println("Professor Id "+e.getProfessorId()+" already exists");
		}
	}
 
	 

	 /*
	  * @method: listProfessor
	  * This method prints all the professors details.
	  * 
	  * @param: plist plist is the professor list.
	  */
	  
	@Override
	public void listProfessor()  {
		// TODO Auto-generated method stub
		try {
		System.out.println("----Professors List-----");
		
		adi.listProfessor();
		}catch(ProfessorNotFound e)
		{
			System.out.println(e.getMsg());
		}
		
		
		//UserServiceImp.plist.forEach(System.out::println);
		
	}
	
	
	 /*
	  * @method: listCourses
	  * This method prints all the student enrolled courses details.
	  * 
	  * @param: cclist cclist is the list of students enrolled for courses.
	  */
	
	public void listCourses() {
		// TODO Auto-generated method stub
		try {
		System.out.println("----Courses List-----");
		adi.listCourses();
		}
		catch(CourseNotFound e)
		{
			System.out.println(e.getMsg());
		}
		

		//cclist.forEach(System.out::println);
		
	}

	
}
