package university;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessCommandServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
    	
        Key universityKey = KeyFactory.createKey("University", "Purdue");
        
        
      /*you don't need to worry about the variable below, this gets the value of the 
       * string entered in the text area as defined in the university.jsp file
       */
        String content = req.getParameter("command");
        
        
        /*This String array contains the individual elements of the 
        command entered in the text area, e.g. if commandEls[0] gives "add_department", 
        commandEls[1] gives the department id, commandEls[2] gives the department name
        and commandEls[3] gives the department location*/ 
        String [] commandEls = content.split(" ");
        
        /*This string contains the results to display to the user once a command is entered.
         * For a query, it should list the results of the query. 
         * For an insertion, it should either contain an error message or 
         * the message "Command executed successfully!"*/
        String results = null;
        
        
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        
        /*your implementation starts here*/
        
        if ( commandEls[0].equals( "add_student" ) ) {
        	String snum = commandEls[1];
        	String sname = commandEls[2];
        	String slevel = commandEls[3];
        	String age = commandEls[4];
        	
        	//add a student record with the given fields to the datastore, don't forget to check for duplicate record
        	
        	
        	//set the value of the "results" String
        	
        }
        else if ( commandEls[0].equals( "add_faculty" ) ) {
        	String fid = commandEls[1];
        	String fname = commandEls[2];
        	
        	//add a faculty record with the given fields to the datastore, don't forget to check for duplicate record
        	
        	
        	//set the value of the "results" String
        		
        }
        else if ( commandEls[0].equals( "add_class" ) ) {
        	String cname = commandEls[1];
        	String room = commandEls[2];
        	String meets_at = commandEls[3];
        	String fid = commandEls[4];
        	
        	//add a class record with the given fields to the datastore, don't forget to check for duplicate record
        	
        	
        	//set the value of the "results" String
            	
        }
        else if ( commandEls[0].equals( "enroll" ) ) {
        	String snum = commandEls[1];
        	String cname = commandEls[2];
        	
        	//add an enrollment record with the given fields to the datastore, don't forget to check for duplicate record
        	
        	
        	//set the value of the "results" String
        	
        }
        
        else if ( commandEls[0].equals( "get_classes_for_student" ) ) {
        	String snum = commandEls[1];
        	//query the datastore for the list of classes the student identified by snum takes, append each record to "results"
        	
        }
        
        else if ( commandEls[0].equals( "get_instructors_for_student" ) ) {
        	String snum = commandEls[1];
        	//query the datastore for the list of instructors of the classes that the student identified by "snum" takes, 
        	//append each record to "results"
        }
        /*your implementation ends here */
        resp.sendRedirect( "/university.jsp?universityName=Purdue&display=" + results );
    }  

}
