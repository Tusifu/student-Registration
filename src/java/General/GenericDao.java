/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author student
 * @param <X>
 */
public class GenericDao<X> {
    
    public void create(X x){
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(x);
        s.getTransaction().commit();
        s.close();
    }
     
    public void update(X x){
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(x);
        s.getTransaction().commit();
        s.close();
    }
    
     
    public void delete(X x){
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(x);
        s.getTransaction().commit();
        s.close();
    }
    
    public X findOne(Class c, Serializable id){
        Session s = HibernateUtil.getSessionFactory().openSession();
        X x = (X) s.get(c, id);
        s.close();
        return x;
    }
    
    public List<X> findAll(Class c){
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("FROM "+c.getName()+" a");
        List<X> list = q.list();
        s.close();
        return list;
    }
    
    public List<X> findByName(Class c,String column,String name){
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q=s.createQuery("From "+c.getName()+" e where e."+column+" like :name").setParameter("name", name+"%");
        List<X> list=q.list();
        s.close();
        return list;
    }
}
