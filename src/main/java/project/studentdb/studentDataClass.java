/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.studentdb;

import java.util.HashMap;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Asus
 */
public class studentDataClass {
private static int regdNoCounter =1001;
private int regdNo;



public HashMap <Integer,student> student; 
student db;

    public studentDataClass() {
        this.student = new HashMap<>();
        db = new student();
        regdNo = regdNoCounter;
        db.setStudentId(regdNo);  
        regdNoCounter++;
//          chkRegd();
    }

    
    
//     public int addStudent(String Name, int Age, String Sex, String StdClass, String Fname, String Mname, String Address) {
//        int regdNo = regdNoCounter++;
//        new database();
//        newstudent.setStudentId(regdNo);
//
//       ArrayList<database> studentsList = database.getOrDefault(regdNo, new ArrayList<>());
//        ArrayList<database> studentsList = new ArrayList<>();
//        studentsList.add(new database());
//        student.put(regdNo, newstudent);
//       return regdNo;
//    }

//    void addStudent(int studentId, String name, int age, String sex, String studentClass, String fname, String mname, String address) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    
    private void chkRegd(){
        regdNo = regdNoCounter;
        for (Map.Entry<Integer, student> entry : student.entrySet()) {
            if (entry.getValue().equals(regdNo)) {
                regdNo = ++regdNoCounter;
               // containsValue = true;
                break; // Exit the loop early if the value is found
            }
            else {
                db.setStudentId(regdNo);  
                regdNoCounter++;
            }
        }
    }
    
    
    
     public int getregdNo(){
    return regdNo;
     }
    
     public void IncreaseRegdNo(){
         regdNo =+1;
     }

    
    public void setStuName(String Name){
    db.setName(Name);
    }
    public String getStuName(){
    return db.getName();
    }
    
    public void setStuAge(int Age) {
        db.setAge(Age);
    }
    public int getStuAge() {
        return db.getAge();
    }
    
    public String getStuSex() {
        return db.getSex();
    }

    public void setStuSex(String Sex) {
        db.setSex(Sex);
    }
    
    
    public String getStuStudentClass() {
        return db.getStudentClass();
    }

    public void setStuStudentClass(String studentClass) {
        db.setStudentClass(studentClass);
    }
    
    public String getStuFname() {
        return db.getFname();
    }

    public void setStuFname(String fname) {
        db.setFname(fname);
    }
    
    public String getStuMname() {
        return db.getMname();
    }

    public void setStuMname(String mname) {
        db.setMname(mname);
    }

    public String getStuAddress() {
        return db.getAddress();
    }

    public void setStuAddress(String address) {
        db.setAddress(address);
    }
    
    public int getStuStudentId(){
        return db.getStudentId();
    }
    
    
}







//public void addStudent() {
//    student newstud = new student();
//    studentId++;
//}

//public Student getStudentByID(int studentID) {
//    return studentMap.get(studentID);
//}

