/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adex.dao;

import static adex.dao.DoctorDaoImpl.validEmail;
import adex.dto.CourseDto;
import adex.dto.DoctorDto;
import adex.dto.StudentDto;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Vega Laptop
 */
public class StudentDaoImpl implements StudentDao{
    //private Map<String, StudentDto> students = new HashMap();
    Scanner input = new Scanner(System.in);

    
    
    @Override
    public StudentDto signup() {
       System.out.println("  Enter Full Name: ");
        String fullName = input.nextLine();
        System.out.println("  Enter User Name: ");
        String userName = input.nextLine();
        System.out.println("  Enter Email: ");
        String email = input.nextLine();
        while(!(validEmail(email))){
            System.out.println("this email is not valid try again....");
            System.out.println("  Enter Email: ");
            email = input.nextLine();
        }
        System.out.println("  Enter password: ");
        String password = input.nextLine();
        System.out.println("  Enter ID: ");
        String ID = input.nextLine();
        StudentDto s = new StudentDto(userName, ID, password, fullName, email);
        DataBaseImpl.students.put(userName, s);
        return s;
    }

    @Override
    public StudentDto login() {
        System.out.println("  Enter User Name: ");
        String userName = input.nextLine();
        System.out.println("  Enter password: ");
        String password = input.nextLine();   
        Set<String> keys = DataBaseImpl.students.keySet();
        for(String key : keys){
            if(key.equals(userName)){
                if(DataBaseImpl.students.get(key).getPassword().equals(password)){
                    System.out.println("Welcomme "+DataBaseImpl.students.get(key).getFullName()+". You are logged in");
                    return DataBaseImpl.students.get(key);
                }else{
                    System.out.println("You enter wrong password try again:  ");
                    if(password.equals(input.next())){
                        System.out.println("Welcomme "+DataBaseImpl.students.get(key).getFullName()+". You are logged in");
                        return DataBaseImpl.students.get(key);
                    }else{
                        System.out.println("You enter wrong password try to login with your ID./nEnter your ID:  ");
                        if(DataBaseImpl.students.get(key).getID().equals(input.next())){
                            System.out.println("Welcomme "+DataBaseImpl.students.get(key).getFullName()+". You are logged in");
                            return DataBaseImpl.students.get(key);
                        }else{
                            System.out.println("\n**Not found account, you have to sign up:\n");
                            signup();
                        }
                    }                  
                }
            }
        }
        System.out.println("\n**Not found account, you have to sign up:\n");return null;
    }
    
    public void nomycourse(StudentDto student){
        Set<String> keys = DataBaseImpl.courses.keySet();
        Set<String> mycourses = student.getMyCourses().keySet();
        for(String key : keys){
            for(String course : mycourses){
                if(!(key.equals(course))){
                    student.getNoMyCourses().put(key, DataBaseImpl.courses.get(key));
                }
            }
        }
    }
    
    @Override
    public void registerC(StudentDto student){
        nomycourse(student);
        Set<String> keys = student.getNoMyCourses().keySet();
        System.out.println("My Courses list:");
        int num = 1;
        for(String key : keys){
            System.out.println(num+") Course: "+student.getNoMyCourses().get(key).getName()+" - Code: "+ key );
            num++;
        }
        System.out.println("\nEnter the code of the course you want to register in:  ");
        String choice = input.next();
        student.getMyCourses().put(choice, student.getNoMyCourses().get(choice));
        student.getNoMyCourses().get(choice).getStudents().put(student.getID(), student);
        student.getNoMyCourses().remove(choice);  
    }

    @Override
    public void listMycourses(StudentDto student){
        Set<String> keys = student.getMyCourses().keySet();
        System.out.println("My Courses list:");
        int num = 1;
        for(String key : keys){
            System.out.println(num+") Course: "+student.getMyCourses().get(key).getName()+" - Code: "+ key );
            num++;
        }
        System.out.println("which ith [1 - "+student.getMyCourses().size()+"] course to view?");
        viewCourse(student);
    }
    
    @Override
    public void viewCourse( StudentDto student){
        System.out.println("Enter  the course code:");
        String code = input.next();
        CourseDto course = student.getMyCourses().get(code);
        System.out.println("Course "+ course.getName()+" with Code "+ course.getCode()+" - taught by Doctor"+course.getDoctorName());
        Set<String> keys = course.getAssignment().keySet();
        System.out.println("Course has "+course.getAssignment().size()+"assignment");
        int num = 1;
        for(String key : keys){
            System.out.println("Assignment "+num+" "+course.getAssignment().get(key).getStudentsSolutions().get(student.getUserName()).isSubmitted()+" - "+course.getAssignment().get(key).getStudentsSolutions().get(student.getUserName()).getStudentGrade()+" / "+course.getAssignment().get(key).getTotalGrade());
        }
        System.out.println();
        menuCourse(student, course);
    }
    
    @Override
    public void menuCourse(StudentDto student,CourseDto course){
        System.out.println("please make a choice:\n           1-Submit assignment solution \n           2-Unredister from course\n           3-Back\n           Enter Choice: ");
        int choice = input.nextInt();
        if(choice == 1){
            submitAss(course, student);
        }else if(choice == 2){
            unregisterC(student, course);
        }else if(choice == 3){
            viewCourse(student);
        }else{
            System.out.println("This number is not valid....try again");
            menuCourse(student,course);
        }
    }
    
    @Override
    public void unregisterC(StudentDto student, CourseDto course){
        student.getNoMyCourses().put(course.getCode(), course);
        student.getMyCourses().remove(course.getCode());
        course.getStudents().remove(student.getID());
    }
    
    @Override
    public void submitAss( CourseDto course, StudentDto student){
        System.out.println("Enter  the assignment code:");
        String code = input.next();
        System.out.println("Enter  the assignment solution:");
        String sol = input.next();
        course.getAssignment().get(code).getStudentsSolutions().get(student).setSolution(sol);
        course.getAssignment().get(code).getStudentsSolutions().get(student).setSubmitted(true);        
    }
    
    @Override
    public void gradReports(StudentDto student){
        Set<String> keys = student.getMyCourses().keySet();
        for(String key : keys){
            double totalGrade = 0;
            double total = 0;
            int totalasssubm = 0;
            System.out.print("Course code "+ key);
            Set<String> assignments = student.getMyCourses().get(key).getAssignment().keySet();
            for(String ass : assignments){
                if(student.getMyCourses().get(key).getAssignment().get(ass).getStudentsSolutions().get(student.getUserName()).isSubmitted().equals("sumitted")){
                    totalasssubm ++;
                }
                totalGrade +=student.getMyCourses().get(key).getAssignment().get(ass).getStudentsSolutions().get(student.getUserName()).getStudentGrade();
                total += student.getMyCourses().get(key).getAssignment().get(ass).getTotalGrade(); 
            }
            System.out.print(" - Total "+totalasssubm+" assignments");
            System.out.println(" - Grade "+totalGrade+" / "+total);   
        }
    }
    
    
}
