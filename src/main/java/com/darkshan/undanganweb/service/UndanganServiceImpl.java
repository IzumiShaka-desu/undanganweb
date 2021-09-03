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
public class UndanganServiceImpl implements UndanganService{
private final UndanganDao dao;

    public UndanganServiceImpl(UndanganDao undanganDao) {
        this.dao = undanganDao;
    }

    @Override
    public boolean insert(Undangan undangan) {
        return dao.insert(undangan);
    }

    @Override
    public boolean update(Undangan undangan) {
      return  dao.update(undangan);
    }

    @Override
    public boolean delete(Undangan u) {
      return  dao.delete(u);
    }

    @Override
    public Undangan getUndanganById(int id_undangan) {
      return  dao.getUndanganById(id_undangan);
    }
    

    @Override
    public List<Undangan> getAllUndangan() {
        return dao.getAllUndangan();
    }

    @Override
    public boolean register(String username, String password) {
        return dao.register(username, password);
    }

    @Override
    public boolean login(String username, String password) {
        return dao.login(username, password);
    }
    
    
}
