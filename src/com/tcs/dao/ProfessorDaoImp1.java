/**
 * 
 */
package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.tcs.constant.SQLConstants;
import com.tcs.exception.CourseNotFound;
import com.tcs.exception.StudentNotFound;
import com.tcs.utils.DBUtils;

/**
 * @author Administrator
 *
 */
public class ProfessorDaoImp1 implements ProfessorDao {
	
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	
    DBUtils cc=new DBUtils();
    Connection conn=cc.connect();
    Scanner sc=new Scanner(System.in);
    
    
    /*@method:viewEnrolledStudent - professor can view the students enrolled for a course
     * @param:courseId
     * 
     */
    
	@Override
	public void viewEnrolledStudent(int cid)  throws StudentNotFound{
		// TODO Auto-generated method stub
		int c=0;
		try
		{
			
			
			
			//String sql="select * from courseregistration";
			
			stmt=conn.prepareStatement(SQLConstants.COURSE_REGISTRATION_DETAILS);
			ResultSet rs = stmt.executeQuery(SQLConstants.COURSE_REGISTRATION_DETAILS);
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		    	 int sid  = rs.getInt("studentId");
		    	 
		         int cid1 = rs.getInt("courseId1");
		         int cid2  = rs.getInt("courseId2");
		         int cid3  = rs.getInt("courseId3");
		         int cid4 = rs.getInt("courseId4");
				if(cid1==cid)
				{
							System.out.println("Student Id: "+sid);
							c++;
				}
				else if(cid2==cid)
				{
					System.out.println("Student Id: "+sid);
					c++;
				}
				else if(cid3==cid)
				{
					System.out.println("Student Id: "+sid);
					c++;
				}
				else if(cid4==cid)
				{
					System.out.println("Student Id: "+sid);
					c++;
				}
				
		      }
		      if(c==0) {
		    	  throw new StudentNotFound("No Student Registered for this course");
		      }
		   }
		catch(SQLException se2){
      }// nothing we can do
		
	}

	
	/*@method: addGrades- professor can add grades to students
     * @param:courseId
     * 
     */
	@Override
	public void addGrades(int sid) throws StudentNotFound {
		// TODO Auto-generated method stub
		try {
			//String sql6="select * from grade";
			stmt = conn.prepareStatement(SQLConstants.GET_GRADE_TABLE);
		    ResultSet rs1 = stmt.executeQuery(SQLConstants.GET_GRADE_TABLE);
		    while(rs1.next())
		    {
		    
		    	if(sid==rs1.getInt("studentId"))
		    	{
		    		//f=true;
		    		throw new StudentNotFound(sid);
		    	}
		    }
		
			
			
			
			boolean f=false;
		//String sql="select * from courseregistration";
		//String sql6="select * from grade";
		
        stmt=conn.prepareStatement(SQLConstants.COURSE_REGISTRATION_DETAILS);
		ResultSet rs = stmt.executeQuery(SQLConstants.COURSE_REGISTRATION_DETAILS);
		while(rs.next()){
	         //Retrieve by column name
	    	 int sid1  = rs.getInt("studentId");
	    	 String sname=rs.getString("studentName");
	         int cid1 = rs.getInt("courseId1");
	         int cid2  = rs.getInt("courseId2");
	         int cid3  = rs.getInt("courseId3");
	         int cid4 = rs.getInt("courseId4");
	         if(sid1==sid) {
	        	 System.out.println("Student Course Ids Are:");
	        	 System.out.print("Course ID1: " + cid1);
		         System.out.print(" Course ID2: " + cid2);
		         System.out.print(" Course ID3: " + cid3);
		         System.out.print(" Course ID4: " + cid4);
		         System.out.println();
		         System.out.println("Enter Grades For CourseId1 , CourseId2, CourseId3, CourseId4");
		         String cg1=sc.next();
		         String cg2=sc.next();
		         String cg3=sc.next();
		         String cg4=sc.next();
		         
		         //String sql2="insert into grade(studentId,studentName,courseId,grade) values(?,?,?,?)";
		         
		         stmt1 = conn.prepareStatement(SQLConstants.ADD_GRADE);
		         
		          stmt1.setInt(1,sid1);
		          stmt1.setString(2, sname);
		         stmt1.setInt(3,cid1);
		         stmt1.setString(4, cg1);
		         stmt1.executeUpdate();
		         
		      
		         //String sql3="insert into grade values(?,?,?,?)";
		         stmt1 = conn.prepareStatement(SQLConstants.ADD_GRADE);
		         stmt1.setInt(1, sid1);
		          stmt1.setString(2, sname);
		         stmt1.setInt(3,cid2);
		         stmt1.setString(4, cg2);
		         stmt1.executeUpdate();
		         
		         //String sql4="insert into grade values(?,?,?,?)";
		         stmt1 = conn.prepareStatement(SQLConstants.ADD_GRADE);
		         stmt1.setInt(1, sid1);
		          stmt1.setString(2, sname);
		         stmt1.setInt(3,cid3);
		         stmt1.setString(4, cg3);
		         stmt1.executeUpdate();
		         
		         //String sql5="insert into grade values(?,?,?,?)";
		         stmt1 = conn.prepareStatement(SQLConstants.ADD_GRADE);
		         stmt1.setInt(1, sid1);
		          stmt1.setString(2, sname);
		         stmt1.setInt(3,cid4);
		         stmt1.setString(4, cg4);
		         stmt1.executeUpdate();
		         f=true;
		         
		         System.out.println("Grades Are Added to The Course Ids");
		        }
		 
		}
		if(f==false) {
		 System.out.println("Student Not Found");
		}
	  }
		catch(SQLException se2){
			se2.printStackTrace();
			
        }
	      // nothing we can do

}
}
