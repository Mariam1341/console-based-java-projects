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
public class DoctorDto extends User {
    private Map<String, CourseDto> courses = new HashMap();
    
    public DoctorDto(String userName, String ID) {
        super(userName, ID);
    }
    public DoctorDto(String userName, String ID, String password, String fullName, String email) {
        super(userName, ID, password, fullName, email);
    }

    public Map<String, CourseDto> getCourses() {
        return courses;
    }
    
    
}