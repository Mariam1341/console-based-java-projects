/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adex.dao;

import adex.dto.CourseDto;
import adex.dto.DoctorDto;
import adex.dto.StudentDto;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vega Laptop
 */
public class DataBaseImpl implements DataBase{
    public static Map<String, StudentDto> students = new HashMap();
    public static Map<String, DoctorDto> doctors = new HashMap();
    public static Map<String, CourseDto> courses = new HashMap();
    
    @Override
    public void registerInCourses(StudentDto stu, CourseDto course){
        stu.getMyCourses().put(course.getCode(), course);
        stu.getNoMyCourses().remove(course.getCode());
        course.getStudents().put(stu.getUserName(), stu);
        System.out.println(course.getCode());
    }
    
    @Override
    public void registerInCourses(StudentDto stu, CourseDto... courses){
        for(int i = 0; i < courses.length ;i++){
            registerInCourses(stu,courses[i]);
            
//            stu.getMyCourses().put(courses[i].getCode(), courses[i]);
//            stu.getNoMyCourses().remove(courses[i].getCode());
//            courses[i].getStudents().put(stu.getUserName(), stu);
        }
        
        
        
    }
    @Override
    public void teach(DoctorDto doc, CourseDto course ){
        doc.getCourses().put(course.getCode(), course);
        DataBaseImpl.courses.put(course.getCode(), course);
    }
    
    @Override
    public void addStu( CourseDto course,StudentDto... stus){
        for(int i = 0; i<stus.length ;i++){
            course.getStudents().put(stus[i].getUserName(), stus[i]);
        }
    }
}
