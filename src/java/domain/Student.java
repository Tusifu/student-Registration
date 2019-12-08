/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Edison
 */
@Entity
public class Student extends Person {
    @Enumerated (EnumType.STRING)
    private EacProgram academicProgram;
    @OneToOne (cascade = CascadeType.ALL)
    private EducationBackground educationBackground = new EducationBackground();
    private String approvalStatus;
    @ManyToOne
    private District district;
    
    @ManyToOne
    private Department department;

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public EducationBackground getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(EducationBackground educationBackground) {
        this.educationBackground = educationBackground;
    }

    public EacProgram getAcademicProgram() {
        return academicProgram;
    }

    public void setAcademicProgram(EacProgram academicProgram) {
        this.academicProgram = academicProgram;
    }

    @Override
    public String toString() {
        return "Student{" + "academicProgram=" + academicProgram + ", educationBackground=" + educationBackground + ", approvalStatus=" + approvalStatus + ", district=" + district + ", department=" + department + '}';
    }
    
       
}
