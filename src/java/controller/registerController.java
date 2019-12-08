/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import General.GenericDao;
import domain.RegisterCredidentials;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Edison
 */
@ManagedBean (name="re",eager = true)
@SessionScoped
public class registerController {
    private final RegisterCredidentials rc=new RegisterCredidentials();
    private String email;
    private String password;
    private String emailConfirm;
    private String passwordConfirm;
    
    private String dbEmail=new String();
    private String dbPassword=new String();
 
    
    public void saveCredidentials(){
        try {
            if(!rc.getEmail().equals(emailConfirm)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("emails has to match"));
            }else if(!rc.getPassword().equals(passwordConfirm)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("passwords has to match"));
            }else{
                new GenericDao<RegisterCredidentials>().create(rc);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("success"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("that email already used"));
        }
    }
    
    public String login(){
        try {
            new GenericDao<RegisterCredidentials>().findByName(RegisterCredidentials.class, "email", email).forEach((r) -> {
                dbEmail=r.getEmail();
            });
            new GenericDao<RegisterCredidentials>().findByName(RegisterCredidentials.class, "password", password).forEach((r) -> {
                dbPassword=r.getPassword();
            });
            
            if(dbEmail.equals(email) && dbPassword.equals(password)){
                return "registerDashboard";
            }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("wrong credidentials"));
            return "";
            }  
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    public RegisterCredidentials getRc() {
        return rc;
    }

    public String getEmailConfirm() {
        return emailConfirm;
    }

    public void setEmailConfirm(String emailConfirm) {
        this.emailConfirm = emailConfirm;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
