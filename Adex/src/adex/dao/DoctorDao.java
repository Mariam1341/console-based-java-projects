/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adex.dao;

import adex.dto.DoctorDto;

/**
 *
 * @author Vega Laptop
 */
public interface DoctorDao {
    public DoctorDto signup();
    public DoctorDto login();
    public void createCourse(String name, String code, String CourseSummary, DoctorDto doctor);
    public void listCourses(DoctorDto doctor);
    public void addTA();
}
