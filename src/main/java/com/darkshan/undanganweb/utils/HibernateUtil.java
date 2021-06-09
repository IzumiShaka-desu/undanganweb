/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darkshan.undanganweb.utils;

import com.darkshan.undanganweb.dao.UndanganDao;
import com.darkshan.undanganweb.dao.UndanganHibDaoimpl;
import com.darkshan.undanganweb.service.UndanganHibImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Darkshan
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static UndanganDao undanganDao;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            // Log the exception. 
            Logger.getLogger(HibernateUtil.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static UndanganDao getUndanganDao() {
        if (undanganDao == null) {
            undanganDao = new UndanganHibDaoimpl(getSessionFactory().openSession());
        }
        return undanganDao;
    }

    private static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

