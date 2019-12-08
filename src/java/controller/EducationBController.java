/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import General.GenericDao;
import domain.EducationBackground;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Edison
 */
@ManagedBean (name = "ed")
@SessionScoped
public class EducationBController {
    private final EducationBackground educationBackground=new EducationBackground();

    public EducationBackground getEducationBackground() {
        return educationBackground;
    }
    public String gotoSelectMojor(){
        new GenericDao<EducationBackground>().create(educationBackground);
    return "selectMajor";
    }
}
