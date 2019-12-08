/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Student;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Edison
 */
public class chartDataDao {
       public List<Student> girls(){
       Session ss=HibernateUtil.getSessionFactory().openSession();
       ss.beginTransaction();
       Query q=ss.createQuery("from Student where gender='FEMALE' and approvalStatus='Approved'");
       List<Student> li=q.list();
       ss.close();
       return li;
   }
      public List<Student> boys(){
       Session ss=HibernateUtil.getSessionFactory().openSession();
       ss.beginTransaction();
       Query q=ss.createQuery("from Student where gender='MALE' and approvalStatus='Approved'");
       List<Student> li=q.list();
       ss.close();
       return li;
   }
        public List<Student> dayStudent(){
       Session ss=HibernateUtil.getSessionFactory().openSession();
       ss.beginTransaction();
       Query q=ss.createQuery("from Student where academicprogram='Day' and approvalStatus='Approved'");
       List<Student> li=q.list();
       ss.close();
       return li;
   }
      public List<Student> eveningStudent(){
       Session ss=HibernateUtil.getSessionFactory().openSession();
       ss.beginTransaction();
       Query q=ss.createQuery("from Student where academicprogram='evening' and approvalStatus='Approved'");
       List<Student> li=q.list();
       ss.close();
       return li;
   }
       public List<Student> inService(){
       Session ss=HibernateUtil.getSessionFactory().openSession();
       ss.beginTransaction();
       Query q=ss.createQuery("from Student where academicprogram='in_service' and approvalStatus='Approved'");
       List<Student> li=q.list();
       ss.close();
       return li;
   }
      
      
}
