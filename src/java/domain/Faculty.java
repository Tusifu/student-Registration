/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author Edison
 */
@Entity
public class Faculty extends AcademicStructure implements Serializable {
    @OneToMany(mappedBy = "faculty",fetch=FetchType.EAGER)
    private List<Department> departments;

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Faculty{" + "departments=" + departments + '}';
    }
    
    
}
