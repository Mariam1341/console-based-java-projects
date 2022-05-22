/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adex.view;

import adex.dao.AssignmentDao;
import adex.dao.DaoFactory;
import adex.dao.DoctorDao;
import adex.dao.StudentDao;
import adex.dto.AssignmentDto;
import adex.dto.CourseDto;
import adex.dto.DoctorDto;
import adex.dto.StudentDto;
import java.util.Scanner;

/**
 *
 * @author Vega Laptop
 */
public class Main {
    Scanner input = new Scanner(System.in);
    DaoFactory fac = new DaoFactory();
    DoctorDao doctor = fac.getDoctorDao();
    StudentDao student = fac.getStudentDao();
    AssignmentDao assignment = fac.getAssignmentDao();
    
    public void mainMenu(){
       System.out.print("\nplease make a choice:\n           1-Login\n           2-Sign up\n           3-Shutdown system\n           Enter your choice: ");
       int choice = input.nextInt();
       if(choice == 1){
           System.out.print("\nplease make a choice login in as a:\n           1-Doctor\n           2-Student\n           3-Teacher Assistant\n           Enter your choice: ");
           int check = input.nextInt();
           switch(check){
               case 1:
                   menuDoc(doctor.login());
                   break;
               case 2:
                   menuStudent(student.login());
                   break;
               case 3:
                   break;
           } 
       }else if(choice == 2){
           System.out.print("\nplease make a choice Sign Up as a:\n           1-Doctor\n           2-Student\n           3-Teacher Assistant\n           Enter your choice: ");
           int check = input.nextInt();
           switch(check){
                case 1:
                    menuDoc(doctor.signup());                    
                    break;
                case 2:
                    menuStudent(student.signup());
                    break;
                case 3:
                    break;
            }      
       }else if(choice == 3){
           System.exit(0);
       }else{
           System.out.println("This num is not vaild");
           mainMenu();
       }
    }
      
    public void menuDoc(DoctorDto doc){      
        System.out.println("please make a choice:\n           1-List courses\n           2-Creat Course\n           3-View Course\n           4-Log Out");
        int choice = input.nextInt();
        if(choice == 1){
            doctor.listCourses(doc);
            menuDoc(doc);
        }else if(choice == 2){
            System.out.println("Enter  the course name:");
            String name = input.next();
            System.out.println("Enter  the course code:");
            String code = input.next();
            System.out.println("Enter  the course Summary:");
            String CourseSummary = input.next();      
            doctor.createCourse(name, code,CourseSummary, doc);
            menuDoc(doc);
        }else if(choice == 3){
            System.out.println("Enter  the course code:");
            String code = input.next();
            viewCourse(doc.getCourses().get(code), doc);
        }else if(choice == 4){
                mainMenu();
        }else{
            System.out.println("This num is not vaild");
            menuDoc(doc);
        }                
    }
     
    public  void viewCourse(CourseDto co,DoctorDto doc){   
        System.out.println("please make a choice:\n           1-List Assignments\n           2-Creat Assignment\n           3-View Assignment\n           4-Back");
        int choice = input.nextInt();
        if(choice == 1){
            assignment.listAss(co);
            viewCourse(co,doc);
            viewCourse(co,doc);
        }else if(choice == 2){
            assignment.createAss(co);
            viewCourse(co,doc);
        }else if(choice == 3){
            System.out.println("Enter  "
                    + " Asssignment code:");
            String code = input.next();
            viewAssignment(co.getAssignment().get(code),co,doc);
            viewCourse(co,doc);
        }else if(choice == 4){
             menuDoc(doc);
        }else{
            System.out.println("Enter a valid number");
            viewCourse(co,doc);
        }
    } 
    
    public void viewAssignment(AssignmentDto ass, CourseDto co, DoctorDto doc){
        System.out.println( "please make a choice:\n           1-Show Info\n           2-Show Grads Report\n           3-List Solutions\n           4-View Solution\n           5-Back");
        int choice = input.nextInt();
        if(choice == 1){
            assignment.showInfo(ass);
            viewAssignment(ass,co,doc);
        }else if(choice == 2){
            assignment.showGradesRep(ass);
            viewAssignment(ass,co,doc);
        }else if(choice == 3){
            assignment.listSolutions(ass);
            viewAssignment(ass,co,doc);
        }else if(choice == 4){
            System.out.println("Enter  the student name:");
            String name = input.next();
            viewSolution(name,ass,co,doc);
        }else if(choice == 5){
            viewCourse(co,doc);
        }else{
            System.out.println("Enter a valid number");
            viewAssignment(ass,co,doc);
        }
    
    
    }
    
    public void viewSolution(String name, AssignmentDto ass, CourseDto co, DoctorDto doc){
        System.out.println( "please make a choice:\n           1-Show Info\n           2-Set Grad\n           3-Set a Comment\n           4-Back");
        int choice = input.nextInt();
        if(choice == 1){
            assignment.showSolInfo(name, ass);
            viewSolution(name,ass,co,doc);
        }else if(choice == 2){
            System.out.println("Enter  the student grade:");
            double grade = input.nextDouble();
            assignment.setGrade(name, ass, grade);
            viewSolution(name,ass,co,doc);
        }else if(choice == 3){
            System.out.println("Enter  the comment:");
            String comment = input.next();
            assignment.setComment(name, ass, comment);
            viewSolution(name,ass,co,doc);
        }else if(choice == 4){
            viewAssignment(ass,co,doc);
        }else{
            System.out.println("Enter a valid number");
            viewSolution(name,ass,co,doc);
        }
    }
    
    public void menuStudent(StudentDto stu){
        System.out.println("please make a choice:\n           1-Register in course \n           2-List My Courses\n           3-View a Course\n           4-Grades Report\n           5-Log Out");
        int choice = input.nextInt();
        if(choice == 1){
            student.registerC(stu);
            menuStudent(stu);
        }else if(choice == 2){
            student.listMycourses(stu);
            menuStudent(stu);
        }else if(choice == 3){
              student.viewCourse(stu);
        }else if(choice == 4){
            student.gradReports(stu);
            menuStudent(stu);
        }else if(choice == 5){
            mainMenu();
        }else{
            System.out.println("Enter a valid number");
            menuStudent(stu);
        } 
    }
    
    
    
    
     public static void main(String[] args) {
        DummyData t = new DummyData();
        t.start();
//        t.isAlive();
//        Main m = new Main();
//        System.out.println(t.isAlive());
//        m.mainMenu(); 
    }
    
}
