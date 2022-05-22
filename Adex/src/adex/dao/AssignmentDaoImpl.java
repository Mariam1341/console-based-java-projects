/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adex.dao;

import adex.dto.AssignmentDto;
import adex.dto.CourseDto;
import adex.dto.SolutionDto;
import adex.dto.StudentDto;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Vega Laptop
 */
public class AssignmentDaoImpl implements AssignmentDao{
    Scanner input = new Scanner(System.in);
    
    @Override
    public void listAss(CourseDto course){
        Set<String> keys = course.getAssignment().keySet();
        for(String key : keys){
            System.out.print("Code: "+course.getAssignment().get(key).getCode() );
            System.out.println("Info: "+course.getAssignment().get(key).getInfo());
        }
    }
    
    public void createAss(CourseDto course){
        System.out.println("Enter  the Asssignment code:");
        String code = input.next();
        System.out.println("Enter  the Asssignment info:");
        String info = input.next();
        System.out.println("Enter  the Asssignment total grade:");
        double totalGrade = input.nextDouble();  
        AssignmentDto ass = new AssignmentDto(code,totalGrade,info);
        course.getAssignment().put(code, ass);
    }
    
    public void showInfo(AssignmentDto ass){
        System.out.println(ass.getInfo());
    }
    
    public void showGradesRep(AssignmentDto ass){
        Set<String> keys = ass.getStudentsGrades().keySet();
        for(String key : keys){
            System.out.println("Student name: "+key+"Student grade: "+ass.getStudentsGrades().get(key));
        }
    }
    
    public void listSolutions(AssignmentDto ass){
        Set<String> keys = ass.getStudentsSolutions().keySet();
        for(String key : keys){
            System.out.println("Student name: "+key+"Student solution: "+ass.getStudentsSolutions().get(key).getSolution());
        }
    }
    
    public void showSolInfo(String name, AssignmentDto ass){        
        ass.getStudentsSolutions().get(name).getSolution();      
    }
    
    public void setGrade(String name, AssignmentDto ass, double grade){
        ass.getStudentsGrades().replace(name, grade);
    }
    
    public void setComment(String name, AssignmentDto ass, String comment){
        ass.getStudentsSolutions().get(name).setComment(comment);
    }
    
    public void solve(StudentDto student, AssignmentDto ass){
        System.out.println(" Enter your solution...");
        String sol = input.next();
        ass.getStudentsSolutions().get(student.getUserName()).setSolution(sol);
    }
    
//    public void solve(StudentDto student, CourseDto course){
//   if () {
//       System.out.println(" Enter your solution...");
//       AssignmentDto.setSolution(input.nextLine()) ;
////            AssignmentDto.isSubmitted() = true;
//   } else {
//
//       System.out.println("you already has a solution. \n Need to update your solution? type y for \"Yes\" or n for \"No\"");
//       char ch = input.next().charAt(0);
//       while (ch != 'y' && ch != 'n') {
//           System.out.println("Wrong input .. Try Again.");
//           ch = input.next().charAt(0);
//       }
//
//       if (ch == 'y') {
//           System.out.println(" Enter your new solution...");
//       AssignmentDto.setSolution(input.nextLine()) ;
////            AssignmentDto.isSubmitted() = true;
//       }
//   }
//    }
//    }
    
    
}