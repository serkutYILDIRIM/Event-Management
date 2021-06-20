/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.OyunOrganizasyonu;
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
public class OyunOrganizasyonuDao {

    public OyunOrganizasyonu getOyunOrganizasyonu(int id) {
        OyunOrganizasyonu o = null;
        Connection con = ConnectionManager.getConnection();
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from oyunOrganizasyonu where id=" + id);

            while (rs.next()) {
                o = new OyunOrganizasyonu(rs.getInt("id"), rs.getString("oyunAdi"), rs.getString("oyunTuru"), rs.getString("tarih"), rs.getString("saat"), rs.getString("nerede"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return o;
    }

    public void createOyunOrganizasyonu(OyunOrganizasyonu o) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("insert into oyunOrganizasyonu (oyunAdi,oyunTuru,tarih,saat,nerede) values ('" + o.getOyunAdi() + "', '" + o.getOyunTuru() + "', '" + o.getTarih() + "', '" + o.getSaat() + "','" + o.getNerede() + "')");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateOyunOrganizasyonu(OyunOrganizasyonu o) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update oyunOrganizasyonu set oyunAdi = '" + o.getOyunAdi() + "', oyunTuru = '" + o.getOyunTuru() + "',tarih = '" + o.getTarih() + "', saat = '" + o.getSaat() + "',nerede = '" + o.getNerede() + "' where id = " + o.getId() + "");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(int id) {

        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from oyunOrganizasyonu where id=" + id);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public ArrayList<OyunOrganizasyonu> getOyunOrganizasyonuList() {
        ArrayList<OyunOrganizasyonu> oList = new ArrayList();
        Connection con = ConnectionManager.getConnection();
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from oyunOrganizasyonu");
            while (rs.next()) {
                oList.add(new OyunOrganizasyonu(rs.getInt("id"), rs.getString("oyunAdi"), rs.getString("oyunTuru"), rs.getString("tarih"), rs.getString("saat"), rs.getString("nerede")));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return oList;
    }

}
