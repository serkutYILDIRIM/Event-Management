/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.DugunOrganizasyonu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utilities.ConnectionManager;

/**
 *
 * @author Serkut
 */
public class DugunOrganizasyonuDao {

    public DugunOrganizasyonu getDugunOrganizasyonu(int id) {
        DugunOrganizasyonu d = null;
        Connection con = ConnectionManager.getConnection();
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from dugunOrganizasyonu where id=" + id);

            while (rs.next()) {
                d = new DugunOrganizasyonu(rs.getInt("id"), rs.getString("dugunCesidi"), rs.getString("dugunYeri"), rs.getString("tarih"),rs.getString("saat"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return d;
    }

    public void createDugunOrganizasyonu(DugunOrganizasyonu d) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("insert into dugunOrganizasyonu (dugunCesidi,dugunYeri,tarih,saat) values ('" + d.getDugunCesidi() + "', '" + d.getDugunYeri() + "', '" + d.getTarih() + "', '" + d.getSaat() + "')");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateDugunOrganizasyonu(DugunOrganizasyonu d) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update dugunOrganizasyonu set dugunCesidi = '" + d.getDugunCesidi() + "', dugunYeri = '" + d.getDugunYeri() + "',tarih = '" + d.getTarih() + "', saat = '" + d.getSaat() + "' where id = " + d.getId() + "");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(int id) {

        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from dugunOrganizasyonu where id=" + id);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public ArrayList<DugunOrganizasyonu> getDugunOrganizasyonuList() {
        ArrayList<DugunOrganizasyonu> dList = new ArrayList();
        Connection con = ConnectionManager.getConnection();
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from dugunOrganizasyonu");
            while (rs.next()) {
                dList.add(new DugunOrganizasyonu(rs.getInt("id"), rs.getString("dugunCesidi"), rs.getString("dugunYeri"), rs.getString("tarih"), rs.getString("saat")));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return dList;
    }

}
