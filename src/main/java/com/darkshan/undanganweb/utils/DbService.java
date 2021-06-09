/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darkshan.undanganweb.utils;

import com.darkshan.undanganweb.config.Koneksi;
import com.darkshan.undanganweb.dao.UndanganDao;
import com.darkshan.undanganweb.dao.UndanganImpl;
import com.darkshan.undanganweb.service.UndanganServiceImpl;

/**
 *
 * @author Darkshan
 */
public class DbService {
    private static UndanganServiceImpl undanganService;
    public static UndanganServiceImpl getUndanganService() {
        if (undanganService == null) {
            undanganService = new UndanganServiceImpl(DbUtils.getUndanganDao());
        }
        return undanganService;
    }
}
