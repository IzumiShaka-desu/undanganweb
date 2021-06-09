/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darkshan.undanganweb.dao;

import com.darkshan.undanganweb.entity.Undangan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Darkshan
 */
public class UndanganImpl implements UndanganDao {
    private final Connection connection;

    private final String INSERT = "INSERT INTO `undangan`(`p_pria`, `p_wanita`, `jadwal`, `alamat`, `mengundang`) "
            + "	VALUES (?,?,?,?,?)";
    private final String UPDATE = "UPDATE `undangan` SET `p_pria`=?,`p_wanita`=?,`jadwal`=?,`alamat`=?,`mengundang`=? WHERE `id_undangan`=?";
    private final String DELETE = "DELETE FROM `undangan` WHERE `id_undangan`=?";
    private final String SELECT_ALL = "SELECT * FROM mahasiswa";
    private final String SELECT_BY_NIM = "SELECT  * FROM `undangan` WHERE `id_undangan`=?";

    public UndanganImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public boolean insert(Undangan u) {
        PreparedStatement prepareStatement = null;
        try{
             prepareStatement = connection.prepareStatement(INSERT);
             prepareStatement.setString(1,u.getP_pria());
             prepareStatement.setString(2,u.getP_wanita());
             prepareStatement.setString(3,u.getJadwal().toString());
             prepareStatement.setString(4,u.getAlamat());
             prepareStatement.setString(5,u.getMengundang());
             return prepareStatement.executeUpdate()>0;
        }catch(SQLException  ex){
             Logger.getLogger(UndanganImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (prepareStatement != null) {
                try {
                    prepareStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UndanganImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;

    }

    @Override
    public boolean update(Undangan u) {
        PreparedStatement prepareStatement = null;
        try{
             prepareStatement = connection.prepareStatement(UPDATE);
             prepareStatement.setString(1,u.getP_pria());
             prepareStatement.setString(2,u.getP_wanita());
             prepareStatement.setString(3,u.getJadwal().toString());
             prepareStatement.setString(4,u.getAlamat());
             prepareStatement.setString(5,u.getMengundang());
             prepareStatement.setLong(6, u.getId_undangan());
             return prepareStatement.executeUpdate()>0;
        }catch(SQLException  ex){
             Logger.getLogger(UndanganImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (prepareStatement != null) {
                try {
                    prepareStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UndanganImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    @Override
    public boolean delete(Undangan u) {
        PreparedStatement prepareStatement = null;
        try{
             prepareStatement = connection.prepareStatement(DELETE);
             prepareStatement.setLong(1,u.getId_undangan());
           
             return prepareStatement.executeUpdate()>0;
        }catch(SQLException  ex){
             Logger.getLogger(UndanganImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (prepareStatement != null) {
                try {
                    prepareStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UndanganImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    @Override
    public Undangan getUndanganById(Long id_undangan) {
        PreparedStatement prepareStatement = null;
        ResultSet executeQuery = null;
        Undangan m = null;
        try {
            prepareStatement = connection.prepareStatement(SELECT_BY_NIM);
            prepareStatement.setLong(1, id_undangan);
            executeQuery = prepareStatement.executeQuery();
            if (executeQuery.next()) {
                System.out.println(""+SELECT_BY_NIM);
                String alamat=executeQuery.getNString("alamat");
                String p_wanita=executeQuery.getNString("p_wanita");
                String p_pria=executeQuery.getNString("p_pria");
//                int id_undangan=executeQuery.getInt("id_undangan");
                LocalDateTime jadwal=LocalDateTime.parse(executeQuery.getString("jadwal")) ;
                String mengundang=executeQuery.getNString("mengundang");
                m = new Undangan( id_undangan,  p_pria,  p_wanita,  alamat,  mengundang,  jadwal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UndanganImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (executeQuery != null) {
                    executeQuery.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UndanganImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return m;
    }

    @Override
    public List<Undangan> getAllUndangan() {
        List<Undangan> mahasiswas;
        mahasiswas = new ArrayList();
        Statement statement = null;
        ResultSet executeQuery = null;
        try {
            statement = connection.createStatement();
            executeQuery = statement.executeQuery(SELECT_ALL);
            while (executeQuery.next()) {
                String alamat=executeQuery.getNString("alamat");
                String p_wanita=executeQuery.getNString("p_wanita");
                String p_pria=executeQuery.getNString("p_pria");
                Long id_undangan=executeQuery.getLong("id_undangan");
                LocalDateTime jadwal=LocalDateTime.parse(executeQuery.getString("jadwal")) ;
                String mengundang=executeQuery.getNString("mengundang");
                Undangan  m = new Undangan( id_undangan,  p_pria,  p_wanita,  alamat,  mengundang,  jadwal);
                mahasiswas.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UndanganImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (statement != null) {
                    statement.close();
                }
                if (executeQuery != null) {
                    executeQuery.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UndanganImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return mahasiswas;

    }
    
}
