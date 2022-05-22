/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adex.dao;

import adex.dto.CourseDto;
import adex.dto.DoctorDto;
import adex.dto.StudentDto;

/**
 *
 * @author Vega Laptop
 */
public interface DataBase {
    public void registerInCourses(StudentDto stu, CourseDto... course);
    public void registerInCourses(StudentDto stu, CourseDto course);
    public void teach(DoctorDto doc, CourseDto course );
    public void addStu( CourseDto course,StudentDto... stus);
}
