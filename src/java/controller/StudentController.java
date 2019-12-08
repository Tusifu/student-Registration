/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import counter.UserCounter;
import dao.DepartmentDao;
import dao.DistrictDao;
import dao.StudentDao;
import domain.Department;
import domain.District;
import domain.EGender;
import domain.EStatus;
import domain.EacProgram;
import domain.EducationBackground;
import domain.Student;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.PostUpdate;

/**
 *
 * @author Edison
 */
@ManagedBean(name = "st", eager = true)
@SessionScoped
public class StudentController {

    Student student = new Student();
    private String depid = new String();
    private String distid = new String();
    //get the list of all approved students
    private List<Student> approvedStudents=new StudentDao().approved();
    //get List of all rejected Students
    private List<Student> rejectedStudents=new StudentDao().reject();
    //the key which will be use to search
    private String searchKey =new String();
    //this list will hold all the applicants event those who are not approved
    private final List<Student> applicants = new StudentDao().findAll(Student.class);

    public List<Student> getApplicants() {
        return applicants;
    }

    
    //save the applicants information
    public void saveStudent() {
        try {
            District dis = new DistrictDao().findOne(District.class, distid);
            Department dep = new DepartmentDao().findOne(Department.class, depid);

            EducationBackground edb = new EducationBackground();
            edb.getEducationId();
            student.setEducationBackground(edb);
            student.setDepartment(dep);
            student.setDistrict(dis);
            new StudentDao().create(student);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("success"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //this will be used in the preview to get only names not id(for district and province).
    public String getDistrictName() {
        District dis = new DistrictDao().findOne(District.class, distid);
        return dis.getName();
    }

    public String getProvinceName() {
        District dis = new DistrictDao().findOne(District.class, distid);
        return dis.getProvince().getName();
    }

    //this will be used in the preview to get only names not id(fac and department).
    public String getDepartmentName() {
        Department dep = new DepartmentDao().findOne(Department.class, depid);
        return dep.getName();
    }

    public String getFacultyName() {
        Department dep = new DepartmentDao().findOne(Department.class, depid);
        return dep.getFaculty().getName();
    }

    //this method is adding the Egender into the list so that it can
    //be passed to combo box
    public List<String> getGender() {
        List<String> gender = new ArrayList<>();
        for (EGender g : EGender.values()) {
            gender.add(g.toString());
        }
        return gender;
    }

    //this method is adding the Estatus into the list so that it can
    //be passed to combo box
    public List<String> getStatus() {
        List<String> status = new ArrayList<>();
        for (EStatus st : EStatus.values()) {
            status.add(st.toString());
        }
        return status;
    }

    //this method is adding the EacademicProgram into the list so that it can
    //be passed to combo box
    public List<String> getAcademicProgram() {
        List<String> program = new ArrayList<>();
        for (EacProgram g : EacProgram.values()) {
            program.add(g.toString());
        }
        return program;
    }

    //after click approved button update the column approvalStatus in applicants table
    public void approve(Student s) {
        try {
            s.setApprovalStatus("Approved");
            new StudentDao().update(s);
            FacesContext context=FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("success"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    //after click reject button update the column approvalStatus in applicants table
    public void reject(Student s) {
        try {
            s.setApprovalStatus("rejected");
            new StudentDao().update(s);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(s.getFirstName()+" is rejected"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    //search method
    public void search(){
        if(searchKey.isEmpty() || searchKey == null){
            approvedStudents=new StudentDao().approved();
        }else{
            approvedStudents=new StudentDao().findByName(Student.class, "firstName", searchKey);
        }
    }
    public List<Student>approvedOnes(){
        return approvedStudents;
    }

    
    //method which return the number of the students who are working the registration
    public int onlineApplicants(){
        return UserCounter.getActiveUser();
    }
    
    
    public List<Student> getApprovedStudents() {
        return approvedStudents;
    }
    

    public List<Student> getRejectedStudents() {
        return rejectedStudents;
    }
    public void setApprovedStudents(List<Student> approvedStudents) {
        this.approvedStudents = approvedStudents;
    }
    public void setRejectedStudents(List<Student> rejectedStudents) {
        this.rejectedStudents = rejectedStudents;
    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    public String getDepid() {
        return depid;
    }

    public void setDepid(String depid) {
        this.depid = depid;
    }
    public String getDistid() {
        return distid;
    }

    public void setDistid(String distid) {
        this.distid = distid;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}
