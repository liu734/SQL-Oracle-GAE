/* Author: Jingye Liu 
 * Login: liu734
 * Email:liu734@purdue.edu
 * 
 * 
 */
import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Integer;
import java.util.*;

public class SimpleDatabase {
  ArrayList<Student> studentDB;
  ArrayList<Class> classDB;
  ArrayList<Department> departmentDB;
  ArrayList<Faculty> facultyDB;
  ArrayList<enrolled_at> enrolled_atDB;

  ArrayList<teaches> teachesDB;
    

  public SimpleDatabase(){
    studentDB=new ArrayList<Student>();
    classDB=new ArrayList<Class>();
    departmentDB=new ArrayList<Department>();
    facultyDB=new ArrayList<Faculty>();
    enrolled_atDB=new ArrayList<enrolled_at>();

    teachesDB=new ArrayList<teaches>();
    studentDB=new ArrayList<Student>();

    
  }

 //declare public variables and constants here
  
  

 /*Your implementation starts here*/
 
 public void addStudent( String snum, String sname, String slevel, int age, String deptid ) {
   
   int flag=0;

// if department exists
   for (int i=0;i<departmentDB.size();i++){
     if(departmentDB.get(i).getDeptid().equals(deptid)){
 flag=1;
 break;
     }
   }
   
   if(flag==0){
      System.out.println("Error: Department does not exist!");
 return;
   }
   



//if added twice
   for (int i=0;i<studentDB.size();i++){
      if(studentDB.get(i).getSnum().equals(snum)){
 flag=0;
 break;
      }
   }
   
   if(flag==0){
      System.out.println("Error: Student already exists!");
   }
   else{
 studentDB.add( new Student( snum, sname, slevel, age, deptid ));    
   }


 


   
 
 }
 
 public void addFaculty( String fid, String fname, String deptid ) {
   int flag=0;

// if department exists
   for (int i=0;i<departmentDB.size();i++){
     if(departmentDB.get(i).getDeptid().equals(deptid)){
 flag=1;
 break;
     }
   }
   
   if(flag==0){
      System.out.println("Error: Department does not exist!");
      return;
   }
   for (int i=0;i<facultyDB.size();i++){
      if(facultyDB.get(i).getFid().equals(fid)){
        flag=0;
        break;
      }
   }
   
   if(flag==0){
      System.out.println("Error: Faculty already exists!");
   }
   else{
      facultyDB.add( new Faculty( fid, fname, deptid ));
   }   




 
 }
 
 public void addClass( String name, String room, String meets_at, String fid ) {

   int flag=0;

// if faculty not exist
   for (int i=0;i<facultyDB.size();i++){
     if(facultyDB.get(i).getFid().equals(fid)){
       flag=1;
       break;
     }
   }
   
   if(flag==0){
     System.out.println("Error: Faculty does not exist!");
     return;
   }
   for (int i=0;i<classDB.size();i++){
      if(classDB.get(i).getName().equals(name)){
        flag=0;
        break;
      }
   }
   
   if(flag==0){
      System.out.println("Error: Class already exists!");
   }
   else{
      classDB.add(new Class(name,room,meets_at, fid));
   }   






 }
 
 public void addDepartment( String deptid, String dname, String location ) {
   
   for (int i=0;i<departmentDB.size();i++){
     if(departmentDB.get(i).getDeptid().equals(deptid)){
       System.out.println("Error: Department already exists!");
     }
   }
   departmentDB.add(new Department(deptid, dname, location));
 }
 
 public void enroll( String snum, String name ) {
   int flag1=0;
   int flag2=0;
   int flag3=1;
   Student tempStudent=null;
   Class tempClass=null;
   
   for (int i=0;i<studentDB.size();i++){
     if(studentDB.get(i).getSnum().equals(snum)){
       flag1=1;
       tempStudent=studentDB.get(i);
     }
   } 
   for (int j=0;j<classDB.size();j++){
     if(classDB.get(j).getName().equals(name)){
       flag2=1;
       tempClass=classDB.get(j);
       break;
     }
   }
   for (int j=0;j<enrolled_atDB.size();j++){
     if(enrolled_atDB.get(j).getStudent().getSnum().equals(snum) && enrolled_atDB.get(j).getName().getName().equals(name)){
       flag3=0;
       break;
     }
   }       
    
   
   
   
   
   if(flag1==0||flag2==0){
     System.out.println("Error: Missing entry!");   
   }
   else if(flag3==0){
     System.out.println("Error: Enrollment already exists!");
   }  
   else{ 
     enrolled_atDB.add(new enrolled_at(tempStudent,tempClass));
   }
   
   
 }
 
 public void getStudentsInDepartment( String deptid ) {

   for (int i=0;i<studentDB.size();i++){
     if(studentDB.get(i).getDeptid().equals(deptid)){
       System.out.println(studentDB.get(i).getSname()+","+studentDB.get(i).getSlevel()+","+studentDB.get(i).getAge());
     }
   }
 }
 public void getStudentsInClass( String name ) {
   for (int i=0;i<enrolled_atDB.size();i++){
     if(enrolled_atDB.get(i).getName().getName().equals(name)){
       System.out.println(enrolled_atDB.get(i).getStudent().getSname()+","+enrolled_atDB.get(i).getStudent().getSlevel()+","+enrolled_atDB.get(i).getStudent().getAge());
     }
      
   }
 }
 
 public void getClassesForStudent( String snum ) {
   for (int i=0;i<enrolled_atDB.size();i++){
     if(enrolled_atDB.get(i).getStudent().getSnum().equals(snum)){
       System.out.println(enrolled_atDB.get(i).getName().getName()+","+enrolled_atDB.get(i).getName().getRoom()+","+enrolled_atDB.get(i).getName().getMeets_at());
     }
      
   }
 }
 
 public void getClassesForFaculty( String fid ) {
   for (int i=0;i<classDB.size();i++){
     if(classDB.get(i).getFid().equals(fid)){
       System.out.println(classDB.get(i).getName());
     }
      
   }
 
 }
 
 public void deleteClass( String name ) {
//delete the enrolled_in   in this class
   for (int i=0;i<enrolled_atDB.size();i++){
     if(enrolled_atDB.get(i).getName().getName().equals(name)){
       enrolled_atDB.remove(enrolled_atDB.get(i));      
       i--;
     }      
   }
   for (int i=0;i<classDB.size();i++){
     if(classDB.get(i).getName().equals(name)){
       classDB.remove(classDB.get(i));
       i--;
     }     
   }
   
   
   
 }
 
 public void save( String filename ) {
   File source=new File(filename+".txt");
   try{
   FileWriter output=new FileWriter(source);    
   BufferedWriter out=new BufferedWriter(output);   

    //department database
    out.write("Department_Database");
    out.newLine(); 
    for (int i=0;i<departmentDB.size();i++){
      out.write(departmentDB.get(i).getDeptid()+" "+departmentDB.get(i).getDname()+" "+departmentDB.get(i).getLocation());
      out.newLine();     
    }   

    //faculty database
    
    out.write("Faculty_Database");
    out.newLine(); 
    for (int i=0;i<facultyDB.size();i++){
      out.write(facultyDB.get(i).getFid()+" "+facultyDB.get(i).getFname()+" "+facultyDB.get(i).getDeptid());
      out.newLine();     
    }
    
    
   //class database
   out.write("Class_Database");
   out.newLine(); 
   for (int i=0;i<classDB.size();i++){
      out.write(classDB.get(i).getName()+" "+classDB.get(i).getRoom()+" "+classDB.get(i).getMeets_at()+" "+classDB.get(i).getFid());
      out.newLine();     
    }
    //student database
    out.write("Student_Database");
    out.newLine(); 
    for (int i=0;i<studentDB.size();i++){
      out.write(studentDB.get(i).getSnum()+" "+studentDB.get(i).getSname()+" "+studentDB.get(i).getSlevel()+" "+studentDB.get(i).getAge()+" "+studentDB.get(i).getDeptid());
      out.newLine();     
    }


    //enrolled_at database
    out.write("enrolled_at_Database");
    out.newLine(); 
    for (int i=0;i<enrolled_atDB.size();i++){
      out.write(enrolled_atDB.get(i).getStudent().getSnum()+" "+enrolled_atDB.get(i).getName().getName());
      out.newLine();     
    }

   out.close();
   output.close();

   }  
   catch (Exception se){
   }

   
   
 
 }
 
 public void load( String filename ) {
   
    studentDB=new ArrayList<Student>();
    classDB=new ArrayList<Class>();
    departmentDB=new ArrayList<Department>();
    facultyDB=new ArrayList<Faculty>();
    enrolled_atDB=new ArrayList<enrolled_at>();

    teachesDB=new ArrayList<teaches>();
    studentDB=new ArrayList<Student>();

    File source=new File(filename+".txt");
    Scanner in=null;
   try{
  
    in=new Scanner(source);   
   }
   catch (Exception e){
   
   }
   ArrayList<String> temp= new ArrayList<String>();
   while(in.hasNext()){
      
    temp.add(in.next());

   }
   in.close();
      
      int count=1;
      
      for(int i=count;i<temp.size();i=i+3){

        addDepartment( temp.get(i), temp.get(i+1), temp.get(i+2));
        if(temp.get(i+3).equals("Faculty_Database")){
          count=i+3;
          break;
        }
      }
      count++;
      for(int i=count;i<temp.size();i=i+3){

        addFaculty( temp.get(i), temp.get(i+1), temp.get(i+2));
        if(temp.get(i+3).equals("Class_Database")){
          count=i+3;
          break;
        }
      }      
      count++;      
      for(int i=count;i<temp.size();i=i+4){

        addClass( temp.get(i), temp.get(i+1), temp.get(i+2), temp.get(i+3));
        if(temp.get(i+4).equals("Student_Database")){
          count=i+4;
          break;
        }
      }
      count++;
      for(int i=count;i<temp.size();i=i+5){

        addStudent( temp.get(i), temp.get(i+1), temp.get(i+2), Integer.parseInt(temp.get(i+3)),temp.get(i+4) );
        
        if(temp.get(i+5).equals("enrolled_at_Database")){
          count=i+5;
          break;
        }
      }
      count++;


      for(int i=count;i<temp.size();i=i+2){
        enroll( temp.get(i), temp.get(i+1));

      }



   
   
   
   
   
 
 }
 
 public void help() {
   System.out.println("add_department DEPTID DNAME LOCATION\nadd_student SNUM SNAME SLEVEL AGE DEPTID\nadd_faculty FID FNAME DEPTID\nadd_class NAME ROOM  MEETS_AT FID enroll SNUM NAME\nget_students_in_department DEPTID");
   System.out.println("get_students_in_class NAME\nget_classes_for_student SNUM\nget_classes_for_faculty FID\ndelete_class NAME\nsave FILENAME\nload FILENAME\nexit");                     

 }
  
   /*Your implementation ends here */
   
   
 public static void main( String [] args ) {
 
  SimpleDatabase sd = new SimpleDatabase();
  
  System.out.println( "Please enter a command.  Enter 'help' for a list of commands." );
  
  BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

  String line = "";
  
  try {
   line = reader.readLine();
  }
  catch ( IOException e ) {
   e.printStackTrace();
  }
  
  
  
  String[] pieces = line.split( "\\s+" );
  String[] params;
  String command;
  
  if ( pieces.length > 0 ) {
   command = pieces[0];
   params = new String[pieces.length - 1];
   System.arraycopy( pieces, 1, params, 0, pieces.length - 1 );
  }
  else {
   command = "";
   params = null;
  }
  
  
  while ( !( command.equalsIgnoreCase( "exit" ) ) ) {
  
   if ( command.equalsIgnoreCase( "add_student" ) ) {
    if ( params.length != 5 ) {
     System.out.println( "Incorrect number of parameters!" );
    }
    else {
     String snum = params[0];
     String sname = params[1];
     String slevel = params[2];
     int age = ( new Integer( params[3] ) ).intValue();
     String deptid = params[4];
     sd.addStudent( snum, sname, slevel, age, deptid );
    }
   }
   else if ( command.equalsIgnoreCase( "add_faculty" ) ) {
    if ( params.length != 3 ) {
     System.out.println( "Incorrect number of parameters!" );
    }
    else {
     String fid = params[0];
     String fname = params[1];
     String deptid = params[2];
     sd.addFaculty( fid, fname, deptid );
    }
   }
   else if ( command.equalsIgnoreCase( "add_department" ) ) {
    if ( params.length != 3 ) {
     System.out.println( "Incorrect number of parameters!" );
    }
    else {
     String deptid = params[0];
     String dname = params[1];
     String location = params[2];
     sd.addDepartment( deptid, dname, location );
    }
   }
   else if ( command.equalsIgnoreCase( "add_class" ) ) {
    if ( params.length != 4 ) {
     System.out.println( "Incorrect number of parameters!" );
    }
    else {
     String name = params[0];
     String room = params[1];
     String meets_at = params[2];
     String fid = params[3];
     sd.addClass( name, room, meets_at, fid );
    }
   }
   else if ( command.equalsIgnoreCase( "enroll" ) ) {
    if ( params.length != 2 ) {
     System.out.println( "Incorrect number of parameters!" );
    }
    else {
     String snum = params[0];
     String name = params[1];
     sd.enroll( snum, name );
    }
   }
   else if ( command.equalsIgnoreCase( "get_students_in_department" ) ) {
    if ( params.length != 1 ) {
     System.out.println( "Incorrect number of parameters!" );
    }
    else {
     String deptid = params[0];
     sd.getStudentsInDepartment( deptid );
    }
   }
   else if ( command.equalsIgnoreCase( "get_students_in_class" ) ) {
    if ( params.length != 1 ) {
     System.out.println( "Incorrect number of parameters!" );
    }
   else {
     String name = params[0];
     sd.getStudentsInClass( name );
    }
   }
   else if ( command.equalsIgnoreCase( "get_classes_for_student" ) ) {
    if ( params.length != 1 ) {
     System.out.println( "Incorrect number of parameters!" );
    }
    else {
     String snum = params[0];
     sd.getClassesForStudent( snum );
    }
   }
   else if ( command.equalsIgnoreCase( "get_classes_for_faculty" ) ) {
    if ( params.length != 1 ) {
     System.out.println( "Incorrect number of parameters!" );
    }
    else {
     String fid = params[0];
     sd.getClassesForFaculty( fid );
    }
   }
   else if ( command.equalsIgnoreCase( "delete_class" ) ) {
    if ( params.length != 1 ) {
     System.out.println( "Incorrect number of parameters!" );
    }
    else {
     String name = params[0];
     sd.deleteClass( name );
    }
   }
   else if ( command.equalsIgnoreCase( "save" ) ) {
    if ( params.length != 1 ) {
     System.out.println( "Incorrect number of parameters!" );
    }
    else {
     String filename = params[0];
     sd.save( filename );
    }
   }
   else if ( command.equalsIgnoreCase( "load" ) ) {
    if ( params.length != 1 ) {
     System.out.println( "Incorrect number of parameters!" );
    }
    else {
     String filename = params[0];
     sd.load( filename );
    }
   }
   else if ( command.equalsIgnoreCase( "help" ) ) {
    if ( params.length != 0 ) {
     System.out.println( "Incorrect number of parameters!" );
    }
    else {
     sd.help();
    }
   }
   else {
    System.out.println( "Invalid command!" );
   }
   
   try {
    line = reader.readLine();
   }
   catch ( IOException e ) {
    e.printStackTrace();
   }
   
   pieces = line.split( "\\s+" );
  
   if ( pieces.length > 0 ) {
    command = pieces[0];
    params = new String[pieces.length - 1];
    System.arraycopy( pieces, 1, params, 0, pieces.length - 1 );
   }
   else {
    command = "";
   }
  }
 
 }



}

class Student{
  String snum;
  String sname;
  String slevel;
  int age;
  String deptid;
  public Student(  String snum,String sname,String slevel,int age,String deptid){
    this.snum=snum;
    this.sname=sname;
    this.slevel=slevel;
    this.age=age;
    this.deptid=deptid;
  }
  public String getSnum(){
    return snum;
  }
  public String getDeptid(){
    return deptid;
  }
  public String getSname(){
    return sname;
  }
  public String getSlevel(){
    return slevel;
  }
  public int getAge(){
    return age;
  }
  
  
}
class Class{
   String name;
   String room;
   String meets_at;
   String fid;
   public Class(String name,String room,String meets_at,String fid){
    this.name= name;
    this.room=room;
    this.meets_at=meets_at;
    this.fid=fid;
     
   }
   public String getName(){
     return name;
   }
   public String getRoom(){
     return room;
   }
   public String getMeets_at(){
     return meets_at;
   }
   public String getFid(){
     return fid;
   }
   
  
}

class Department{
  String deptid;
  String dname;
  String location;
  public Department(String deptid,String dname,String location){
    this.deptid= deptid;
    this.dname=dname;
    this.location=location;
  }
  public String getDeptid(){
    return deptid;
  }
  public String getDname(){
    return dname;
  }
  public String getLocation(){
    return location;
  }
  
  
}

class Faculty{
  String fid;
  String fname;
  String deptid;
  public Faculty(String fid,String fname,String deptid){
    this.fid= fid;
    this.fname=fname;
    this.deptid=deptid;
  }
  public String getFid(){
    return fid;
  }
  public String getFname(){
    return fname;
  }
  public String getDeptid(){
    return deptid;
  }
}

class enrolled_at{
  Student s;
  Class name;
  public enrolled_at(Student student, Class name ){
    this.s=student;
    this.name=name;
  }
  public Class getName(){
    return name;
  }
  public Student getStudent(){
    return s;
  }
}



class teaches{
  String fid;
  String name;
  public teaches(String fid,String name){
    this.fid=fid;
    this.name=name;
  }
  public String getFid(){
    return fid;
  }
  public String getName() {
    return name;
  }
  
}



