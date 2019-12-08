/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import General.GenericDao;
import dao.FacultyDao;
import dao.StudentDao;
import domain.Faculty;
import domain.Student;

/**
 *
 * @author Edison
 */
public class MainClass {

    public static void main(String[] args) {
//        HibernateUtil.getSessionFactory().openSession();
//        HibernateUtil.getSessionFactory().close();

//new GenericDao<District>().findAll(District.class).forEach((b)->{
//    System.out.println(b);
//});

//    new GenericDao<RegisterCredidentials>().findByName(RegisterCredidentials.class, "email", "king").forEach((b)->{
//        System.out.println(b);
//    });

//for(RegisterCredidentials r : new GenericDao<RegisterCredidentials>().findByName(RegisterCredidentials.class, "email", "kalisa@gmail.com")){
//        String dbEmail=r.getEmail();
//        System.out.println(dbEmail);
//            } 
       
//    new StudentDao().reject().forEach((b)->{
//        System.out.println(b);
//    });

//        System.out.println(new StudentDao().approved().size());

//            double AllStudents=new StudentDao().approved().size();
//     double male=new StudentDao().boys().size();
//     double female=new StudentDao().girls().size();
//     
//    double percent=(male/ AllStudents)*100;
//        System.out.println(Math.round(male));

//        new GenericDao<Student>().findByName(Student.class, "firstName", "kama").forEach((b)->{
//            System.out.println(b);
//        });

    new FacultyDao().findAll(Faculty.class).forEach((c)->{
        System.out.println(c);
    });
    
    }
     
}
