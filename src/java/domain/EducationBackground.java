/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Edison
 */
@Entity
public class EducationBackground implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int educationId;
   
    private String alevelSchool;
    private int alevelStartYear;
    private int alevelEndYear;
    private String acourseTaken;
    
    private String olevelSchool;
    private int olevelStartYear;
    private int olevelEndYear;
    
    private String instituteName;
    private int instituteStartYear;
    private int instituteEndYear;

    public int getEducationId() {
        return educationId;
    }

    public void setEducationId(int educationId) {
        this.educationId = educationId;
    }

    public String getAlevelSchool() {
        return alevelSchool;
    }

    public void setAlevelSchool(String alevelSchool) {
        this.alevelSchool = alevelSchool;
    }

    public int getAlevelStartYear() {
        return alevelStartYear;
    }

    public void setAlevelStartYear(int alevelStartYear) {
        this.alevelStartYear = alevelStartYear;
    }

    public int getAlevelEndYear() {
        return alevelEndYear;
    }

    public void setAlevelEndYear(int alevelEndYear) {
        this.alevelEndYear = alevelEndYear;
    }

    public String getAcourseTaken() {
        return acourseTaken;
    }

    public void setAcourseTaken(String acourseTaken) {
        this.acourseTaken = acourseTaken;
    }

    public String getOlevelSchool() {
        return olevelSchool;
    }

    public void setOlevelSchool(String olevelSchool) {
        this.olevelSchool = olevelSchool;
    }

    public int getOlevelStartYear() {
        return olevelStartYear;
    }

    public void setOlevelStartYear(int olevelStartYear) {
        this.olevelStartYear = olevelStartYear;
    }

    public int getOlevelEndYear() {
        return olevelEndYear;
    }

    public void setOlevelEndYear(int olevelEndYear) {
        this.olevelEndYear = olevelEndYear;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public int getInstituteStartYear() {
        return instituteStartYear;
    }

    public void setInstituteStartYear(int instituteStartYear) {
        this.instituteStartYear = instituteStartYear;
    }

    public int getInstituteEndYear() {
        return instituteEndYear;
    }

    public void setInstituteEndYear(int instituteEndYear) {
        this.instituteEndYear = instituteEndYear;
    }

//    @Override
//    public String toString() {
//        return "EducationBackground{" + "educationId=" + educationId + ", alevelSchool=" + alevelSchool + ", alevelStartYear=" + alevelStartYear + ", alevelEndYear=" + alevelEndYear + ", acourseTaken=" + acourseTaken + ", olevelSchool=" + olevelSchool + ", olevelStartYear=" + olevelStartYear + ", olevelEndYear=" + olevelEndYear + ", instituteName=" + instituteName + ", instituteStartYear=" + instituteStartYear + ", instituteEndYear=" + instituteEndYear + '}';
//    }

    
}
