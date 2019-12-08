/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DepartmentDao;
import dao.FacultyDao;
import domain.Department;
import domain.EacProgram;
import domain.Faculty;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Edison
 */
@ManagedBean (name = "ac",eager = true)
@SessionScoped
public class AcademicController {
   private final Faculty faculty=new Faculty();
   private final Department department=new Department();
   private List<Faculty>faculties=new FacultyDao().findAll(Faculty.class);
   private String facId = new String();
   private List<Department> departments=new ArrayList<>();

    public Faculty getFaculty() {
        return faculty;
    }
    
    
    public void departmentsInit(){
        departments.clear();
        for(Department d : new DepartmentDao().findAll(Department.class)){
            if(d.getFaculty().getCode().equalsIgnoreCase(facId)){
                departments.add(d);
            }
        }
    }
    public void saveFaculty(){
        try {
            new FacultyDao().create(faculty);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    public void saveDepartment(){
        try {
            Faculty fc=new FacultyDao().findOne(Faculty.class, facId);
            department.setFaculty(fc);
            new DepartmentDao().create(department);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public Department getDepartment() {
        return department;
    }
    

    public String getFacId() {
        return facId;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public void setFacId(String facId) {
        this.facId = facId;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
   
   
}
