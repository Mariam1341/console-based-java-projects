/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adex.view;

import adex.dao.DaoFactory;
import adex.dao.DataBase;
import adex.dao.DataBaseImpl;
import adex.dto.CourseDto;
import adex.dto.DoctorDto;
import adex.dto.StudentDto;

/**
 *
 * @author Vega Laptop
 *///super(userName, ID, password, fullName, email);
public class DummyData extends Thread {
    DaoFactory fac = new DaoFactory();
     DataBase d = fac.getData();
    @Override
    public void run() {
        
        CourseDto c111 = new CourseDto("Prog1","CS111","summary1","Samy");
        CourseDto c112 = new CourseDto("Prog2","CS112","summary2","Morad");
        CourseDto c123 = new CourseDto("Math1","CS123","summary3","Ashraf");
        CourseDto c333 = new CourseDto("Math2","CS333","summary4","Hani");
        CourseDto c136 = new CourseDto("Prog3","CS136","summary5","Sayed");
        CourseDto c240 = new CourseDto("Stat1","CS240","summary6","Hussien");
        CourseDto c350 = new CourseDto("Stat2","CS350","summary7","Morad");
        
        
        DoctorDto do1 = new DoctorDto("Ali","10102345");
        DoctorDto do2 = new DoctorDto("Mostafa","20102345");
        DoctorDto do3 = new DoctorDto("Hani","30102345");
        DoctorDto do4 = new DoctorDto("Mohamed","40102345");
        DoctorDto do5 = new DoctorDto("Ashraf","50102345");
        DoctorDto do6 = new DoctorDto("Samy","60102345");
        DoctorDto do7 = new DoctorDto("Morad","70102345");
        DoctorDto do8 = new DoctorDto("Sayed","80102345");
        DoctorDto do9 = new DoctorDto("Hussien","90102345");
        
        
        StudentDto stu1 = new StudentDto("s001","00102345","s001","Hussien Samy","hs001@gmail.com");
        StudentDto stu2 = new StudentDto("AshrafSayed","00204690");
        StudentDto stu3 = new StudentDto("MostafaHussien","00307035");
        StudentDto stu4 = new StudentDto("AliMohamed","00409380");
        StudentDto stu5 = new StudentDto("HaniSayed","00501725");
        
        DataBaseImpl.doctors.put("Ali", do1);
        DataBaseImpl.doctors.put("Mostafa", do2);
        DataBaseImpl.doctors.put("Hani", do3);
        DataBaseImpl.doctors.put("Mohamed", do4);
        DataBaseImpl.doctors.put("Ashraf", do5);
        DataBaseImpl.doctors.put("Samy", do6);
        DataBaseImpl.doctors.put("Morad", do7);
        DataBaseImpl.doctors.put("Sayed", do8);
        DataBaseImpl.doctors.put("Hussien", do9);
        
        
        DataBaseImpl.students.put("s001", stu1);
        DataBaseImpl.students.put("AshrafSayed", stu2);
        DataBaseImpl.students.put("MostafaHussien", stu3);
        DataBaseImpl.students.put("AliMohamed", stu4);
        DataBaseImpl.students.put("HaniSayed", stu5);
        
        d.teach(do3, c333);
        d.teach(do5, c123);
        d.teach(do6, c111);
        d.teach(do7, c112);
        d.teach(do8, c350);
        d.teach(do8, c136);
        d.teach(do9, c240);
//        d.registerInCourses(stu1, c111);
//        d.registerInCourses(stu1, c112);
//        d.registerInCourses(stu1, c333);
//        d.registerInCourses(stu1, c136);
//        d.registerInCourses(stu1, c240);
        
        stu1.getMyCourses().put(c111.getCode(),c111 );
        stu1.getMyCourses().put(c112.getCode(),c112 );
        stu1.getMyCourses().put(c333.getCode(),c333 );
        stu1.getNoMyCourses().remove(c111.getCode());
        stu1.getNoMyCourses().remove(c112.getCode());
        stu1.getNoMyCourses().remove(c333.getCode());
        
        //d.registerInCourses(stu1, c350);
        System.out.println(stu1.getMyCourses().size());
    //   d.registerInCourses(stu1, c111, c112, c333, c136, c240, c350);
//        d.registerInCourses(stu2,c111,c112,c123,c136,c240,c350,c333);
//        d.registerInCourses(stu3,c112,c123,c136,c333);
//        d.registerInCourses(stu4,c111,c112,c123,c136,c350,c333);
//        d.registerInCourses(stu5,c111,c112,c123,c136,c240,c333);
//       
//        //d.addStu(c111,new StudentDto("",""));
      
        
        
        System.out.println("now");
  
                       
    }
    
    

}
