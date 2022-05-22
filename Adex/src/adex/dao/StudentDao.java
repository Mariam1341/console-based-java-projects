/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adex.dao;

import adex.dto.CourseDto;
import adex.dto.StudentDto;

/**
 *
 * @author Vega Laptop
 */
public interface StudentDao {
    public StudentDto signup();
    public StudentDto login();
    public void registerC(StudentDto student);
    public void listMycourses(StudentDto student);
    public void viewCourse( StudentDto student);
    public void menuCourse(StudentDto student,CourseDto course);
    public void unregisterC(StudentDto student, CourseDto course);
    public void submitAss( CourseDto course, StudentDto student);
    public void gradReports(StudentDto student);
}
