/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darkshan.undanganweb.utils;

import com.darkshan.undanganweb.config.Koneksi;
import com.darkshan.undanganweb.dao.UndanganDao;
import com.darkshan.undanganweb.dao.UndanganImpl;

/**
 *
 * @author Darkshan
 */
public class DbUtils {
    private static UndanganDao undanganDao;

    public static UndanganDao getUndanganDao() {
        if (undanganDao == null) {
            undanganDao = new UndanganImpl(Koneksi.getConnection());
        }
        return undanganDao;
    }
}
