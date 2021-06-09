/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darkshan.undanganweb.service;

import com.darkshan.undanganweb.entity.Undangan;
import java.util.List;

/**
 *
 * @author Darkshan
 */
public interface UndanganService {
    public boolean insert(Undangan undangan);
    public boolean update(Undangan undangan);
    public boolean delete(Undangan id_undangan);
    public Undangan getUndanganById(Long id_undangan);
    public List<Undangan> getAllUndangan();
}
