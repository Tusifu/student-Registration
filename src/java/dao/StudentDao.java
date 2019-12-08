/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import General.GenericDao;
import domain.Student;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Edison
 */
public class StudentDao extends GenericDao<Student>{
   public List<Student> approved(){
       Session ss=HibernateUtil.getSessionFactory().openSession();
       ss.beginTransaction();
       Query q=ss.createQuery("from Student where approvalStatus='Approved'");
       List<Student> li=q.list();
       ss.close();
       return li;
    }
   
   public List<Student> reject(){
       Session ss=HibernateUtil.getSessionFactory().openSession();
       ss.beginTransaction();
       Query q=ss.createQuery("from Student where approvalStatus='rejected'");
       List<Student> li=q.list();
       ss.close();
       return li;
    }

   
}
