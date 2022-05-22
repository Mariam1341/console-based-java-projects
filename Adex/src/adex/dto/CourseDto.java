/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adex.dto;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vega Laptop
 */
public class CourseDto {
    private static String name, code, DoctorName, DoctorId, CourseSummary;//, DoctorDao doctor  doctor.addCourse(this);
    private Map<String, StudentDto> students = new HashMap();
    private Map<String, AssignmentDto> assignments = new HashMap();

    public CourseDto(String name, String code, String CourseSummary, String DoctorName) {
        this.name = name;
        this.code = code;
        this.CourseSummary = CourseSummary;
        this.DoctorName = DoctorName;
        System.out.println(code);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }

    public void setDoctorId(String doctorId) {
        DoctorId = doctorId;
    }

    public String getDoctorId() {
        return this.DoctorId;
    }
    public String getCourseSummary() {
        return CourseSummary;
    }
   
    public void printBasicDetails() {

        System.out.println("Course Name: " + name + "\tCode" + code);

    }

    public Map<String, StudentDto> getStudents() {
        return students;
    }

    public Map<String, AssignmentDto> getAssignment() {
        return assignments;
    }

    
}
