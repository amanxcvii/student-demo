/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.studentdb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.lang.model.element.Name;
import javax.swing.GroupLayout;
import javax.swing.JDialog;

/**
 *
 * @author Asus
 */
public class student implements Serializable{
private int studentId;// = 1001;
private String Name = "";
private int Age;
private String Sex = "";
private String StdClass = "";
private String Fname = "";
private String Mname= "";
private String Address = ""; 

ArrayList<ArrayList<Object>> studentDB = new ArrayList<ArrayList<Object>>();

//    database(int regdNo) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    database(int regdNo, String Name, int Age, String Sex, String StdClass, String Fname, String Mname, String Address) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    database() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
     
    /**
     *
     * @param studentId
     * @param Name
     * @param name
     * @param Age
     * @param Sex
     * @param Fname
     * @param StdClass
     * @param Address
     * @param Mname
     * @param age
     * @param sex
     * @param className
     */
    public void student(int studentId, String Name, int Age, String Sex, String StdClass, String Fname, String Mname, String Address){
       //ArrayList<Object> addstu = new ArrayList<Object>();
        this.studentId = studentId; 
        this.Name = Name;
        this.Age = Age;
        this.Sex = Sex;
        this.StdClass = StdClass;
        this.Fname = Fname;
        this.Mname = Mname;
        this.Address = Address;
          
//        addstu.add(0, studentId);
//        addstu.add(1, Name);
//        addstu.add(2, Age);
//        addstu.add(3, Sex);
//        addstu.add(4, StdClass);
//        addstu.add(5, Fname );
//        addstu.add(6, Mname);
//        addstu.add(7, Address);
//        studentDB.add(addstu);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + Name + '\'' +
                ", age=" + Age +
                ", sex='" + Sex + '\'' +
                ", className='" + StdClass + '\'' +
                ", fName='" + Fname + '\'' +
                ", mName='" + Mname + '\'' +
                ", address='" + Address + '\'' +
                '}';
    }
   

    public void increaseId(){
        studentId += 1;
    }
  
  
    
     // Getters and setters for each field
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public String getStudentClass() {
        return StdClass;
    }

    public void setStudentClass(String studentClass) {
        this.StdClass = studentClass;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        this.Fname = fname;
    }

    public String getMname() {
        return Mname;
    }

    public void setMname(String mname) {
        this.Mname = mname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }
    
    

//    
//    
//    //al.add(String Name, int Age, String Sex,String StdClass, String FName, String MName,String address);
//        
//        al.add
//    
//        // Create and add the first row
//        ArrayList<Object> student1 = new ArrayList<>();
//        student1.add(String Name, int Age, String Sex,String StdClass, String FName, String MName,String address);
//        al.add(student1);
//        
//
//        // Create and add the second row
//        ArrayList<String> row2 = new ArrayList<>();
//        row2.add("Alice");
//        row2.add("Smith");
//        row2.add("25");
//        rows.add(row2);
//
//        // Create and add the third row
//        ArrayList<String> row3 = new ArrayList<>();
//        row3.add("Bob");
//        row3.add("Johnson");
//        row3.add("35");
//        rows.add(row3);
//
//        // Display the rows
//        for (ArrayList<String> row : rows) {
//            System.out.println(row);
//        }
    
    
    public void check(){
        if(!(Sex == "M" || Sex == "F")){
            JDialog Alert = new JDialog();
            Alert.setSize(400, 400);
            Alert.setVisible(true);
        }
    }
}
