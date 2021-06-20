/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.GeziOrganizasyonu;
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
public class GeziOrganizasyonuDao {

    public GeziOrganizasyonu getGeziOrganizasyonu(int id) {
        GeziOrganizasyonu g = null;
        Connection con = ConnectionManager.getConnection();
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from geziOrganizasyonu where id=" + id);

            while (rs.next()) {
                g = new GeziOrganizasyonu(rs.getInt("id"), rs.getString("gidilecekYer"), rs.getString("hareketYeri"), rs.getString("tarih"),rs.getString("saat"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return g;
    }

    public void createGeziOrganizasyonu(GeziOrganizasyonu g) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("insert into geziOrganizasyonu (gidilecekYer,hareketYeri,tarih,saat) values ('" + g.getGidilecekYer() + "', '" + g.getHareketYeri() + "', '" + g.getTarih() + "', '" + g.getSaat() + "')");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateGeziOrganizasyonu(GeziOrganizasyonu g) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update geziOrganizasyonu set gidilecekYer = '" + g.getGidilecekYer() + "', hareketYeri = '" + g.getHareketYeri() + "',tarih = '" + g.getTarih() + "', saat = '" + g.getSaat() + "' where id = " + g.getId() + "");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(int id) {

        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from geziOrganizasyonu where id=" + id);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public ArrayList<GeziOrganizasyonu> getGeziOrganizasyonuList() {
        ArrayList<GeziOrganizasyonu> gList = new ArrayList();
        Connection con = ConnectionManager.getConnection();
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from geziOrganizasyonu");
            while (rs.next()) {
                gList.add(new GeziOrganizasyonu(rs.getInt("id"), rs.getString("gidilecekYer"), rs.getString("hareketYeri"), rs.getString("tarih"), rs.getString("saat")));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return gList;
    }

}
