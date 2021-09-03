/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darkshan.undanganweb.service;

import com.darkshan.undanganweb.dao.UndanganDao;
import com.darkshan.undanganweb.entity.Undangan;
import java.util.List;

/**
 *
 * @author Darkshan
 */
public class UndanganHibImpl implements UndanganService {
    private final UndanganDao dao;

    public UndanganHibImpl(UndanganDao dao) {
        this.dao = dao;
    }
     
    @Override
    public boolean insert(Undangan undangan) {
        return dao.insert(undangan);
    }

    @Override
    public boolean update(Undangan undangan) {
        return dao.update(undangan);
    }

    @Override
    public boolean delete(Undangan undngn) {
        return dao.delete(undngn);
    }

    @Override
    public Undangan getUndanganById(int id_undangan) {
        return dao.getUndanganById(id_undangan);
    }

    @Override
    public List<Undangan> getAllUndangan() {
        return dao.getAllUndangan();
    }

    @Override
    public boolean register(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean login(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
