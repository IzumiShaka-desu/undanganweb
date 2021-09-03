/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darkshan.undanganweb.dao;

import com.darkshan.undanganweb.entity.Undangan;
import com.darkshan.undanganweb.entity.UserLogin;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Darkshan
 */
public class UndanganHibDaoimpl implements UndanganDao{
    private final Session session;

    public UndanganHibDaoimpl(Session session) {
        this.session = session;
    }

    @Override
    public boolean insert(Undangan u) {
         try {
            session.beginTransaction();
            int id = (int) session.save(u);
            session.getTransaction().commit();
            return String.valueOf(id)!= null;
        } catch (Exception e) {
            Logger.getLogger(UndanganHibDaoimpl.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
//            session.close();
        }
        return false;
    }

    @Override
    public boolean update(Undangan u) {
        try {
            session.beginTransaction();
            session.update(u);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            Logger.getLogger(UndanganHibDaoimpl.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
//            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Undangan u) {
        try {
            session.beginTransaction();
            session.delete(u);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            Logger.getLogger(UndanganHibDaoimpl.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
//            session.close();
        }
        return false;
    }

    @Override
    public Undangan getUndanganById(int i) {
         try {
            Query query = session.createQuery("FROM Undangan u WHERE u.id_undangan=:id_undangan");
            query.setParameter("id_undangan", i);
            return (Undangan) query.uniqueResult();
        } catch (Exception e) {
            Logger.getLogger(UndanganHibDaoimpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
//            session.close();
        }
        return null;
    }

    @Override
    public List<Undangan> getAllUndangan() {
          try {
              Query q=session.createQuery("FROM Undangan",Undangan.class);
            return q.list();
            
        } catch (Exception e) {
            Logger.getLogger(UndanganHibDaoimpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
//            session.close();
        }
        return null;
    }

    @Override
    public boolean register(String username, String password) {
         try {
              session.beginTransaction();
              UserLogin user=new UserLogin();
              user.setUsername(username);
              user.setPassword(password);
            int id = (int) session.save(user);
            session.getTransaction().commit();
            return String.valueOf(id)!= null;
        } catch (Exception e) {
            Logger.getLogger(UndanganHibDaoimpl.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
//            session.close();
        }
        return false;
    }

    @Override
    public boolean login(String username, String password) {
        try {
            Query query = session.createQuery("FROM UserLogin u WHERE u.username=:username AND u.password=:password");
            query.setParameter("username", username);
            query.setParameter("password",password);
            return  query.list().size()>0;
        } catch (Exception e) {
            Logger.getLogger(UndanganHibDaoimpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
//            session.close();
        }
        return false;
    }
}
